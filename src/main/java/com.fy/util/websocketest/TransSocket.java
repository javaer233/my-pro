package com.fy.util.websocketest;

import com.fy.bean.GetHttpSessionConfigurator;
import com.fy.util.MessageUtil;
import com.fy.util.websocketest.bean.Message;
import com.google.gson.Gson;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServerEndpoint(value = "/websocket", configurator = GetHttpSessionConfigurator.class)
public class TransSocket {
    //存储任务id及对应的连接到该任务websocket认领用户session列表
    private static Map<String, List<Session>> maps = new HashMap<>();
    //存放每个认领用户session及对应任务id
    private static Map<Session, String> reverseMaps = new HashMap<>();
    //存放用户session及对应id
//    private static Map<Session, String> users = new HashMap<Session, String>();

    //与maps类似，但存储的是关注用户
    private static Map<String, List<Session>> concernMaps = new HashMap<>();
    //reverseMaps类似，但存储的关注用户
    private static Map<Session, String> concernReverseMaps = new HashMap<>();

    private Gson gson = new Gson();
    // session及对应的用户类型(关注用户2、认领用户1)
    // 用于移除session时，判断从maps还是concernMaps中移除
    private static Map<Session, String> types = new HashMap<>();

    /**
     * @Title: open
     * @Description: 建立socket通道，存储session及用户信息
     * @author kai
     * @date 2018/5/29 10:28
     * @param
     * @return void
     */
    @OnOpen
    public void open(Session session, EndpointConfig config) {
        //HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        //try {
        //    Object userId = httpSession.getAttribute("token");
        //    System.out.println(userId);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //获取session携带的字符串数据frameId和deviceId
        String queryString = session.getQueryString();
        System.out.println("websocket连接参数：" +queryString);
        //分离获取missionId(单个聊天链接的唯一标识)
        String missionId = queryString.substring(queryString.indexOf("=") + 1, queryString.indexOf("&"));
        //分离获得type(是否关注用户的标识 0未认领或关注 1认领  2关注)
        String type = queryString.split("=")[2];
//        String type = "2";
//        获取权限
//        if (httpSession != null && httpSession.getAttribute("permission") != null) {
//            System.out.println(httpSession.getAttribute("permission"));
//            permission.put(session, httpSession.getAttribute("permission").toString());
//        }
        if ("1".equals(type)) {
            //认领用户存入认领map
            if (maps.get(missionId) == null) {
                List<Session> sessionList = new ArrayList<>();
                sessionList.add(session);
                maps.put(missionId, sessionList);
            } else {
                List<Session> sessionList = maps.get(missionId);
                sessionList.add(session);
                maps.put(missionId, sessionList);
            }
            reverseMaps.put(session, missionId);
            System.out.println("添加认领用户：" + maps);
            //System.out.println(reverseMaps);
        } else if ("2".equals(type)) {
            //关注人放入关注map
            if (concernMaps.get(missionId) == null) {
                List<Session> sessionList = new ArrayList<>();
                sessionList.add(session);
                concernMaps.put(missionId, sessionList);
            } else {
                List<Session> SessionList = concernMaps.get(missionId);
                SessionList.add(session);
                concernMaps.put(missionId, SessionList);
            }
            concernReverseMaps.put(session, missionId);
            System.out.println("添加关注用户："+concernMaps);
            //System.out.println(concernReverseMaps);
        } else {
            System.out.println("type参数不正确");
            return;
        }
        types.put(session, type);
//        users.put(session,userId);
        System.out.println("通道已建立，欢迎使用");
    }

    /**
     * @Title: message
     * @Description: 发送聊天信息
     * @author kai
     * @date 2018/5/29 10:25
     * @param
     * @return void
     */
    @OnMessage
    public void message(Session session, String json) {
        //将json数据转换为message对象
        Message message = gson.fromJson(json, Message.class);
        System.out.println("发送message: " + message);
        String to = message.getTo();
        //发送信息
        if (maps.size() != 0 && maps.get(to) != null) {
            List<Session> sessions = maps.get(to);
            System.out.println("向认领用户发送信息 ： " + to);
            sendMessage(sessions, message, "1");
        }
        if (concernMaps.size() != 0 && concernMaps.get(to) != null) {
            //是否向关注人公开
            Integer broadcast = MessageUtil.getMissionBroadcastStatus(to);
            if (broadcast == 0) return; //不公开则不发送消息
            //向关注用户发送
            List<Session> concernSessions = concernMaps.get(to);
            System.out.println("向关注用户发送信息 ： " + to);
            sendMessage(concernSessions, message, "2");
        }
    }

    /**
     * @Title: sendMessage
     * @Description: 消息群发
     * @author kai
     * @date 2018/6/7 10:16
     * @param
     * @return void
     */
    public void sendMessage(List<Session> sessions, Message message, String type){
        //存储发送记录，用于聊天记录获取
        MessageUtil.insertSendMessage(message);
        // 将发送的消息存储到数据库,判断未读消息
        MessageUtil.insertMessage(message, type);
        for (Session toSession : sessions) {
            try {
                toSession.getBasicRemote().sendText(gson.toJson(message));
                //向前台反馈发送结果
                //session.getBasicRemote().sendText(FI+"-"+DI+":消息发送成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Title: close
     * @Description: 关闭socket通道，移除session
     * @author kai
     * @date 2018/5/29 10:25
     * @param
     * @return void
     */
    @OnClose
    public void close(Session session) {
        System.out.println("通道已关闭");
        String type = types.get(session);
        if ("1".equals(type)) {
            String missionId = reverseMaps.get(session);
            List<Session> SessionList = maps.get(missionId);
            //移除关闭的session
            SessionList.remove(session);
            if (SessionList.isEmpty()) {
                maps.remove(missionId);
            } else {
                maps.put(missionId, SessionList);
            }
        } else if ("2".equals(type)) {
            String missionId = concernReverseMaps.get(session);
            List<Session> SessionList = concernMaps.get(missionId);
            //移除关闭的session
            SessionList.remove(session);
            if (SessionList.isEmpty()) {
                concernMaps.remove(missionId);
            } else {
                concernMaps.put(missionId, SessionList);
            }
        } else {
            System.out.println("移除session时出错，type：" + type + ", types：" + types);
        }
        types.remove(session);
        System.out.println("Session已移除");
    }

    /**
     * @Title: error
     * @Description: 出错时提示信息
     * @author kai
     * @date 2018/5/29 10:30
     * @param
     * @return void
     */
    @OnError
    public void error(Throwable t, Session session) {
        System.out.println("连接已中止，请刷新后再试");
    }
}

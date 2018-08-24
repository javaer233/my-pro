package com.fy.util.websocketest;

import com.fy.util.websocketest.bean.Message;
import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author kai
 * @Description websocket处理类
 * @Create 2018-05-15 15:22
 **/
@ServerEndpoint("/myWebsocket")
public class MyWebsocket {
    public static Map<String, Session> sessionMap = new HashMap<String, Session>();
    private Session session;

    @OnOpen
    public void openSocket(Session session) {
        this.session = session;
        System.out.println("链接成功");
        if (sessionMap.size() == 0) {
            return ;
        }
        Set userIds = sessionMap.keySet();
        StringBuffer sBuffer  = new StringBuffer();
        for (Object str : userIds) {
            sBuffer.append(str.toString() + ":");
        }
        Gson gson = new Gson();
        try {
            Message message = new Message();
            message.setFrom("系统");
            message.setMsg(sBuffer.toString());
            session.getBasicRemote().sendText(gson.toJson(message),true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @OnMessage
    public void sendMessgae(Session session, String str) {
        System.out.println("sessionMap:" + sessionMap);
        boolean last = true;
        if (session.isOpen()) {
            try {
                System.out.println(str);
                Gson gson = new Gson();
                Message msg = gson.fromJson(str, Message.class);
                Message toMessage = msg;
                toMessage.setFrom(msg.getId());
                toMessage.setTo(msg.getTo());

                if (msg.getMsg().equals("newUser")) {
                    if (sessionMap.containsKey(msg.getId())) {
                        sessionMap.remove(msg.getId());
                    }
                    sessionMap.put(msg.getId(), session);
                } else {
                    Session toSession = sessionMap.get(msg.getTo());
                    if (toSession != null && toSession.isOpen()) {
                        toSession.getBasicRemote().sendText(gson.toJson(toMessage), last);
                    } else {
                        toMessage.setMsg("用户不存在");
                        toMessage.setFrom("系统");
                        session.getBasicRemote().sendText(gson.toJson(toMessage), last);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("session is closed");
        }
    }

    @OnClose
    public void closeSocket(){
        System.out.println("websocket closed");
    }
}

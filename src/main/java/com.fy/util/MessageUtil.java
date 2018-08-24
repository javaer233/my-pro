package com.fy.util;


import com.fy.bean.MultipleDataSource;
import com.fy.mapper.BaseDataMapper;
import com.fy.util.websocketest.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author kai
 * @Description 从数据库读取配置，拼接sql
 * @Create 2018-02-27 9:36
 **/
@Component
public class MessageUtil {

    @Autowired
    private BaseDataMapper baseDataMapper;

    //@Autowired
    //private MissionServiceImpl missionService;

    private static MessageUtil messageUtil;

    @PostConstruct
    public void init() {
        //初始化工具类和mapper
        messageUtil = this;
        messageUtil.baseDataMapper = this.baseDataMapper;
        //messageUtil.missionService = this.missionService;
    }

    /**
     * @Title: insertSendMessage
     * @Description: 插入消息发送表，每次发送只存储一次
     * @author kai
     * @date 2018/6/13 15:52
     * @param
     * @return void
     */
    public static void insertSendMessage(Message message){
        MultipleDataSource.setDataSourceKey(MultipleDataSource.DP);
        // 插入信息发送表，用于记录/获取聊天记录
        StringBuilder insertSql1 = new StringBuilder("insert into fy_zf_message_send (from_user,mission_id,send_img," +
                "message_content,send_time) values (");
        insertSql1.append("'").append(message.getUserId()).append("',");
        insertSql1.append(message.getTo()).append(",");
        insertSql1.append("'").append(message.getImg()).append("',");
        insertSql1.append("'").append(message.getContent()).append("',");
        insertSql1.append("now())");
        System.out.println("执行消息发送记录插入：" + insertSql1);
        messageUtil.baseDataMapper.execute(insertSql1.toString());
    }

    /**
     * @Title: insertMessage
     * @Description: 存储消息记录，用于已读/未读，每个用户都发送一次
     * @author kai
     * @date 2018/6/6 16:47
     * @param
     * @return void
     */
    public static void insertMessage(Message message, String type) {
        MultipleDataSource.setDataSourceKey(MultipleDataSource.DP);
        try {
            //获取认领用户id
            String sql = "SELECT DISTINCT user_id from fy_zf_mission_obtain_info where mission_id = "
                    + message.getTo() + " and delete_status = 1";
            Set<String> userIds = messageUtil.baseDataMapper.getSet(sql);//认领用户id
            // 获取所有pc用户id
            //List<String> pcUserIds = messageUtil.missionService.getPcUserIds();
            //userIds.addAll(pcUserIds);
            //向关注人公开则获取关注用户id
            if ("2".equals(type)) {
                // 获取关注用户id
                sql = "SELECT DISTINCT concern_userid from fy_zf_mission_concern where mission_id = "
                        + message.getTo() + " and delete_status = 1";
                Set<String> concernUsers = messageUtil.baseDataMapper.getSet(sql);//关注用户id
                userIds.addAll(concernUsers);
            }
            //无用户则返回
            if (userIds == null || userIds.size() == 0) return;
            //移除发送者id
            if (userIds.contains(message.getUserId()))userIds.remove(message.getUserId());
            // 插入message聊天记录表，用于查询未读消息
            StringBuilder insertSql2 = new StringBuilder("insert into fy_zf_message_record (from_user, to_user, " +
                    "mission_id, message_content, send_time) values");
            for (String userId : userIds) {
                if (userId.equals(message.getUserId()))continue;
                insertSql2.append("(");
                insertSql2.append("'").append(message.getUserId()).append("',");
                insertSql2.append("'").append(userId).append("',");
                insertSql2.append(message.getTo()).append(",");
                insertSql2.append("'").append(message.getContent()).append(",").append(message.getImg()).append("',");
                insertSql2.append("now()),");
            }
            insertSql2.deleteCharAt(insertSql2.lastIndexOf(","));
            System.out.println("执行消息历史记录插入：" + insertSql2);
            messageUtil.baseDataMapper.execute(insertSql2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title: getMissionBroadcastStatus
     * @Description: 查询任务是否向关注用户公开
     * @author kai
     * @date 2018/6/7 13:41
     * @param
     * @return java.lang.Integer 1广播  0只发给认领用户
     */
    public static Integer getMissionBroadcastStatus(String missionId) {
        MultipleDataSource.setDataSourceKey(MultipleDataSource.DP);
        String sql = "SELECT ifnull(broadcast,0) as broadcast from fy_zf_mission_allocate " +
                "where delete_status = 1 and mission_id = " + missionId;
        //查询向关注人公开的标识
        Map<String, Object> info = messageUtil.baseDataMapper.getInfo(sql);
        if (info != null && (Long) info.get("broadcast") == 1) {
            return 1;
        }
        return 0;
    }


}

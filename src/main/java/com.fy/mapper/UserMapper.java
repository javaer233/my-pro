package com.fy.mapper;

import com.fy.bean.Users;
import org.springframework.stereotype.Repository;

/**
 * Created by yk on 2018/08/27
 */
@Repository
public interface UserMapper {

    void insertSelective(Users iu);
    /**
     * @Title: countIfRegistered
     * @Description: 根据openId判断该第三方用户之前是否登录过
     * @author kai
     * @date 2018/8/27 13:50
     * @param
     * @return boolean
     */
    Integer countIfRegistered(String openId);

    /**
     * @Title: getUserInfoByOpenId
     * @Description: 根据openId获取用户信息
     * @author kai
     * @date 2018/8/27 13:57
     * @param
     * @return com.lw.bean.Users
     */
    Users getUserInfoByOpenId(String openId);


}

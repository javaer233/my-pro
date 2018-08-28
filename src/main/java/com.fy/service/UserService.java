package com.fy.service;

import com.fy.bean.UserInfoData;
import com.fy.bean.Users;

import java.util.Map;

/**
 * Created by yk on 2018/08/27
 */
public interface UserService {
    /**
     * @Title: weChatLogin
     * @Description: 微信授权登录
     * @author kai
     * @date 2018/8/27 11:10
     * @param
     * @param code
     * @return com.lw.bean.Users
     */
    Users weChatLogin(Map<String, Object> code) throws Exception;

    /**
     * @Title: qqLogin
     * @Description: qq授权登录
     * @author kai
     * @date 2018/8/27 14:51
     * @param
     * @param accessToken
     * @return com.lw.bean.Users
     */
    Users qqLogin(Map<String, Object> accessToken) throws Exception;

    /**
     * @Title: weiboLogin
     * @Description: 微博授权登录
     * @author kai
     * @date 2018/8/27 16:04
     * @param
     * @return com.lw.bean.Users
     */
    Users weiboLogin(Map<String,Object> params) throws Exception;
}

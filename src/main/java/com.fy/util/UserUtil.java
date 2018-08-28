package com.fy.util;/**
 * Created by yk on 2018/08/27
 */

/**
 * @Author kai
 * @Description 用户操作工具类
 * @Create 2018-08-27 9:53
 **/
public class UserUtil {

    /*-------------------------------微信----------------------------------*/
    //授权地址
    public static final String WX_AUTH_LOGIN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    //获取用户信息地址
    public static final String WX_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
    //appid和appSecret 是在公众平台上申请的
    //AppId
    public static final String WX_APP_ID = "wxb6411cbea5c*****";
    //AppSecret
    public static final String WX_APP_KEY = "86b91b295d23f34337b76cacd*******";

    /*----------------------------------qq-------------------------------*/
    //获取access_token
    public static final String QQ_ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";
    //授权地址
    public static final String QQ_AUTH_LOGIN_URL = "https://graph.qq.com/oauth2.0/me";
    //获取用户信息地址
    public static final String QQ_USER_INFO_URL = "https://graph.qq.com/user/get_user_info";
    //AppId
    public static final String QQ_APP_ID = "wxb6411cbea5c*****";
    //AppSecret
    public static final String QQ_APP_KEY = "86b91b295d23f34337b76cacd*******";
    //重定向网址
    public static final String QQ_REDIRECT_URI = "redirect_uri";

    /*--------------------------------微博--------------------------------*/
    //获取access_token
    public static final String WB_ACCESS_TOKEN_URL = "https://api.weibo.com/oauth2/access_token";
    //获取用户信息地址
    public static final String WB_USER_INFO_URL = "https://api.weibo.com/2/users/show.json";
    //AppId
    public static final String WB_APP_ID = "wxb6411cbea5c*****";
    //AppSecret
    public static final String WB_APP_KEY = "86b91b295d23f34337b76cacd*******";
    //重定向网址
    public static final String WB_REDIRECT_URI = "redirect_uri";
}

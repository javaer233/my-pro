package com.fy.service.serviceImpl;/**
 * Created by yk on 2018/08/27
 */

import com.alibaba.fastjson.JSON;
import com.fy.bean.UserInfoData;
import com.fy.bean.Users;
import com.fy.mapper.UserMapper;
import com.fy.service.UserService;
import com.fy.util.HttpUtil;
import com.fy.util.UserUtil;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author kai
 * @Description 用户操作接口
 * @Create 2018-08-27 9:50
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users weChatLogin(Map<String, Object> param) throws Exception {
        //获取授权 access_token
        //Map<String, String> params = new HashMap<>();
        //params.put("appid", UserUtil.WX_APP_ID);
        //params.put("secret", UserUtil.WX_APP_KEY);
        //params.put("code", (String) param.get("code"));
        //params.put("grant_type", "authorization_code");
        //发送请求并接收返回结果
        String loginRet = HttpUtil.sendGet(UserUtil.WX_AUTH_LOGIN_URL + "?appid=" + UserUtil.WX_APP_ID +
            "&secret=" + UserUtil.WX_APP_KEY + "&code=" + (String) param.get("code") + "&grant_type=authorization_code");
        //String loginRet = getHttpAgent().doGet(UserUtil.WX_AUTH_LOGIN_URL, params, null);
        com.alibaba.fastjson.JSONObject grantObj = JSON.parseObject(loginRet);
        String errorCode = String.valueOf(grantObj.get("errcode"));
        //错误返回
        if (!org.apache.commons.lang3.StringUtils.isEmpty(errorCode)) {
            logger.error("login weixin error" + loginRet);
            return null;
        }
        //openid：授权用户唯一标识
        String openId = String.valueOf(grantObj.get("openid"));
        if (org.apache.commons.lang3.StringUtils.isEmpty(openId)) {
            logger.error("login weixin getOpenId error" + loginRet);
            return null;
        } else if (userMapper.countIfRegistered(openId) > 0) {
            //如果当前用户已经注册过
            return userMapper.getUserInfoByOpenId(openId);
        }
        String accessToken = String.valueOf(grantObj.get("access_token"));
        //获取用户信息
        //HashMap<String, String> infoParams = new HashMap<>();
        //infoParams.put("access_token", accessToken);
        //infoParams.put("openid", openId);
        String userRet = HttpUtil.sendGet(UserUtil.WX_USER_INFO_URL + "?access_token=" +
            accessToken + "&openid=" + openId);
        //String userRet = getHttpAgent().doGet(UserUtil.WX_USER_INFO_URL, infoParams, null);
        com.alibaba.fastjson.JSONObject userObj = JSON.parseObject(userRet);
        errorCode = String.valueOf(userObj.get("errcode"));
        //未正确获取到用户信息
        if (!org.apache.commons.lang3.StringUtils.isEmpty(errorCode)) {
            logger.error("getting user info error");
            return null;
        }
        //成功则自动将用户进行游客身份注册
        //String roleId = getRoleId();
        //if (org.apache.commons.lang3.StringUtils.isEmpty(roleId)) {
        //    throw new LwException(BusinessErrorEnum.ERROR_ALL);
        //}
        Users users = new Users();
        String nickname = String.valueOf(userObj.get("nickname"));
        users.setUserName(nickname);
        users.setName(nickname);
        users.setUserPassword("123456");
        com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
        json.put("userName", nickname);
        json.put("userPassword", "123456");
        //json.put("roleIdArray", roleId);
        json.put("name", nickname);
        //进行用户注册
        logger.info("用户注册上送参数===" + json.toJSONString());
        //String str = getHttpAgent().post(getRabcUrl() + "/fyUser/addUser.do", json);
        //logger.info("用户注册返回结果===" + str);
        //Map<String, Object> result = JSON.parseObject(str);
        //if ("0".equals(String.valueOf(result.get("success")))) {
            //注册失败
            //throw new LwException("000000" + "|" + result.get("message"));
        //} else {
            //注册成功,用户信息存入数据库
            //Map<String, Object> userMap = (Map<String, Object>) result.get("data");
            Users iu = new Users();
            //iu.setUserId(String.valueOf(userMap.get("id")));
            //iu.setUserName(String.valueOf(userMap.get("userName")));
            //iu.setName(String.valueOf(userMap.get("name")));
            //iu.setRegistrationTime(getNowDateTime());
            iu.setLevel(0);
            iu.setProvince(String.valueOf(userObj.get("province")));
            iu.setCity(String.valueOf(userObj.get("city")));
            iu.setCountry(String.valueOf(userObj.get("country")));
            iu.setHeadImg(String.valueOf(userObj.get("headimgurl")));
            iu.setUserPassword("123456");
            userMapper.insertSelective(iu);
        //}
        return users;
    }



    @Override
    public Users qqLogin(Map<String, Object> param) throws Exception {
        //根据code获取accessToken
        String code = (String) param.get("code");
        //HashMap<String, String> tokenParam = new HashMap<>();
        //tokenParam.put("grant_type", "authorization_code");
        //tokenParam.put("client_id", UserUtil.QQ_APP_ID);
        //tokenParam.put("client_secret", UserUtil.QQ_APP_KEY);
        //tokenParam.put("code", code);
        //tokenParam.put("redirect_uri", UserUtil.QQ_REDIRECT_URI);
        String result = HttpUtil.sendGet(UserUtil.QQ_ACCESS_TOKEN_URL + "?grant_type=authorization_code" +
                "&client_id=" + UserUtil.QQ_APP_ID + "&client_secret=" + UserUtil.QQ_APP_KEY +
            "&code=" + code + "&redirect_uri=" + UserUtil.QQ_REDIRECT_URI);
        //String result = getHttpAgent().doGet(UserUtil.QQ_ACCESS_TOKEN_URL, tokenParam, null);
        com.alibaba.fastjson.JSONObject tokenResult = JSON.parseObject(result);
        if (tokenResult.get("code") != null) {
            logger.error("getting access token failed");
            return null;
        }
        // 根据accessToken换取openId
        String accessToken = (String) tokenResult.get("access_token");
        //Map<String, String> loginParam = new HashMap<>();
        //loginParam.put("access_token", accessToken);
        result = HttpUtil.sendGet(UserUtil.QQ_AUTH_LOGIN_URL + "?access_token=" + accessToken);
        //result = getHttpAgent().doGet(UserUtil.QQ_AUTH_LOGIN_URL, loginParam, null);
        com.alibaba.fastjson.JSONObject loginResult = JSON.parseObject(result);
        //登录失败
        if (loginResult.get("error") != null) {
            logger.error("qq login error" + String.valueOf(loginResult.get("error_description")));
            return null;
        }
        String openId = String.valueOf(loginResult.get("openid"));
        //判断该用户是否注册过
        if (org.apache.commons.lang3.StringUtils.isEmpty(openId)) {
            logger.error("login weixin getOpenId error");
            return null;
        } else if (userMapper.countIfRegistered(openId) > 0) {
            //如果当前用户已经注册过
            return userMapper.getUserInfoByOpenId(openId);
        }
        // 获取用户昵称、头像等信息，{ret: 0, msg: '', nickname: '', ...} ret不为0表示失败
        //HashMap<String, String> infoParams = new HashMap<>();
        //infoParams.put("access_token", accessToken);
        //infoParams.put("oauth_consumer_key", UserUtil.QQ_APP_ID);
        //infoParams.put("openid", openId);
        //infoParams.put("openid", accessToken);
        result = HttpUtil.sendGet(UserUtil.QQ_USER_INFO_URL + "?access_token=" + accessToken +
        "&oauth_consumer_key=" + UserUtil.QQ_APP_ID + "&openid=" + openId);
        //result = getHttpAgent().doGet(UserUtil.QQ_USER_INFO_URL, infoParams, null);
        com.alibaba.fastjson.JSONObject infoResult = JSON.parseObject(result);
        //获取用户信息失败
        if (Integer.valueOf((String) infoResult.get("ret")) != 0) {
            logger.error("getting user info error " + String.valueOf(infoResult.get("msg")));
            return null;
        }

        //成功则自动将用户进行游客身份注册
        //String roleId = getRoleId();
        //if (org.apache.commons.lang3.StringUtils.isEmpty(roleId)) {
        //    throw new LwException(BusinessErrorEnum.ERROR_ALL);
        //}
        Users users = new Users();
        com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
        json.put("userName", infoResult.get("nickname"));
        users.setName(String.valueOf(infoResult.get("nickname")));
        users.setUserName(String.valueOf(infoResult.get("nickname")));
        json.put("userPassword", "123456");
        users.setUserPassword("123456");
        //json.put("roleIdArray", roleId);
        json.put("name", infoResult.get("nickname"));
        //进行用户注册
        logger.info("用户注册上送参数===" + json.toJSONString());
        //String str = getHttpAgent().post(getRabcUrl() + "/fyUser/addUser.do", json);
        //logger.info("用户注册返回结果===" + str);
        //Map<String, Object> registResult = JSON.parseObject(str);
        //if ("0".equals(String.valueOf(registResult.get("success")))) {
            //注册失败
            //throw new LwException("000000" + "|" + registResult.get("message"));
        //} else {
            //注册成功,用户信息存入数据库
            //Map<String, Object> userMap = (Map<String, Object>) registResult.get("data");
            Users iu = new Users();
            //iu.setUserId(String.valueOf(userMap.get("id")));
            //iu.setUserName(String.valueOf(userMap.get("userName")));
            //iu.setName(String.valueOf(userMap.get("name")));
            //iu.setRegistrationTime(getNowDateTime());
            iu.setLevel(0);
            iu.setUserPassword("123456");
            iu.setHeadImg(infoResult.getString("figureurl_2"));//空间头像100x100
            userMapper.insertSelective(iu);
        //}
        return users;

    }

    @Override
    public Users weiboLogin(Map<String, Object> param) throws Exception {
        //根据code获取accessToken
        String code = (String) param.get("code");
        //HashMap<String, String> tokenParam = new HashMap<>();
        //tokenParam.put("grant_type", "authorization_code");
        //tokenParam.put("client_id", UserUtil.WB_APP_ID);
        //tokenParam.put("client_secret", UserUtil.WB_APP_KEY);
        //tokenParam.put("code", code);
        //tokenParam.put("redirect_uri", UserUtil.WB_REDIRECT_URI);
        String result = HttpUtil.sendGet(UserUtil.WB_ACCESS_TOKEN_URL + "?grant_type=authorization_code" +
         "&client_id=" + UserUtil.WB_APP_ID + "&client_secret=" + UserUtil.WB_APP_KEY + "&code=" + code +
         "&redirect_uri=" + UserUtil.WB_REDIRECT_URI);
        //String result = getHttpAgent().doGet(UserUtil.WB_ACCESS_TOKEN_URL, tokenParam, null);
        com.alibaba.fastjson.JSONObject tokenResult = JSON.parseObject(result);
        if (tokenResult.get("error_code") != null && (Integer) tokenResult.get("error_code") != 0) {
            logger.error("getting access token failed");
            return null;
        }
        // 获取accessToken和uid
        String accessToken = (String) tokenResult.get("access_token");
        String uid = (String) tokenResult.get("uid");
        //判断该用户是否注册过
        if (org.apache.commons.lang3.StringUtils.isEmpty(uid) || org.apache.commons.lang3.StringUtils.isEmpty(accessToken)) {
            logger.error("getting weibo uid error");
            return null;
        } else if (userMapper.countIfRegistered(uid) > 0) {
            //如果当前用户已经注册过
            return userMapper.getUserInfoByOpenId(uid);
        }
        //获取用户信息，进行注册
        //HashMap<String, String> infoParams = new HashMap<>();
        //infoParams.put("access_token", accessToken);
        //infoParams.put("uid", uid);
        result = HttpUtil.sendGet(UserUtil.WB_USER_INFO_URL + "?access_token=" + accessToken + "&uid=" + uid);
        //result = getHttpAgent().doGet(UserUtil.WB_USER_INFO_URL, infoParams, null);
        com.alibaba.fastjson.JSONObject infoResult = JSON.parseObject(result);
        //失败
        if (infoResult.get("error_code") != null && (Integer) infoResult.get("error_code") != 0) {
            logger.error("qq login error" + String.valueOf(infoResult.get("error_description")));
            return null;
        }
        //成功则自动将用户进行游客身份注册
        //String roleId = getRoleId();
        //if (org.apache.commons.lang3.StringUtils.isEmpty(roleId)) {
        //    throw new LwException(BusinessErrorEnum.ERROR_ALL);
        //}
        Users users = new Users();
        users.setName(String.valueOf(infoResult.get("screen_name")));
        users.setUserName(String.valueOf(infoResult.get("screen_name")));
        users.setUserPassword("123456");
        com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
        json.put("userName", infoResult.get("screen_name"));
        json.put("name", infoResult.get("screen_name"));
        json.put("userPassword", "123456");
        //json.put("roleIdArray", roleId);
        //进行用户注册
        //logger.info("用户注册上送参数===" + json.toJSONString());
        //String str = getHttpAgent().post(getRabcUrl() + "/fyUser/addUser.do", json);
        //logger.info("用户注册返回结果===" + str);
        //Map<String, Object> registerResult = JSON.parseObject(str);
        //if ("0".equals(String.valueOf(registerResult.get("success")))) {
        //    //注册失败
        //    throw new LwException("000000" + "|" + registerResult.get("message"));
        //} else {
            //注册成功,用户信息存入数据库
            //Map<String, Object> userMap = (Map<String, Object>) registerResult.get("data");
            Users iu = new Users();
            //iu.setUserId(String.valueOf(userMap.get("id")));
            //iu.setUserName(String.valueOf(userMap.get("userName")));
            //iu.setName(String.valueOf(userMap.get("name")));
            //iu.setRegistrationTime(getNowDateTime());
            iu.setLevel(0);
            iu.setUserPassword("123456");
            iu.setHeadImg(infoResult.getString("avatar_large"));//空间头像100x100
            userMapper.insertSelective(iu);
        //}
        return users;
    }

}

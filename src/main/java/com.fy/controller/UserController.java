package com.fy.controller;

import com.fy.bean.BaseResponse;
import com.fy.bean.UserInfoData;
import com.fy.bean.Users;
import com.fy.service.UserService;
import com.fy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Author kai
 * @Description 微信登录
 * @Create 2018-08-23 11:19
 **/
@RestController(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Title: checkLogin
     * @Description: 微信登录
     * @author kai
     * @date 2018/8/27 9:31
     * @param
     *      code：用户确认登录后返回的code
     * @return com.fy.bean.UserInfoData
     */
    @RequestMapping(value="/weChatLogin", method = RequestMethod.GET)
    public BaseResponse weChatLogin(@RequestParam Map<String, Object> params) {
        Users info;
        try {
            info = userService.weChatLogin(params);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
        return ResponseUtil.success(info);
    }

    /**
     * @Title: qqLogin
     * @Description: qq第三方登录
     * @author kai
     * @date 2018/8/27 14:50
     * @param
     *      code：用户确认登录后返回的code
     * @return com.lw.bean.base.BaseResponse
     */
    @RequestMapping(value="/qqLogin", method = RequestMethod.GET)
    public BaseResponse qqLogin(@RequestParam Map<String, Object> params){
        Users info;
        try {
            info = userService.qqLogin(params);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
        return ResponseUtil.success(info);
    }

    /**
     * @Title: weiboLogin
     * @Description: 微博登录
     * @author kai
     * @date 2018/8/27 16:03
     * @param
     *      code：用户确认登录后返回的code
     * @return com.lw.bean.base.BaseResponse
     */
    @RequestMapping(value = "/weiboLogin", method = RequestMethod.GET)
    public BaseResponse weiboLogin(@RequestParam Map<String, Object> params){
        Users info;
        try {
            info = userService.weiboLogin(params);
        } catch (Exception e) {
            return ResponseUtil.error(e.getMessage());
        }
        return ResponseUtil.success(info);
    }


}

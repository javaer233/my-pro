package com.fy.bean;/**
 * Created by yk on 2018/08/27
 */

/**
 * @Author kai
 * @Description 用户信息
 * @Create 2018-08-27 9:27
 **/
public class UserInfoData {
    private String openId;
    private String authToken;
    private String authRefreshToken;
    private String scope;
    private Integer expiresIn;
    private String name;
    private String icon;
    private String gender;
    private String loginId;

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthRefreshToken(String authRefreshToken) {
        this.authRefreshToken = authRefreshToken;
    }

    public String getAuthRefreshToken() {
        return authRefreshToken;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginId() {
        return loginId;
    }
}

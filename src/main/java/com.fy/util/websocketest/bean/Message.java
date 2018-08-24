package com.fy.util.websocketest.bean;

/**
 * 传输的消息体
 */
public class Message {

    private String token;
	private String userId;  //由谁发的
	private String userName;
	private String to; //发给谁
	private String content; //聊天内容
    private String headImg;//用户头像
    private String img;//发送的图片

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Message{" +
                "token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", headImg='" + headImg + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

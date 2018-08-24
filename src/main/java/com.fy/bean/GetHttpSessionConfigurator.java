package com.fy.bean;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class GetHttpSessionConfigurator extends Configurator{

    /**
     * @Title: modifyHandshake
     * @Description: 将httpSession存入应用参数，以在onopen中获取
     * @author kai
     * @date 2018/5/29 10:34
     * @param [sec, request, response]
     * @return void
     */
	@Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession=(HttpSession) request.getHttpSession();
        if(httpSession == null){
        	return;
        }
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}

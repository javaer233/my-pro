package com.fy.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by bzl on 2016-12-14 下午 1:18
 */
public class BaseResponse implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 是否成功,0/1
     */
    @JSONField(ordinal = 1)
    private short success;

    /**
     * 错误码
     */
    @JSONField(ordinal = 2)
    private String errorCode;

    /**
     * 主要存放错误信息
     */
    @JSONField(ordinal = 3)
    private String message;

    /**
     * 返回数据
     */
    @JSONField(ordinal = 4)
    private Object data;

    public short getSuccess() {
        return success;
    }

    public void setSuccess(short success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}

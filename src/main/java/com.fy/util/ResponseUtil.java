package com.fy.util;

import com.fy.bean.BaseResponse;
import com.fy.common.bean.base.PageResponse;
import com.github.pagehelper.Page;

/**
 * Created by bzl on 2016-12-14 下午 1:16
 */
public class ResponseUtil {
	private final static short SUCCESS=1;
	private final static short FAIL=0;
	
    public static BaseResponse success(){
        /**
         * 无返回数据的成功响应
         * Created by bzl on 2016-12-14 13:28:42
         * @param []
         * @return  com.lw.bean.base.BaseResponse
         * @TODO
         */
        BaseResponse response = new BaseResponse();
        response.setSuccess(SUCCESS);
        return response;
    }

    public static BaseResponse success(Object data){
        /**
         * 有返回数据的成功响应
         * Created by bzl on 2016-12-14 13:32:35
         * @param [Data]
         * @return  com.lw.bean.base.BaseResponse
         * @TODO
         */
        BaseResponse response = new BaseResponse();
        response.setSuccess(SUCCESS);
        response.setData(data);
        return response;
    }

    public static BaseResponse error(String message){
        /**
         * Created by bzl on 2016-12-14 13:30:45
         * @param [message] 错误信息
         * @return  com.lw.bean.base.BaseResponse
         * @TODO
         */
        BaseResponse response = new BaseResponse();
        response.setSuccess(FAIL);
        String[] msg=message.split("\\|");
        response.setMessage(msg.length>1?msg[1]:msg[0]);
        response.setErrorCode(msg.length>1?msg[0]:"");
        return response;
    }

    public static BaseResponse error(String message,String errorCode){
        /**
         * Created by bzl on 2017-01-20 09:32:21
         * @param [message, errorCode]
         * @return  com.lw.bean.base.BaseResponse
         * @TODO
         */
        BaseResponse response = new BaseResponse();
        response.setSuccess(FAIL);
        response.setMessage(message);
        response.setErrorCode(errorCode);
        return response;
    }

    public static BaseResponse page(Page list){
        /**
         * 返回分页数据信息
         * Created by bzl on 2016-12-14 13:41:28
         * @param [list]
         * @return  com.lw.bean.base.BaseResponse
         * @TODO
         */
        BaseResponse response = new BaseResponse();
        PageResponse page = new PageResponse(list,list.getTotal(),list.getPageNum(),list.getPageSize());
        response.setData(page);
        response.setSuccess(SUCCESS);
        return response;
    }

	//public static BaseResponse error(BusinessErrorEnum errorAll) {
	//	BaseResponse response = new BaseResponse();
     //   response.setSuccess(FAIL);
     //   response.setMessage(errorAll.getMsg());
     //   response.setErrorCode(errorAll.getCode());
     //   return response;
	//}

}

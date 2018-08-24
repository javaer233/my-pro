package com.fy.util;

import com.fy.common.util.HttpAgent;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.message.MessageElement;
import org.apache.axis.message.RPCElement;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by bzl on 2017/3/28.
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * @Title: getResultFromResponse
     * @Description: 从返回结果中解析数据
     * @author kai
     * @date 2018/8/24 14:42
     * @param
     * @return java.lang.String
     */
    private static String getResultFromResponse(CloseableHttpResponse response) {
        if (response == null) return null;
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //EntityUtils专门处理HttpEntity
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public static String sendGet(String url) {
        logger.debug("正在请求数据接口：" + url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResultFromResponse(response);
    }

    /**
     * @Title: sendGet
     * @Description: 对给定url发送get请求，并设置连接超时
     * @author kai
     * @date 2018/5/10 9:02
     * @param
     *      timeout: (单位：毫秒)
     * @return java.lang.String
     */
    public static String sendGet(String url, Integer timeout) {
        logger.debug("正在请求数据接口：" + url + ", 设置超时：" + timeout);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        //设置请求和传输超时时间
        //socketTimeout：从服务器获取响应数据需要等待的时间
        //connectTimeout：通过网络与服务器建立连接的超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
        httpget.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResultFromResponse(response);
    }

    public static String sendPost(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResultFromResponse(response);
    }

    /**
     * 数字政通专用webservice请求接口，
     * @param  requestName 请求方法名
     * @param params 传入参数
     * @return
     * @throws ServiceException
     * @throws RemoteException
     * @throws JAXBException
     * @throws MalformedURLException
     */
//    public static Document getSoapData(String requestName,SZZTXmlRequest.Params params) throws Exception {
//        String endpoint = "http://172.18.13.114:8087/szcg/ws/common?wsdl"; //部署的测试服务器
//        String namespace = "http://egova.com.cn/";
//        String action = "process";
//        Service service = new Service();
//        Call call = (Call) service.createCall();
//        call.setTargetEndpointAddress(new java.net.URL(endpoint));
//        call.setOperationUse(Use.LITERAL);
//        call.setOperationName(new QName(namespace, action));
//        call.setReturnType(XMLType.XSD_STRING);
//        call.addParameter(new QName(namespace, "request"), XMLType.XSD_STRING, ParameterMode.IN);
//        SZZTXmlRequest info = new SZZTXmlRequest(new SZZTXmlRequest.Product("1"),new SZZTXmlRequest.Function(requestName),params);
////        logger.info(info.toXml());
//        String str = (String) call.invoke(new Object[]{info.toXml()});
////        logger.info(str);
//        Document document = DocumentHelper.parseText(str);
//        return document;
//    }

    /**
     * 行政审批文书数据请求
     * @param sourceId
     * @return
     */
    public static SOAPBodyElement getXzspWenShuPostList(String sourceId) {
        try {
            String endpoint = "http://172.18.6.147:7879/byg_dpl_getWenShuPostList/services/soa_getwenshupostlistService?wsdl";
            String namespace = "http://www.tongtech.com/ti/do_getwenshupostlist";
            String action = "SOA_getWenShuPostList";
            String soa = "http://byg/wsfolder/ws_byg/inboundservice/SOA_getWenShuPostList";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationUse(Use.LITERAL);
            call.setOperationStyle(Style.MESSAGE);

            call.addHeader(new SOAPHeaderElement("", "AppKey", "DPXT"));
            call.addHeader(new SOAPHeaderElement("", "Secret", "45ea46af737d46dca530493829c52bb2"));
            call.addHeader(new SOAPHeaderElement("", "Version", "1.0"));
            call.addHeader(new SOAPHeaderElement("", "Timestamp", "20160415123422(时间戳)"));

            Document document = DocumentHelper.createDocument();
            Element request = document.addElement("request");
            Element params = request.addElement("params");
            Element param = params.addElement("param");
            param.addAttribute("name", "lspid");
            param.addAttribute("value", sourceId);

            MessageElement element2 = new MessageElement(namespace, "paramsXML");
            element2.setValue(document.asXML());
            MessageElement element1 = new MessageElement(namespace, "Do_getWenShuPostList");
            element1.addChild(element2);
            RPCElement body = new RPCElement(soa, "SOA_getWenShuPostList", new Object[]{});
            body.addChild(element1);
            return (SOAPBodyElement) call.invoke(body);
        } catch (Exception e) {
            logger.error("------------------------------行政审批文书查询接口访问出错--------------------------------------");
            return null;
        }

    }

    public static void main(String[] args) {


    }

}

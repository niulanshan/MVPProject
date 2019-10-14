package com.lins.it.isolation_processor.httpprocessor;

import com.lins.it.isolation_processor.ICallBack;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 代理类
 */
public class HttpHelper implements IHttpProcessor {
    private static HttpHelper instance;
    private HttpHelper(){}
    public static HttpHelper getInstance(){
        if(instance == null){
            synchronized (HttpHelper.class){
                if(instance == null){
                    instance = new HttpHelper();
                }
            }
        }
        return instance;
    }
    private static IHttpProcessor mIHttpProcessor;
    //定义一个API 设置代码接口 切换框架的地方
   private static void init(IHttpProcessor iHttpProcessor){
       mIHttpProcessor = iHttpProcessor;
   }
    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        String finalUrl = appendParams(url, params);
        mIHttpProcessor.post(finalUrl,params,callBack);
    }

    public static String appendParams(String url, Map<String,Object> params) {
        if(params==null || params.isEmpty()){
            return url;
        }
        StringBuilder urlBuilder=new StringBuilder(url);
        if(urlBuilder.indexOf("?")<=0){
            urlBuilder.append("?");
        }else{
            if(!urlBuilder.toString().endsWith("?")){
                urlBuilder.append("&");
            }
        }
        for(Map.Entry<String,Object> entry:params.entrySet()){
            urlBuilder.append("&"+entry.getKey())
                    .append("=")
                    .append(encode(entry.getValue().toString()));
        }
        return urlBuilder.toString();
    }
    private static String encode(String str){
        try {
            return URLEncoder.encode(str,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

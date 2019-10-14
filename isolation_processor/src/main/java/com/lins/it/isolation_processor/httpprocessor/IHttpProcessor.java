package com.lins.it.isolation_processor.httpprocessor;

import com.lins.it.isolation_processor.ICallBack;

import java.util.Map;

public interface IHttpProcessor {
    /**
     * 网络操作 post
     * @param url
     * @param params
     * @param callBack
     */
    void post(String url , Map<String,Object> params, ICallBack callBack);
}

package com.lins.it.isolation_processor;

/**
 * 顶层回调接口
 */
public interface ICallBack {
    void onSuccess(String result);
    void onFailure(String e);
}

package com.lins.it.isolation_processor.httpprocessor;

import com.google.gson.Gson;
import com.lins.it.isolation_processor.ICallBack;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 回调接口json版本实现类
 * 用于把网络返回的json字符串转化为对象（Result就是用户接收的类型）
 */
public abstract class HttpCallBack<Result> implements ICallBack {
    /**
     * @param result 网络回来的数据
     */
    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(result, clz);
        onSuccess(objResult);
    }

    public abstract void onSuccess(Result result);


    private Class<?> analysisClassInfo(Object obj) {
        //getGenericSuperclass  Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        //ParameterizedType参数化类型，即泛型
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        return actualTypeArguments[0].getClass();
    }

    @Override
    public void onFailure(String e) {

    }
}

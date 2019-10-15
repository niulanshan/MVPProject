package com.lins.it.mvp1.net;

import android.app.Dialog;


import com.lins.it.mvp1.net.callback.IError;
import com.lins.it.mvp1.net.callback.IFailure;
import com.lins.it.mvp1.net.callback.IRequest;
import com.lins.it.mvp1.net.callback.ISuccess;
import com.lins.it.mvp1.net.callback.RequestCallbacks;

import java.io.File;
import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;


public class RestClient {
    private final HashMap<String, Object> PARAMS;
    private final String URL;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    //上传下载
    private final File FILE;

    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String FILENAME;
    public RestClient(HashMap<String, Object> params,
                      String url,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      File file, String downloadDir, String extension, String filename) {
        this.PARAMS = params;
        this.URL = url;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;

        this.FILE=file;
        this.DOWNLOAD_DIR=downloadDir;  ///sdcard/XXXX.ext
        this.EXTENSION=extension;
        this.FILENAME=filename;
    }
    public static RestClientBuilder create(){
        return new RestClientBuilder();
    }

    private Callback<String> getRequestCallback(){
        return new RequestCallbacks(REQUEST,SUCCESS,FAILURE,ERROR);
    }

    //开始真实的网络操作   参数HTTP_METHOD.GET  HTTP_METHOD.POST......
    private void request(HttpMethod method){
        final RestService service=RestCreator.getRestService();
        Call<String> call=null;
        if(REQUEST!=null){
            REQUEST.onRequestStart();
        }
        //开始进行网络访问
        switch (method){
            case GET:
                call=service.get(URL,PARAMS);
                break;
            case POST:
                call=service.post(URL,PARAMS);
                break;
            case PUT:
                call=service.put(URL,PARAMS);
                break;
            case DELETE:
                call=service.delete(URL,PARAMS);
                break;
            case UPLOAD:
                final MultipartBody.Part body=MultipartBody.Part.createFormData(
                        "file",FILE.getName());
                call=service.upload(URL,body);
                break;

        }
        if(call!=null){
            call.enqueue(getRequestCallback());
        }

        if(REQUEST!=null){
            REQUEST.onRequestEnd();
        }

    }
    //各种请求(给用户使用的)
    //各种请求
    public final void get(){
        request(HttpMethod.GET);
    }
    public final void post(){
        request(HttpMethod.POST);
    }
    public final void put(){
        request(HttpMethod.PUT);
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }
    public final void upload(){
        request(HttpMethod.UPLOAD);
    }
//    public final void download(){
//        new DownloadHandler(PARAMS,URL,REQUEST,
//                SUCCESS,FAILURE,ERROR,DOWNLOAD_DIR,
//                EXTENSION,FILENAME)
//                .handleDownload();
//    }

}









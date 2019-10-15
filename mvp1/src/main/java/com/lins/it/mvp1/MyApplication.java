package com.lins.it.mvp1;

import android.app.Application;

import com.lins.it.isolation_processor.httpprocessor.HttpHelper;
import com.lins.it.isolation_processor.httpprocessor.OkHttpProcessor;
import com.lins.it.isolation_processor.httpprocessor.VolleyProcessor;

/**
 * created by ${lins}
 * on 2019/10/15
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new VolleyProcessor(this));
    }
}

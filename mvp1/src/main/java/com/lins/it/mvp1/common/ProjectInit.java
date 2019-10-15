package com.lins.it.mvp1.common;

import android.content.Context;

/**
 * 提供给用户的API
 * created by ${lins}
 * on 2019/10/15
 */
public class ProjectInit {
    public static Configurator init(Context context){
        Configurator.getInstance()
                .getConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key){
        return (T)getConfigurator().getConfiguration(key);
    }
}

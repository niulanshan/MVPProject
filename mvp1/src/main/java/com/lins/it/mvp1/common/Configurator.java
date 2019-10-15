package com.lins.it.mvp1.common;

import java.util.HashMap;

/**
 * created by ${lins}
 * on 2019/10/15
 */
public class Configurator {
    private static final HashMap<Object, Object> CONFIGS = new HashMap<>();

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    private Configurator() {
        CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

     final HashMap<Object, Object> getConfigs() {
        return CONFIGS;
    }

    public final Configurator withApiHost(String host) {
        CONFIGS.put(ConfigKeys.API_HOST.name(), host);
        return this;
    }

    public final void configure() {
        CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        Object value = CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + "is null");
        }
        return (T) value;
    }
}

package com.hl.dc.config;

import java.util.HashMap;
import java.util.Map;

public class DIContainer {
    private static final Map<Class<?>, Object> container = new HashMap<>();

    private DIContainer() {
    }

    public static void register(Class<?> clazz, Object instance) {
        container.put(clazz, instance);
    }

    public static <T> T get(Class<T> clazz) {
        return clazz.cast(container.get(clazz));
    }

}

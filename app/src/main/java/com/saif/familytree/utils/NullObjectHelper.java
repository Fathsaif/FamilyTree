package com.saif.familytree.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Morabea on 4/19/16.
 *
 * Provides default values for mimicking empty implementations of any method.
 */
public class NullObjectHelper {

    public static class DefaultValues {
        static final Map<Class<?>,Object> defaultValues = new HashMap<>(8);

        // load
        static {
            defaultValues.put(boolean.class, Boolean.FALSE);
            defaultValues.put(byte.class, (byte) 0);
            defaultValues.put(short.class, (short) 0);
            defaultValues.put(int.class, 0);
            defaultValues.put(long.class, 0L);
            defaultValues.put(char.class, '\0');
            defaultValues.put(float.class, 0f);
            defaultValues.put(double.class, 0d);
        }

        public static <T> T defaultValueFor(Class<T> clazz) {
            return (T) defaultValues.get(clazz);
        }

    }

}

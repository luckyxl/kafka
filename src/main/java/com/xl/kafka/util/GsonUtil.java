package com.xl.kafka.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * TODO-xule GsonUtil
 *
 * @author xule
 * @since 2022-02-08 09:16
 */
public class GsonUtil {

    private static final Gson gson = new GsonBuilder().create();


    public static String toJsonStr(Object object) {
        if (object == null) {
            return null;
        }

        return gson.toJson(object);
    }


    public static <T> T toObject(String str, Class<T> clazz) {
        if (StringUtils.isBlank(str) || clazz == null) {
            return null;
        }

        return gson.fromJson(str, clazz);
    }
}
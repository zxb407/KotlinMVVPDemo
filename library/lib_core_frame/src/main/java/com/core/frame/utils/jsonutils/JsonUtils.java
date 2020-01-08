package com.core.frame.utils.jsonutils;

import android.text.TextUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <b>Project:</b> android_sdk_base<br>
 * <b>Create Date:</b> 15/9/15<br>
 * <b>Author:</b> Gordon<br>
 * <b>Description:</b>
 * Json converter utils.
 * <br>
 */
@SuppressWarnings("unused")
public class JsonUtils {

    private static final class SingletonHolder {
        private static IJsonConverter INSTANCE = new GsonImpl();
    }

    private JsonUtils() {
        // Prevents instantiation from other classes
    }

    /**
     * Convert json string to target class.
     *
     * @param json  json string
     * @param clazz target class
     * @param <T>   target class type
     * @return target class.
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return SingletonHolder.INSTANCE.fromJson(json, clazz);
    }

    /**
     * Convert json string to target class.
     *
     * @param json json string
     * @param type {@link Type}
     * @param <T>  target class type
     * @return target class
     */
    public static <T> T fromJson(String json, Type type) {
        return SingletonHolder.INSTANCE.fromJson(json, type);
    }

    /**
     * Convert json object to json string
     *
     * @param jsonObject json object
     * @return json string.
     */
    public static String toString(Object jsonObject) {
        if (jsonObject instanceof String) return (String) jsonObject;
        return SingletonHolder.INSTANCE.toJson(jsonObject);
    }


    public static <T> List<T> toList(String json, Class<T> classOfT) {
        if (TextUtils.isEmpty(json)) {
            return new ArrayList<>();
        }
        return SingletonHolder.INSTANCE.fromJson(json, new ListOfJson<>(classOfT));
    }

    public static Map<String, Object> toMap(String json) {
        return SingletonHolder.INSTANCE.toMap(json);
    }

    private static class ListOfJson<T> implements ParameterizedType {

        private Class<?> wrapped;

        ListOfJson(Class<T> wrapper) {
            this.wrapped = wrapper;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}

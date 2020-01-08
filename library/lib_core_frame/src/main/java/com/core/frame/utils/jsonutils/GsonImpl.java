package com.core.frame.utils.jsonutils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * <b>Project:</b> android_sdk_base<br>
 * <b>Create Date:</b> 15/9/15<br>
 * <b>Author:</b> Gordon<br>
 * <b>Description:</b>
 * Gson implements of IJsonConverter.
 * <br>
 */
public class GsonImpl implements IJsonConverter {

    private Gson gson;

    public GsonImpl() {
        gson = new Gson();
    }

    @Override
    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T fromJson(String json, Type type) {
        try {
            return gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toJson(Object jsonObject) {
        return gson.toJson(jsonObject);
    }

    @Override
    public Map<String, Object> toMap(String json) {
        return JSON.parseObject(json, new TypeReference<Map<String, Object>>() {
        });
    }


}

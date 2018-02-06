package com.yj.njh.ret.http.Api;

import android.support.v4.util.ArrayMap;

import com.yj.njh.ret.http.retrofit.RetrofitUtils;

/**
 * Created by xdj on 16/3/14.
 * 接口管理
 */
public class ServiceManager {
    private static final ArrayMap<Class, Object> mServiceMap = new ArrayMap<>();

    public static <T> T create(Class<T> serviceClass) {
        Object service = mServiceMap.get(serviceClass);
        if (service == null) {
            service = RetrofitUtils.get().retrofit().create(serviceClass);
            mServiceMap.put(serviceClass, service);
        }

        return (T) service;
    }
    public static <T> T defCreate(){
        return (T) create(ApiService.class);
    }
}

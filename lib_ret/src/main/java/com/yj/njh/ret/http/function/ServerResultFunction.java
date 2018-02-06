package com.yj.njh.ret.http.function;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.yj.njh.ret.http.exception.ServerException;
import com.yj.njh.ret.http.retrofit.HttpResponse;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 服务器结果处理函数
 *
 * @author ZhongDaFeng
 */
public class ServerResultFunction implements Function<HttpResponse, Object> {
    @Override
    public Object apply(@NonNull HttpResponse response) throws Exception {
        //打印服务器回传结果
        LogUtils.e(response.toString());
        if (!response.isSuccess()) {
            throw new ServerException(response.getCode(), response.getMsg());
        }
        return new Gson().toJson(response.getResult());
    }
}

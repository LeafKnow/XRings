package com.yj.njh.ret.http.Api;


import com.yj.njh.ret.http.bean.ClassDataModel;
import com.yj.njh.ret.http.bean.VoideClassTJBean;
import com.yj.njh.ret.http.bean.VoideInfoListBean;
import com.yj.njh.ret.http.retrofit.HttpResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author ZhongDaFeng
 */
public interface PhoneApi1 {

    @GET("v1/mobile/address/query")
    Observable<HttpResponse> phoneQuery(@QueryMap Map<String, Object> request);

    /**
     * 获取视频类目
     * @param request
     * @return
     */
    @GET("HmR12ApIJack.php?ty=json&ac=list")
    Observable<ClassDataModel> getvideoTitleInfo();

    /**
     * 获取视频列表
     * @param request
     * @return
     */
    @GET("HmR12ApIJack.php?ty=json&ac=videolist")
    Observable<VoideInfoListBean> getvideoListInfo(@QueryMap Map<String, Object> request);
}
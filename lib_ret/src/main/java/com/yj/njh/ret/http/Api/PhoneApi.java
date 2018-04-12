package com.yj.njh.ret.http.Api;


import com.yj.njh.ret.http.bean.HotTopicTjBean;
import com.yj.njh.ret.http.bean.VoideClassTJBean;
import com.yj.njh.ret.http.retrofit.HttpResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author ZhongDaFeng
 */
public interface PhoneApi {

    @GET("v1/mobile/address/query")
    Observable<HttpResponse> phoneQuery(@QueryMap Map<String, Object> request);

    /**
     * 获取视频
     * @param request
     * @return
     */
    @GET("getnewlist.php")
    Observable<List<VoideClassTJBean>> getnewlist(@QueryMap Map<String, Object> request);

    /**
     * 获取名牧推荐
     * @return
     */
    @GET("hot_topic.php")
    Observable<List<HotTopicTjBean>> getHotTopic();
    /**
     * 获取搜索
     * @return
     */
    @GET("select.php")
    Observable<List<HotTopicTjBean>> selectInfo();

}

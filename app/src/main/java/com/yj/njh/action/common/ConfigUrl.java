package com.yj.njh.action.common;

/**
 * Created by niejiahuan on 17/12/16.
 */

public class ConfigUrl {
    /**
     * 获取类别信息
     */
   public static final String GET_CLASS_URL="http://api.hmr12.net/inc/HmR12ApIJack.php?ty=json&ac=list";

    /**
     * 获取类别下的系列问题
     */
   public static final String GET_CLASS_INFO_URL="http://api.hmr12.net/inc/HmR12ApIJack.php?ty=json&ac=videolist&t=";

    /**
     * 获取推荐视频
     */
    public static final String GET_VOIDE_CLASS_TJ_URL="http://i.api.murendao.com/api_i1A5o3P/getnewlist.php";

    /**
     * 获取视频
     */
    public static final String GET_VOIDE_CLASS_TJ2_URL="http://i.api.murendao.com/api_i1A5o3P/getnewlist.php?num=6";
    /**
     * 获取名牧推荐
     */
    public static final String GET_HOT_TOPIC_URL="http://i.api.murendao.com/api_i1A5o3P/hot_topic.php";

    /**
     * 进行搜索
     */
    public static final String GET_SEACH_DAT_URL="http://i.api.murendao.com/api_i1A5o3P/select.php?key=";

}
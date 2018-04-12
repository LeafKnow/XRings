package com.yj.njh.ret.http.bean;

import java.io.Serializable;

/**
 * Created by niejiahuan on 18/1/23.
 */

public class HotTopicTjBean implements Serializable{

    /**
     * id : 2
     * name : 寇绍恩
     * pic : http://img.murendao.com/upload/vodtopic/2018-01/201801191516362880.jpg
     * sort : 2
     */

    private String id;
    private String name;
    private String pic;
    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}

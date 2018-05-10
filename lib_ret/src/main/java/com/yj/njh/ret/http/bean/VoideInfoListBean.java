package com.yj.njh.ret.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niejiahuan on 18/4/10.
 */
public class VoideInfoListBean implements Serializable{

    /**
     * id : 1468
     * name : 神迹的元素
     * type : 36
     * pic : http://img.murendao.com/upload/vod/2018-01/201801191516334915.jpg
     * starring : 周巽正
     * directed : 台北灵粮堂
     * hits : 1572
     * topic : 77
     * picslide : http://img.murendao.com/
     * content : 2017.06.17 神蹟的元素_周巽正牧師
     * time : 2018-01-19 12:09:39
     * playurls : [["http://vod1.hmr12.net/vod2/76周巽正/2017.06.17 神蹟的元素_周巽正牧師.mp4"],["http://vod1.hmr12.net/vod2/76周巽正/2017.06.17 神蹟的元素_周巽正牧師.mp3"]]
     * level : 3
     */

    private String id;
    private String name;
    private String type;
    private String pic;
    private String starring;
    private String directed;
    private String hits;
    private String topic;
    private String picslide;
    private String content;
    private String time;
    private String level;
    private List<List<String>> playurls;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDirected() {
        return directed;
    }

    public void setDirected(String directed) {
        this.directed = directed;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPicslide() {
        return picslide;
    }

    public void setPicslide(String picslide) {
        this.picslide = picslide;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<List<String>> getPlayurls() {
        return playurls;
    }

    public void setPlayurls(List<List<String>> playurls) {
        this.playurls = playurls;
    }
}

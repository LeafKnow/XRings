package com.yj.njh.ret.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niejiahuan on 18/1/23.
 */

public class VoideClassTJBean implements Serializable{

    /**
     * id : 1467
     * name : 超自然大能与使徒性教会特会
     * type : 26
     * pic : http://img.murendao.com/upload/vod/2018-01/201801101515562301.jpg
     * starring : 马都纳多
     * directed : 台北灵粮堂
     * hits : 329
     * topic : 0
     * picslide : http://img.murendao.com/upload/vod/2018-01/201801101515562308.jpg
     * content : 1-信心是超自然的起點2-勝過心思的爭戰3-進入聖靈的運行（上）4-進入聖靈的運行（下）5-渴慕神帶來恩膏6-生命釋放的途徑7-擺脫捆綁的新生命8-耶穌復活的大能
     * time : 2018-01-10 15:56:32
     * playurls : [["http://vod1.hmr12.net/vod2/1-信心是超自然的起點$77马都纳多/超自然大能与使徒性JHTH/1-信心是超自然的起點.mp4","http://vod1.hmr12.net/vod2/2-勝過心思的爭戰$77马都纳多/超自然大能与使徒性JHTH/2-勝過心思的爭戰.mp4","http://vod1.hmr12.net/vod2/3-進入聖靈的運行（上）$77马都纳多/超自然大能与使徒性JHTH/3-進入聖靈的運行（上）.mp4","http://vod1.hmr12.net/vod2/4-進入聖靈的運行（下）$77马都纳多/超自然大能与使徒性JHTH/4-進入聖靈的運行（下）.mp4","http://vod1.hmr12.net/vod2/5-渴慕神帶來恩膏$77马都纳多/超自然大能与使徒性JHTH/5-渴慕神帶來恩膏.mp4","http://vod1.hmr12.net/vod2/6-生命釋放的途徑$77马都纳多/超自然大能与使徒性JHTH/6-生命釋放的途徑.mp4","http://vod1.hmr12.net/vod2/7-擺脫捆綁的新生命$77马都纳多/超自然大能与使徒性JHTH/7-擺脫捆綁的新生命.mp4","http://vod1.hmr12.net/vod2/8-耶穌復活的大能$77马都纳多/超自然大能与使徒性JHTH/8-耶穌復活的大能.mp4"],["http://vod1.hmr12.net/vod2/1-信心是超自然的起點$77马都纳多/超自然大能与使徒性JHTH/1-信心是超自然的起點.mp3","http://vod1.hmr12.net/vod2/2-勝過心思的爭戰$77马都纳多/超自然大能与使徒性JHTH/2-勝過心思的爭戰.mp3","http://vod1.hmr12.net/vod2/3-進入聖靈的運行（上）$77马都纳多/超自然大能与使徒性JHTH/3-進入聖靈的運行（上）.mp3","http://vod1.hmr12.net/vod2/4-進入聖靈的運行（下）$77马都纳多/超自然大能与使徒性JHTH/4-進入聖靈的運行（下）.mp3","http://vod1.hmr12.net/vod2/5-渴慕神帶來恩膏$77马都纳多/超自然大能与使徒性JHTH/5-渴慕神帶來恩膏.mp3","http://vod1.hmr12.net/vod2/6-生命釋放的途徑$77马都纳多/超自然大能与使徒性JHTH/6-生命釋放的途徑.mp3","http://vod1.hmr12.net/vod2/7-擺脫捆綁的新生命$77马都纳多/超自然大能与使徒性JHTH/7-擺脫捆綁的新生命.mp3","http://vod1.hmr12.net/vod2/8-耶穌復活的大能$77马都纳多/超自然大能与使徒性JHTH/8-耶穌復活的大能.mp3"]]
     * level : 2
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

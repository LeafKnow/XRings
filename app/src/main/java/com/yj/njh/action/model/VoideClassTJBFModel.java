package com.yj.njh.action.model;

import com.yj.njh.action.db.dao.VoideClassTJBFModelDao;
import com.yj.njh.action.db.manager.GreenDaoManager;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by niejiahuan on 18/1/23.
 */
@Entity
public class VoideClassTJBFModel {
    @Id
    public Long vId;
//    public VoideClassTJBean() {
//    }
//    public VoideClassTJBean(VoideInfoListBean.ListBean listBean) {
//        this.id = listBean.getId();
//        this.name = listBean.getName();
//        this.type = listBean.getType();
//        this.pic = listBean.getPic();
//        this.starring = listBean.getStarring();
//        this.directed = listBean.getDirected();
//        this.hits = listBean.getHits();
//        this.topic = listBean.getTopic();
//        this.picslide = listBean.getPicslide();
//        this.content = listBean.getDes();
//        this.level = listBean.getLevel();
//
//        String path;
//        String downserver = listBean.getPlayserver();
//        if (downserver.contains("rtmp1vod1")){
//            path="http://wx.vod1.hmr12.net:883/";
//        }else {
//            path="http://wx.vod2.hmr12.net:883/";
//        }
//        String [] split = new String[0];
//        if (listBean.getDl().size() > 0) {
//            String url = listBean.getDl().get(0).getUrl();
//            if (null != url) {
//                split = url.split("#");
//            }
//
//        }
//        List<String> stringList=new ArrayList<>();
//        for (int i = 0; i < split.length; i++) {
//            stringList.add(path+split[i]);
//        }
//        this.playurls=new ArrayList<>();
//        this.playurls.add(stringList);
//    }

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
    private String playurls;


    @Generated(hash = 2116473227)
    public VoideClassTJBFModel(Long vId, String id, String name, String type, String pic, String starring, String directed, String hits, String topic, String picslide, String content, String time, String level, String playurls) {
        this.vId = vId;
        this.id = id;
        this.name = name;
        this.type = type;
        this.pic = pic;
        this.starring = starring;
        this.directed = directed;
        this.hits = hits;
        this.topic = topic;
        this.picslide = picslide;
        this.content = content;
        this.time = time;
        this.level = level;
        this.playurls = playurls;
    }

    @Generated(hash = 1252124040)
    public VoideClassTJBFModel() {
    }


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

    public String getPlayurls() {
        return playurls;
    }

    public void setPlayurls(String playurls) {
        this.playurls = playurls;
    }

    public Long getVId() {
        return this.vId;
    }

    public void setVId(Long vId) {
        this.vId = vId;
    }

    public VoideClassTJBFModelDao getVoideClassTJBFModelDao(){
        return GreenDaoManager.getInstance().getNewSession().getVoideClassTJBFModelDao();
    }
}

package com.yj.njh.action.ui.stores;


import com.yj.njh.common.flux.annotation.BindAction;
import com.yj.njh.common.flux.dispatcher.Dispatcher;
import com.yj.njh.common.flux.stores.Store;

import java.util.HashMap;


/**
 * Created by liuhaizhu on 2017/4/24.
 */

public class LoginStore extends Store {
    public LoginStore(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @BindAction("login")
    public void login(HashMap<String, Object> data) {
        emitStoreChange("login", data);
    }
    @BindAction("getnewlist")
    public void getnewlist(HashMap<String, Object> data) {
        emitStoreChange("getnewlist", data);
    }
    @BindAction("getHotTopic")
    public void getHotTopic(HashMap<String, Object> data) {
        emitStoreChange("getHotTopic", data);
    }
    @BindAction("select")
    public void selectInfo(HashMap<String, Object> data) {
        emitStoreChange("select", data);
    }
    @BindAction("getvideoTitleInfo")
    public void getvideoTitleInfo(HashMap<String, Object> data) {
        emitStoreChange("getvideoTitleInfo", data);
    }
    @BindAction("getvideoListInfo")
    public void getvideoListInfo(HashMap<String, Object> data) {
        emitStoreChange("getvideoListInfo", data);
    }

}

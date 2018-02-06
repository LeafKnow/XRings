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


}

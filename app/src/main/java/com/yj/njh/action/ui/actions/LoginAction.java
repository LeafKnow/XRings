package com.yj.njh.action.ui.actions;


import com.yj.njh.base.base.act.BaseView;
import com.yj.njh.common.base.BaseFluxFragment;
import com.yj.njh.common.flux.actions.ActionsCreator;
import com.yj.njh.common.flux.dispatcher.Dispatcher;
import com.yj.njh.ret.http.Api.PhoneApi;
import com.yj.njh.ret.http.Api.ServiceManager;

import java.util.Map;


/**
 * 用户相关的接口都在此处
 */

public class LoginAction extends ActionsCreator {
    public LoginAction(Dispatcher dispatcher, BaseView view) {
        super(dispatcher,view);
    }

    public void login(Map<String,Object> params, BaseFluxFragment act) {
        reqDate(ServiceManager.create(PhoneApi.class).phoneQuery(params),
                act,true, "login");
    }

}

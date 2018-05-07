package com.yj.njh.action.ui.actions;


import com.yj.njh.base.base.act.BaseView;
import com.yj.njh.common.base.BaseFluxActivity;
import com.yj.njh.common.base.BaseFluxFragment;
import com.yj.njh.common.flux.actions.ActionsCreator;
import com.yj.njh.common.flux.dispatcher.Dispatcher;
import com.yj.njh.ret.http.Api.PhoneApi;
import com.yj.njh.ret.http.Api.PhoneApi1;
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
    public void getnewlist(Map<String,Object> params, BaseFluxActivity act) {
        reqDate(ServiceManager.create(PhoneApi.class).getnewlist(params),
                act,true, "getnewlist");
    }
    public void getHotTopic(BaseFluxActivity act) {
        reqDate(ServiceManager.create(PhoneApi.class).getHotTopic(),
                act,true, "getHotTopic");
    }
    public void selectInfo(Map<String,Object> params,BaseFluxActivity act) {
        reqDate(ServiceManager.create(PhoneApi.class).selectInfo(),
                act,true, "select");
    }
    public void getvideoTitleInfo(BaseFluxActivity act) {
        reqDate(ServiceManager.create1(PhoneApi1.class).getvideoTitleInfo(),
                act,true, "getvideotype");
    }
    public void getvideoListInfo(Map<String,Object> params,BaseFluxActivity act) {
        reqDate(ServiceManager.create1(PhoneApi1.class).getvideoListInfo(params),
                act,true, "getvideoListInfo");
    }
}

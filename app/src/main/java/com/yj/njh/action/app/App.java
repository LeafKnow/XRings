package com.yj.njh.action.app;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.action.BuildConfig;
import com.yj.njh.common.app.ComApp;
import com.yj.njh.ret.http.retrofit.TokenManager;

/**
 * Created by niejiahuan on 18/2/3.
 */

public class App extends ComApp {
    @Override
    public void onCreate() {
        super.onCreate();
        Rigger.enableDebugLogging(BuildConfig.IS_DEBUG);
        Utils.init(this);
        LogUtils.getConfig().setConsoleSwitch(BuildConfig.IS_DEBUG);
        TokenManager.getInstance().initOnApplicationCreate();
    }
}

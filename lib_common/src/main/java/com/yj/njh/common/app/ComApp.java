package com.yj.njh.common.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.base.base.app.XBaseApp;
import com.yj.njh.ret.http.retrofit.TokenManager;

/**
 * Created by niejiahuan on 18/2/3.
 */

public class ComApp extends XBaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
    public void setDeBug(boolean isDebug){
        Rigger.enableDebugLogging(isDebug);
        LogUtils.getConfig().setConsoleSwitch(isDebug);
        TokenManager.getInstance().initOnApplicationCreate();
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}

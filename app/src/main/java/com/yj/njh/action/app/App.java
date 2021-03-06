package com.yj.njh.action.app;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.yj.njh.action.BuildConfig;
import com.yj.njh.common.app.ComApp;

/**
 * Created by niejiahuan on 18/2/3.
 */

public class App extends ComApp {
    static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        CrashReport.initCrashReport(getApplicationContext(), "9fec5bedc3", true);
        setDeBug(BuildConfig.IS_DEBUG);
    }

    public static Context getContext() {
        return context;
    }
}

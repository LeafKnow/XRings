package com.yj.njh.action.app;

import android.content.Context;

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
        setDeBug(BuildConfig.IS_DEBUG);
    }

    public static Context getContext() {
        return context;
    }
}

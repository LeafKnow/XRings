package com.yj.njh.action.app;

import com.yj.njh.action.BuildConfig;
import com.yj.njh.common.app.ComApp;

/**
 * Created by niejiahuan on 18/2/3.
 */

public class App extends ComApp {
    @Override
    public void onCreate() {
        super.onCreate();

        setDeBug(BuildConfig.IS_DEBUG);
    }
}

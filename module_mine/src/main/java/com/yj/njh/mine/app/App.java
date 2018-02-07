package com.yj.njh.mine.app;

import com.yj.njh.common.app.ComApp;
import com.yj.njh.mine.BuildConfig;

/**
 * Created by niejiahuan on 18/2/7.
 */

public class App extends ComApp {
    @Override
    public void onCreate() {
        super.onCreate();
        setDeBug(BuildConfig.DEBUG);
    }
}

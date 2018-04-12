package com.yj.njh.action.ui.launch;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.yj.njh.action.MainActivity;
import com.yj.njh.action.R;
import com.yj.njh.common.base.BaseFluxActivity;

/**
 * 启动界面
 */
public class LaunchAct extends BaseFluxActivity {

    @Override
    public void initData(Bundle savedInstanceState) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchAct.this, MainActivity.class));
                LaunchAct.this.finish();
            }
        },5000);
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_launch;
    }
}

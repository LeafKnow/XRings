package com.yj.njh.mine.ui.act;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yj.njh.common.base.BaseFluxActivity;
import com.yj.njh.common.constant.Constants;
import com.yj.njh.mine.R;
// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = Constants.LOGIN_ACT)
public class LoginAct extends BaseFluxActivity {


    @Override
    protected boolean isSwipeBackEnable() {
        return true;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
}

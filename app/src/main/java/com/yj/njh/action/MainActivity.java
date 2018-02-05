package com.yj.njh.action;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.base.base.act.BaseActivity;
@Puppet(containerViewId = R.id.fm_content, bondContainerView = true)
public class MainActivity extends BaseActivity{


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected boolean isSwipeBackEnable() {
        return false;
    }

    @Override
    protected void initBundleData() {
        Rigger.getRigger(this).startFragment(BlankFragment.newInstance());
    }

}

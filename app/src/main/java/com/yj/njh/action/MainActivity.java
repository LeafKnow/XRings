package com.yj.njh.action;

import android.os.Bundle;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.common.base.action.ActionAct;

@Puppet(containerViewId = R.id.fm_content, bondContainerView = true)
public class MainActivity extends ActionAct {

    @Override
    public void initBus() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {
        Rigger.getRigger(this).startFragment(BlankFragment.newInstance());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

}

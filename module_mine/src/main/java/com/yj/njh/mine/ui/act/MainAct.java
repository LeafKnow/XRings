package com.yj.njh.mine.ui.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.common.base.action.ActionAct;
import com.yj.njh.common.constant.Constants;
import com.yj.njh.mine.R;
import com.yj.njh.mine.R2;

@Puppet(containerViewId = R2.id.fm_mine_content, bondContainerView = true)
public class MainAct extends ActionAct {

    @Override
    public void initBus() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {
        // 获取Fragment
        Fragment fragment = (Fragment) ARouter.getInstance().build(Constants.MINE_FMT).navigation();
        if (null!=fragment)
            Rigger.getRigger(this).startFragment(fragment);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}

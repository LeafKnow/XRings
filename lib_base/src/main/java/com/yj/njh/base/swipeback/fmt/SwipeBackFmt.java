package com.yj.njh.base.swipeback.fmt;

import android.os.Bundle;

import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.base.base.fmt.BaseFragment;
import com.yj.njh.base.swipeback.SwipeBackLayout;
import com.yj.njh.base.swipeback.act.SwipeBackBase;

public abstract class SwipeBackFmt extends BaseFragment implements SwipeBackBase
        ,SwipeBackLayout.OnScrollFinish {
    private SwipeBackFmtHelper mHelper;

    @Override
    protected void init(Bundle savedInstanceState) {
        mHelper = new SwipeBackFmtHelper(this);
        mHelper.onActivityCreate();
        getSwipeBackLayout().setOnScrollFinish(this);
        mHelper.onPostCreate(mContentView);
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void onScFinish() {
        Rigger.getRigger(this).onBackPressed();
    }

}

package com.yj.njh.base.swipeback.act;

import android.os.Bundle;

import com.yj.njh.base.base.act.BaseActivity;
import com.yj.njh.base.swipeback.SwipeBackLayout;


public abstract class SwipeBackAct extends BaseActivity implements SwipeBackBase
        ,SwipeBackLayout.OnScrollFinish {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        getSwipeBackLayout().setOnScrollFinish(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
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
        this.finish();
    }
}

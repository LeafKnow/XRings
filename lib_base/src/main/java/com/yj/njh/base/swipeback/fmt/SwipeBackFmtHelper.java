package com.yj.njh.base.swipeback.fmt;

import android.view.LayoutInflater;
import android.view.View;

import com.yj.njh.base.R;
import com.yj.njh.base.base.fmt.BaseFragment;
import com.yj.njh.base.swipeback.SwipeBackLayout;


/**
 * @author njh
 */
public class SwipeBackFmtHelper {
    private BaseFragment mFragment;

    private SwipeBackLayout mSwipeBackLayout;

    public SwipeBackFmtHelper(BaseFragment fragment) {
        mFragment = fragment;
    }

    @SuppressWarnings("deprecation")
    public void onActivityCreate() {
        mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(mFragment.getActivity()).inflate(
                R.layout.swipeback_layout, null);

    }

    public void onPostCreate(View view) {
        mSwipeBackLayout.attachToFragment(mFragment,view);
    }

    public View findViewById(int id) {
        if (mSwipeBackLayout != null) {
            return mSwipeBackLayout.findViewById(id);
        }
        return null;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout;
    }
}

package com.yj.njh.mine.ui.fmt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.yj.njh.common.base.action.ActionFmt;
import com.yj.njh.common.constant.Constants;
import com.yj.njh.mine.R;
import com.yj.njh.mine.R2;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = Constants.MINE_FMT)
public class MineFmt extends ActionFmt {


    @BindView(R2.id.tv_login1)
    TextView tvLogin1;
    Unbinder unbinder;

    public MineFmt() {
        // Required empty public constructor
    }

    @Override
    public void initBus() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine_fmt;
    }



    @OnClick(R2.id.tv_login1)
    public void onViewClicked() {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
        ARouter.getInstance().build(Constants.LOGIN_ACT).navigation(this.getActivity(), new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                LogUtils.d("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                LogUtils.d("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                LogUtils.d("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                LogUtils.d("ARouter", "被拦截了");
            }
        });
    }
}

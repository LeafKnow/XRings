package com.yj.njh.main.ui.fmt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.njh.common.base.action.ActionFmt;
import com.yj.njh.common.constant.Constants;
import com.yj.njh.main.R;
import com.yj.njh.main.R2;
import com.yj.njh.widget.bom.BottomBar;
import com.yj.njh.widget.bom.BottomBarTab;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = Constants.MAIN_FMT)
public class MainFmt extends ActionFmt {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    @BindView(R2.id.btnbar)
    BottomBar btnbar;
    @BindView(R2.id.view_root)
    LinearLayout viewRoot;
    private ActionFmt[] mFragments = new ActionFmt[3];
    private ArrayList<String> mFragmentTags;
    private int mPosition;
    public MainFmt() {
        // Required empty public constructor
    }

    @Override
    public void initBus() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mFragmentTags = new ArrayList<>();
            mFragments[FIRST] = getFragment(Constants.HOME_FMT);
            mFragments[SECOND] = getFragment(Constants.SHOPPING_CART_FMT);
            mFragments[THIRD] = getFragment(Constants.MINE_FMT);
            for (int i = 0; i < mFragments.length; i++) {
                mFragmentTags.add(Rigger.getRigger(mFragments[i]).getFragmentTAG());
                Rigger.getRigger(this).addFragment(R.id.fl_tab_container, mFragments[i]);
            }
            btnbar.addItem(new BottomBarTab(getActivity(),
                    R.drawable.ic_message_white_24dp,
                    R.drawable.ic_message_white_24dp,"首页"))
                    .addItem(new BottomBarTab(getActivity(),
                            R.drawable.ic_account_circle_white_24dp,
                            R.drawable.ic_message_white_24dp, "聊天"))
                    .addItem(new BottomBarTab(getActivity(),
                            R.drawable.ic_discover_white_24dp,
                            R.drawable.ic_message_white_24dp, "个人"));

            // 模拟未读消息
            btnbar.getItem(FIRST).setUnreadCount(-1);

            btnbar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
                @Override
                public void onTabSelected(int position, int prePosition) {
                    mPosition=position;
                    Rigger.getRigger(MainFmt.this).showFragment(mFragmentTags.get(position));
                }

                @Override
                public void onTabUnselected(int position) {

                }

                @Override
                public void onTabReselected(int position) {
                    mPosition=position;
                    // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                    Rigger.getRigger(MainFmt.this).showFragment(mFragmentTags.get(position));
                }
            });
            btnbar.setCurrentItem(mPosition);
        } else {
            Rigger.getRigger(this).showFragment(mFragmentTags.get(mPosition));
        }

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_fmt;
    }



}

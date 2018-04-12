package com.yj.njh.spcart.ui.fmt;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yj.njh.common.base.action.ActionFmt;
import com.yj.njh.common.constant.Constants;
import com.yj.njh.spcart.R;

/**
 * A simple {@link Fragment} subclass.
 */
@Route(path = Constants.SHOPPING_CART_FMT)
public class ShoppingCartFmt extends ActionFmt {


    public ShoppingCartFmt() {
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
        return R.layout.fragment_shopping_cart_fmt;
    }
}

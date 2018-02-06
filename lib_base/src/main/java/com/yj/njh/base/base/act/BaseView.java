package com.yj.njh.base.base.act;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by niejiahuan
 */

public interface BaseView {
    void initBus();
    void initData(Bundle savedInstanceState);

    void setListener();

    int getLayoutId();

    Context getContext();

    void showToast(String msg);

    void showLoading();

    void hideLoading();

    void onError(int code, String msg);
}
package com.yj.njh.common.base.action;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yj.njh.base.base.act.BaseActivity;
import com.yj.njh.common.utils.DialogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public abstract class ActionAct extends BaseActivity {
    private Toast mToast;
    private ProgressDialog mProgressDialog;

    @Override
    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    protected void showProgressDialog() {
        showProgressDialog("加载中,请稍后...");
    }

    protected void showProgressDialog(String message) {
        showProgressDialog(message, true);
    }

    protected void showProgressDialog(String message, boolean cancelable) {
        if (mProgressDialog == null)
            mProgressDialog = DialogUtil.createProgressDialog(this, message, cancelable);
        if (mProgressDialog.isShowing()) {
            hideDialog();
            return;
        } else {
            try {
                mProgressDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void hideDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        hideDialog();
    }


    public Observable click(View view) {
        return throttleFirst(RxView.clicks(view));
    }
    /**
     * 防抖动，防止快速点击
     *
     * @param observable
     * @param <T>
     * @return
     */
    protected <T extends Object> Observable<T> throttleFirst(Observable<T> observable) {
        return observable.throttleFirst(30000, TimeUnit.MILLISECONDS);
    }

    /**
     * 将事件与生命周期绑定
     *
     * @param observable
     * @return
     */
    protected <T extends Object> Observable<T> bindLife(Observable<T> observable) {
        return (Observable<T>) observable.compose(bindToLifecycle());
    }

    /**
     * 指定事件在哪个生命周期结束
     *
     * @param observable
     * @param event      生命周期
     * @return
     */
    protected <T extends Object> Observable<T> bindUntil(Observable<T> observable, ActivityEvent event) {
        return (Observable<T>) observable.compose(bindUntilEvent(event));
    }

    @Override
    public void onError(int code, String msg) {
        if (code==401){
//            UserInfoManager.getInstance().clearData();
//            AppManager.getAppManager().finishAllActivity();
//            startActivity(new Intent(BaseActivity.this, LoginAct.class));
//            showToast("登录失效，请重新登录");
        }else {
            if (null != msg && !TextUtils.isEmpty(msg)) {
                showToast(msg);
            }
        }
    }

}

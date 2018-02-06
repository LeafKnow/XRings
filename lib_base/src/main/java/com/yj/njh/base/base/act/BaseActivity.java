package com.yj.njh.base.base.act;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yj.njh.base.listener.LifeCycleListener;
import com.yj.njh.base.manager.ActivityStackManager;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import pub.devrel.easypermissions.EasyPermissions;



/**
 * 基类Activity
 * 备注:所有的Activity都继承自此Activity
 * 1.规范团队开发
 * 2.统一处理Activity所需配置,初始化
 *
 * @author ZhongDaFeng
 */
public abstract class BaseActivity extends RxAppCompatActivity
        implements EasyPermissions.PermissionCallbacks,BaseView{

    protected Context mContext;
    protected Unbinder unBinder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getManager().push(this);
        setContentView(getLayoutId());
        mContext = this;
        unBinder = ButterKnife.bind(this);
        initBus();
        initData(savedInstanceState);
        setListener();
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)//获取当前页面
                .setSwipeBackEnable(isSwipeBackEnable())//设置是否可滑动
                .setScrimColor(Color.TRANSPARENT);//底层阴影颜色;
    }

    protected boolean isSwipeBackEnable() {
        return false;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mListener != null) {
            mListener.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mListener != null) {
            mListener.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mListener != null) {
            mListener.onDestroy();
        }
        //移除view绑定
        if (unBinder != null) {
            unBinder.unbind();
        }
        SwipeBackHelper.onDestroy(this);
        ActivityStackManager.getManager().remove(this);
    }
    /**
     * 回调函数
     */
    public LifeCycleListener mListener;

    public void setOnLifeCycleListener(LifeCycleListener listener) {
        mListener = listener;
    }
}

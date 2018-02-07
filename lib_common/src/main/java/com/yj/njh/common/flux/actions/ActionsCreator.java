package com.yj.njh.common.flux.actions;


import android.os.Bundle;

import com.yj.njh.base.base.act.BaseActivity;
import com.yj.njh.base.base.act.BaseFmtActivity;
import com.yj.njh.base.base.act.BaseView;
import com.yj.njh.base.base.fmt.BaseFragment;
import com.yj.njh.base.listener.LifeCycleListener;
import com.yj.njh.common.flux.dispatcher.Dispatcher;
import com.yj.njh.common.http.Sniffer;
import com.yj.njh.ret.http.observer.HttpRxObservable;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;


/**
 * Created by lgvalle on 02/08/15.
 */
public class ActionsCreator<V extends BaseView,T extends LifeCycleListener> implements LifeCycleListener{
    protected Reference<V> mViewRef;
    protected V mView;
    protected Reference<T> mActivityRef;
    protected T mActivity;
    Map<String,Sniffer> snifferMap=new HashMap<>();
    protected final Dispatcher dispatcher;
    protected final long RETRY_TIMES = 0;
    public ActionsCreator(Dispatcher dispatcher,V v) {
        this.dispatcher = dispatcher;
        this.mView=v;
//        this.mActivity=t;
//        attachActivity(t);
//        attachView(v);
//        setListener(t);
    }
    protected void reqDate(Observable apiObservable, BaseActivity activity, boolean isShow, final String tag){
        snifferMap.put(tag,new Sniffer(dispatcher,mView,isShow,tag));
        HttpRxObservable.getObservable(apiObservable, activity)
                .subscribe(snifferMap.get(tag));
    }
    protected void reqDate(Observable apiObservable, BaseFragment fragment, boolean isShow, final String tag){
        snifferMap.put(tag,new Sniffer(dispatcher,mView,isShow,tag));
        HttpRxObservable.getObservable(apiObservable, fragment)
                .subscribe(snifferMap.get(tag));
    }

    /**
     * 设置生命周期监听
     *
     * @author ZhongDaFeng
     */
    private void setListener(T activity) {
        if (getActivity() != null) {
            if (activity instanceof BaseActivity) {
                ((BaseActivity) getActivity()).setOnLifeCycleListener(this);
            } else if (activity instanceof BaseFmtActivity) {
                ((BaseFmtActivity) getActivity()).setOnLifeCycleListener(this);
            }else if (activity instanceof BaseFragment){
                ((BaseFragment) getActivity()).setOnLifeCycleListener(this);
            }
        }
    }

    /**
     * 关联
     *
     * @param view
     */
    private void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
        mView = mViewRef.get();
    }

    /**
     * 关联
     *
     * @param activity
     */
    private void attachActivity(T activity) {
        mActivityRef = new WeakReference<T>(activity);
        mActivity = mActivityRef.get();
    }

    /**
     * 销毁
     */
    private void detachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * 销毁
     */
    private void detachActivity() {
        if (isActivityAttached()) {
            mActivityRef.clear();
            mActivityRef = null;
        }
    }

    /**
     * 获取
     *
     * @return
     */
    public V getView() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }

    /**
     * 获取
     *
     * @return
     */
    public T getActivity() {
        if (mActivityRef == null) {
            return null;
        }
        return mActivityRef.get();
    }

    /**
     * 是否已经关联
     *
     * @return
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 是否已经关联
     *
     * @return
     */
    public boolean isActivityAttached() {
        return mActivityRef != null && mActivityRef.get() != null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        detachView();
        detachActivity();
    }
}

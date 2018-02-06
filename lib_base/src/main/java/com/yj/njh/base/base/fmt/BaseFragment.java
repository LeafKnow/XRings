package com.yj.njh.base.base.fmt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.yj.njh.base.base.act.BaseView;
import com.yj.njh.base.listener.LifeCycleListener;

/**
 * Base fragment.
 *
 * @author JingYeoh
 *         <a href="mailto:yangjing9611@foxmail.com">Email me</a>
 *         <a href="https://github.com/justkiddingbaby">Github</a>
 *         <a href="http://blog.justkiddingbaby.com">Blog</a>
 * @since Nov 22,2017
 */
@Puppet
public abstract class BaseFragment extends RxFragment implements BaseView {

  protected static final String BUNDLE_KEY = "/bundle/key";
  protected View mContentView;
  protected Context mContext;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    mContext = context;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    mContentView = inflater.inflate(getLayoutId(), container, false);
    return mContentView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initBus();
    initData(savedInstanceState);
    setListener();
  }
  public void onFragmentResult(int requestCode, int resultCode, Bundle args){

  }

  @Override
  public Context getContext() {
    return super.getContext();
  }

  LifeCycleListener mListener;

  public void setOnLifeCycleListener(LifeCycleListener lifeCycleListener) {
    this.mListener = lifeCycleListener;
  }
  @Override
  public void onStart() {
    super.onStart();
    if (mListener != null) {
      mListener.onStart();
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    if (mListener != null) {
      mListener.onResume();
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    if (mListener != null) {
      mListener.onPause();
    }
  }

  @Override
  public void onStop() {
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
  }

}

package com.yj.njh.base.base.fmt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.trello.rxlifecycle2.components.RxFragment;

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
public abstract class BaseFragment extends RxFragment  {

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
    mContentView = inflater.inflate(getContentView(), container, false);
    return mContentView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    init(savedInstanceState);
  }
  public void onFragmentResult(int requestCode, int resultCode, Bundle args){

  }
  @LayoutRes
  protected abstract int getContentView();

  protected abstract void init(Bundle savedInstanceState);

  protected View findViewById(@IdRes int id) {
    return mContentView.findViewById(id);
  }
}

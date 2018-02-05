package com.yj.njh.action;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.yj.njh.base.base.fmt.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends BaseFragment {

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getContentView() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }


}

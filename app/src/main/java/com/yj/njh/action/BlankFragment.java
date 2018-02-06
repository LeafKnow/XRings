package com.yj.njh.action;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.yj.njh.action.ui.actions.LoginAction;
import com.yj.njh.action.ui.stores.LoginStore;
import com.yj.njh.common.base.BaseFluxFragment;
import com.yj.njh.common.flux.stores.Store;
import com.yj.njh.ret.http.retrofit.HttpRequest;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends BaseFluxFragment<LoginStore,LoginAction> {
   String TAG=BlankFragment.class.getName();
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected boolean flux() {
        return true;
    }

    /**
     * 获取信息
     *
     * @author ZhongDaFeng
     */
    public void getInfo(String phone) {

        //构建请求数据
        Map<String, Object> request = HttpRequest.getRequest();
        request.put("phone", phone);
        actionsCreator().login(request,this);

    }

    @Override
    public void initBus() {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        getInfo("13720342920");
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void updateView(Store.StoreChangeEvent event) {
        super.updateView(event);
        if (event.code==200){

        }
    }
}

package com.yj.njh.action;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.yj.njh.action.ui.actions.LoginAction;
import com.yj.njh.action.ui.stores.LoginStore;
import com.yj.njh.common.base.BaseFluxFragment;
import com.yj.njh.common.flux.stores.Store;
import com.yj.njh.ret.http.retrofit.HttpRequest;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends BaseFluxFragment<LoginStore, LoginAction> {
    String TAG = BlankFragment.class.getName();
    @BindView(R.id.tv_login)
    TextView tvLogin;

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
        actionsCreator().login(request, this);

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
        if (event.code == 200) {

        }
    }

    @OnClick(R.id.tv_login)
    public void onViewClicked() {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
        ARouter.getInstance().build("/mine/login").navigation(this.getActivity(), new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                LogUtils.d("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                LogUtils.d("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                LogUtils.d("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                LogUtils.d("ARouter", "被拦截了");
            }
        });
    }
}

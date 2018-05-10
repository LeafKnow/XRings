package com.yj.njh.action.ui.vlist;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.lemon95.androidtvwidget.bridge.EffectNoDrawBridge;
import com.lemon95.androidtvwidget.bridge.OpenEffectBridge;
import com.lemon95.androidtvwidget.view.GridViewTV;
import com.lemon95.androidtvwidget.view.ListViewTV;
import com.lemon95.androidtvwidget.view.MainUpView;
import com.yj.njh.action.R;
import com.yj.njh.action.ui.actions.LoginAction;
import com.yj.njh.action.ui.adapter.ConditionsAdapter;
import com.yj.njh.action.ui.adapter.GridViewAdapter;
import com.yj.njh.action.ui.search.SearchActivity;
import com.yj.njh.action.ui.stores.LoginStore;
import com.yj.njh.action.ui.vlist.details.MovieDetailsActivity2;
import com.yj.njh.common.base.BaseFluxActivity;
import com.yj.njh.common.flux.stores.Store;
import com.yj.njh.ret.http.Api.PhoneApi;
import com.yj.njh.ret.http.Api.PhoneApi1;
import com.yj.njh.ret.http.Api.ServiceManager;
import com.yj.njh.ret.http.bean.LMClassBean;
import com.yj.njh.ret.http.bean.VoideClassTJBean;
import com.yj.njh.ret.http.bean.VoideInfoListBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class VideoListActivity extends BaseFluxActivity<LoginStore,LoginAction> {

    private ListViewTV lemon_video_menu_id;
    private MainUpView mainUpView2;
    OpenEffectBridge mOpenEffectBridge;
    private ProgressBar lemon_movie_details_pro1,lemon_movie_details_pro2;
    private LinearLayout lemon_movie_details_main,lemon_ll;
    private boolean isKeyDown = false;
    private ConditionsAdapter conditionsAdapter;
    private View mOldListView;
    private View mOldGridView;
    private GridViewTV gridView;
    private GridViewAdapter gridViewAdapter;
    private List<VoideInfoListBean> videoList = new ArrayList<>(); //影片
    private List<LMClassBean> conditionsArrayList;
    private int page = 1;
    private TextView lemon_title;
    private boolean isPage = true; //是否在翻页
    private long totleCount ;
    private boolean isStart = false;
    private boolean isListClick = true;
    private int point = 0; //gridview 位置
    private TextView lemon_search;

    @Override
    protected boolean flux() {
        return true;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setupViews();
        initialized();
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_list;
    }


    protected void setupViews() {
        initViewMove();
        lemon_video_menu_id = (ListViewTV) findViewById(R.id.lemon_video_menu_id);
        lemon_search = (TextView) findViewById(R.id.lemon_search);
        lemon_video_menu_id.setItemsCanFocus(true);
        gridView = (GridViewTV) findViewById(R.id.gridView);
        gridView.setIsSearch(true);
        lemon_movie_details_pro1 = (ProgressBar) findViewById(R.id.lemon_movie_details_pro1);
        lemon_movie_details_pro2 = (ProgressBar) findViewById(R.id.lemon_movie_details_pro2);
        lemon_movie_details_main = (LinearLayout) findViewById(R.id.lemon_movie_details_main);
        lemon_ll = (LinearLayout) findViewById(R.id.lemon_ll);
        lemon_title = (TextView) findViewById(R.id.lemon_title);
        mOpenEffectBridge.setVisibleWidget(true); // 隐藏
        lemon_video_menu_id.requestFocus();
        gridViewAdapter = new GridViewAdapter(videoList,this);
        gridView.setAdapter(gridViewAdapter);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
       // gridView.setFocusable(false);  //初始化时不让Gridview抢焦点
        lemon_video_menu_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (view != null && isStart) {
                    // 子控件置顶，必需使用ListViewTV才行，
                    // 不然焦点会错乱.
                    // 不要忘记这句关键的话哦.
                    gridView.setFocusable(true);
//                    LogUtils.i(TAG, "离开焦点2");
                    view.bringToFront();
                }
               /* View view1 = lemon_video_menu_id.getChildAt(0);
                if (view1 != null && isListClick) {
                    isListClick = false;
                    TextView textView = (TextView)view1.findViewById(R.id.lemon_video_tv);
                    textView.setTextColor(Color.WHITE);
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        lemon_video_menu_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lemon_video_menu_id.setPoint(position);
                initListColor();
                conditionsAdapter.setPoint(position);
                TextView textView = (TextView) view.findViewById(R.id.lemon_video_tv);
                textView.setTextColor(Color.WHITE);
                mOldListView = view;
//                ClassDataModel.ClassBean classBean = conditionsArrayList.get(position);
                page = 1;
                mOldGridView = null;
                lemon_title.setText(conditionsArrayList.get(position).getName());
                showPro2();
                videoList.clear();
                totleCount =0;
                gridViewAdapter.notifyDataSetChanged();
                point = 0;
                gridView.smoothScrollToPosition(0);  //定位到顶部

                lemon_video_menu_id.requestFocus();
                mainUpView2.setVisibility(View.GONE);
                mOpenEffectBridge.setVisibleWidget(true); // 隐藏
                mainUpView2.setUpRectResource(R.drawable.test_rectangle); // 设置移动边框的图片.
//                videoListPresenter.getCombSearch(queryConditions.getAreaId(), queryConditions.getGenreId(), queryConditions.getGroupId(), queryConditions.getChargeMethod(), queryConditions.getVipLevel(), queryConditions.getYear(), queryConditions.getType(), page + "", AppConstant.PAGESIZE);
                getvideoListInfo(conditionsArrayList.get(position).getId());
            }
        });
        lemon_video_menu_id.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    isStart = false;
                    mOpenEffectBridge.setVisibleWidget(true);
                    lemon_video_menu_id.setSelector(R.drawable.lemon_liangguang_03);
                    // textView.setTextColor(getResources().getColor(R.color.lemon_b3aeae));
                } else {
                    gridView.setPoint(point);
                    lemon_video_menu_id.setSelector(R.color.lemon_0E0A0B);
                }
            }
        });
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /**
                 * 这里注意要加判断是否为NULL.
                 * 因为在重新加载数据以后会出问题.
                 */
                // mOpenEffectBridge.setVisibleWidget(false);
                if (view != null) {
                    if (point == 0) {
                        if (mOldGridView != view) {
                            view.bringToFront();
                            LogUtils.i("onItemSelected", "放大" + position);
                            mainUpView2.setFocusView(view, mOldGridView, 1.1f);
                        }
                    } else {
                        view.bringToFront();
                        LogUtils.i("onItemSelected", "放大" + position);
                        mainUpView2.setFocusView(view, mOldGridView, 1.1f);
                    }
                }
                point = position;
                mOldGridView = view;
                int size = videoList.size();
                if (size - 15 < position && size < totleCount) {
                    if (isPage) {
                        //翻页
                        page = page + 1;
                        int poi = lemon_video_menu_id.getSelectedItemPosition();
//                        QueryConditions queryConditions = conditionsArrayList.get(poi);
//                        videoListPresenter.getCombSearch(queryConditions.getAreaId(), queryConditions.getGenreId(), queryConditions.getGroupId(), queryConditions.getChargeMethod(), queryConditions.getVipLevel(), queryConditions.getYear(), queryConditions.getType(), page + "", AppConstant.PAGESIZE);
                        isPage = false;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                VoideClassTJBean voideClassTJBean=new VoideClassTJBean(videoList.get(position));
                bundle.putSerializable("videoInfo",voideClassTJBean);
                startActivity(new Intent(VideoListActivity.this,MovieDetailsActivity2.class)
                        .putExtras(bundle));
//                }
//                VideoSearchList.Data.VideoBriefs video = videoList.get(position);
//                if (AppConstant.FUNNY.equals(video.getVideoTypeId())) {
//                    //搞笑
//                    Bundle bundle = new Bundle();
//                    bundle.putString("videoId", video.getVideoId());
//                    bundle.putString("SerialEpisodeId", "");
//                    bundle.putString("videoName", video.getVideoName());
//                    bundle.putString("videoType", video.getVideoTypeId());
//                    startActivity(BdPalyActivity.class, bundle);
//                } else {
//                    Bundle bundle = new Bundle();
//                    bundle.putString("videoId", video.getVideoId());
//                    bundle.putString("videoType", video.getVideoTypeId());
//                    bundle.putString("isNew", video.getIsNew());
//                    startActivity(MovieDetailsActivity.class, bundle);
//                }
            }
        });
        gridView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                LogUtils.i("onFocusChange", "gridView" + hasFocus);
                if (hasFocus) {
                    mOpenEffectBridge.setVisibleWidget(false);
                    mainUpView2.setUpRectResource(R.drawable.health_focus_border); // 设置移动边框的图片.
                    //if (!isListClick) {
                    if (mOldGridView == null) {
                        myHandler.postAtFrontOfQueue(new Runnable() {
                            public void run() {
                                LogUtils.i("onFocusChange", "空");
                                gridView.setSelection(0);
                                //isListClick = false;
                                mOldGridView = gridView.getChildAt(0);
                                mainUpView2.setFocusView(mOldGridView, 1.1f);
                            }
                        });
                    } else {
                        LogUtils.i("onFocusChange", "非空");
                        mainUpView2.setFocusView(mOldGridView, 1.1f);
                    }
                     /*} else {
                        mainUpView2.setFocusView(mOldGridView, 1.1f);
                    }*/
                } else {
                    // mainUpView2.setVisibility(View.GONE);
                    mOpenEffectBridge.setVisibleWidget(true); // 隐藏
                    mainUpView2.setUpRectResource(R.drawable.test_rectangle); // 设置移动边框的图片.
                    mainUpView2.setUnFocusView(mOldGridView);
                }
            }
        });
        //搜索
        lemon_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoListActivity.this,SearchActivity.class));
            }
        });
        lemon_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                   // lemon_video_menu_id.setIsParam(false);
                } else {
                    lemon_video_menu_id.setIsParam(false);
                }
            }
        });
    }

    public void initListColor() {
        for (int i=0;i<conditionsArrayList.size();i++) {
            View view = lemon_video_menu_id.getChildAt(i);
            if (view != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.lemon_video_tv);
                textView2.setTextColor(getResources().getColor(R.color.lemon_b3aeae));
            }
        }
    }

    private final static int HIDE_PRO2 = 0;
    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case HIDE_PRO2:
                    if (lemon_video_menu_id.getChildAt(0) != null) {
                        TextView textView = (TextView)lemon_video_menu_id.getChildAt(0).findViewById(R.id.lemon_video_tv);
                        textView.setTextColor(Color.WHITE);
                    }
                    hidePro();
                    break;
            }
        }
    };


    public void initialized() {
        String videoType = getIntent().getStringExtra("videoType");
        TextView lemon_movie_title = (TextView)findViewById(R.id.lemon_movie_title);
//        if (AppConstant.MOVICE.equals(videoType)) {
//            lemon_movie_title.setText(getString(R.string.lemon95_movie));
//        } else if(AppConstant.SERIALS.equals(videoType)) {
//            lemon_movie_title.setText("电视剧");
//        } else if(AppConstant.FUNNY.equals(videoType)) {
//            lemon_movie_title.setText("短视频");
//        } else if (AppConstant.DONGMAN.equals(videoType)) {
//            lemon_movie_title.setText("动漫");
//        } else if (AppConstant.ZONGYI.equals(videoType)) {
//            lemon_movie_title.setText("综艺");
//        }
//        videoListPresenter.getCombQueryConditions(videoType);
//        actionsCreator().getvideoTitleInfo(this);

        ServiceManager.create1(PhoneApi1.class).getvideoTitleInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<LMClassBean>>() {
            @Override
            public void accept(List<LMClassBean> titleInfoBeans) throws Exception {
                showListView(titleInfoBeans);
                if (titleInfoBeans.size() > 0) {
                    getvideoListInfo(titleInfoBeans.get(0).getId());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                showToast(throwable.getMessage());
            }
        });
    }

    public void showPro() {
        lemon_movie_details_pro1.setVisibility(View.VISIBLE);
        lemon_movie_details_main.setVisibility(View.GONE);
    }

    public void hidePro() {
        lemon_movie_details_pro1.setVisibility(View.GONE);
        lemon_movie_details_main.setVisibility(View.VISIBLE);
        isKeyDown = false;
    }

    public void initViewMove() {
        mainUpView2 = (MainUpView) findViewById(R.id.mainUpView2);
        mOpenEffectBridge = (OpenEffectBridge) mainUpView2.getEffectBridge();
        switchNoDrawBridgeVersion();
    }

    private void switchNoDrawBridgeVersion() {
        EffectNoDrawBridge effectNoDrawBridge = new EffectNoDrawBridge();
        effectNoDrawBridge.setTranDurAnimTime(1);
        mOpenEffectBridge.setDrawUpRectEnabled(false);
        mainUpView2.setEffectBridge(effectNoDrawBridge); // 4.3以下版本边框移动.
        mainUpView2.setUpRectResource(R.drawable.health_focus_border); // 设置移动边框的图片.
        mainUpView2.setDrawUpRectPadding(new Rect(10, -8, 7, -41)); // 边框图片设置间距.
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return super.onKeyDown(keyCode, event);
        }
       /* else if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (gridView.isFocusable()) {
                LogUtils.i(TAG,"右键");
               // lemon_video_menu_id.setFocusable(false);
                gridView.requestFocus();
            }
        }*/
        return isKeyDown;
    }

    /**
     * 显示listView
//     * @param conditionsArrayList
     */
    public void showListView(List<LMClassBean> lmClassBeanList) {
        this.conditionsArrayList = lmClassBeanList;
        conditionsAdapter = new ConditionsAdapter(conditionsArrayList, this);
        lemon_video_menu_id.setAdapter(conditionsAdapter);
        conditionsAdapter.notifyDataSetChanged();
        lemon_title.setText(conditionsArrayList.get(0).getName());
        hidePro();
 }

    public void showPro2() {
        lemon_movie_details_pro2.setVisibility(View.VISIBLE);
        lemon_ll.setVisibility(View.VISIBLE);
       // gridView.setVisibility(View.GONE);
    }

    public void hidePro2() {
        lemon_movie_details_pro2.setVisibility(View.GONE);
        lemon_ll.setVisibility(View.GONE);
        gridView.setVisibility(View.VISIBLE);
    }

    /**
     * 显示gridView
     * @param data
     */
    public void showGridView( List<VoideInfoListBean> data) {
        isPage = true;
        if (data != null) {
          //  gridViewAdapter.notifyDataSetChanged();
            /*if (mOldGridView == null) {
                myHandler.postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        gridView.smoothScrollToPosition (0);
                        //mOldGridView = gridView.getChildAt(0);
                        //mainUpView2.setFocusView(mOldGridView, 1.1f);
                    }
                });
            }*/
            totleCount = data.size();
            videoList.clear();
            videoList.addAll(data);
            gridViewAdapter.notifyDataSetChanged();
            isStart = false;
            /*new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(2000);  //隐藏滚动效果
                        Message msg = new Message();
                        msg.what = HIDE_PRO2;
                        myHandler.sendMessage(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();*/
        }
        hidePro2();
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    public void getvideoListInfo(String t){
        Map<String,Object> params=new HashMap<>();
        params.put("t",t);
        params.put("page",1);
        ServiceManager.create(PhoneApi.class)
                .getvideoListInfo(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<VoideInfoListBean>>() {
                    @Override
                    public void accept(List<VoideInfoListBean> voideInfoListBeans) throws Exception {
                        showGridView(voideInfoListBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        showToast(throwable.getMessage());
                    }
                });
//        actionsCreator().getvideoListInfo(params,this);
    }

    @Override
        protected void updateView(Store.StoreChangeEvent event) {
            super.updateView(event);
            if ("getvideotype".equals(event.url)){
//            lmClassBeans= (List<LMClassBean>) event.data;
//            showListView(lmClassBeans);
//            if (lmClassBeans.size()>0) {
//                getvideoListInfo(lmClassBeans.get(0).getId());
//            }
            }else if ("getvideoListInfo".equals(event.url)){
//                VoideInfoListBean classDataModel= (VoideInfoListBean) event.data;
//                showGridView(classDataModel);
            }
    }
}

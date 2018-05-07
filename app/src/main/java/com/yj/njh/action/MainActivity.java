package com.yj.njh.action;

import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lemon95.androidtvwidget.bridge.EffectNoDrawBridge;
import com.lemon95.androidtvwidget.bridge.OpenEffectBridge;
import com.lemon95.androidtvwidget.utils.OPENLOG;
import com.lemon95.androidtvwidget.view.MainUpView;
import com.lemon95.androidtvwidget.view.OpenTabHost;
import com.lemon95.androidtvwidget.view.ReflectItemView;
import com.lemon95.androidtvwidget.view.TextViewWithTTF;
import com.yj.njh.action.ui.TJDetailsActivity;
import com.yj.njh.action.ui.actions.LoginAction;
import com.yj.njh.action.ui.adapter.OpenTabTitleAdapter;
import com.yj.njh.action.ui.favoritery.FavoritesActivity;
import com.yj.njh.action.ui.history.HistoryActivity;
import com.yj.njh.action.ui.mm.MmListActivity;
import com.yj.njh.action.ui.search.SearchActivity;
import com.yj.njh.action.ui.stores.LoginStore;
import com.yj.njh.action.ui.vlist.VideoListActivity;
import com.yj.njh.action.ui.vlist.details.MovieDetailsActivity2;
import com.yj.njh.action.view.ConfirmDialog;
import com.yj.njh.common.base.BaseFluxActivity;
import com.yj.njh.common.flux.stores.Store;
import com.yj.njh.ret.http.bean.HotTopicTjBean;
import com.yj.njh.ret.http.bean.VoideClassTJBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseFluxActivity<LoginStore,LoginAction> implements OpenTabHost.OnTabSelectListener,View.OnClickListener {

    private List<View> viewList;// view数组
    private View view1, view2, view3, view4;
    ViewPager viewpager;
    OpenTabHost mOpenTabHost;
    OpenTabTitleAdapter mOpenTabTitleAdapter;
    private OpenEffectBridge mSavebridge;
    private View mOldFocus;
    private Button lemon_but_search;  //搜索
    private ReflectItemView page1_item1,page1_item2,page1_item3,page1_item4;
    private ReflectItemView page2_item0,page2_item1,page2_item2,page2_item3,page2_item4,page2_item5,page2_item6,page2_item7,page2_item8;
    private ReflectItemView page3_item0,page3_item1,page3_item2,page3_item3,page3_item4,page3_item5,page3_item6,page3_item7,page3_item8;
    private ReflectItemView page4_item1,page4_item2,page4_item3,page4_item4,page4_item5,page4_item6;
    private ImageView lemon_page2_img1,lemon_page2_img2,lemon_page2_img3,lemon_page2_img4,lemon_page2_img5,lemon_page2_img6,lemon_page2_img7,lemon_page2_img8;
    private ImageView lemon_page3_img1,lemon_page3_img2,lemon_page3_img3,lemon_page3_img4,lemon_page3_img5,lemon_page3_img6,lemon_page3_img7,lemon_page3_img8;
    private TextView lemon_page3_name1,lemon_page3_name2,lemon_page3_name3,lemon_page3_name4;
    private int postion = 1;

    List<VoideClassTJBean> voideClassTJBeanList;//视频列表
    List<HotTopicTjBean> hotTopicTjBeans;//名牧推荐
    @Override
    protected boolean flux() {
        return true;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        // OPENLOG.initTag("hailongqiu", true); // 测试LOG输出.
        // 初始化标题栏.
        initAllTitleBar();
        // 初始化viewpager.
        initAllViewPager();
        // 初始化.
        initViewMove();
        initView();
        initRecommends(); //初始化每日推荐数据
        initVideoType(); //初始化影视分类
        initOnClick();
        initialized();
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.content_main;
    }


    /**
     * 初始化影视类型
     */
    private void initVideoType() {
        //从数据库获取数据

    }

    /**
     * 初始化名牧数据
     */
    private void initRecommends() {
        //从数据库获取数据
        actionsCreator().getHotTopic(this);
    }

    private void initView() {
        lemon_but_search = (Button)findViewById(R.id.lemon_but_search);
        page1_item1 = (ReflectItemView)view1.findViewById(R.id.page1_item1);
        page1_item2 = (ReflectItemView)view1.findViewById(R.id.page1_item2);
        page1_item3 = (ReflectItemView)view1.findViewById(R.id.page1_item3);
        page1_item4 = (ReflectItemView)view1.findViewById(R.id.page1_item4);
        page2_item1 = (ReflectItemView)view2.findViewById(R.id.page2_item1);
        page2_item0=(ReflectItemView)view2.findViewById(R.id.page2_item0);
        page2_item2 = (ReflectItemView)view2.findViewById(R.id.page2_item2);
        page2_item3 = (ReflectItemView)view2.findViewById(R.id.page2_item3);
        page2_item4 = (ReflectItemView)view2.findViewById(R.id.page2_item4);
        page2_item5 = (ReflectItemView)view2.findViewById(R.id.page2_item5);
        page2_item6 = (ReflectItemView)view2.findViewById(R.id.page2_item6);
        page2_item7 = (ReflectItemView)view2.findViewById(R.id.page2_item7);
        page2_item8 = (ReflectItemView)view2.findViewById(R.id.page2_item8);
        lemon_page2_img1 = (ImageView)view2.findViewById(R.id.lemon_page2_img1);
        lemon_page2_img2 = (ImageView)view2.findViewById(R.id.lemon_page2_img2);
        lemon_page2_img3 = (ImageView)view2.findViewById(R.id.lemon_page2_img3);
        lemon_page2_img4 = (ImageView)view2.findViewById(R.id.lemon_page2_img4);
        lemon_page2_img5 = (ImageView)view2.findViewById(R.id.lemon_page2_img5);
        lemon_page2_img6 = (ImageView)view2.findViewById(R.id.lemon_page2_img6);
        lemon_page2_img7 = (ImageView)view2.findViewById(R.id.lemon_page2_img7);
        lemon_page2_img8 = (ImageView)view2.findViewById(R.id.lemon_page2_img8);
        lemon_page3_img1 = (ImageView)view3.findViewById(R.id.lemon_page3_img1);
        lemon_page3_img2 = (ImageView)view3.findViewById(R.id.lemon_page3_img2);
        lemon_page3_img3 = (ImageView)view3.findViewById(R.id.lemon_page3_img3);
        lemon_page3_img4 = (ImageView)view3.findViewById(R.id.lemon_page3_img4);
        lemon_page3_img5 = (ImageView)view3.findViewById(R.id.lemon_page3_img5);
        lemon_page3_img6 = (ImageView)view3.findViewById(R.id.lemon_page3_img6);
        lemon_page3_img7 = (ImageView)view3.findViewById(R.id.lemon_page3_img7);
        lemon_page3_img8 = (ImageView)view3.findViewById(R.id.lemon_page3_img8);
//        lemon_page3_name1 = (TextView)view3.findViewById(R.id.lemon_page3_name1);
//        lemon_page3_name2 = (TextView)view3.findViewById(R.id.lemon_page3_name2);
//        lemon_page3_name3 = (TextView)view3.findViewById(R.id.lemon_page3_name3);
//        lemon_page3_name4 = (TextView)view3.findViewById(R.id.lemon_page3_name4);
        page3_item0 = (ReflectItemView)view3.findViewById(R.id.page3_item0);
        page3_item1 = (ReflectItemView)view3.findViewById(R.id.page3_item1);
        page3_item2 = (ReflectItemView)view3.findViewById(R.id.page3_item2);
        page3_item3 = (ReflectItemView)view3.findViewById(R.id.page3_item3);
        page3_item4 = (ReflectItemView)view3.findViewById(R.id.page3_item4);
        page3_item5 = (ReflectItemView)view3.findViewById(R.id.page3_item5);
        page3_item6 = (ReflectItemView)view3.findViewById(R.id.page3_item6);
        page3_item7 = (ReflectItemView)view3.findViewById(R.id.page3_item7);
        page3_item8 = (ReflectItemView)view3.findViewById(R.id.page3_item8);
//        page4_item1 = (ReflectItemView)view4.findViewById(R.id.page4_item1);
//        page4_item2 = (ReflectItemView)view4.findViewById(R.id.page4_item2);
//        page4_item3 = (ReflectItemView)view4.findViewById(R.id.page4_item3);
//        page4_item4 = (ReflectItemView)view4.findViewById(R.id.page4_item4);
//        page4_item5 = (ReflectItemView)view4.findViewById(R.id.page4_item5);
//        page4_item6 = (ReflectItemView)view4.findViewById(R.id.page4_item6);
        lemon_but_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int pos = viewpager.getCurrentItem();
                int id = R.id.title_bar1;
                switch (pos) {
                    case 0:
                        break;
                    case 1:
                        id = R.id.title_bar2;
                        break;
                    case 2:
                        id = R.id.title_bar3;
                        break;
                    case 3:
                        id = R.id.title_bar4;
                        break;
                }
                if (hasFocus) {
                    lemon_but_search.setNextFocusDownId(id);
                }
            }
        });
        List<View> viewList = mOpenTabHost.getAllTitleView();
        if (viewList != null) {
            viewList.get(0).setNextFocusDownId(R.id.page1_item1);
            viewList.get(1).setNextFocusDownId(R.id.page2_item1);
            viewList.get(2).setNextFocusDownId(R.id.page3_item1);
//            viewList.get(3).setNextFocusDownId(R.id.page4_item1);
        }
    }

    private void initAllTitleBar() {
        mOpenTabHost = (OpenTabHost) findViewById(R.id.openTabHost);
        mOpenTabTitleAdapter = new OpenTabTitleAdapter();
        mOpenTabHost.setOnTabSelectListener(this);
        mOpenTabHost.setAdapter(mOpenTabTitleAdapter);
    }

    private void initAllViewPager() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        //
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.fragment01, null);
        view2 = inflater.inflate(R.layout.fragment02, null); // gridview demo.
        view3 = inflater.inflate(R.layout.fragment03, null);
//        view4 = inflater.inflate(R.layout.fragment04, null);
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
//        viewList.add(view4);
        viewpager.setAdapter(new FragmentPagerAdapter());
        // 全局焦点监听.
        viewpager.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                int pos = viewpager.getCurrentItem();
                final MainUpView mainUpView = (MainUpView) viewList.get(pos).findViewById(R.id.mainUpView1);
                final OpenEffectBridge bridge = (OpenEffectBridge) mainUpView.getEffectBridge();
                if (!(newFocus instanceof ReflectItemView)) { // 不是 ReflectitemView 的话.
                    OPENLOG.D("onGlobalFocusChanged no ReflectItemView + " + (newFocus instanceof GridView));
                    mainUpView.setUnFocusView(mOldFocus);
                    bridge.setVisibleWidget(true); // 隐藏.
                    mSavebridge = null;
                } else {
//                    LogUtils.i(TAG, "onGlobalFocusChanged yes ReflectItemView");
                    newFocus.bringToFront();
                    mSavebridge = bridge;
                    // 动画结束才设置边框显示，
                    // 是位了防止翻页从另一边跑出来的问题.
                    bridge.setOnAnimatorListener(new OpenEffectBridge.NewAnimatorListener() {
                        @Override
                        public void onAnimationStart(OpenEffectBridge bridge, View view, Animator animation) {
                        }

                        @Override
                        public void onAnimationEnd(OpenEffectBridge bridge1, View view, Animator animation) {
                            if (mSavebridge == bridge1)
                                bridge.setVisibleWidget(false);
                        }
                    });
                    float scale = 1.05f;
                    // test scale.
                    if (pos == 1)
                        scale = 1.05f;
                    else if (pos == 2)
                        scale = 1.05f;
                    else if (pos == 3)
                        scale = 1.05f;
                    mainUpView.setFocusView(newFocus, mOldFocus, scale);
                }
                mOldFocus = newFocus;
            }
        });
        viewpager.setOffscreenPageLimit(4);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
//                LogUtils.i(TAG, "onPageSelected position:" + position);
                //position = viewpager.getCurrentItem();
                switchFocusTab(mOpenTabHost, position);
                // 这里加入是为了防止移动过去后，移动的边框还在的问题.
                // 从标题栏翻页就能看到上次的边框.
                if (position > 0) {
                    MainUpView mainUpView0 = (MainUpView) viewList.get(position - 1).findViewById(R.id.mainUpView1);
                    OpenEffectBridge bridge0 = (OpenEffectBridge) mainUpView0.getEffectBridge();
                    bridge0.setVisibleWidget(true);
                }
                //
                if (position < (viewpager.getChildCount() - 1)) {
                    MainUpView mainUpView1 = (MainUpView) viewList.get(position + 1).findViewById(R.id.mainUpView1);
                    OpenEffectBridge bridge1 = (OpenEffectBridge) mainUpView1.getEffectBridge();
                    bridge1.setVisibleWidget(true);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    public void initialized() {
//        ((TextView)findViewById(R.id.lemon_main_nick)).setText(PreferenceUtils.getString(context, AppConstant.USERNAME, "未登录"));
        if (mOpenTabHost != null) {
            List<View> viewList = mOpenTabHost.getAllTitleView();
            if (viewList != null && viewList.size() > 1) {
                viewList.get(1).setFocusableInTouchMode(true);
                viewList.get(1).setFocusable(true);
                viewList.get(1).setSelected(true);
                viewList.get(1).requestFocus();
//                viewList.get(0).setBackgroundResource(R.drawable.lemon_null);
//                viewList.get(1).setBackgroundResource(R.drawable.radio_btn_check_true);
                onTabSelect(mOpenTabHost, viewList.get(1), 1);
            }
        }
        Map<String,Object> params=new HashMap<>();
        params.put("num","8");
        actionsCreator().getnewlist(params,this);
    }

    @Override
    public void onTabSelect(OpenTabHost openTabHost, View titleWidget, int postion) {
        if (viewpager != null) {
            viewpager.setCurrentItem(postion);
        }
        switchTab(openTabHost, postion);
    }

    /**
     * demo
     * 设置标题栏被选中，<br>
     * 但是没有焦点的状态.
     */
    public void switchFocusTab(OpenTabHost openTabHost, int postion) {
        List<View> viewList = openTabHost.getAllTitleView();
        if (viewList != null && viewList.size() > 0) {
            for (int i = 0; i < viewList.size(); i++) {
                View viewC = viewList.get(i);
                if (i == postion) {
                    viewC.setSelected(true);
                } else {
                    viewC.setSelected(false);
                }
            }
        }
        switchTab(openTabHost, postion);
    }

    /**
     * demo
     * 将标题栏的文字颜色改变. <br>
     */
    public void switchTab(OpenTabHost openTabHost, int postion) {
        this.postion = postion;
        List<View> viewList = openTabHost.getAllTitleView();
        for (int i = 0; i < viewList.size(); i++) {
            TextViewWithTTF view = (TextViewWithTTF) openTabHost.getTitleViewIndexAt(i);
            if (view != null) {
                Resources res = view.getResources();
                if (res != null) {
                    if (i == postion) {
                        view.setTextColor(res.getColor(android.R.color.white));
                       // view.setTypeface(null, Typeface.BOLD);
                    } else {
                        view.setTextColor(res.getColor(R.color.lemon_color2));
                        view.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        }
    }

    public void initViewMove() {
        for (View view : viewList) {
            MainUpView mainUpView = (MainUpView) view.findViewById(R.id.mainUpView1);
            // 建议使用 noDrawBridge.
            mainUpView.setEffectBridge(new EffectNoDrawBridge()); // 4.3以下版本边框移动.
            mainUpView.setUpRectResource(R.drawable.health_focus_border); // 设置移动边框的图片.
            //mainUpView.setDrawUpRectPadding(new Rect(12,14,14,14)); // 边框图片设置间距.
            mainUpView.setDrawUpRectPadding(new Rect(10,10,8,10)); // 边框图片设置间距.
            EffectNoDrawBridge bridget = (EffectNoDrawBridge) mainUpView.getEffectBridge();
            bridget.setTranDurAnimTime(100);
        }
    }



//    /**
//     * 控制影视分类显示
//     * @param videoList
//     */
//    public void showVideoType(List<VideoType.Data> videoList) {
//        videoTypeList = videoList;
//        for (int i=0;i<videoList.size();i++) {
//            VideoType.Data videoType = videoList.get(i);
//            String orderNum = videoType.getVideoTypeId();
//            if (AppConstant.MOVICE.equals(orderNum)) {
//                lemon_page3_name1.setText(videoType.getTitle());
//                viewVideoTypeImg(videoType, lemon_page3_img1);
//            } else if(AppConstant.SERIALS.equals(orderNum)) {
//                lemon_page3_name2.setText(videoType.getTitle());
//                viewVideoTypeImg(videoType, lemon_page3_img2);
//            } else if(AppConstant.ZONGYI.equals(orderNum)) {
//                lemon_page3_name3.setText(videoType.getTitle());
//                viewVideoTypeImg(videoType,lemon_page3_img3);
//            } else if(AppConstant.DONGMAN.equals(orderNum)) {
//                lemon_page3_name4.setText(videoType.getTitle());
//                viewVideoTypeImg(videoType,lemon_page3_img4);
//            }
//        }
//    }

//    private void viewVideoTypeImg(VideoType.Data videoType, ImageView imagView) {
//        final String downImg = videoType.getDownImg();
//        if (StringUtils.isBlank(downImg)) {
//            loadVideoTypeImg(videoType, downImg, imagView);
//        } else {
//            String SDCarePath = Environment.getExternalStorageDirectory().toString();
//            File file = new File(SDCarePath + downImg);
//            LogUtils.i(TAG, "图片保存地址：" + SDCarePath + downImg);
//            if (file.exists()) {
//                //文件存在，判断图片是否需要更新
//                LogUtils.i(TAG,"加载本地显示");
//                ImageLoader.getInstance().displayImage("file://" + SDCarePath + downImg, imagView);
//            } else {
//                //文件不存在从新下载
//                loadVideoTypeImg(videoType, "", imagView);
//            }
//        }
//    }

//    private void loadVideoTypeImg(final VideoType.Data videoType, final String downImg, ImageView imagView) {
//        ImageLoader.getInstance().displayImage(AppConstant.RESOURCE + videoType.getPicturePath(), imagView,
//                new ImageLoadingListener() {
//                    @Override
//                    public void onLoadingStarted(String imageUri, View view) {
//                    }
//
//                    @Override
//                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                    }
//
//                    @Override
//                    public void onLoadingComplete(String imgUrl, View arg1, Bitmap arg2) {
//                        //加载成功
//                        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1,imgUrl.lastIndexOf("."));
//                        try {
//                            ImageUtils.saveImage(arg2, fileName);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        if (StringUtils.isNotBlank(downImg)) {
//                            File file = new File(downImg);
//                            if (file.exists()) {
//                                file.delete();
//                            }
//                        }
//                        videoType.setDownImg("/myImage/ymtv/" + fileName + ".png");
//                        dataBaseDao.addOrUpdateVideoType(videoType);
//                        LogUtils.i(TAG, "加载成功" + imgUrl);
//                    }
//
//                    @Override
//                    public void onLoadingCancelled(String imageUri, View view) {
//                    }
//                });
//    }
//
//    private void viewImage(Video video, String orderNum, ImageView imagView) {
//        final String downImg = video.getDownImg();
//        if (StringUtils.isBlank(downImg)) {
//            loadImg(video, orderNum, downImg,imagView);
//        } else {
//            String SDCarePath = Environment.getExternalStorageDirectory().toString();
//            File file = new File(SDCarePath + downImg);
//            LogUtils.i(TAG, "图片保存地址：" + SDCarePath + downImg);
//            if (file.exists()) {
//                //文件存在，判断图片是否需要更新
//                LogUtils.i(TAG,"加载本地显示");
//                ImageLoader.getInstance().displayImage("file://" + SDCarePath + downImg, imagView);
//            } else {
//                //文件不存在从新下载
//                loadImg(video, orderNum, "",imagView);
//            }
//        }
//    }
//
//    /**
//     * 加载网络图片
//     * @param video
//     * @param orderNum
//     * @param downImg
//     */
//    private void loadImg(final Video video, final String orderNum, final String downImg, ImageView imagView) {
//        ImageLoader.getInstance().displayImage(AppConstant.RESOURCE + video.getPicturePath(), imagView,
//                new ImageLoadingListener() {
//                    @Override
//                    public void onLoadingStarted(String imageUri, View view) {
//                    }
//
//                    @Override
//                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                    }
//
//                    @Override
//                    public void onLoadingComplete(String imgUrl, View arg1, Bitmap arg2) {
//                        //加载成功
//                        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1,imgUrl.lastIndexOf("."));
//                        try {
//                            ImageUtils.saveImage(arg2, fileName);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        if (StringUtils.isNotBlank(downImg)) {
//                            File file = new File(downImg);
//                            if (file.exists()) {
//                                file.delete();
//                            }
//                        }
//                        Video v = new Video();
//                        v.setCreateTime(video.getCreateTime());
//                        v.setDownImg(video.getDownImg());
//                        v.setOrderNum(video.getOrderNum());
//                        v.setPicturePath(video.getPicturePath());
//                        v.setTag(video.getTag());
//                        v.setTitle(video.getTitle());
//                        v.setVideoId(video.getVideoId());
//                        v.setVideoTypeId(video.getVideoTypeId());
//                        v.setDownImg("/myImage/ymtv/" + fileName + ".png");
//                        dataBaseDao.addOrUpdateVideo(v);
//                        LogUtils.i(TAG, "加载成功" + imgUrl);
//                    }
//
//                    @Override
//                    public void onLoadingCancelled(String imageUri, View view) {
//                    }
//                });
//    }

    private void initOnClick() {
        lemon_but_search.setOnClickListener(this);

        page1_item1.setOnClickListener(this);
        page1_item2.setOnClickListener(this);
        page1_item3.setOnClickListener(this);
        page1_item4.setOnClickListener(this);

        page2_item0.setOnClickListener(this);
        page2_item1.setOnClickListener(this);
        page2_item2.setOnClickListener(this);
        page2_item3.setOnClickListener(this);
        page2_item4.setOnClickListener(this);
        page2_item5.setOnClickListener(this);
        page2_item6.setOnClickListener(this);
        page2_item7.setOnClickListener(this);
        page2_item8.setOnClickListener(this);

        page3_item0.setOnClickListener(this);
        page3_item1.setOnClickListener(this);
        page3_item2.setOnClickListener(this);
        page3_item3.setOnClickListener(this);
        page3_item4.setOnClickListener(this);
        page3_item5.setOnClickListener(this);
        page3_item6.setOnClickListener(this);
        page3_item7.setOnClickListener(this);
        page3_item8.setOnClickListener(this);
//        page4_item1.setOnClickListener(this);
//        page4_item2.setOnClickListener(this);
//        page4_item3.setOnClickListener(this);
//        page4_item4.setOnClickListener(this);
//        page4_item5.setOnClickListener(this);
//        page4_item6.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
//        Bundle bundle = new Bundle();
//        Video video = null;
//        String userId = PreferenceUtils.getString(context,AppConstant.USERID,"");
        switch (v.getId()) {
            case R.id.lemon_but_search:
//                MobclickAgent.onEvent(context, "lemon_but_search");

                startActivity(new Intent(this,SearchActivity.class));
                break;
            case R.id.page1_item1:
//                MobclickAgent.onEvent(context, "page1_item1");
               // ToastUtils.showBgToast("1",context);
                startActivity(new Intent(this,HistoryActivity.class));
                break;
//            case R.id.page1_item2:
//                MobclickAgent.onEvent(context, "page1_item2");
//                if(StringUtils.isBlank(userId)) {
//                    //去登录界面
//                    PreferenceUtils.putString(context,AppConstant.PAGETYPE,"1");
//                    startActivity(LoginActivity.class);
//                } else {
//                    startActivity(NeedMovieActivity.class);
//                }
//                break;
//            case R.id.page1_item4:
//                MobclickAgent.onEvent(context, "page1_item4");
//                if(StringUtils.isBlank(userId)) {
//                    //去登录界面
//                    PreferenceUtils.putString(context,AppConstant.PAGETYPE,"2");
//                    startActivity(LoginActivity.class);
//                } else {
//                    startActivity(UserActivity.class);
//                }
//                break;
            case R.id.page1_item3:
//                MobclickAgent.onEvent(context, "page1_item3");
               // ToastUtils.showBgToast("1",context);
                startActivity(new Intent(this,FavoritesActivity.class));
                break;
            case R.id.page2_item0:
                Bundle bundle3 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle3.putString("videoType",AppConstant.ZONGYI);
                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle3));
                break;

            case R.id.page2_item1:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>0) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(0));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                bundle.putString("videoId",video.getVideoId());
//                bundle.putString("videoType",video.getVideoTypeId());
//                bundle.putString("SerialEpisodeId", "");
//                startActivity(MovieDetailsActivity.class,bundle);
                break;
            case R.id.page2_item2:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=1) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(1));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                bundle.putString("videoId", video.getVideoId());
//                bundle.putString("SerialEpisodeId", "");
//                bundle.putBoolean("isPersonal", false);
//                bundle.putString("videoName", video.getTitle());
//                bundle.putString("videoType",video.getVideoTypeId());
//                startActivity(PlayActivity.class,bundle);
                break;
            case R.id.page2_item3:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=2) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(2));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                MobclickAgent.onEvent(context, "page2_item3");
//                page2StartPage("3");
//                bundle.putString("videoId", video.getVideoId());
//                bundle.putString("SerialEpisodeId", "");
//                bundle.putBoolean("isPersonal", false);
//                bundle.putString("videoName", video.getTitle());
//                bundle.putString("videoType",video.getVideoTypeId());
//                startActivity(PlayActivity.class, bundle);

                break;
            case R.id.page2_item4:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=3) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(3));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                MobclickAgent.onEvent(context, "page2_item4");
//                page2StartPage("4");
                break;
            case R.id.page2_item5:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=3) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(3));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                MobclickAgent.onEvent(context, "page2_item5");
//                page2StartPage("5");
                break;
            case R.id.page2_item6:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=4) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(4));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                MobclickAgent.onEvent(context, "page2_item6");
//                page2StartPage("6");
                break;
            case R.id.page2_item7:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=5) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(5));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                MobclickAgent.onEvent(context, "page2_item7");
//                page2StartPage("7");
                break;
            case R.id.page2_item8:
                if (voideClassTJBeanList!=null&&voideClassTJBeanList.size()>=6) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("videoInfo", voideClassTJBeanList.get(6));
                    startActivity(new Intent(this, MovieDetailsActivity2.class).putExtras(bundle1));
                }
//                MobclickAgent.onEvent(context, "page2_item8");
//                page2StartPage("8");
                break;

            case R.id.page3_item0:
                Bundle bundle4 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle3.putString("videoType",AppConstant.ZONGYI);
                startActivity(new Intent(this,MmListActivity.class).putExtras(bundle4));

                break;
            case R.id.page3_item1:
//                MobclickAgent.onEvent(context, "page3_item1");
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>0) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(0));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item2:
//                MobclickAgent.onEvent(context, "page3_item2");
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=1) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(1));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item3:
//                MobclickAgent.onEvent(context, "page3_item3");
//                Bundle bundle3 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle3.putString("videoType",AppConstant.ZONGYI);
//                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle3));
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=2) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(2));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item4:
////                MobclickAgent.onEvent(context, "page3_item4");
//                Bundle bundle4 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle4.putString("videoType",AppConstant.DONGMAN);
//                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle4));
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=3) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(3));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item5:
////                MobclickAgent.onEvent(context, "page3_item4");
//                Bundle bundle4 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle4.putString("videoType",AppConstant.DONGMAN);
//                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle4));
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=4) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(4));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item6:
////                MobclickAgent.onEvent(context, "page3_item4");
//                Bundle bundle4 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle4.putString("videoType",AppConstant.DONGMAN);
//                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle4));
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=5) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(5));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item7:
////                MobclickAgent.onEvent(context, "page3_item4");
//                Bundle bundle4 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle4.putString("videoType",AppConstant.DONGMAN);
//                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle4));
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=6) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(6));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
            case R.id.page3_item8:
////                MobclickAgent.onEvent(context, "page3_item4");
//                Bundle bundle4 = new Bundle();
//               // bundle3.putString("videoType",AppConstant.FUNNY);
////                bundle4.putString("videoType",AppConstant.DONGMAN);
//                startActivity(new Intent(this,VideoListActivity.class).putExtras(bundle4));
                if (hotTopicTjBeans!=null&&hotTopicTjBeans.size()>=7) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("tjInfo", hotTopicTjBeans.get(7));
                    startActivity(new Intent(this, TJDetailsActivity.class).putExtras(bundle1));
                }
                break;
//            case R.id.page4_item1:
//                MobclickAgent.onEvent(context, "page4_item1");
//                Bundle bundle5 = new Bundle();
//                bundle5.putInt("meun1", 0);
//                bundle5.putString("meun2", "CCTV1");
//                startActivity(LiveActivity.class, bundle5);
//                break;
//            case R.id.page4_item2:
//                MobclickAgent.onEvent(context, "page4_item2");
//                Bundle bundle6 = new Bundle();
//                bundle6.putInt("meun1", 1);
//                startActivity(LiveActivity.class,bundle6);
//                break;
//            case R.id.page4_item3:
//                MobclickAgent.onEvent(context, "page4_item3");
//                Bundle bundle7 = new Bundle();
//                bundle7.putInt("meun1", 2);
//                startActivity(LiveActivity.class,bundle7);
//                break;
//            case R.id.page4_item4:
//                MobclickAgent.onEvent(context, "page4_item4");
//                Bundle bundle8 = new Bundle();
//                bundle8.putInt("meun1", 4);
//                startActivity(LiveActivity.class,bundle8);
//                break;
//            case R.id.page4_item5:
//                MobclickAgent.onEvent(context, "page4_item5");
//                Bundle bundle9 = new Bundle();
//                bundle9.putInt("meun1", 3);
//                startActivity(LiveActivity.class,bundle9);
//                break;
//            case R.id.page4_item6:
//                MobclickAgent.onEvent(context, "page4_item6");
//                Bundle bundle10 = new Bundle();
//                bundle10.putInt("meun1",5);
//                startActivity(LiveActivity.class, bundle10);
//                break;
        }
    }
//
//    /**
//     * 每日推荐 点击
//     * @param point
//     */
//    private void page2StartPage(String point) {
//        Video video = null;
//        for (int i=0;i<videoList.size();i++) {
//            Video video1 = videoList.get(i);
//            final String orderNum = video1.getOrderNum();
//            if (point.equals(orderNum)) {
//                video = video1;
//            }
//        }
//        if (AppConstant.FUNNY.equals(video.getVideoTypeId())) {
//            //搞笑
//            Bundle bundle = new Bundle();
//            bundle.putString("videoId", video.getVideoId());
//            bundle.putString("SerialEpisodeId", "");
//            bundle.putBoolean("isPersonal", false);
//            bundle.putString("videoName", video.getTitle());
//            bundle.putString("videoType",video.getVideoTypeId());
//            startActivity(BdPalyActivity.class, bundle);
//        } else {
//            Bundle bundle = new Bundle();
//            bundle.putString("videoId", video.getVideoId());
//            bundle.putString("videoType", video.getVideoTypeId());
//            startActivity(MovieDetailsActivity.class, bundle);
//        }
//    }

    class FragmentPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        };

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (postion != 1) {
                List<View> viewList = mOpenTabHost.getAllTitleView();
                if (viewList != null && viewList.size() > 1) {
                    viewList.get(1).setFocusableInTouchMode(true);
                    viewList.get(1).setFocusable(true);
                    viewList.get(1).setSelected(true);
                    viewList.get(1).requestFocus();
                    onTabSelect(mOpenTabHost, viewList.get(1), 1);
                }
            } else {
                ConfirmDialog.Builder dialog = new ConfirmDialog.Builder(MainActivity.this);
                dialog.setMessage("您确定退出应用？");
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.dismiss();
                    }
                });
                dialog.create().show();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        //sdk释放
//        ThinkoEnvironment.tearDown();
    }

    @Override
    protected void updateView(Store.StoreChangeEvent event) {
        super.updateView(event);
        if (event.url.equals("getnewlist")){
             voideClassTJBeanList= (List<VoideClassTJBean>) event.data;
            for (int i = 0; i < voideClassTJBeanList.size(); i++) {
                if (voideClassTJBeanList.size()>0&&i==0) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img1);
                } else if (voideClassTJBeanList.size()>=1&&i==1) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img2);
                } else if (voideClassTJBeanList.size()>=2&&i==2) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img3);
                } else if (voideClassTJBeanList.size()>=3&&i==3) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img4);
                } else if (voideClassTJBeanList.size()>=4&&i==4) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img5);
                } else if (voideClassTJBeanList.size()>=5&&i==5) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img6);
                } else if (voideClassTJBeanList.size()>=6&&i==6) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img7);
                } else if (voideClassTJBeanList.size()>=7&&i==7) {
                    Glide.with(this)
                            .load(voideClassTJBeanList.get(i).getPic())
                            .into(lemon_page2_img8);
                }
            }
        }else if ("getHotTopic".equals(event.url)){
             hotTopicTjBeans= (List<HotTopicTjBean>) event.data;
            for (int i = 0; i < hotTopicTjBeans.size(); i++) {
                if (hotTopicTjBeans.size()>0&&i==0) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img1);
                } else if (hotTopicTjBeans.size()>=1&&i==1) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img2);
                } else if (hotTopicTjBeans.size()>=2&&i==2) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img3);
                } else if (hotTopicTjBeans.size()>=3&&i==3) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img4);
                }else if (hotTopicTjBeans.size()>=4&&i==4) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img5);
                }
                else if (hotTopicTjBeans.size()>=5&&i==5) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img6);
                }
                else if (hotTopicTjBeans.size()>=6&&i==6) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img7);
                }else if (hotTopicTjBeans.size()>=7&&i==7) {
                    Glide.with(this)
                            .load(hotTopicTjBeans.get(i).getPic())
                            .into(lemon_page3_img8);
                }
//                else if (hotTopicTjBeans.size()>=4&&i==4) {
//                    Glide.with(this)
//                            .load(hotTopicTjBeans.get(i).getPic())
//                            .into(lemon_page3_img5);
//                } else if (hotTopicTjBeans.size()>=5&&i==5) {
//                    Glide.with(this)
//                            .load(hotTopicTjBeans.get(i).getPic())
//                            .into(lemon_page3_img6);
//                } else if (hotTopicTjBeans.size()>=6&&i==6) {
//                    Glide.with(this)
//                            .load(hotTopicTjBeans.get(i).getPic())
//                            .into(lemon_page2_img7);
//                } else if (hotTopicTjBeans.size()>=7&&i==7) {
//                    Glide.with(this)
//                            .load(hotTopicTjBeans.get(i).getPic())
//                            .into(lemon_page2_img8);
//                }
            }
        }
    }
}

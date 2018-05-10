package com.yj.njh.action.ui.vlist.details;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lemon95.androidtvwidget.view.GridViewTV;
import com.yj.njh.action.R;
import com.yj.njh.action.db.dao.VoideClassTJBFModelDao;
import com.yj.njh.action.model.PlayUrlsBean;
import com.yj.njh.action.model.VoideClassTJBFModel;
import com.yj.njh.action.ui.PlayEmptyControlActivity;
import com.yj.njh.common.base.BaseFluxActivity;
import com.yj.njh.ret.http.bean.VoideClassTJBean;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class SerialActivity extends BaseFluxActivity {

    private GridViewTV lemon_gridview;
    //private ArrayList<SerialDitions.Data.SerialEpisodes> serialEpisodes;
    private SerialAdapter serialAdapter;
    private View oldView;
    String videoType = "2";
    private String picUrl,lastEpisode;
    private VoideClassTJBean listBean;
    @Override
    public void initData(Bundle savedInstanceState) {
        listBean= (VoideClassTJBean) getIntent().getSerializableExtra("listBean");
        setupViews();
        initialized();
    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_serial;
    }

    protected void setupViews() {
       // serialEpisodes = getIntent().getParcelableArrayListExtra("SerialEpisodes");
        lemon_gridview = (GridViewTV) findViewById(R.id.lemon_gridview);
        picUrl = getIntent().getStringExtra("PicturePath");
        videoType = getIntent().getStringExtra("videoType");
        lastEpisode = getIntent().getStringExtra("lastEpisode"); //多少集
        ImageView movie_details_img_id = (ImageView)findViewById(R.id.movie_details_img_id);
        Glide.with(this).load(picUrl).into(movie_details_img_id);
    }


    public void initialized() {
        serialAdapter = new SerialAdapter(listBean.getPlayurls().get(0),this);
        lemon_gridview.setAdapter(serialAdapter);
        lemon_gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));
        lemon_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VoideClassTJBFModel voideClassTJBFModel=new VoideClassTJBFModel();
                QueryBuilder<VoideClassTJBFModel> voideClassTJBFModelQueryBuilder = voideClassTJBFModel.getVoideClassTJBFModelDao().queryBuilder();
                voideClassTJBFModelQueryBuilder.where(VoideClassTJBFModelDao.Properties.Id.eq(listBean.getId()));
                List<VoideClassTJBFModel> list1 = voideClassTJBFModelQueryBuilder.list();
                if (list1.size()==0){
                    voideClassTJBFModel.setContent(listBean.getContent());
                    voideClassTJBFModel.setDirected(listBean.getDirected());
                    voideClassTJBFModel.setHits(listBean.getHits());
                    voideClassTJBFModel.setId(listBean.getId());
                    voideClassTJBFModel.setLevel(listBean.getLevel());
                    voideClassTJBFModel.setPic(listBean.getPic());
                    voideClassTJBFModel.setPicslide(listBean.getPicslide());
                    voideClassTJBFModel.setTime(listBean.getTime());
                    voideClassTJBFModel.setTopic(listBean.getTopic());
                    voideClassTJBFModel.setStarring(listBean.getStarring());
                    PlayUrlsBean playUrlsBean=new PlayUrlsBean();
                    playUrlsBean.setPlayurls(listBean.getPlayurls());
                    voideClassTJBFModel.setType(listBean.getType());
                    voideClassTJBFModel.setPlayurls(new Gson().toJson(playUrlsBean));
                    voideClassTJBFModel.setName(listBean.getName());
                    voideClassTJBFModel.getVoideClassTJBFModelDao().save(voideClassTJBFModel);
                }
                Intent intent = new Intent(SerialActivity.this, PlayEmptyControlActivity.class);
                intent.putExtra("listBean",listBean);
                intent.putExtra("page",position);
                startActivity(intent);
//                Bundle bundle = new Bundle();
//                bundle.putString("SerialEpisodeId", getIntent().getStringExtra("SerialEpisodeId"));  //剧集ID
//                bundle.putString("videoId", getIntent().getStringExtra("videoId"));
//                bundle.putString("videoName", getIntent().getStringExtra("videoName"));
//                bundle.putInt("index", position + 1);
//                bundle.putString("videoImage", getIntent().getStringExtra("videoType"));
//                bundle.putString("videoType", videoType);
//                bundle.putString("videoImage", picUrl);
//                bundle.putString("lastEpisode", lastEpisode);
               // bundle.putParcelableArrayList("SerialEpisodes", serialEpisodes);
//                startActivity(IjkPlayerActivity.class, bundle);
                //startActivity(BdPalyActivity.class, bundle);
                //startActivity(PlayActivity.class, bundle);
            }
        });
        lemon_gridview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView button = (TextView) view.findViewById(R.id.lemon_item_but);
                button.setTextColor(Color.parseColor("#57fffa"));
                button.setBackgroundResource(R.drawable.lemon_servial_pree);
                if (oldView != null) {
                    TextView button2 = (TextView) oldView.findViewById(R.id.lemon_item_but);
                    button2.setTextColor(Color.parseColor("#b3aeae"));
                    button2.setBackgroundResource(R.drawable.lemon_servial_none);
                }
                oldView = view;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        lemon_gridview.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                //初始化选择
                oldView = lemon_gridview.getChildAt(0 - lemon_gridview.getFirstVisiblePosition());
                if (oldView != null) {
                    TextView button = (TextView) oldView.findViewById(R.id.lemon_item_but);
                    button.setTextColor(Color.parseColor("#57fffa"));
                    button.setBackgroundResource(R.drawable.lemon_servial_pree);
                }
            }
        });


    }


}

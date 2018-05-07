package com.yj.njh.action.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yj.njh.action.R;
import com.yj.njh.action.model.VoideClassTJBFModel;

import java.util.List;

/**
 * Created by WXT on 2016/7/27.
 */
public class HistoryAdapter extends BaseAdapter {

    private List<VoideClassTJBFModel> videoList;
    private Context context;
//    private DisplayImageOptions options;

    public HistoryAdapter(List<VoideClassTJBFModel> videoList, Context context) {
//        options = new DisplayImageOptions.Builder()
//                .showStubImage(R.drawable.lemon_details_small_def)          // 设置图片下载期间显示的图片
//                .showImageForEmptyUri(R.drawable.lemon_details_small_def)  // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageOnFail(R.drawable.lemon_details_small_def)       // 设置图片加载或解码过程中发生错误显示的图片
//                .build();
        this.videoList = videoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return videoList.size();
    }

    @Override
    public Object getItem(int position) {
        return videoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = View.inflate(context, R.layout.item_gridview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        VoideClassTJBFModel videoBriefs = videoList.get(position);
        Glide.with(context).load(videoBriefs.getPic()).into(holder.lemon_grid_img);
//        ImageLoader.getInstance().displayImage(AppConstant.RESOURCE + videoBriefs.getPicturePath(),holder.lemon_grid_img,options);
        holder.lemon_grid_textView.setText(videoBriefs.getName());
        return view;
    }

    private static class ViewHolder {
        TextView lemon_grid_textView;
        ImageView lemon_grid_img;
        public ViewHolder(View view) {
            lemon_grid_textView = (TextView) view.findViewById(R.id.lemon_grid_textView);
            lemon_grid_img = (ImageView) view.findViewById(R.id.lemon_grid_img);
        }
    }
}

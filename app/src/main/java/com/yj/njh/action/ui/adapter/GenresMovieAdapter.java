package com.yj.njh.action.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.lemon95.androidtvwidget.view.LabelView;
import com.yj.njh.action.R;
import com.yj.njh.action.model.GenresMovie;

import java.util.List;

/**
 * Created by WXT on 2016/8/11.
 * 相关影视
 */
public class GenresMovieAdapter extends BaseAdapter {

    private List<GenresMovie.Data> dataList;
    private Context context;
//    private DisplayImageOptions options;


    public GenresMovieAdapter(List<GenresMovie.Data> dataList, Context context) {
        // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
//        options = new DisplayImageOptions.Builder()
//                .showStubImage(R.drawable.lemon_details_def)          // 设置图片下载期间显示的图片
//                .showImageForEmptyUri(R.drawable.lemon_details_def)  // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageOnFail(R.drawable.lemon_details_def)       // 设置图片加载或解码过程中发生错误显示的图片
//                .build();
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
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
            view = View.inflate(context, R.layout.item_min_gridview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        GenresMovie.Data videoBriefs = dataList.get(position);
//        ImageLoader.getInstance().displayImage(AppConstant.RESOURCE + videoBriefs.getPicturePath(),holder.lemon_grid_img,options);
        holder.lemon_grid_textView.setText(videoBriefs.getVideoName());
        String title = videoBriefs.getTitle();
        if (!StringUtils.isEmpty(title)) {
            holder.lemon_title.setText(title);
            holder.lemon_title.setVisibility(View.VISIBLE);
        } else {
            holder.lemon_title.setVisibility(View.GONE);
        }
        if (videoBriefs.getIsNew().equalsIgnoreCase("true")) {
            holder.lemon_image_icon.setVisibility(View.VISIBLE);
        } else {
            holder.lemon_image_icon.setVisibility(View.GONE);
        }
        return view;
    }

    private static class ViewHolder {
        TextView lemon_grid_textView;
        TextView lemon_title;
        ImageView lemon_grid_img;
        LabelView lemon_image_icon;
        public ViewHolder(View view) {
            lemon_grid_textView = (TextView) view.findViewById(R.id.lemon_grid_textView);
            lemon_title = (TextView) view.findViewById(R.id.lemon_title);
            lemon_grid_img = (ImageView) view.findViewById(R.id.lemon_grid_img);
            lemon_image_icon = (LabelView) view.findViewById(R.id.lemon_image_icon);
        }
    }
}

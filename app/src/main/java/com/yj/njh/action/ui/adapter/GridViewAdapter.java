package com.yj.njh.action.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.lemon95.androidtvwidget.view.LabelView;
import com.yj.njh.action.R;
import com.yj.njh.ret.http.bean.VoideInfoListBean;

import java.util.List;

/**
 * Created by WXT on 2016/7/19.
 */
public class GridViewAdapter extends BaseAdapter {

    List<VoideInfoListBean> videoBriefsList;
    private Context context;


    public GridViewAdapter(List<VoideInfoListBean> videoBriefsList, Context context) {
        this.videoBriefsList = videoBriefsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return videoBriefsList.size();
    }

    @Override
    public Object getItem(int position) {
        return videoBriefsList.get(position);
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
        VoideInfoListBean videoBriefs = videoBriefsList.get(position);
//        ImageLoader.getInstance().displayImage(AppConstant.RESOURCE + videoBriefs.getPicturePath(),holder.lemon_grid_img,options);
//        holder.lemon_grid_textView.setText(videoBriefs);
        Glide.with(context).load(videoBriefs.getPic()).into(holder.lemon_grid_img);
        String title = videoBriefs.getName();
        if (!StringUtils.isEmpty(title)) {
            holder.lemon_title.setText(title);
            holder.lemon_title.setVisibility(View.VISIBLE);
        } else {
            holder.lemon_title.setVisibility(View.GONE);
        }
//        if (videoBriefs.getIsNew().equalsIgnoreCase("true")) {
//            holder.lemon_image_icon.setVisibility(View.VISIBLE);
//        } else {
//            holder.lemon_image_icon.setVisibility(View.GONE);
//        }
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

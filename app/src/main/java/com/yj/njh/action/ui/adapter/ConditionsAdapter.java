package com.yj.njh.action.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.yj.njh.action.R;
import com.yj.njh.ret.http.bean.ClassDataModel;

import java.util.List;


/**
 * Created by WXT on 2016/7/19.
 */
public class ConditionsAdapter extends BaseAdapter {

    private static final String TAG = "ConditionsAdapter";
    private List<ClassDataModel.ClassBean> conditionsArrayList;
    private Context context;
    private boolean isParam = true;
    private int point = 0;

    public void setPoint(int point) {
        this.point = point;
    }

    public ConditionsAdapter(List<ClassDataModel.ClassBean> conditionsArrayList, Context context) {
        this.conditionsArrayList = conditionsArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return conditionsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return conditionsArrayList.get(position);
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
            view = View.inflate(context, R.layout.lemon_item_video, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        ClassDataModel.ClassBean queryConditions = conditionsArrayList.get(position);
        holder.lemon_video_tv.setText(queryConditions.getName());
        if (position == point) {
            LogUtils.i(TAG,"白色" + position);
            isParam = false;
           // holder.lemon_video_tv.setNextFocusUpId(R.id.lemon_search);
            holder.lemon_video_tv.setTextColor(Color.WHITE);
        } else {
            holder.lemon_video_tv.setTextColor(context.getResources().getColor(R.color.lemon_b3aeae));
        }
        return view;
    }

    private static class ViewHolder {
        TextView lemon_video_tv;

        public ViewHolder(View view) {
            lemon_video_tv = (TextView) view.findViewById(R.id.lemon_video_tv);
        }
    }


}

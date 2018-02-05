package com.yj.njh.base.swipeback.act;


import com.yj.njh.base.swipeback.SwipeBackLayout;

/**
 * @author Yrom
 */
public interface SwipeBackBase {
    /**
     * @return the SwipeBackLayout associated with this activity.
     */
    public abstract SwipeBackLayout getSwipeBackLayout();

    public abstract void setSwipeBackEnable(boolean enable);


}

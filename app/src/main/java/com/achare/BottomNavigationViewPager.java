package com.achare;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Reza on 16/05/2017.
 */

public class BottomNavigationViewPager extends ViewPager {
    private boolean isPagingEnable;

    public BottomNavigationViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isPagingEnable = false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return this.isPagingEnable && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.isPagingEnable && super.onTouchEvent(ev);

    }

    public void setPagingEnable(boolean pagingEnable) {
        isPagingEnable = pagingEnable;
    }

    public boolean isPagingEnable() {
        return isPagingEnable;
    }
}

package com.example.slidinglistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class MyLinearLayout extends LinearLayout {


    private OnScrollListener mScrollListener;

    private int mlastX = 0;
    private final int MAX_WIDTH = 200;
    private Context mContext;
    private Scroller mScroller;

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mScroller = new Scroller(context,new LinearInterpolator(context,null));
    }

    public static interface OnScrollListener{
        public void OnScroll(MyLinearLayout view);
    }
    private int dipToPx(Context context,int dip){
        return (int) (dip * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public void disPatchTouchEvent(MotionEvent event){
        int maxLength = dipToPx(mContext,MAX_WIDTH);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
            }
            break;
            case MotionEvent.ACTION_MOVE:{
                int scrollX = this.getScrollX();
                int newScrollX = scrollX + mlastX - x;
                if(scrollX < 0){
                    newScrollX = 0;
                }else if(newScrollX > maxLength){
                    newScrollX = maxLength;
                }
                this.scrollTo(newScrollX,0);
            }
                break;
            case MotionEvent.ACTION_UP:{
                int scrollX = this.getScrollX();
                int newScrollX = scrollX + mlastX - x;
                if(scrollX > maxLength / 2){
                    newScrollX = maxLength;
                    //当完全展开时，通知出去
                    mScrollListener.OnScroll(this);
                }else{
                    newScrollX = 0;
                }
                mScroller.startScroll(scrollX,0,newScrollX - scrollX,0);
                invalidate();//重绘View
            }
            break;
        }
        mlastX = x;
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            this.scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
        }
        invalidate();
    }

    //缓慢滚动到指定位置
    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        mScroller.startScroll(scrollX,0,delta,0);
        invalidate();
    }
    //设置监听器
    public void setOnScrollListener(OnScrollListener scrollListener){
        mScrollListener = scrollListener;
    }
}

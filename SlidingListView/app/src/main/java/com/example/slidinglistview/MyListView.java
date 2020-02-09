package com.example.slidinglistview;

import android.content.Context;
import android.media.MediaDrmResetException;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;


public class MyListView extends ListView {
    private MyLinearLayout mCurView;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                //点击了哪一行
                int position = pointToPosition(x,y);
                if(position != INVALID_POSITION){
                    MergeListAdapter.DataHolder data = (MergeListAdapter.DataHolder) getItemAtPosition(position);
                    mCurView = data.rootView;
                }

                break;
                default:
                    break;
        }

        if(mCurView != null){
            mCurView.disPatchTouchEvent(ev);
        }
        return super.onTouchEvent(ev);
    }


}

package com.example.slidinglistview;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MergeListAdapter extends BaseAdapter {

    public static Context mContext;
    private MyLinearLayout.OnScrollListener mScrollListener;
    private View.OnClickListener mDelClickListener;
    private LayoutInflater mInflater;
    private List<DataHolder> mDataList = new ArrayList<DataHolder>();
    public MergeListAdapter(Context context, List<DataHolder> dataList,View.OnClickListener delClickListener,MyLinearLayout.OnScrollListener listener){
        mContext = context;
        mDelClickListener = delClickListener;
        mScrollListener = listener;
        mInflater = LayoutInflater.from(context);
        if(dataList.size() > 0 && dataList != null){
            mDataList.addAll(dataList);
        }
    }

    public void removeItem(int position){
        mDataList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null || convertView.getTag() == null){
            convertView = mInflater.inflate(R.layout.item_layout,parent,false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }

        TextView delTv = convertView.findViewById(R.id.del);
        delTv.setOnClickListener(mDelClickListener);


        DataHolder item = mDataList.get(position);
        holder.title.setText(item.title);
        item.rootView = convertView.findViewById(R.id.lin_root);
        item.rootView.scrollTo(0,0);
        item.rootView.setOnScrollListener(mScrollListener);
        return convertView;
    }

    private static class ViewHolder{
        private TextView title;
    }
    public static class DataHolder{
        public String title;
        public MyLinearLayout rootView;
    }
}

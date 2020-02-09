package com.example.slidinglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MyLinearLayout.OnScrollListener {

    private MyLinearLayout mLastScrollView;
    private MyListView listView;
    private MergeListAdapter adapter;
    List<MergeListAdapter.DataHolder> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listview);

        for (int i = 0; i < 20; i ++){
            MergeListAdapter.DataHolder item = new MergeListAdapter.DataHolder();
            item.title = "第" + i + "项";
            items.add(item);
        }

        adapter = new MergeListAdapter(this,items,this,this);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.del){
            int position = listView.getPositionForView(v);
            items.remove(position);
            adapter.removeItem(position);
        }
    }

    @Override
    public void OnScroll(MyLinearLayout view) {
        if(mLastScrollView != null){
            mLastScrollView.smoothScrollTo(0,0);
        }
        mLastScrollView = view;
    }
}

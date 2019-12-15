package com.example.xrecyclerviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    XRecyclerView recyclerView;
    List<String> list = new ArrayList<>();
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        View header = LayoutInflater.from(this).inflate(R.layout.header,null);
        recyclerView.addHeaderView(header);//添加头部
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallZigZag);//下拉刷新样式
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//上拉加载样式
        recyclerView.setArrowImageView(R.drawable.ic_loading_rotate);//设定下拉刷新显示图片
        initData();
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
//            下拉刷新
            @Override
            public void onRefresh() {

                initData();
                adapter.notifyDataSetChanged();
                recyclerView.refreshComplete();

            }
//          初始化数据
            @Override
            public void onLoadMore() {
                addData();
                recyclerView.loadMoreComplete();
            }
        });

    }

    public void addData(){
        int r;
        for(int i = 0; i < 20; i ++){
            r = (int) (Math.random()*100);
            list.add("item" + r);
        }
        adapter.notifyDataSetChanged();

    }

    public void initData(){
        list.clear();
        for(int i = 0; i <40 ; i ++){
            list.add("item" + i);
        }
    }
}

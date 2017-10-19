package com.bwie.action.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

public class MainActivity extends AppCompatActivity {

    private SpringView springView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        springView = (SpringView) findViewById(R.id.myspring);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this);
        adapter.setLisner(new OnClickRecyclerListner() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,position+"  长摁",Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        springView.setFooter(new DefaultFooter(MainActivity.this));
        springView.setHeader(new DefaultHeader(MainActivity.this));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadmore() {

            }
        });
    }
}

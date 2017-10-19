package com.bwie.action.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/10/19.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<String> data = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
        for (int i=0; i<20; i++){
            data.add("ddddd"+i);
        }
    }

    public void addData(String text){
        data.add(0,text);
        notifyDataSetChanged();
    }
    public void delData(int pos){
        data.remove(pos);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = View.inflate(context,R.layout.item,null);
        final MyViewHolder holder = new MyViewHolder(view);
        if(listner!=null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClick(view,holder.getLayoutPosition());
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listner.onLongItemClick(view,holder.getLayoutPosition());
                    return true;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.mytext);
        }
    }

    private OnClickRecyclerListner listner;

    public void setLisner(OnClickRecyclerListner lisner) {
        this.listner = lisner;
    }
}

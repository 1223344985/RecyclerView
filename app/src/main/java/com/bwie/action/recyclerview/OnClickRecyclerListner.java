package com.bwie.action.recyclerview;

import android.view.View;

/**
 * Created by ASUS on 2017/10/19.
 */
public interface OnClickRecyclerListner {
    void onItemClick(View view,int position);
    void onLongItemClick(View view,int position);
}

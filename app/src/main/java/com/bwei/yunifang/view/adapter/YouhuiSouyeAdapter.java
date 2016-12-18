package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 *  * 作者：19084 on 2016/12/11 19:34
 *  * 邮箱：xjs250@163.com
 *  
 */
public class YouhuiSouyeAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<ImageView> list;

    public YouhuiSouyeAdapter(Context context, ArrayList<ImageView> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view = list.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

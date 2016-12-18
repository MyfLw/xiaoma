package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwei.yunifang.view.Bean.GoodsInfoBean;
import com.bwei.yunifang.view.activity.SouyeshangpinActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/15.
 */
public class ImageAdapter extends PagerAdapter {

    ArrayList<ImageView> imageViews;

    public ImageAdapter(ArrayList<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view=imageViews.get(position);
        container.addView(view);


        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

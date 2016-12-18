package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.ShuXingBean;

import org.xutils.x;

import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/15.
 */
public class ShuXingAdapter extends BaseAdapter {
    Context context;
    List<ShuXingBean.DataBean> data;

    public ShuXingAdapter(Context context, List<ShuXingBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context, R.layout.shuxing_item,null);
        ImageView imageView= (ImageView) view.findViewById(R.id.item_goods_image);
        TextView item_goods_name= (TextView) view.findViewById(R.id.item_goods_name);
        TextView item_goods_info= (TextView) view.findViewById(R.id.item_goods_info);
        TextView item_goods_old_price= (TextView) view.findViewById(R.id.item_goods_old_price);
        TextView item_goods_price= (TextView) view.findViewById(R.id.item_goods_price);
        x.image().bind(imageView,data.get(i).getGoods_img());
        item_goods_name.setText(data.get(i).getEfficacy());
        item_goods_info.setText(data.get(i).getGoods_name());
        item_goods_old_price.setText("¥"+data.get(i).getMarket_price()+"");
        item_goods_price.setText("¥"+data.get(i).getShop_price());
        return view;
    }
}

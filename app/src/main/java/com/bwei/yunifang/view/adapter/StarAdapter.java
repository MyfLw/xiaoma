package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.ClassifyBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.x;

import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/13.
 */
public class StarAdapter extends BaseAdapter{
    Context context;
    List<ClassifyBean.DataBean.GoodsBriefBean> goodsBrief;
    private ViewHolder holder;

    public StarAdapter(Context context, List<ClassifyBean.DataBean.GoodsBriefBean> goodsBrief) {
        this.context = context;
        this.goodsBrief = goodsBrief;
    }

    @Override
    public int getCount() {
        return goodsBrief.size();
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
        if (view==null){
            holder = new ViewHolder();
               view=View.inflate(context,R.layout.classify_gride_star,null);
            holder.item_goods_image= (ImageView) view.findViewById(R.id.item_goods_image);
            holder.item_goods_name= (TextView) view.findViewById(R.id.item_goods_name);
            holder.item_goods_info= (TextView) view.findViewById(R.id.item_goods_info);
            holder.item_goods_price= (TextView) view.findViewById(R.id.item_goods_price);
            holder.item_goods_old_price= (TextView) view.findViewById(R.id.item_goods_old_price);
            view.setTag(holder);
        }else {
            view.getTag();
        }
        holder.item_goods_name.setText(goodsBrief.get(i).getEfficacy());
        holder.item_goods_info.setText(goodsBrief.get(i).getGoods_name());
        holder.item_goods_price.setText("¥"+(int) goodsBrief.get(i).getShop_price());
        holder.item_goods_old_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
        holder.item_goods_old_price.setText("¥"+goodsBrief.get(i).getMarket_price());
        x.image().bind(holder.item_goods_image,goodsBrief.get(i).getGoods_img());
        return view;
    }
    class ViewHolder{
        ImageView item_goods_image;
        TextView item_goods_name;
        TextView item_goods_info;
        TextView item_goods_price;
        TextView item_goods_old_price;

    }
}

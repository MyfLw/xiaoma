package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.AllGoodsBean;


import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 55081 on 2016/12/13.
 */
public  class  AllGoodsGridviewAdapter extends BaseAdapter  {
//    private List<AllGoodsBean.DataBean> data;
    private  Context c;
    private List<AllGoodsBean.DataBean> list2=new ArrayList<>();
//
  public AllGoodsGridviewAdapter(Context c){
                 this.c=c;
   }
    @Override
    public int getCount() {
        return list2.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list2.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
         ViewHodler viewHodler=null;
        if(viewHodler==null){
           viewHodler= new ViewHodler();
            convertView=View.inflate(c, R.layout.home_goodsgridviewitem,null);
            viewHodler.iv_dibu= (ImageView) convertView.findViewById(R.id.iv_dibutu);
            viewHodler.iv_zuoshang= (ImageView) convertView.findViewById(R.id.iv_zuoshang);
            viewHodler.tv_goodstitle= (TextView) convertView.findViewById(R.id.tv_goodstitle);
            viewHodler.tv_jianjie= (TextView) convertView.findViewById(R.id.tv_jianjie);
            viewHodler.tv_xianjia= (TextView) convertView.findViewById(R.id.tv_xianjia);
            viewHodler.tv_yuanjia= (TextView) convertView.findViewById(R.id.tv_yuanjia);
            convertView.setTag(viewHodler);
        }else {
            viewHodler= (ViewHodler) convertView.getTag();
        }
        x.image().bind(viewHodler.iv_dibu,list2.get(position).getGoods_img());
//        Picasso.with(MyApp.getContext()).load(data.get(position).getWatermarkUrl()).into(viewHodler.iv_zuoshang);
        viewHodler.tv_goodstitle.setText(list2.get(position).getEfficacy());
        viewHodler.tv_jianjie.setText(list2.get(position).getGoods_name());
        viewHodler.tv_xianjia.setText("¥"+list2.get(position).getShop_price());
        viewHodler.tv_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        viewHodler.tv_yuanjia.setText("¥"+list2.get(position).getMarket_price());

        return convertView;
    }




    class ViewHodler{
        private ImageView iv_dibu;
        private  ImageView iv_zuoshang;
        private TextView tv_goodstitle;
        private  TextView tv_jianjie;
        private  TextView tv_xianjia;
        private  TextView tv_yuanjia;
    }

      public  void addData(List<AllGoodsBean.DataBean> data ){
         list2.clear();
         list2.addAll(data);
         this.notifyDataSetChanged();
     }
    //升序
    public  void shengxuData(List<AllGoodsBean.DataBean> data ){
        list2.clear();
        list2.addAll(data);
        this.notifyDataSetChanged();
     }
     //降序
    public  void jiangxu(List<AllGoodsBean.DataBean> data ){
        list2.clear();
        list2.addAll(data);
        this.notifyDataSetChanged();
    }



}

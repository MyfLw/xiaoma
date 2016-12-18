package com.bwei.yunifang.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.icu.math.MathContext;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.Imagbean;
import com.bwei.yunifang.view.activity.SouyeshangpinActivity;
import com.bwei.yunifang.view.activity.view.Girdeview;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 *  * 作者：19084 on 2016/12/11 20:12
 *  * 邮箱：xjs250@163.com
 *  
 */
public class RecyclerviewAdapert extends RecyclerView.Adapter<RecyclerviewAdapert.base>  {
    private Context mcontext;
    private List<Imagbean.DataBean.SubjectsBean> list;
    private List<Imagbean.DataBean.SubjectsBean.GoodsListBean> goodsList;
    private  Activity ac;
  private   int size;
    public RecyclerviewAdapert(Context context, List<Imagbean.DataBean.SubjectsBean> list, Activity activity) {
        this.mcontext = context;
        this.list = list;
           this.ac=activity;
    }

    @Override
    public base onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.remenrecyclerview, null);
        return new base(view);
    }

    @Override
    public void onBindViewHolder(base holder, int position) {
        //显示热图
        for (int j = 0; j < list.size(); j++) {
            ImageLoader.getInstance().displayImage(list.get(position).getImage(), holder.imare);
        }
        InShuju(holder, position);


    }

    private void InShuju(base holder, final int position) {
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(8).getGoods_img(), holder.image1);
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(1).getGoods_img(), holder.image2);
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(2).getGoods_img(), holder.image3);
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(3).getGoods_img(), holder.image4);
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(4).getGoods_img(), holder.image5);
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(5).getGoods_img(), holder.image6);
        ImageLoader.getInstance().displayImage(list.get(position).getGoodsList().get(6).getGoods_img(), holder.image7);
        holder.title1.setText(list.get(position).getGoodsList().get(8).getGoods_name());
        holder.title2.setText(list.get(position).getGoodsList().get(1).getGoods_name());
        holder.title3.setText(list.get(position).getGoodsList().get(2).getGoods_name());
        holder.title4.setText(list.get(position).getGoodsList().get(3).getGoods_name());
        holder.title5.setText(list.get(position).getGoodsList().get(4).getGoods_name());
        holder.title6.setText(list.get(position).getGoodsList().get(5).getGoods_name());
        holder.title7.setText(list.get(position).getGoodsList().get(6).getGoods_name());
        holder.xianjia1.setText("¥"+list.get(position).getGoodsList().get(8).getShop_price());
        holder.xianjia2.setText("¥"+list.get(position).getGoodsList().get(1).getShop_price());
        holder.xianjia3.setText("¥"+list.get(position).getGoodsList().get(2).getShop_price());
        holder.xianjia4.setText("¥"+list.get(position).getGoodsList().get(3).getShop_price());
        holder.xianjia5.setText("¥"+list.get(position).getGoodsList().get(4).getShop_price());
        holder.xianjia6.setText("¥"+list.get(position).getGoodsList().get(5).getShop_price());
        holder.xianjia7.setText("¥"+list.get(position).getGoodsList().get(6).getShop_price());
        holder.yuanjia1.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia3.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia4.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia5.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia6.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia7.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.yuanjia1.setText("¥"+list.get(position).getGoodsList().get(8).getMarket_price());
        holder.yuanjia2.setText("¥"+list.get(position).getGoodsList().get(1).getMarket_price());
        holder.yuanjia3.setText("¥"+list.get(position).getGoodsList().get(2).getMarket_price());
        holder.yuanjia4.setText("¥"+list.get(position).getGoodsList().get(3).getMarket_price());
        holder.yuanjia5.setText("¥"+list.get(position).getGoodsList().get(4).getMarket_price());
        holder.yuanjia6.setText("¥"+list.get(position).getGoodsList().get(5).getMarket_price());
        holder.yuanjia7.setText("¥"+list.get(position).getGoodsList().get(7).getMarket_price());

        holder.itim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(8).getId());
            }
        });

        holder.itim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(1).getId());
            }
        });
        holder.itim3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(2).getId());
            }
        });
        holder.itim4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(3).getId());
            }
        });
        holder.itim5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(4).getId());
            }
        });
        holder.itim6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(5).getId());
            }
        });
        holder.itim7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tiao(mcontext, SouyeshangpinActivity.class,list.get(position).getGoodsList().get(6).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  void Tiao(Context context, Class cals,String id)
    {
        Intent it=new Intent();
        it.setClass(context,cals);
        it.putExtra("id",id);
        context.startActivity(it);
    }

    class  base extends  RecyclerView.ViewHolder{

        ImageView imare;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;
        ImageView image6;
        ImageView image7;
      //  android:id="@+id/yuanjia8"
       // android:id="@+id/xianjia8"
        TextView title1;
        TextView title2;
        TextView title3;
        TextView title4;
        TextView title5;
        TextView title6;
        TextView title7;
        TextView yuanjia1;
        TextView yuanjia2;
        TextView yuanjia3;
        TextView yuanjia4;
        TextView yuanjia5;
        TextView yuanjia6;
        TextView yuanjia7;
        TextView xianjia1;
        TextView xianjia2;
        TextView xianjia3;
        TextView xianjia4;
        TextView xianjia5;
        TextView xianjia6;
        TextView xianjia7;
        LinearLayout  itim1;
        LinearLayout  itim2;
        LinearLayout  itim3;
        LinearLayout  itim4;
        LinearLayout  itim5;
        LinearLayout  itim6;
        LinearLayout  itim7;
        LinearLayout  itim8;

        public base(View v) {
        super(v);
        imare= (ImageView) v.findViewById(R.id.imageRecyremen);
            image1 = (ImageView) v.findViewById(R.id.image1);
            image2 = (ImageView) v.findViewById(R.id.image2);
            image3 = (ImageView) v.findViewById(R.id.image3);
          image4 = (ImageView) v.findViewById(R.id.image4);
           image5 = (ImageView) v.findViewById(R.id.image5);
            image6 = (ImageView)v.findViewById(R.id.image6);
          image7 = (ImageView) v.findViewById(R.id.image7);
          title1= (TextView) v.findViewById(R.id.text1);
          title2= (TextView) v.findViewById(R.id.text2);
           title3= (TextView) v.findViewById(R.id.text3);
           title4= (TextView)v.findViewById(R.id.text4);
            title5= (TextView) v.findViewById(R.id.text5);
           title6= (TextView) v.findViewById(R.id.text6);
            title7= (TextView) v.findViewById(R.id.text7);
            yuanjia1= (TextView) v.findViewById(R.id.yuanjia1);
            yuanjia2= (TextView) v.findViewById(R.id.yuanjia2);
            yuanjia3= (TextView) v.findViewById(R.id.yuanjia3);
            yuanjia4= (TextView) v.findViewById(R.id.yuanjia4);
            yuanjia5= (TextView) v.findViewById(R.id.yuanjia5);
            yuanjia6= (TextView) v.findViewById(R.id.yuanjia6);
            yuanjia7= (TextView) v.findViewById(R.id.yuanjia7);
            xianjia1= (TextView) v.findViewById(R.id.xianjia1);
            xianjia2= (TextView) v.findViewById(R.id.xianjia2);
            xianjia3= (TextView) v.findViewById(R.id.xianjia3);
            xianjia4= (TextView) v.findViewById(R.id.xianjia4);
            xianjia5= (TextView) v.findViewById(R.id.xianjia5);
            xianjia6= (TextView) v.findViewById(R.id.xianjia6);
            xianjia7= (TextView) v.findViewById(R.id.xianjia7);

         itim1= (LinearLayout) v.findViewById(R.id.itm1);
            itim2= (LinearLayout) v.findViewById(R.id.itm2);
            itim3= (LinearLayout) v.findViewById(R.id.itm3);
            itim4= (LinearLayout) v.findViewById(R.id.itm4);
            itim5= (LinearLayout) v.findViewById(R.id.itm5);
            itim6= (LinearLayout) v.findViewById(R.id.itm6);
            itim7= (LinearLayout) v.findViewById(R.id.itm7);
            itim8= (LinearLayout) v.findViewById(R.id.itm8);



        }
}
}

package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.Imagbean;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.x;

import java.util.List;

/**
 *  * 作者：19084 on 2016/12/12 18:04
 *  * 邮箱：xjs250@163.com
 *  
 */
public class gridview extends BaseAdapter {
    private  Context context;
    private   List<Imagbean.DataBean.SubjectsBean.GoodsListBean> list;
    private ViewHod vi;
    private Object tag;

    public  gridview(Context context, List<Imagbean.DataBean.SubjectsBean.GoodsListBean> list)
   {
       this.list=list;
       this.context=context;
   }
    @Override
    public int getCount() {
        return list.size();
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
          if (view==null)
          {
              vi = new ViewHod();
              view=View.inflate(context, R.layout.yingridview,null);
              vi.xiaotu= (ImageView) view.findViewById(R.id.imagremenxiaomens);
              vi.xianjia= (TextView) view.findViewById(R.id.remenxianjin);
              vi.yuanjia= (TextView) view.findViewById(R.id.remenyuanjia);
              vi.tile= (TextView) view.findViewById(R.id.rementextview);
              vi.temen= (ImageView) view.findViewById(R.id.imaremen);
              view.setTag(vi);

          }
        else {
              tag = view.getTag();

          }
          vi.tile.setText(list.get(i).getGoods_name());
      vi.xianjia.setText("￥ "+list.get(i).getShop_price());
        vi.yuanjia.setText("￥ "+list.get(i).getMarket_price());
        //x.image().bind(vi.temen,list.get(i).getWatermarkUrl());
        x.image().bind(vi.xiaotu,list.get(i).getGoods_img());


        return view;
    }
    class   ViewHod{
        ImageView  temen;
        ImageView  xiaotu;
        TextView xianjia;
        TextView yuanjia;
        TextView  tile;
    }

}

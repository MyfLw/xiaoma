package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.Imagbean;

import org.xutils.x;

import java.util.List;

/**
 *  * 作者：19084 on 2016/12/12 19:56
 *  * 邮箱：xjs250@163.com
 *  
 */
public class ShouyezuihouGrdview extends BaseAdapter {
    private Context mcontext;
    private List<Imagbean.DataBean.DefaultGoodsListBean> list;
    private Object tag;
    private GrdeviewAdapter.ViewHond viewHond;
    private ViewHonds he;

    public ShouyezuihouGrdview(Context context,List<Imagbean.DataBean.DefaultGoodsListBean> list)
    {
        this.mcontext=context;
        this.list=list;
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
                  he = new ViewHonds();
                    view=View.inflate(mcontext,R.layout.souyezuihougriview,null);
                    he.img= (ImageView) view.findViewById(R.id.Shouyegriview);
                  he.textima= (ImageView) view.findViewById(R.id.Shouyegriviewxiaotu);
                  he.name= (TextView) view.findViewById(R.id.Souyezuihouname);
                  he.jiage= (TextView) view.findViewById(R.id.Souyezuihouxianjia);
                  he.yuanjia= (TextView) view.findViewById(R.id.Souyezuihouyuanjia);
                  view.setTag(he);
              }
            else {
                  view.getTag();

              }
        he.yuanjia.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
           he.name.setText(list.get(i).getGoods_name());
        x.image().bind(he.img,list.get(i).getWatermarkUrl());
        x.image().bind(he.textima,list.get(i).getGoods_img());
      he.yuanjia.setText("￥ "+list.get(i).getMarket_price());
  he.jiage.setText("￥ "+list.get(i).getShop_price());
        return view;
    }

    class ViewHonds
    {
       ImageView textima;
        ImageView  img;
        TextView jiage;
        TextView yuanjia;
        TextView name;
    }
}

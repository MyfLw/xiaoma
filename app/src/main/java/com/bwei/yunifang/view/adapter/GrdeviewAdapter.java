package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.Imagbean;
import com.bwei.yunifang.view.Uitls.ImageLoaderUtils;

import java.util.List;

/**
 *  * 作者：19084 on 2016/12/12 11:09
 *  * 邮箱：xjs250@163.com
 *  
 */
public class GrdeviewAdapter extends BaseAdapter {
    private Context mcontext;
    private List<Imagbean.DataBean.SubjectsBean.GoodsListBean> list;
    private Object tag;
    private ViewHond viewHond;

    public GrdeviewAdapter(Context context,List<Imagbean.DataBean.SubjectsBean.GoodsListBean> list)
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
            viewHond = new ViewHond();
            view=View.inflate(mcontext, R.layout.remenyin1,null);
            viewHond.img= (ImageView) view.findViewById(R.id.imagremenxiaomens);
            viewHond.textima= (TextView) view.findViewById(R.id.rementextview);
            viewHond.jiage= (TextView) view.findViewById(R.id.remenxianjin);
            viewHond.yuanjia= (TextView) view.findViewById(R.id.remenyuanjia);
            view.setTag(viewHond);
        }else {
            tag = view.getTag();
        }
        ImageLoaderUtils imageLoaderUtils=new ImageLoaderUtils();

       com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(list.get(i).getGoods_img(),viewHond.img);
   viewHond.textima.setText(list.get(i).getGoods_name());

        return view;
    }

    class ViewHond
    {
        TextView textima;
        ImageView  img;
        TextView jiage;
        TextView yuanjia;
    }
}

package com.bwei.yunifang.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.volley.toolbox.ImageLoader;
import com.bwei.yunifang.R;

import com.bwei.yunifang.view.Bean.Imagbean;

import java.util.List;

/**
 *  * 作者：19084 on 2016/12/10 08:52
 *  * 邮箱：xjs250@163.com
 *  
 */
public class HomebaseAdapter extends BaseAdapter{
    private Context mcontext;
    private List<Imagbean.DataBean.Ad5Bean> list;
    private Object tag;
    private ViewHond viewHond;

    public HomebaseAdapter(Context context,List<Imagbean.DataBean.Ad5Bean> list)
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
           view=View.inflate(mcontext, R.layout.imaghomyingyong,null);
           viewHond.img= (ImageView) view.findViewById(R.id.imghom);
           viewHond.textima= (TextView) view.findViewById(R.id.tilegHom);
            view.setTag(viewHond);
       }else {
           tag = view.getTag();
       }
       // ImageLoaderUtils  imageLoaderUtils=new ImageLoaderUtils();
      //  imageLoaderUtils.LoadImageWithoutLister(list.get(i).getImage(),viewHond.img,false);
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(list.get(i).getImage(),viewHond.img);
           viewHond.textima.setText(list.get(i).getTitle());

        return view;
    }

    class ViewHond
    {
        TextView textima;
        ImageView  img;

    }

}

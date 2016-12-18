package com.bwei.yunifang.view.Not;

import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.Imagbean;
import com.bwei.yunifang.view.Uitls.Uri;
import com.google.gson.Gson;

import java.io.IOException;

/**
 *  * 作者：19084 on 2016/12/10 10:47
 *  * 邮箱：xjs250@163.com
 *  
 */
public class Postion {
    private Okjiekou mvp;
    private BaseBean basebean;
    model  md;
    private final Gson gson;

    public Postion ()
    {

        md=new model();
        gson = new Gson();
    }
    public void setMvpview(Okjiekou mvp, BaseBean basebean)
    {
        this.basebean=basebean;
        this.mvp=mvp;
    }
    public  void  loadData()
    {
        md.kaisi();

        md.MoText(new OKjiekouchuan() {

            private BaseBean baseBean;

            @Override
            public void onSucces(String bean) {
                if(mvp!=null)
                {
                    baseBean = gson.fromJson(bean, basebean.getClass());
                    mvp.onSuccess(baseBean);
                }
            }

            @Override
            public void onFaill(IOException d) {
                mvp.onFail(d);
            }
        });


    }

}

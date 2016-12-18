package com.bwei.yunifang.view.activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.bwei.yunifang.R;

/**
 *  * 作者：19084 on 2016/12/8 20:42
 *  * 邮箱：xjs250@163.com
 *  
 */
public class Wode_zhuce_Activity extends AppCompatActivity  implements View.OnClickListener{

    private ImageView fanhui;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_zhuche);
        //获得控件的方法
        Init();
    }

    private void Init() {
        fanhui = (ImageView) findViewById(R.id.title_zhuche_FANhui);
        fanhui.setOnClickListener(this);
    }
  //点击事件的方法
    @Override
    public void onClick(View view) {
         switch (view.getId())
         {case  R.id.title_zhuche_FANhui:
             Tiaozhuan(this,Wode_log_Activity.class);
             break;

         }
    }
    //跳转的方法
    public void Tiaozhuan(Context context, Class c)
    {
        Intent it=new Intent();
        it.setClass(context,c);
        startActivity(it);
    }
}

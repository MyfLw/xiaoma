package com.bwei.yunifang.view.fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.activity.Wode_Xianjin_Activity;
import com.bwei.yunifang.view.activity.Wode_log_Activity;
import com.bwei.yunifang.view.activity.Wode_shezhi_Activity;
import com.bwei.yunifang.view.activity.Wode_yaoqin_Activity;
import com.bwei.yunifang.view.activity.view.PersonInfo;

/**
 * Created by Mayuefeng on 2016/12/6.
 */
public class MineFragment extends Fragment implements View.OnClickListener{
      private   boolean  ANniu=false;
    private ImageButton shezhi;
    private LinearLayout wodedindan;
    private LinearLayout wodeYaoQin;
    private LinearLayout wodeXianjin;
    private LinearLayout wodeChoujian;
    private LinearLayout wodeShoucan;
    private Button bt_log;
    private ImageButton imagBt_touXian;
    private SharedPreferences log;
    private SharedPreferences sharedPreferences;
    private String Logstring;
    private LinearLayout   wodeshuanian;
    private LinearLayout   wodelianxi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.wode_xinxi_yemian,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
           //获得控件的方
        sharedPreferences = getActivity().getSharedPreferences("1412Log", Context.MODE_PRIVATE);
        //存值得方法
        Logstring = sharedPreferences.getString("Log", null);
        Init();



    }
//获得控件的方法
    private void Init() {
        imagBt_touXian = (ImageButton) getView().findViewById(R.id.ImagBt_TouXian);
        bt_log = (Button) getView().findViewById(R.id.Bt_Huiyuan);
        shezhi = (ImageButton) getView().findViewById(R.id.ImagBt_SheZhi);
        wodedindan = (LinearLayout) getView().findViewById(R.id.Liner_WodeDindan);
        wodeYaoQin = (LinearLayout) getView().findViewById(R.id.Liner_Yaoqin);
        wodeXianjin = (LinearLayout) getView().findViewById(R.id.Liner_WodeXianjin);
        wodeChoujian = (LinearLayout) getView().findViewById(R.id.Liner_WodeChoujian);
        wodeShoucan = (LinearLayout) getView().findViewById(R.id.Liner_WodeShoucan);
        wodeshuanian = (LinearLayout) getView().findViewById(R.id.Liner_Shuanian);
        wodelianxi = (LinearLayout) getView().findViewById(R.id.Liner_Lianxi);
                    wodelianxi.setOnClickListener(this);
          wodeshuanian.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        wodedindan.setOnClickListener(this);
        wodeYaoQin.setOnClickListener(this);
        wodeXianjin.setOnClickListener(this);
        wodeShoucan.setOnClickListener(this);
        wodeChoujian.setOnClickListener(this);
        imagBt_touXian.setOnClickListener(this);
   bt_log.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

     switch (view.getId())
     {
         case  R.id.ImagBt_SheZhi:
         //没有登录的情况
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);
             }
             else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_shezhi_Activity.class);

             }
         return;
         case  R.id.Liner_WodeDindan:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_yaoqin_Activity.class);
             }
             return;
         case  R.id.Liner_Yaoqin:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_yaoqin_Activity.class);
             }

             return;
         case  R.id.Liner_WodeXianjin:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }
             else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_Xianjin_Activity.class);
             }

             return;
         case  R.id.Liner_WodeChoujian:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }else if(Logstring.equals("Log"))
             {
//                 Tiaozhuan(Wode_Choujian_Activity.class);
             }

             return;
         case  R.id.Liner_WodeShoucan:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }
             else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_Xianjin_Activity.class);
             }

             return;
         case  R.id.Bt_Huiyuan:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }

             return;
         case  R.id.ImagBt_TouXian:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(PersonInfo.class);

             }
             break;
         case  R.id.Liner_Shuanian:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }
             else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_Xianjin_Activity.class);
             }
             break;
         case  R.id.Liner_Lianxi:
             if (TextUtils.isEmpty(Logstring))
             {
                 Tiaozhuan(Wode_log_Activity.class);

             }
             else if(Logstring.equals("Log"))
             {
                 Tiaozhuan(Wode_Xianjin_Activity.class);
             }


         break;

     }
    }
    //跳转的方法
    public void Tiaozhuan(Class c)
    {
        Intent  it=new Intent();
        it.setClass(getActivity(),c);
         startActivity(it);
    }

}

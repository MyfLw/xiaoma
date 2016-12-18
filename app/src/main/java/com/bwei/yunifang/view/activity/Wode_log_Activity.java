package com.bwei.yunifang.view.activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.Imagbean;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Tanchu_jianpan;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.fragment.MineFragment;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

/**
 *  * 作者：19084 on 2016/12/7 16:49
 *  * 邮箱：xjs250@163.com
 *  
 */
public class Wode_log_Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView login_ynf;
    private TextView login_mobile;
    private EditText login_et_shoujihao;
    private EditText login_et_mima;
    private TextView login_forget_tv_ps;
    private LinearLayout zhanghao_log;
    private LinearLayout login_kuaisu_log;
    private EditText login_et_kuaisu;
    private EditText login_et_code;
    private Button bt_wolog;
    private TextView login_tv_other;
    private ImageView title_back_iv;
    private TextView title_right_tv;
    private PopupWindow po;
    private ImageButton qq;
    private ImageButton xinlan;
    private ImageButton weixin;
    private String url = "http://v.juhe.cn/toutiao/index?type=top&key=APPKEY";


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_log);
            //获得控件的方法

        /*app.httpUtils.requestGet(url, Imagbean.class, new ANdebuk() {
            @Override
            public void onSuccess(BaseBean bean) {

                Imagbean subBean = (Imagbean) bean;
               subBean.getResult();
                Log.e("尼玛","ddfd");

            }

            @Override
            public void onSuccess_Fail() {
                Log.e("尼玛","dfdsssssssssss");
            }

            @Override
            public void onFail() {
                Log.e("尼玛","dfdsssssssssss");

            }
        });*/
        Init();

    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            //登录御泥坊
            case  R.id.login_ynf:
                ynf_qiehuan();
            break;
            //手机快速登录
            case  R.id.login_mobile:
                login_qiehuan();
                break;
            //输入的手机号
            case  R.id.login_et_shoujihao:
                //弹出系统键盘
                Tanchu_jianpan.openInputMethod(login_et_shoujihao);
                break;
            //输入的密码
            case  R.id.login_et_mima:
                Tanchu_jianpan.openInputMethod(login_et_shoujihao);
                break;
            //忘记密码
            case  R.id.login_forget_tv_ps:
                break;
            //账号登录
            case  R.id.zhanghao_log:
                Tanchu_jianpan.openInputMethod(login_et_shoujihao);
                break;
            //快速登录手机
            case R.id.login_kuaisu_log:
                Tanchu_jianpan.openInputMethod(login_et_shoujihao);
                break;
            //快速登录手机号
            case R.id.login_et_kuaisu:
                //打开注册页面
             //  zhu_Che();
                break;
            //验证码
            case  R.id.login_et_code:
                Tanchu_jianpan.openInputMethod(login_et_shoujihao);
                break;
            //登录按钮
            case  R.id.Bt_wolog:

                break;
            //第三方登录
            case  R.id.login_tv_other:
                popw(bt_wolog);
                break;
            //返回按钮
            case  R.id.title_back_iv:

                Intent  it=new Intent();
                it.setClass(this,HomePageActivity.class);
                it.putExtra("int",4);
                startActivity(it);


               //Tiaozhuan(Wode_log_Activity.this,HomePageActivity.class);

                break;
            //注册按钮
            case  R.id.title_right_tv:
                 Tiaozhuan(this,Wode_zhuce_Activity.class);
                break;
            case R.id.ImagBt_QQ_log:
                QQ_log();
                break;
        }
    }
    //跳转的方法
    public void Tiaozhuan(Context context, Class c)
    {
        Intent  it=new Intent();
        it.setClass(context,c);
        startActivity(it);
    }
    private void QQ_log() {

        UMShareAPI mShareAPI = UMShareAPI.get( Wode_log_Activity.this );
        mShareAPI.getPlatformInfo(this, SHARE_MEDIA.QQ, umAuthListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
   /* private void zhu_Che() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
               // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

// 提交用户信息（此方法可以不调用）
                    registerUser(country, phone);
                }
            }
        });
        registerPage.show(context);
    }
*/
    private void login_qiehuan() {
        login_mobile.setTextColor(Color.RED);
        login_ynf.setTextColor(Color.BLACK);
        zhanghao_log.setVisibility(View.GONE);
        login_kuaisu_log.setVisibility(View.VISIBLE);
    }

    private void ynf_qiehuan() {
        zhanghao_log.setVisibility(View.VISIBLE);
        login_kuaisu_log.setVisibility(View.GONE);
        login_ynf.setTextColor(Color.RED);
        login_mobile.setTextColor(Color.BLACK);
    }

    private void Init() {
        //登录控件御泥坊
        login_ynf = (TextView) findViewById(R.id.login_ynf);
        login_ynf.setOnClickListener(this);
        //手机快速登录
        login_mobile = (TextView) findViewById(R.id.login_mobile);
        login_mobile.setOnClickListener(this);
       // 输入的手机号
        login_et_shoujihao = (EditText) findViewById(R.id.login_et_shoujihao);
        login_et_shoujihao.setOnClickListener(this);
        //密码输入的
        login_et_mima = (EditText) findViewById(R.id.login_et_mima);
        login_et_mima.setOnClickListener(this);
        //忘记密码
        login_forget_tv_ps = (TextView) findViewById(R.id.login_forget_tv_ps);
           login_forget_tv_ps.setOnClickListener(this);
        //账号登录
        zhanghao_log = (LinearLayout) findViewById(R.id.zhanghao_log);
        zhanghao_log.setOnClickListener(this);
        //快速登录
        login_kuaisu_log = (LinearLayout) findViewById(R.id.login_kuaisu_log);
        login_kuaisu_log.setOnClickListener(this);
        //快速登录手机号
        login_et_kuaisu = (EditText) findViewById(R.id.login_et_kuaisu);
        login_et_kuaisu.setOnClickListener(this);
        //验证码
        login_et_code = (EditText) findViewById(R.id.login_et_code);
        login_et_code.setOnClickListener(this);
        //登录按钮
        bt_wolog = (Button) findViewById(R.id.Bt_wolog);
        bt_wolog.setOnClickListener(this);
        //第三方登录
        login_tv_other = (TextView) findViewById(R.id.login_tv_other);
        login_tv_other.setOnClickListener(this);
        //返回按钮
        title_back_iv = (ImageView) findViewById(R.id.title_back_iv);
        title_back_iv.setOnClickListener(this);
        //注册按钮
        title_right_tv = (TextView) findViewById(R.id.title_right_tv);
        title_right_tv.setOnClickListener(this);
    }
    //popwwindou
    public  void  popw(View v)
    {
        //弹出框
        po=new PopupWindow(v, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        View  pos=  View.inflate(Wode_log_Activity.this,R.layout.wode_powlog,null);
          //获得控件
        qq = (ImageButton) pos.findViewById(R.id.ImagBt_QQ_log);
        xinlan = (ImageButton) pos.findViewById(R.id.ImagBt_xinlang_log);
        weixin = (ImageButton) pos.findViewById(R.id.ImagBt_weixin_log);

        qq.setOnClickListener(this);
       po.setBackgroundDrawable(new BitmapDrawable());
        po.setContentView(pos);
        po.setAnimationStyle(R.style.popu);
        po.showAtLocation(v,Gravity.NO_GRAVITY,0,500);
    }
}

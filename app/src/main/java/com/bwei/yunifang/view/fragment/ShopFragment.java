package com.bwei.yunifang.view.fragment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Api.Jiekoushuju;
import com.bwei.yunifang.view.Bean.GoodsInfoBean;
import com.bwei.yunifang.view.Bean.shoppingCart;
import com.bwei.yunifang.view.Database.SQLItegouwu;
import com.bwei.yunifang.view.activity.SouyeshangpinActivity;

import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Mayuefeng on 2016/12/6.
 */

public class ShopFragment extends Fragment implements View.OnClickListener {
    private ShoppingCartAdapter shoppingCartAdapter;
    TextView jiesuan;
    TextView proName;
    private View view;
    private ListView list_shop;
    private TextView bianji;
    private TextView money_all;
    private TextView jiesuan_button;
    private CheckBox bt_all;
    private boolean flag = false;
    String shopPrice;
    TextView proCount;
    ListView aListView;
    private LayoutInflater layoutInflater;
    private SouyeshangpinActivity sp;
    private SQLItegouwu sqlItegouwu;
    private SQLiteDatabase database;
    private Cursor cursor;
    private ArrayList<shoppingCart> list;
    private SQLiteDatabase database1;
    private float zongpian;
    private TextView zongjiatext;
    private CheckBox quanbuchek;
     private   boolean  quan=true;
    private  int po;
   public Jiekoushuju jk;
    private  float zongjiaqian;
    private   boolean kaisi=false;
    private boolean[] q;
private HashMap<Integer,Boolean> lt=new HashMap<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqlItegouwu = new SQLItegouwu(getActivity());
        sqlItegouwu.getReadableDatabase();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.list_shopping_cart_item, null);

        return view;
    }
 public   void  jieke(Jiekoushuju jk)
 {
     this.jk=jk;
 }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findViewByID();
        initView();
        //全部选中


        bt_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

          private boolean checked;

          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              checked = compoundButton.isChecked();
              for (int i = 0; i <list.size(); i++)
              {
                  lt.put(i,b);
                 /* if (shoppingCartAdapter.getIsSelected().get(i)) {
                      shoppingCartAdapter.getIsSelected().put(i, b);
                  //    checkNum--;// 数量减1
                }*/
              }
              shoppingCartAdapter.setIsSelected(lt);
              Message message = mHandler.obtainMessage();
              message.what = 5;
              mHandler.sendMessage(message);
          }

      });

    }

    /*子线程-解析数据*/
    private Handler mHandler = new Handler() {


        private Iterator<Boolean> iterator;
        private CheckBox d;
        private ArrayList<shoppingCart> temp;
        private int anInt;
        private GoodsInfoBean.DataBean.GoodsBean goods;

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -1:
                    Toast.makeText(getActivity(), "服务器连接失败!",
                            Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(getActivity(), "哎呀，出错啦...",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    temp = (ArrayList<shoppingCart>) msg.obj;
                    shoppingCartAdapter = new ShoppingCartAdapter(getActivity(), temp);
                    aListView.setAdapter(shoppingCartAdapter);
                    break;
                case 2:
                    String add = (String) msg.obj;
                    Float input2 = Float.parseFloat(add);
                    zongpian += input2;
                    money_all.setText("合计:" + "¥" + zongpian);
                   shoppingCartAdapter.notifyDataSetChanged();
                    break;
                case  3:
                    String jianq = (String) msg.obj;
                    Float jian = Float.parseFloat(jianq);
                    zongpian -= jian;
                    money_all.setText("合计:" + "¥" + zongpian);
                 shoppingCartAdapter.notifyDataSetChanged();
                    break;
                    case 5:

                        for (int i = 0; i <lt.size() ; i++) {

                            shopPrice = temp.get(i).getShopPrice();
                            Float input= Float.parseFloat(shopPrice);
                            zongjiaqian+=input;
                        }
                        float zon = (float) zongjiaqian;
                        money_all.setText("合计:" + "¥" + zon);
                       shoppingCartAdapter.notifyDataSetChanged();


                    break;
                default:
                    break;
            }
        }
    };

    public void findViewByID() {
        aListView = (ListView) getView().findViewById(R.id.cart_shopping_listview);
        bianji = (TextView) getView().findViewById(R.id.bianji);
        money_all = (TextView) getView().findViewById(R.id.money_all);
        jiesuan_button = (TextView) getView().findViewById(R.id.suan_button);
        bt_all = (CheckBox) getView().findViewById(R.id.bt_all);
        bianji.setOnClickListener(this);
        money_all.setOnClickListener(this);
        jiesuan_button.setOnClickListener(this);
        bt_all.setOnClickListener(this);



    }

    //开辟线程
    protected void initView() {

        list = new ArrayList<>();
        if (list.size() == 0 && list == null) {
            mHandler.sendEmptyMessage(-2);
        } else if (list != null) {
            String sql = "select * from gouwuche";
            database1 = sqlItegouwu.getReadableDatabase();
            cursor = database1.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                //   ProName text,proimg text,shopprice text,markPrice text,proCount text
                String name = cursor.getString(cursor.getColumnIndex("ProName"));
                String proimg = cursor.getString(cursor.getColumnIndex("proimg"));
                String shopprice = cursor.getString(cursor.getColumnIndex("shopprice"));
                String proCount = cursor.getString(cursor.getColumnIndex("proCount"));
                shoppingCart sp = new shoppingCart();
                sp.setProImg(proimg);
                sp.setProName(name);
                sp.setShopPrice(shopprice);
                sp.setProCount(proCount);
                list.add(sp);
            }
       //  database1.execSQL("Delete from gouwuche where 1=1");
            Message message = mHandler.obtainMessage();
            message.what = 1;
            message.obj = list;
            mHandler.sendMessage(message);
        }


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bianji:
                if (flag == false) {
                    bianji.setText("完成");
                    jiesuan_button.setText("删除");
                    money_all.setVisibility(View.GONE);
                    flag = true;

                } else {
                    bianji.setText("编辑");
                    jiesuan_button.setText("结算");
                    money_all.setVisibility(View.VISIBLE);
                    flag = false;
                }


                break;
            case R.id.bt_all:
                break;
            case R.id.money_all:
                break;
            default:
                break;
        }

    }

    public class ShoppingCartAdapter extends BaseAdapter {
        private HashMap<Integer, Boolean> isSelected;
        private Context mContext;
        private List<shoppingCart> mList;

        private ViewHolder holder;

        public ShoppingCartAdapter(Context mContext, List<shoppingCart> mList) {
            super();
            this.mContext = mContext;
            this.mList = mList;
            isSelected = new HashMap<Integer, Boolean>();
            initDate();
        }
        private void initDate() {
            for (int i = 0; i < list.size(); i++) {
                getIsSelected().put(i, false);
            }
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (mList == null) {
                return 0;
            } else {
                return this.mList.size();
            }
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            if (mList == null) {
                return null;
            } else {
                return this.mList.get(position);
            }
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(this.mContext).inflate(R.layout.goucheyinyong, null, true);
                holder.image = (ImageView) convertView.findViewById(R.id.pro_image);
                holder.chose = (CheckBox) convertView.findViewById(R.id.pro_checkbox);
                holder.proName = (TextView) convertView.findViewById(R.id.pro_name);
                holder.proPrice = (TextView) convertView.findViewById(R.id.pro_shopPrice);
                holder.proCount = (TextView) convertView.findViewById(R.id.shop_num);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (this.mList != null) {
                final shoppingCart shoppingList = this.mList.get(position);
                po=mList.size();

                x.image().bind(holder.image, shoppingList.getProImg());
                holder.proName.setText(shoppingList.getProName().toString());
                holder.proPrice.setText("¥ " + shoppingList.getShopPrice().toString());
                holder.proCount.setText("数量:"+shoppingList.getProCount().toString());
                if(isSelected.size()==list.size()) {
                    holder.chose.setChecked(isSelected.get(position));

                }
                holder.chose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    private String shopPrice;
                    private int size;
                    private boolean checked;

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        checked = compoundButton.isChecked();

                        for (int i = 0; i <isSelected.size() ; i++) {
                            if (i==position)
                            {


                                Log.e("heh", "position"+position);
                                isSelected.put(position,checked);
                               // holder.chose.setChecked(isSelected.get(i));
                                if (isSelected.get(i)==true) {
                                  holder.chose.setChecked(isSelected.get(i));
                                    Log.e("hehs", mList.get(position).getShopPrice());
                                    Message message = mHandler.obtainMessage();
                                    message.what = 2;
                                    message.obj = mList.get(position).getShopPrice();
                                    mHandler.sendMessage(message);


                                } else if (isSelected.get(i)==false) {
                                    holder.chose.setChecked(isSelected.get(i));
                                    Message message = mHandler.obtainMessage();
                                    message.what = 3;
                                    message.obj = mList.get(position).getShopPrice();
                                    mHandler.sendMessage(message);

                                }
                            }

                        }





                    }

                });

            }

            return convertView;
        }
        public  HashMap<Integer, Boolean> getIsSelected() {
            return isSelected;
        }

        public  void setIsSelected(HashMap<Integer, Boolean> isSelected) {
            this.isSelected = isSelected;
        }
        /*定义item对象*/
        class ViewHolder {
            ImageView image;
            TextView proName;
            CheckBox chose;
            TextView proPrice;
            TextView proCount;
        }


    }
}

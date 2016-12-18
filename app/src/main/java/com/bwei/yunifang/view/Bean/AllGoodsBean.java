package com.bwei.yunifang.view.Bean;

import java.util.Comparator;
import java.util.List;

/**
 * Created by 55081 on 2016/12/13.
 */

public class AllGoodsBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }



    public static class DataBean implements Comparable<DataBean> {
        /**
         * id : 121
         * goods_name : 镇店之宝丨美白嫩肤矿物蚕丝面膜7片
         * shop_price : 39.9
         * market_price : 99
         * is_coupon_allowed : true
         * is_allow_credit : false
         * goods_img : http://image.hmeili.com/yunifang/images/goods/121/goods_img/161201135479872856902510.jpg
         * sales_volume : 116103
         * efficacy : 镇店之宝 美白爆款
         * sort : 0
         */

        private String id;
        private String goods_name;
        private double shop_price;
        private double market_price;
        private boolean is_coupon_allowed;
        private boolean is_allow_credit;
        private String goods_img;
        private int sales_volume;
        private String efficacy;
        private int sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public double getShop_price() {
            return shop_price;
        }

        public void setShop_price(double shop_price) {
            this.shop_price = shop_price;
        }

        public double getMarket_price() {
            return market_price;
        }

        public void setMarket_price(double market_price) {
            this.market_price = market_price;
        }

        public boolean isIs_coupon_allowed() {
            return is_coupon_allowed;
        }

        public void setIs_coupon_allowed(boolean is_coupon_allowed) {
            this.is_coupon_allowed = is_coupon_allowed;
        }

        public boolean isIs_allow_credit() {
            return is_allow_credit;
        }

        public void setIs_allow_credit(boolean is_allow_credit) {
            this.is_allow_credit = is_allow_credit;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(int sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getEfficacy() {
            return efficacy;
        }

        public void setEfficacy(String efficacy) {
            this.efficacy = efficacy;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

       /* @Override
        public int compare(Object o1, Object o2) {

            if (market_price < this.getMarket_price()) {
                return 1;
            } else if (market_price > this.getMarket_price()) {
                return -1;
            } else {
                return 0;
            }

        }*/


        @Override
        public int compareTo(DataBean o) {
            if (this.getMarket_price()< o.getMarket_price()) {
                return 1;
            } else if (this.market_price > o.getMarket_price()) {
                return -1;
            } else {
                return 0;
            }

        }
    }
}

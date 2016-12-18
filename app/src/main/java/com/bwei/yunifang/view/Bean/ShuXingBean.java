package com.bwei.yunifang.view.Bean;

import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/15.
 */

public class ShuXingBean extends BaseBean{

    /**
     * code : 200
     * msg : success
     * data : [{"id":"5","goods_name":"金桂花矿物眼膜贴60片","shop_price":69,"market_price":89,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/5/goods_img/16081908444051052195086751.jpg","sales_volume":48821,"efficacy":"补水靓眼 改善熊猫眼","sort":0},{"id":"446","goods_name":"芦荟补水保湿凝胶150g","shop_price":49.9,"market_price":59,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/446/goods_img/16081909409518953549635059.jpg","sales_volume":35737,"efficacy":"水水润润 抗痘修护","sort":0},{"id":"14","goods_name":"矿物泥浆鼻膜60g","shop_price":55,"market_price":69,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/14/goods_img/160819084841216186223194195.jpg","sales_volume":30005,"efficacy":"草莓鼻小救星 收敛毛孔","sort":0},{"id":"58","goods_name":"矿物养肤霜(滋润型)50g","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/58/goods_img/160819085056119208440462735.jpg","sales_volume":12186,"efficacy":"滋润补水 持久水润","sort":0},{"id":"577","goods_name":"【补差价专用】差几元拍几个 不支持单独购买 每人限拍10个","shop_price":1,"market_price":1,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/577/goods_img/1607051923785571077318132.jpg","sales_volume":8205,"efficacy":"补差价专用","sort":0},{"id":"181","goods_name":"玫瑰滋养矿物身体乳150ml","shop_price":59,"market_price":69,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/181/goods_img/160819091085514098528951391.jpg","sales_volume":7898,"efficacy":"补水保湿 柔嫩丝滑","sort":0},{"id":"7","goods_name":"丝滑莹润矿物护手霜50g*2支","shop_price":59,"market_price":79,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/7/goods_img/1608190845971977396598657.jpg","sales_volume":7865,"efficacy":"柔润滑嫩 滋养保湿","sort":0},{"id":"487","goods_name":"爆款眼霜|御泥坊海洋弹性蛋白矿物精华眼霜25g","shop_price":139,"market_price":169,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/487/goods_img/160819094177112712665888283.jpg","sales_volume":6870,"efficacy":"提拉紧致 润亮双眸","sort":0},{"id":"183","goods_name":"矿物养肤霜（清爽型）50g","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/183/goods_img/160819091075218776817117661.jpg","sales_volume":4032,"efficacy":"清新润泽 锁水保湿","sort":0},{"id":"403","goods_name":"黑玫瑰矿物精华液30ml","shop_price":159,"market_price":199,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/403/goods_img/160819093789216886909199956.jpg","sales_volume":2488,"efficacy":"深度保养 提亮肤色","sort":0},{"id":"165","goods_name":"黑茶修护新生矿物眼膜贴9对","shop_price":79,"market_price":147,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/165/goods_img/16081909089821315447896064.jpg","sales_volume":1433,"efficacy":"紧致双眼 唤醒明眸","sort":0},{"id":"1280","goods_name":"潜心研制|御泥坊精华水分光感气垫BB霜 新品上市","shop_price":139,"market_price":169,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1280/goods_img/16120518307098199689667991.jpg","sales_volume":780,"efficacy":"控油遮瑕 水润透亮","sort":0},{"id":"167","goods_name":"玫瑰精油水润花瓣面膜100g","shop_price":119,"market_price":139,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/167/goods_img/16081909090814297164366459.jpg","sales_volume":649,"efficacy":"补水锁水 持久滋润","sort":0},{"id":"1250","goods_name":"新品推荐|红石榴矿物面霜50g","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1250/goods_img/16120711377623595883702997.jpg","sales_volume":418,"efficacy":"水润亮颜 紧致淡纹","sort":0},{"id":"169","goods_name":"燕麦酸奶面膜100g","shop_price":129,"market_price":159,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/169/goods_img/16081909095497046935697259.jpg","sales_volume":391,"efficacy":"细腻肌肤 清洁角质","sort":0},{"id":"171","goods_name":"红豆薏米面膜100g","shop_price":129,"market_price":159,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/171/goods_img/1608190909716552416566162.jpg","sales_volume":369,"efficacy":"改善黯哑 绽放莹亮","sort":0},{"id":"1281","goods_name":"火爆新品|红石榴矿物眼霜25g","shop_price":129,"market_price":159,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1281/goods_img/16120320397768553621232313.jpg","sales_volume":308,"efficacy":"亮肤修护 改善补水","sort":0}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * goods_name : 金桂花矿物眼膜贴60片
         * shop_price : 69
         * market_price : 89
         * is_coupon_allowed : true
         * is_allow_credit : false
         * goods_img : http://image.hmeili.com/yunifang/images/goods/5/goods_img/16081908444051052195086751.jpg
         * sales_volume : 48821
         * efficacy : 补水靓眼 改善熊猫眼
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
    }


}

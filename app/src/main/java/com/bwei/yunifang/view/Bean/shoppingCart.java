package com.bwei.yunifang.view.Bean;

import java.io.Serializable;

/**
 *  * 作者：19084 on 2016/12/16 11:37
 *  * 邮箱：xjs250@163.com
 *  
 */
public class shoppingCart implements Serializable {
    private String proImg;
    private String ProName;
    private String shopPrice;
    private String markPrice;
    private String proCount;
    private  boolean cart=false;
    public String getProImg() {
        return proImg;
    }
    public void setProImg(String proImg) {
        this.proImg = proImg;
    }
    public String getProName() {
        return ProName;
    }
    public void setProName(String proName) {
        ProName = proName;
    }
    public String getShopPrice() {
        return shopPrice;
    }
    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }
    public String getMarkPrice() {
        return markPrice;
    }
    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }
    public String getProCount() {
        return proCount;
    }
    public void setProCount(String proCount) {
        this.proCount = proCount;
    }
}

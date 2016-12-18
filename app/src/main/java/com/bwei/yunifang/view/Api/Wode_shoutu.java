package com.bwei.yunifang.view.Api;

import com.bwei.yunifang.view.Bean.Imagbean;

/**
 *  * 作者：19084 on 2016/12/9 18:51
 *  * 邮箱：xjs250@163.com
 *  
 */

public interface Wode_shoutu {
    //返回成功的案例
    void   Succeed (Imagbean img);
  void   Failure(String errs);
}

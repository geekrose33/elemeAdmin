package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    public void listBusinessAll();

    public void listBusinessInsert();

    public void listBusinessSelect();

    public void listBusinessDelete();

    // 添加一个商家登录验证的方法
    public Business login();

    // select
    public void viewInfo(Business business);



    // xiugai
    public void update(Business business);
    // 更新密码
    public void updatePass(Business business);

    // 查看商品信息
    public void viewSelectFood(Business business);

}

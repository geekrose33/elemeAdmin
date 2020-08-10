package com.neusoft.dao;

import com.neusoft.domain.Business;
import com.neusoft.domain.Food;

import java.util.ArrayList;

public interface FoodDao {

    // 查看
    public ArrayList<Food> select();

    // 增加
    public void insert(Food food);

    // 删除
    public void delete(Integer foodId);
    // 修改
    public void update(String foodName,Integer foodId);


    // 查看商品信息（business）
    public void searchFood(Integer businessId);

}

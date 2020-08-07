package com.neusoft.dao;

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
    public void update(Food food,Integer foodId);

}

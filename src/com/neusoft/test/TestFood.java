package com.neusoft.test;

import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.Impl.FoodViewImpl;

import java.util.ArrayList;

/**
 * @author Joker_Dong
 * @date 2020-8-8 7:44
 */

public class TestFood {

    public static void main(String[] args) {

//        System.out.println(new FoodDaoImpl().select());

//        Food food = new Food("黄焖鸡","很香",60,10012);
//        new FoodDaoImpl().insert(food);
//
//        System.out.println(new FoodDaoImpl().select("黄焖鸡"));
//
//        new FoodDaoImpl().delete(10);

        new FoodDaoImpl().update(10014,11);
        ArrayList<Food> foodArrayList = new FoodDaoImpl().select();
        for (Food food:foodArrayList
             ) {
            System.out.println(food);
        }
//        new FoodDaoImpl().select();

    }

}

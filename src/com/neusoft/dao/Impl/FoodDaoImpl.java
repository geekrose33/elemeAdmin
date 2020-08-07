package com.neusoft.dao.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Joker_Dong
 * @date 2020-8-7 11:15
 */

public class FoodDaoImpl implements FoodDao {

    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;

    @Override
    public ArrayList<Food> select() {

        try {
            // 创建连接
            connection = JDBCutils.getConnection();

            // 开始事物
            connection.setAutoCommit(false);

            String sqr = "select * from food";
            // 创建preparestatement对象
            pstmt = connection.prepareStatement(sqr);




        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }


        return null;
    }

    @Override
    public void insert(Food food) {

    }

    @Override
    public void delete(Integer foodId) {

    }

    @Override
    public void update(Food food, Integer foodId) {

    }
}

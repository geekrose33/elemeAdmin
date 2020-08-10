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

            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Food> foods = new ArrayList<>();
            while (resultSet.next()){
                Food food = new Food();
                food.setFoodId(resultSet.getInt(1));
                food.setFoodName(resultSet.getNString(2));
                food.setFoodExplain(resultSet.getNString(3));
                food.setFoodPrice(resultSet.getInt(4));
                food.setBusinessId(resultSet.getInt(5));
                foods.add(food);
            }
            return foods;


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }


        return null;
    }
    // 重载select方法
    public ArrayList<Food> select(String keyword){
        try {
            // 创建连接
            connection = JDBCutils.getConnection();

            // 开始事物
            connection.setAutoCommit(false);

            StringBuffer stringBuffer = new StringBuffer("select * from food where 1=1");
            stringBuffer.append(" and foodname like '%").append(keyword).append("%'")
                    .append(" or foodexplain like '%").append(keyword).append("%'");

            // 创建preparestatement对象
            pstmt = connection.prepareStatement(stringBuffer.toString());
//            System.out.println(stringBuffer);
            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Food> foods = new ArrayList<>();
            while (resultSet.next()){
                Food food = new Food();
                food.setFoodId(resultSet.getInt(1));
                food.setFoodName(resultSet.getNString(2));
                food.setFoodExplain(resultSet.getNString(3));
                food.setFoodPrice(resultSet.getInt(4));
                food.setBusinessId(resultSet.getInt(5));
                foods.add(food);
            }
            return foods;


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }



        return null;
    }


    @Override
    public void insert(Food food) {
        int foddId = 0;
        try {
            connection = JDBCutils.getConnection();
            // 开启事物
            connection.setAutoCommit(false);
            String sql = "insert into food (foodid,foodname,businessid) values (null,?,?)";
            pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,food.getFoodName());
            pstmt.setInt(2,food.getBusinessId());
            pstmt.executeUpdate();
            connection.commit();
            System.out.println("-------------------添加成功----------------");

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()){
                foddId = generatedKeys.getInt(1);
            }




        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }


            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt,connection);
        }
    }

    @Override
    public void delete(Integer foodId) {


        try {
            connection = JDBCutils.getConnection();
            // 开启事物
            connection.setAutoCommit(false);

            String sql = "delete from food where foodId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,foodId);
            pstmt.executeUpdate();
            System.out.println("----------------删除成功----------------");

            connection.commit();

        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }


            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt,connection);
        }


    }

    @Override
    public void update(String foodName, Integer foodId) {
        try {
            connection = JDBCutils.getConnection();
            // 开启事物
            connection.setAutoCommit(false);

            String sql = "update food set foodname = ? where foodId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,foodName);
            pstmt.setInt(2,foodId);
            pstmt.executeUpdate();
            connection.commit();

        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt,connection);
        }
    }

    @Override
    public void searchFood(Integer businessId) {
        String sql = "select * from food where businessId = ?";
        try {
            connection = JDBCutils.getConnection();



            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            resultSet = pstmt.executeQuery();
            resultSet.next();
            // 在使用resultset toString 之前一定要next
            // 因为结果集开始时光标在元素之前
            System.out.println("食物Id： " + resultSet.getInt(1));
            System.out.println("食物名称： " + resultSet.getString(2));
            System.out.println("食物描述： " + resultSet.getString(3));
            System.out.println("食物单价： " + resultSet.getDouble(4));
            System.out.println("商家Id ： " + resultSet.getInt(5));


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }
    }








    // 调用重载后方法
    public void update(int foodId,String foodExpain) {
        try {
            connection = JDBCutils.getConnection();
            // 开启事物
            connection.setAutoCommit(false);

            String sql = "update food set foodexplain = ? where foodId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,foodExpain);
            pstmt.setInt(2,foodId);
            pstmt.executeUpdate();
            connection.commit();

        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt,connection);
        }
    }
    public void update(Double foodPrice, int foodId) {
        try {
            connection = JDBCutils.getConnection();
            // 开启事物
            connection.setAutoCommit(false);

            String sql = "update food set foodPrice = ? where foodId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1,foodPrice);
            pstmt.setInt(2,foodId);
            pstmt.executeUpdate();
            connection.commit();

        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt,connection);
        }
    }
    public void update(int businessId, int foodId) {
        try {
            connection = JDBCutils.getConnection();
            // 开启事物
            connection.setAutoCommit(false);

            String sql = "update food set businessId = ? where foodId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            pstmt.setInt(2,foodId);
            pstmt.executeUpdate();
            connection.commit();

        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstmt,connection);
        }
    }
}

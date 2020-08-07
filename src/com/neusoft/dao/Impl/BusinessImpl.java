package com.neusoft.dao.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker_Dong
 * @date 2020-8-7 14:52
 */

public class BusinessImpl implements BusinessDao {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    ArrayList<Business> businesses = null;
    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {

        StringBuffer sql = new StringBuffer("select * from business where 1=1");

        if ((businessName != null) && !businessAddress.equals("")){
            // 传入了商家名
            sql.append("and businessName like '%").append(businessName).append("%' ");
            System.out.println(sql);

        }
        if ((businessName != null) && !businessAddress.equals("")){
            // 传入了商家地址
            sql.append("and businessAddress like '%").append(businessAddress).append("%' ");
            System.out.println(sql);

        }
        try {
            connection = JDBCutils.getConnection();
            pstmt = connection.prepareStatement(sql.toString());
            resultSet = pstmt.executeQuery();
            businesses = new ArrayList<>();
            while (resultSet.next()){
                Business business = new Business();
                business.setBusinessId(resultSet.getInt(1));
                business.setPassword(resultSet.getString(2));
                business.setBusinessName(resultSet.getString(3));
                business.setBusinessAddress(resultSet.getString("businessAddress"));
                business.setBusinessExplain(resultSet.getString("businessExplain"));
                business.setDeliveryPrice(resultSet.getDouble("deliveryPrice"));
                business.setStarPrice(resultSet.getDouble("starPrice"));
//                business.setStarPrice();
                // TODO
                businesses.add(business);


            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }



        return businesses;
    }

    @Override
    public List<Business> businessSelect(String keyword) {
        try {
            connection = JDBCutils.getConnection();
            StringBuffer stringBuffer = new StringBuffer("select * from business where businessName like '%");
            stringBuffer.append(keyword).append("%' or businessAddress like '%").append(keyword).append("%'");
            pstmt = connection.prepareStatement(stringBuffer.toString());
            resultSet = pstmt.executeQuery();

            businesses = new ArrayList<Business>();
            while (resultSet.next()){
                Business business = new Business();
                business.setBusinessId(resultSet.getInt(1));
                business.setPassword(resultSet.getString(2));
                business.setBusinessName(resultSet.getString(3));
                business.setBusinessAddress(resultSet.getString("businessAddress"));
                business.setBusinessExplain(resultSet.getString("businessExplain"));
                business.setDeliveryPrice(resultSet.getDouble("deliveryPrice"));
                business.setStarPrice(resultSet.getDouble("starPrice"));
                businesses.add(business);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }


        return businesses;
    }





    @Override
    public void save(String businessName,String businessPass) {
        try {

            connection = JDBCutils.getConnection();
            // 开始事物
            connection.setAutoCommit(false);

            StringBuffer stringBuffer = new StringBuffer("insert into business (password,businessName) values('");
            stringBuffer.append(businessPass).append("','").append(businessName).append("')");
            System.out.println(stringBuffer.toString());
            pstmt = connection.prepareStatement(stringBuffer.toString());
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
    public void delete(Integer id) {
        try {

            connection = JDBCutils.getConnection();
            // 开始事物
            connection.setAutoCommit(false);
            StringBuffer stringBuffer = new StringBuffer("delete from business where businessId = ");
            stringBuffer.append(id);
            pstmt = connection.prepareStatement(stringBuffer.toString());
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

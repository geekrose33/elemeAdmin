package com.neusoft.dao.Impl;

import com.alibaba.druid.util.JdbcUtils;
import com.neusoft.dao.AdminDao;
import com.neusoft.domain.Admin;
import com.neusoft.utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Joker_Dong
 * @date 2020-8-7 9:48
 */

public class AdminDaoImpl implements AdminDao {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    @Override
    public ArrayList<Admin> getAdminByNameByPass(String username, String password) {
        try {
            connection = JDBCutils.getConnection();
            String sql = "select * from admin where adminName = ? and password = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            resultSet = pstmt.executeQuery();
            ArrayList<Admin> admins = new ArrayList<>();
            while (resultSet.next()){
                Admin admin1 = new Admin();
                admin1.setAdaminId(resultSet.getInt("adminId"));
                admin1.setAdminName(resultSet.getString(2));

                admin1.setPassWord(resultSet.getString("password"));
                admins.add(admin1);
            }
            System.out.println("----------------查询成功-----------------");
            return admins;

        }catch (SQLException e){
            System.out.println("----------------查询失败-----------------");
            e.printStackTrace();
        }finally {
            JDBCutils.close(resultSet,pstmt,connection);
        }


        return null;
    }

    @Override
    public void save(Admin admin){

        try {
            connection = JDBCutils.getConnection();
            // 获取连接

            // 在此处开启事物
            connection.setAutoCommit(false);

            String sql = "insert into admin values (null,?,?)";

            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,admin.getAdminName());
            pstmt.setString(2,admin.getPassWord());

            // 执行prepareStatement的修改方法

            pstmt.executeUpdate();

            System.out.println("------------添加成功-----------");



            String sql1 = "select * from admin";

            PreparedStatement pstmt1 = connection.prepareStatement(sql1);
            ResultSet set = pstmt1.executeQuery();
            ArrayList<Admin> admins = new ArrayList<>();
            while (set.next()){
                Admin admin1 = new Admin();
                admin1.setAdaminId(set.getInt(1));
                admin1.setAdminName(set.getString(2));
                admin1.setPassWord(set.getString(3));
                admins.add(admin1);
            }
            for (Admin admin1:admins
                 ) {
                System.out.println(admin1);
            }

            // 提交事物
            connection.commit();

        }catch (SQLException e){
            try {

                // 添加失败 事物回滚 避免数据失误
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
    public void update(Admin admin,Integer id){
        try {
            // 获取连接
            connection = JDBCutils.getConnection();

            // 开始事物
            connection.setAutoCommit(false);

            // 写一个sql 字符串命令
            String sql = "update admin set adminName = ? , password = ? where adminId = ?";

            // 创建preparestatement对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,admin.getAdminName());
            pstmt.setString(2,admin.getPassWord());
            pstmt.setInt(3,id);

            pstmt.executeUpdate();
            // 提交事物
            connection.commit();

            // 再查询一下
            String sql1 = "select * from admin";

            PreparedStatement pstmt1 = connection.prepareStatement(sql1);
            ResultSet set = pstmt1.executeQuery();
            ArrayList<Admin> admins = new ArrayList<>();
            while (set.next()){
                Admin admin1 = new Admin();
                admin1.setAdaminId(set.getInt(1));
                admin1.setAdminName(set.getString(2));
                admin1.setPassWord(set.getString(3));
                admins.add(admin1);
            }
            for (Admin admin1:admins
            ) {
                System.out.println(admin1);
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
    public void delete(Integer id) {
        try {
            // 获取连接
            connection = JDBCutils.getConnection();

            // 创建事物
            connection.setAutoCommit(false);

            String sql = "delete from admin where adminId = ?";

            // 创建PrepareStatement 的对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            connection.commit();
            System.out.println("------------删除成功----------");
            // 再查询一下
            String sql1 = "select * from admin";

            PreparedStatement pstmt1 = connection.prepareStatement(sql1);
            ResultSet set = pstmt1.executeQuery();
            ArrayList<Admin> admins = new ArrayList<>();
            while (set.next()){
                Admin admin1 = new Admin();
                admin1.setAdaminId(set.getInt(1));
                admin1.setAdminName(set.getString(2));
                admin1.setPassWord(set.getString(3));
                admins.add(admin1);
            }
            for (Admin admin1:admins
            ) {
                System.out.println(admin1);
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
}

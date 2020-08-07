package com.neusoft.view.Impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Joker_Dong
 * @date 2020-8-7 11:35
 */

public class AdminViewImpl implements AdminView {
    private Scanner input = new Scanner(System.in);
    @Override
    public Admin login() {

        System.out.println("请输入管理员的用户名： ");
        String adminName = input.next();
        System.out.println("请输入管理员的密码： ");
        String adminPassword = input.next();

        AdminDao adminDao = new AdminDaoImpl();

        Admin admin = adminDao.getAdminByNameByPass(adminName, adminPassword);
        return admin;
    }
}

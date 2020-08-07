package com.neusoft.test;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;

import java.util.ArrayList;

/**
 * @author Joker_Dong
 * @date 2020-8-7 10:01
 */

public class TestAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();


        System.out.println("----------- 查询---------------");
        Admin admin = adminDao.getAdminByNameByPass("zhangsan","123");
        System.out.println(admin);
        System.out.println("----------- 添加---------------");
        Admin admin1 = new Admin("盖饭英雄5","9527");
//        adminDao.save(admin1);

        System.out.println("----------- 修改---------------");
        Admin admin2 = new Admin("name2","222");
        adminDao.update(admin2,2);

        System.out.println("----------- 删除---------------");
//        adminDao.delete(11);
//        adminDao.delete(12);
    }
}

package com.neusoft;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.Impl.AdminViewImpl;
import com.neusoft.view.Impl.BusinessViewImpl;

import java.security.UnrecoverableEntryException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Joker_Dong
 * @date 2020-8-7 11:30
 */

public class ElmAdmin {
    public static void main(String[] args) {

        work();

    }
    public static void work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| \t \t \t \t \t  饿了么控制台后台管理系统 v1.0 \t \t \t \t \t|");
        System.out.println("------------------------------------------------------------------------");

        // 调用登录方法
        AdminView adminView = new AdminViewImpl();
        Admin login = adminView.login();

        int menu = 0;
        BusinessView businessView = new BusinessViewImpl();
        if (login == null){
            System.out.println("账号或密码错误   请重试");
        }else{
            System.out.println("|\t \t \t \t \t 欢迎来到饿了么后台系统 \t \t \t \t \t|");
            while (menu != 5){
                // 创建一个菜单
                System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();


                    switch (menu){
                        case 1:
//                            System.out.println("1.所有商家列表");
                            businessView.listBusinessAll();
                            break;
                        case 2:

                            new BusinessViewImpl().listBusinessSelect();
                            break;
                        case 3:
//                            System.out.println("新建商家");

                            new BusinessViewImpl().listBusinessInsert();
                            break;
                        case 4:
                            System.out.println("删除商家  ---  请输入商家id");
                            new BusinessViewImpl().listBusinessDelete();
                            break;
                        case 5:
                            System.out.println("================= 欢迎下次光临饿了么系统 =========================");
                            break;
                        default:
                            System.out.println("没有这个菜单项");
                    }

            }


        }

//        if (){
//            System.out.println("欢迎来到饿了么商家管理系统");
//            //
//        }

    }
}

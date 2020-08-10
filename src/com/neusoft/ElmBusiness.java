package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.Impl.AdminViewImpl;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewImpl;

import java.util.Scanner;

/**
 * @author Joker_Dong
 * @date 2020-8-10 9:04
 */

public class ElmBusiness {
    public static void main(String[] args) {
        work();
    }
    public static void work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| \t \t \t \t \t  饿了么商家管理系统 v1.0 \t \t \t \t \t|");
        System.out.println("------------------------------------------------------------------------");

        // 调用商家登录方法
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();


        int menu = 0;

        if (business == null){
            System.out.println("账号或密码错误   请重试");
        }else{
            System.out.println("|\t \t \t \t \t 欢迎来到饿了么后台系统 \t \t \t \t \t|");
            while (menu != 5){
                // 创建一个菜单
                System.out.println("=========一级菜单：   1.商家列表=2.修改商家=3.更新密码=4.所属商品管理=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();


                switch (menu){
                    case 1:
//                            System.out.println("1.所有商家列表");
                        new BusinessViewImpl().viewInfo(business);
                        break;
                    case 2:

                        new BusinessViewImpl().update(business);
                        break;
                    case 3:
//                            System.out.println("新建商家");

                        new BusinessViewImpl().updatePass(business);
                        break;
                    case 4:
                        System.out.println("二级标题（管理食物）： 1. 查看食物 2. 增加食物 3.修改食物 4.删除食物 5. 退出二级");
                        int i = 0;
                        while (i != 5){
                            i = input.nextInt();

                            switch (i){
                                case 1:
                                    new BusinessViewImpl().viewSelectFood(business);
                                    break;
                                case 2:
                                    new FoodViewImpl().insert();
                                    break;
                                case 3:
                                    new FoodViewImpl().update();
                                    break;
                                case 4:
                                    new FoodViewImpl().delete();
                                    break;
                                case 5:
                                    System.out.println("退出二级");
                                default:
                                    System.out.println("没有这个选项！");

                            }



                        }


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

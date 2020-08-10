package com.neusoft.view.Impl;

import com.neusoft.dao.Impl.BusinessImpl;
import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.view.BusinessView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Joker_Dong
 * @date 2020-8-7 15:18
 */

public class BusinessViewImpl implements BusinessView {

    @Override
    public void listBusinessAll() {
        List<Business> list = new BusinessImpl().listBusiness(null, null);
        System.out.println("商家编号 \t 商家名称 \t \t 商家密码 \t 商家地址  \t \t \t 商品介绍 \t 星级评分 \t 交货价格");
        for (Business business:list
             ) {
            System.out.println(business.getBusinessId() + "\t" + business.getBusinessName()
                    + "\t" + business.getPassword() + "\t" + business.getBusinessAddress() +
                    "\t \t \t" + business.getBusinessExplain() + "\t" + business.getStarPrice() +
                    "\t" + business.getDeliveryPrice());
        }

    }

    @Override
    public void listBusinessInsert() {

        System.out.println("请输入商家名");
        String businessName = new Scanner(System.in).nextLine();
        System.out.println("请输入商家密码");
        String businessPass = new Scanner(System.in).nextLine();


        new BusinessImpl().save(businessName,businessPass);
        System.out.println("添加商家成功");

    }

    @Override
    public void listBusinessSelect() {

        System.out.println("搜索商家");
        System.out.println("请输入关键字（关于商家名和地址）： ");
        String keyword = new Scanner(System.in).nextLine();




        List<Business> businesses = new BusinessImpl().businessSelect(keyword);

            System.out.println("商家编号 \t 商家名称 \t \t 商家密码 \t 商家地址  \t \t \t 商品介绍 \t 星级评分 \t 交货价格");
            for (Business business:businesses
            ) {
                System.out.println(business.getBusinessId() + "\t" + business.getBusinessName()
                        + "\t \t \t" + business.getPassword() + "\t" + business.getBusinessAddress() +
                        "\t \t \t" + business.getBusinessExplain() + "\t" + business.getStarPrice() +
                        "\t" + business.getDeliveryPrice());
            }


    }

    @Override
    public void listBusinessDelete() {

        int businessid = new Scanner(System.in).nextInt();
        new BusinessImpl().delete(businessid);
        System.out.println("---------------删除成功----------------");
    }

    private Scanner input = new Scanner(System.in);

    @Override
    public Business login() {


        System.out.println("请输入商家Id： ");
        Integer businessId = input.nextInt();
        System.out.println("请输入管理员的密码： ");
        String password = input.next();

        BusinessViewImpl dao = new BusinessViewImpl();
//        BusinessImpl business = new BusinessImpl();
//        business.getBusinessByNameByPass(businessId,password);
        return new BusinessImpl().getBusinessByNameByPass(businessId,password);
    }





    @Override
    public void viewInfo(Business business) {
        System.out.println("商家编号： " + business.getBusinessId());
        System.out.println("商家名称： " + business.getBusinessName());
        System.out.println("商家地址： " + business.getBusinessAddress());
        System.out.println("商家介绍： " + business.getBusinessExplain());
        System.out.println("起送费： " + business.getStarPrice());
        System.out.println("配送费： " + business.getDeliveryPrice());
    }

    @Override
    public void update(Business business) {

        viewInfo(business);
        System.out.println("是否要修改商家名称（y/n):");
        String s = new Scanner(System.in).nextLine();
        if (s.equals("y")){
            System.out.println("请输入新的商家名");
            String businessName = new Scanner(System.in).nextLine();
            new BusinessImpl().update(businessName,business.getBusinessId());
        }else if (s.equals("n")){
            System.out.println("over");
        }
        System.out.println("是否要修改商家地址（y/n):");
        String s1 = new Scanner(System.in).nextLine();
        if (s1.equals("y")){
            System.out.println("请输入新的商家地址");
            String businessAddres = new Scanner(System.in).nextLine();
            new BusinessImpl().update(business.getBusinessId(),businessAddres);
        }else if (s1.equals("n")){
            System.out.println("over");
        }

        System.out.println("是否要修改商家描述（y/n):");
        String s2= new Scanner(System.in).nextLine();
        if (s2.equals("y")){
            String businessExplain = new Scanner(System.in).nextLine();
            new BusinessImpl().update(businessExplain,business.getBusinessId(),business.getBusinessName());
        }else if (s2.equals("n")){
            System.out.println("over");
        }

        System.out.println("是否要修改起送费（y/n):");
        String s3 = new Scanner(System.in).nextLine();
        if (s3.equals("y")){
            System.out.println("请输入新的起送费");
            Integer starPrice = new Scanner(System.in).nextInt();
            new BusinessImpl().update(starPrice,business.getBusinessId());
        }else if (s3.equals("n")){
            System.out.println("over");
        }
        System.out.println("是否要修改配送费（y/n):");
        String s4 = new Scanner(System.in).nextLine();
        if (s4.equals("y")){
            System.out.println("请输入新的配送费");
            Integer deliveryPrice = new Scanner(System.in).nextInt();
            new BusinessImpl().update(deliveryPrice,business.getBusinessId(),business.getBusinessName());
        }else if (s4.equals("n")){
            System.out.println("over");
        }

    }
    @Override
    public void updatePass(Business business){
        System.out.println("是否要修改密码（y/n):");
        String s4 = new Scanner(System.in).nextLine();
        if (s4.equals("y")){
            System.out.println("请输入旧的密码");
            String oldpass = new Scanner(System.in).nextLine();
            if (oldpass.equals(business.getPassword())){
                System.out.println("请输入新的密码");
                String businessPass1 = new Scanner(System.in).nextLine();
                System.out.println("请再次输入新密码");
                String businessPass2 = new Scanner(System.in).nextLine();
                if (businessPass1.equals(businessPass2)) {
                    new BusinessImpl().updatePass(businessPass1, business.getBusinessId());
                }else{
                    System.out.println("两次输入的密码不一致！");
                }
            }else{
                System.out.println("请重试 over");
            }
        }else if (s4.equals("n")){
            System.out.println("over");
        }


    }

    @Override
    public void viewSelectFood(Business business) {

        System.out.println("1.显示本店商品   2.查看所有商品" );
        int i = new Scanner(System.in).nextInt();
        if (i == 1){
            System.out.println("显示商品食物信息： ");
            new FoodDaoImpl().searchFood(business.getBusinessId());

        }else if(i == 2){
            ArrayList<Food> foodArrayList = new FoodDaoImpl().select();
            for (int i1 = 0; i1 < foodArrayList.size(); i1++) {
                System.out.println(foodArrayList.get(i1));
            }
        }else{
            System.out.println("请重试");
        }
        // 调用dao层方法


    }


}

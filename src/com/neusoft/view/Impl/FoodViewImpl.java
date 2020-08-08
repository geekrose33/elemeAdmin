package com.neusoft.view.Impl;

import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Joker_Dong
 * @date 2020-8-8 7:45
 */

public class FoodViewImpl implements FoodView {

    @Override
    public void select() {

        System.out.println("是否使用关键字搜索（y/n）");

        A:  while (true) {
            Scanner sc = new Scanner(System.in);
            String yn = sc.next();
            if (yn.equals("y")) {
                System.out.println("--------------请输入有关食品名字或描述的关键字-------------");

                String keyword = new Scanner(System.in).nextLine();
                System.out.println("关键字为： " + keyword);

                ArrayList<Food> foodArrayList = new FoodDaoImpl().select(keyword);

                for (Food food : foodArrayList
                ) {
                    System.out.println(food);
                }
                break A;

            } else if (yn.equals("n")) {
                System.out.println("--------------全部数据清单------------");
                ArrayList<Food> foodArrayList = new FoodDaoImpl().select();
                for (Food food : foodArrayList
                ) {
                    System.out.println(food);
                }
                break A;
            } else {
                System.out.println("请使用正确的关键字");
                continue A;
            }


        }
    }

    @Override
    public void insert() {

        Food food = new Food();
        System.out.println("请输入要添加的食品名称");
        Scanner scanner = new Scanner(System.in);
        String foodname = scanner.nextLine();
        System.out.println("请输入要添加的食品的商家号");
        int businessid = scanner.nextInt();
        food.setBusinessId(businessid);
        food.setFoodName(foodname);
        new FoodDaoImpl().insert(food);

    }

    @Override
    public void delete() {
        System.out.println("请输入要删除的食品 id");
        Scanner scanner = new Scanner(System.in);
        int foodId = scanner.nextInt();
        new FoodDaoImpl().delete(foodId);
    }

    @Override
    public void update() {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        while (num != 6) {
            System.out.println("请选择你要修改的选项");
            System.out.println("1-foodName  2-foodExplain  3-foodPrice  4-businessId  5-查询数据  6-exit");
            num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("即将修改foodName  请输入新的食品名称");
                    String foodName = new Scanner(System.in).nextLine();
                    System.out.println("请输入食品id");
                    int foodId1 = sc.nextInt();
                    new FoodDaoImpl().update(foodName,foodId1);
                    System.out.println("-------------修改成功-----------");
                    break;
                case 2:
                    System.out.println("即将修改foodExplain  请输入新的食品描述");
                    String foodExplain = new Scanner(System.in).nextLine();
                    System.out.println("请输入食品id");
                    int foodId2 = sc.nextInt();
                    new FoodDaoImpl().update(foodId2,foodExplain);
                    System.out.println("-------------修改成功-----------");
                    break;
                case 3:
                    System.out.println("即将修改foodPrice  请输入新的食品价格");
                    Integer foodPrice = sc.nextInt();
                    System.out.println("请输入食品id");
                    int foodId3 = sc.nextInt();
                    new FoodDaoImpl().update(foodPrice,foodId3);
                    System.out.println("-------------修改成功-----------");
                    break;
                case 4:
                    System.out.println("即将修改businessId  请输入新的食品的商家id ");
                    int businessId = sc.nextInt();
                    System.out.println("请输入食品id");
                    int foodId4 = sc.nextInt();
                    new FoodDaoImpl().update(businessId,foodId4);
                    System.out.println("-------------修改成功-----------");
                    break;
                case 5:
                    new FoodViewImpl().select();
                    break;
                case 6:
                    System.out.println("------------exit------------");
                    break;
                default:
                    System.out.println("没有这个选项（重试）");

            }
        }

    }


}

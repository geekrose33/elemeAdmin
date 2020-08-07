package com.neusoft.view.Impl;

import com.neusoft.dao.Impl.BusinessImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

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
    public void listBusinessInsert(String businessName, String businessPass) {


        new BusinessImpl().save(businessName,businessPass);
        System.out.println("添加商家成功");

    }

    @Override
    public void listBusinessSelect(String keyword) {






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


}

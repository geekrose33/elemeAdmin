package com.neusoft.test;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessImpl;
import com.neusoft.domain.Business;

import java.util.List;

/**
 * @author Joker_Dong
 * @date 2020-8-7 15:01
 */

public class TestBusiness {
    public static void main(String[] args) {
//        new BusinessImpl().listBusiness("万家饺子","沈阳");
//        new BusinessImpl().listBusiness(null,"沈阳");
//        new BusinessImpl().save("味之屋2","122");
//        List<Business> list = new BusinessImpl().businessSelect("味之屋");
//        for (Business business:list
//             ) {
//            System.out.println(business);
//        }
            new BusinessImpl().update("好吃就完了",10001,"王婆大虾");


    }
}

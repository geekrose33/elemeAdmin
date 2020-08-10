package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {

    // 查询所有商家信息 可选输入商家businessName businessAddress
    public List<Business> listBusiness(String businessName,String businessAddress);

    // 搜索商家
    public List<Business> businessSelect(String keyword);

    // 新建商家
    public void save(String businessName,String businessPass);

    // 删除商家
    public void delete(Integer id);

    public Business getBusinessByNameByPass(Integer businessId, String password);

    // xiugai
    public void update();

    // 改密码
    public void updatePass(String password,Integer businessId);

}

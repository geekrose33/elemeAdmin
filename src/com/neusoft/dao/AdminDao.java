package com.neusoft.dao;

import com.neusoft.domain.Admin;

import java.util.ArrayList;

public interface AdminDao {


    public void select();

    // 查询
    public Admin getAdminByNameByPass(String username, String password);

    // 显示所有数据


    // 添加
    public void save(Admin admin);

    // 修改
    public void update(Admin admin,Integer id);

    // 删除
    public void delete(Integer id);
}

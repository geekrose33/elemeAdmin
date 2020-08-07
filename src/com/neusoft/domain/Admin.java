package com.neusoft.domain;

/**
 * @author Joker_Dong
 * @date 2020-8-7 9:44
 *
 * 用户实体类
 *
 */

public class Admin {
    private Integer adaminId;
    private String adminName;
    private String passWord;

    public Integer getAdaminId() {
        return adaminId;
    }

    public void setAdaminId(Integer adaminId) {
        this.adaminId = adaminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Admin(String adminName,String passWord) {
        this.adminName = adminName;
        this.passWord = passWord;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adaminId=" + adaminId +
                ", adminName='" + adminName + '\'' +
                ", passWord=" + passWord +
                '}';
    }

}

package com.healthmonitor.pojo;

import java.util.Date;

public class linkman {
    private Integer id;

    private String userAccount;

    private String name;

    private String tel;

    private String email;

    private Date creatTime;

    private Date updateTime;

    public linkman(Integer id, String userAccount, String name, String tel, String email, Date creatTime, Date updateTime) {
        this.id = id;
        this.userAccount = userAccount;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    public linkman() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
package com.healthmonitor.pojo;

import java.util.Date;

public class user {
    private Integer id;

    private String account;

    private String name;

    private String password;

    private String question;

    private String answer;

    private String sex;

    private Integer age;

    private String tel;

    private String email;

    private String imageid;

    private Double height;

    private Double weight;

    private Integer heartrate;

    private Integer bloodpressure;

    private Integer step;

    private Integer sleep;

    private Date creatTime;

    private Date updateTime;

    public user(Integer id, String account, String name, String password, String question, String answer, String sex, Integer age, String tel, String email, String imageid, Double height, Double weight, Integer heartrate, Integer bloodpressure, Integer step, Integer sleep, Date creatTime, Date updateTime) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.email = email;
        this.imageid = imageid;
        this.height = height;
        this.weight = weight;
        this.heartrate = heartrate;
        this.bloodpressure = bloodpressure;
        this.step = step;
        this.sleep = sleep;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    public user() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid == null ? null : imageid.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(Integer heartrate) {
        this.heartrate = heartrate;
    }

    public Integer getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(Integer bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
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
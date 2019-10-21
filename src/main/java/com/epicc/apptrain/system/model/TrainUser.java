package com.epicc.apptrain.system.model;

import java.util.Date;

/**
 * @Title:TrainUser
 * @Description;ToDo
 * @Author: wangpan
 * @Date 2019/10/18 0018 上午 9:28
 * @Version: 1.0
 */

public class TrainUser {
    private long userId;
    private String userName;
    private String userPassword;
    private Date regisierTime;

    public TrainUser() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getRegisierTime() {
        return regisierTime;
    }

    public void setRegisierTime(Date regisierTime) {
        this.regisierTime = regisierTime;
    }

    @Override
    public String toString() {
        return "TrainUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", regisierTime=" + regisierTime +
                '}';
    }
}

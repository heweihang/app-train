package com.epicc.apptrain.system.model;

import java.util.Date;

/**
 * @Title:TrainMenu
 * @Description;ToDo
 * @Author: wangpan
 * @Date 2019/10/18 0018 下午 1:45
 * @Version: 1.0
 */
public class TrainMenu {
    private long menuId;
    private String trainName;
    private String trainNameUrl;
    private String activityName;
    private String activityNameUrl;
    private String honorName;
    private String honorNameUrl;
    private String advisorySellName;
    private String advisorySellNameUrl;
    private String newBarrcksName;
    private String newBarrcksNameUrl;
    private String resourceOneUrl;
    private String resourceOneType;
    private String resourceTwoUrl;
    private String resourceTwoType;
    private Date createTime;

    public TrainMenu() {
    }

    public TrainMenu(long menuId, String trainName, String trainNameUrl, String activityName, String activityNameUrl, String honorName, String honorNameUrl, String advisorySellName, String advisorySellNameUrl, String newBarrcksName, String newBarrcksNameUrl, String resourceOneUrl, String resourceOneType, String resourceTwoUrl, String resourceTwoType, Date createTime) {
        this.menuId = menuId;
        this.trainName = trainName;
        this.trainNameUrl = trainNameUrl;
        this.activityName = activityName;
        this.activityNameUrl = activityNameUrl;
        this.honorName = honorName;
        this.honorNameUrl = honorNameUrl;
        this.advisorySellName = advisorySellName;
        this.advisorySellNameUrl = advisorySellNameUrl;
        this.newBarrcksName = newBarrcksName;
        this.newBarrcksNameUrl = newBarrcksNameUrl;
        this.resourceOneUrl = resourceOneUrl;
        this.resourceOneType = resourceOneType;
        this.resourceTwoUrl = resourceTwoUrl;
        this.resourceTwoType = resourceTwoType;
        this.createTime = createTime;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNameUrl() {
        return trainNameUrl;
    }

    public void setTrainNameUrl(String trainNameUrl) {
        this.trainNameUrl = trainNameUrl;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityNameUrl() {
        return activityNameUrl;
    }

    public void setActivityNameUrl(String activityNameUrl) {
        this.activityNameUrl = activityNameUrl;
    }

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

    public String getHonorNameUrl() {
        return honorNameUrl;
    }

    public void setHonorNameUrl(String honorNameUrl) {
        this.honorNameUrl = honorNameUrl;
    }

    public String getAdvisorySellName() {
        return advisorySellName;
    }

    public void setAdvisorySellName(String advisorySellName) {
        this.advisorySellName = advisorySellName;
    }

    public String getAdvisorySellNameUrl() {
        return advisorySellNameUrl;
    }

    public void setAdvisorySellNameUrl(String advisorySellNameUrl) {
        this.advisorySellNameUrl = advisorySellNameUrl;
    }

    public String getNewBarrcksName() {
        return newBarrcksName;
    }

    public void setNewBarrcksName(String newBarrcksName) {
        this.newBarrcksName = newBarrcksName;
    }

    public String getNewBarrcksNameUrl() {
        return newBarrcksNameUrl;
    }

    public void setNewBarrcksNameUrl(String newBarrcksNameUrl) {
        this.newBarrcksNameUrl = newBarrcksNameUrl;
    }

    public String getResourceOneUrl() {
        return resourceOneUrl;
    }

    public void setResourceOneUrl(String resourceOneUrl) {
        this.resourceOneUrl = resourceOneUrl;
    }

    public String getResourceTwoUrl() {
        return resourceTwoUrl;
    }

    public void setResourceTwoUrl(String resourceTwoUrl) {
        this.resourceTwoUrl = resourceTwoUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getResourceOneType() {
        return resourceOneType;
    }

    public void setResourceOneType(String resourceOneType) {
        this.resourceOneType = resourceOneType;
    }

    public String getResourceTwoType() {
        return resourceTwoType;
    }

    public void setResourceTwoType(String resourceTwoType) {
        this.resourceTwoType = resourceTwoType;
    }

    @Override
    public String toString() {
        return "TrainMenu{" +
                "menuId=" + menuId +
                ", trainName='" + trainName + '\'' +
                ", trainNameUrl='" + trainNameUrl + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityNameUrl='" + activityNameUrl + '\'' +
                ", honorName='" + honorName + '\'' +
                ", honorNameUrl='" + honorNameUrl + '\'' +
                ", advisorySellName='" + advisorySellName + '\'' +
                ", advisorySellNameUrl='" + advisorySellNameUrl + '\'' +
                ", newBarrcksName='" + newBarrcksName + '\'' +
                ", newBarrcksNameUrl='" + newBarrcksNameUrl + '\'' +
                ", resourceOneUrl='" + resourceOneUrl + '\'' +
                ", resourceOneType='" + resourceOneType + '\'' +
                ", resourceTwoUrl='" + resourceTwoUrl + '\'' +
                ", resourceTwoType='" + resourceTwoType + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

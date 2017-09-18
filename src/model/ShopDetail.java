package model;

import java.io.Serializable;

/**
 * 店铺详情
 * Created by hadoop on 9/14/17.
 */
public class ShopDetail implements Serializable{
    private String shopName;//店铺名称
    private String shopAddress;//店铺地址
    private double averageConsume;//人均消费
    private int categoryId;//分类编号
    private int areaId;//商圈编号
    private int evaluateNumber;//评价总人数
    private double flavorScore;//口味评分
    private double environmentScore;//环境评分
    private double serviceScore;//服务评分
    private String phoneNumber;//联系电话
    private int shopId;//商铺编号
    private String categoryName	;//分类名
    private String areaName	;//商圈名
    private long updateTime;//更新时间


    public ShopDetail() {
    }

    public ShopDetail(String shopName, String shopAddress, double averageConsume, int categoryId, int areaId, int evaluateNumber, double flavorScore, double environmentScore, double serviceScore, String phoneNumber, int shopId, String categoryName, String areaName, long updateTime) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.averageConsume = averageConsume;
        this.categoryId = categoryId;
        this.areaId = areaId;
        this.evaluateNumber = evaluateNumber;
        this.flavorScore = flavorScore;
        this.environmentScore = environmentScore;
        this.serviceScore = serviceScore;
        this.phoneNumber = phoneNumber;
        this.shopId = shopId;
        this.categoryName = categoryName;
        this.areaName = areaName;
        this.updateTime = updateTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public double getAverageConsume() {
        return averageConsume;
    }

    public void setAverageConsume(double averageConsume) {
        this.averageConsume = averageConsume;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getEvaluateNumber() {
        return evaluateNumber;
    }

    public void setEvaluateNumber(int evaluateNumber) {
        this.evaluateNumber = evaluateNumber;
    }

    public double getFlavorScore() {
        return flavorScore;
    }

    public void setFlavorScore(double flavorScore) {
        this.flavorScore = flavorScore;
    }

    public double getEnvironmentScore() {
        return environmentScore;
    }

    public void setEnvironmentScore(double environmentScore) {
        this.environmentScore = environmentScore;
    }

    public double getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(double serviceScore) {
        this.serviceScore = serviceScore;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}

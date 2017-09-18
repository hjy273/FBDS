package model;

import java.io.Serializable;

/**
 * Created by hadoop on 9/14/17.
 * 商圈详情
 */
public class AreaDetail implements Serializable {
    private String categoryName;        // 分类名称
    private double averageConsume;      // 人均消费
    private int    shopNum;             // 店铺数量
    private double environmentScore;    // 环境评分
    private double flavorScore;         // 口味评分
    private double serviceScore;        // 服务评分
    private int    areaId;              // 商圈编号
    private String    areaName;            // 商圈名
    private long   updateTime;          // 更新时间
    private int    categoryID;          // 分类id
    private String passWord;

    public AreaDetail() {}


    public AreaDetail(String categoryName, double averageConsume, int shopNum, double environmentScore, double flavorScore, double serviceScore, int areaId, String areaName, long updateTime, int categoryID, String passWord) {
        this.categoryName = categoryName;
        this.averageConsume = averageConsume;
        this.shopNum = shopNum;
        this.environmentScore = environmentScore;
        this.flavorScore = flavorScore;
        this.serviceScore = serviceScore;
        this.areaId = areaId;
        this.areaName = areaName;
        this.updateTime = updateTime;
        this.categoryID = categoryID;
        this.passWord = passWord;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public double getAverageConsume() {
        return averageConsume;
    }

    public void setAverageConsume(double averageConsume) {
        this.averageConsume = averageConsume;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getEnvironmentScore() {
        return environmentScore;
    }

    public void setEnvironmentScore(double environmentScore) {
        this.environmentScore = environmentScore;
    }

    public double getFlavorScore() {
        return flavorScore;
    }

    public void setFlavorScore(double flavorScore) {
        this.flavorScore = flavorScore;
    }

    public double getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(double serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getShopNum() {
        return shopNum;
    }

    public void setShopNum(int shopNum) {
        this.shopNum = shopNum;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

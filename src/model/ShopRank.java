package model;

import java.io.Serializable;

/**
 * Created by hadoop on 9/14/17.
 * 商圈ID下的商铺销售额排名表
 */
public class ShopRank implements Serializable {
    private String shopName;      // 店铺名称
    private Double    tatolSales;    // 总销售额
   // private int    rangNum;       // 排名
    private int    areaId;        // 商圈id
    private String    areaName;      // 商圈名
    private long   updateTime;    // 更新时间

    public ShopRank() {}

    public ShopRank(String shopName, Double tatolSales, int areaId, String areaName, long updateTime) {
        this.shopName   = shopName;
        this.tatolSales = tatolSales;
       // this.rangNum    = rangNum;
        this.areaId     = areaId;
        this.areaName   = areaName;
        this.updateTime = updateTime;
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
//
//    public int getRangNum() {
//        return rangNum;
//    }
//
//    public void setRangNum(int rangNum) {
//        this.rangNum = rangNum;
//    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getTatolSales() {
        return tatolSales;
    }

    public void setTatolSales(Double tatolSales) {
        this.tatolSales = tatolSales;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

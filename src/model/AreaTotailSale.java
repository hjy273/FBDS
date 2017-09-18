package model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by hadoop on 9/14/17.
 * 商圈销售
 */
public class AreaTotailSale implements Serializable {
    private String areaName;      // 商圈名
    private int    totalSales;    // 销售总额
    private int updateTime;    // 更新时间

    public AreaTotailSale() {}

    public AreaTotailSale(String areaName, int totalSales, int updateTime) {
        this.areaName   = areaName;
        this.totalSales = totalSales;
        this.updateTime = updateTime;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

package dao;

import model.AreaTotailSale;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public interface AreaTotailSaleDao {
    /**
     * 获取商圈销售总额
     * @return List<AreaTotalSale> 商圈销售总额
     */
    public List<AreaTotailSale> getAreaTotalSale();
}

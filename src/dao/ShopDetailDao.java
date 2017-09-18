package dao;

import model.ShopDetail;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public interface ShopDetailDao {
    /**
     * 获取店铺详情
     * @param shopId 店铺id
     * @return ShopDetail 店铺详情
     */
    public ShopDetail getShopDetailByShopId(int shopId);
    /**
     * 获取店铺详情
     * @param shopName 店铺名称
     * @return ShopDetail 店铺详情
     */
    public ShopDetail getShopDetailByShopName(String shopName);
    /**
     * 获取所有的店铺详情
     * @return List<ShopDetail> 店铺详情Lsit
     */
    public List<ShopDetail> getAllShopDetail();
}

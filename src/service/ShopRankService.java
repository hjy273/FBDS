package service;

import model.ShopRank;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public interface ShopRankService {
    /**
     * 获取店铺详情
     * @param areaId 商圈id
     * @return ShopRank 店铺排名信息
     */
    public List<ShopRank> getShopRankByAreaId(int areaId);
}

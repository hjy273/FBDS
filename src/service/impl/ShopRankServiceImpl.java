package service.impl;

import dao.impl.ShopRankDaoImpl;
import model.ShopRank;
import service.ShopRankService;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class ShopRankServiceImpl implements ShopRankService {
    @Override
    public List<ShopRank> getShopRankByAreaId(int areaId) {
        return new ShopRankDaoImpl().getShopRankByAreaId(areaId);
    }
}

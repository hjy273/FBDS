package service.impl;

import dao.impl.ShopDetailDaoImpl;
import model.ShopDetail;
import service.ShopDetailService;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class ShopDetailServiceImpl implements ShopDetailService {
    @Override
    public ShopDetail getShopDetailByShopId(int shopId) {
        return new ShopDetailDaoImpl().getShopDetailByShopId(shopId);
    }

    @Override
    public ShopDetail getShopDetailByShopName(String shopName) {
        return new ShopDetailDaoImpl().getShopDetailByShopName(shopName);
    }

    @Override
    public List<ShopDetail> getAllShopDetail() {
        return new ShopDetailDaoImpl().getAllShopDetail();
    }
}

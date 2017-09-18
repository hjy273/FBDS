package service.impl;

import dao.impl.AreaTotailSaleDaoImpl;
import model.AreaTotailSale;
import service.AreaTotailSaleService;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 实现的业务是，当时间大于一天，点击会再执行一次MapReduce。否则只会查询数据库的表。
 * Created by hadoop on 9/14/17.
 */
public class AreaTotailSaleServiceImpl implements AreaTotailSaleService {
    @Override
    public List<AreaTotailSale> getAreaTotalSale() {
        AreaTotailSaleDaoImpl areaTotailSaleDaoImpl = new AreaTotailSaleDaoImpl();
        List<AreaTotailSale> list = areaTotailSaleDaoImpl.getAreaTotalSale();//先查询数据库获取更新时间
        return list;
    }
}

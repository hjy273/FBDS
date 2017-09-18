package test;

import dao.impl.AreaTotailSaleDaoImpl;
import model.AreaTotailSale;
import service.impl.AreaDetailServiceImpl;
import service.impl.AreaTotailSaleServiceImpl;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class TestxiaosiAreaTotailSaleService {
    public static void main(String[] args) {
        AreaTotailSaleServiceImpl areaTotailSaleService = new AreaTotailSaleServiceImpl();
        String tableName = "AreaTotalSale";
        String sql =  "create table if not exists "+ tableName + " as select s.areaname,sum(p.productprice*p.productsalenumber) as TotalSales,unix_timestamp() as updatetime from shop_Details s join product p on p.shopid=s.shopid \n" +"  join area_info a on s.areaname=a.areaname group by s.areaname";
        AreaTotailSaleDaoImpl areaTotailSaleDao = new AreaTotailSaleDaoImpl();
        areaTotailSaleDao.createTable(sql);
        List<AreaTotailSale> list =  areaTotailSaleService.getAreaTotalSale();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAreaName()+"\t"+list.get(i).getTotalSales()+"\t"+list.get(i).getUpdateTime());
        }
    }
}

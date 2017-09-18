package test;

import dao.impl.ShopRankDaoImpl;
import model.ShopRank;
import service.impl.ShopRankServiceImpl;

import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class TestzjqShopRankService {
    public static void main(String[] args) {
        ShopRankServiceImpl shopRankService = new ShopRankServiceImpl();
        String tableName = "ShopRank";
        String sql =   "create table if not exists "+ tableName + " as select s.shopname as shopname,sum(p.productprice * p.productsalenumber)as totalsales,a.areaid as areaid,a.areaname as areaname,unix_timestamp() as updatetime from product p join shop_details s on p.shopid = s.shopid join area_info a on s.areaname = a.areaname group by a.areaid,s.shopname,a.areaname order by areaid,totalsales desc";
        //String loadSql = "load data local inpath '" + filepath + "' into table "+ tableName;
        ShopRankDaoImpl shopRankDao = new ShopRankDaoImpl();
        shopRankDao.createTable(sql);
//        shopRankDaoImpl.loadData(loadSql);
        List<ShopRank> list =  shopRankService.getShopRankByAreaId(1974);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAreaId() + "\t"+ list.get(i).getTatolSales() + "\t" + list.get(i).getShopName() + "\t" +list.get(i).getAreaName()+ "\t" +list.get(i).getUpdateTime());
        }
    }
}

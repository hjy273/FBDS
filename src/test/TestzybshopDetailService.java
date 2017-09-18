package test;

import dao.impl.AreaDetailDaoImpl;
import model.ShopDetail;
import service.ShopDetailService;
import service.impl.ShopDetailServiceImpl;

import java.util.List;

/**
 * Created by hadoop on 17-9-15.
 */
public class TestzybshopDetailService {
    public static void main(String[] args) {
        ShopDetailService shopDetailService=  new ShopDetailServiceImpl();
        String sql = "create table ShopDetail as \n" +
                "select s.shopid as shopid,s.shopname as shopname,\n" +
                "s.shopaddress as shopaddress,s.AverageConsume as AverageConsume,\n" +
                "si.CategoryId as CategoryId,a.AreaId as AreaId,s.EvaluateNumber as EvaluateNumber,\n" +
                "s.FlavorScore as FlavorScore,s.EnvironmentScore as EnvironmentScore,\n" +
                "s.ServiceScore as ServiceScore,s.PhoneNumber as PhoneNumber,\n" +
                "s.CategoryName as CategoryName,s.AreaName as AreaName,unix_timestamp() as updatetime from shop_details s \n" +
                "join area_info a on s.areaname = a.areaname \n" +
                "join shop_cate_info si on s.CategoryName = si.CategoryName";
//        AreaDetailDaoImpl areaDetailDaoImpl = new AreaDetailDaoImpl();
//        areaDetailDaoImpl.createTable(sql);
        List<ShopDetail> list =  shopDetailService.getAllShopDetail();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getShopName()+"\t"+list.get(i).getCategoryId()+"\t"+list.get(i).getEvaluateNumber()+"\t"+list.get(i).getShopId()+"\t"+list.get(i).getAverageConsume()+"\t"+list.get(i).getEnvironmentScore()+"\t"+list.get(i).getFlavorScore()+"\t"+list.get(i).getUpdateTime());
        }
    }
}

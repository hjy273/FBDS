package test;

import dao.impl.AreaDetailDaoImpl;
import model.AreaDetail;
import service.impl.AreaDetailServiceImpl;
import util.DaoSupport;

import java.util.List;

/**
 * Created by hadoop on 17-9-15.
 */
public class TestZengYuAreaDetailService {
    public static void main(String[] args) {
        AreaDetailDaoImpl areaDetailDao = new AreaDetailDaoImpl();
        String sql = "create table if not exists areadetail as " +
                "select a.areapassword as password,s.categoryname as categoryname,avg(s.AverageConsume) as AverageConsume," +
                "count(*) as shopnum,avg(s.environmentscore) as environmentscore,avg(s.flavorscore) as flavorscore," +
                "avg(s.servicescore) as servicescore ,a.areaid,a.areaname,unix_timestamp() as updatetime, " +
                "ac.CategoryId as categoryid"+
                " from shop_details s join area_info a on s.areaname = a.areaname join shop_cate_info ac on ac.categoryname=s.categoryname group by s.categoryname,categoryid,a.areaid,a.areaname,a.areapassword";
        AreaDetailServiceImpl AreaDetailService = new AreaDetailServiceImpl();
//        areaDetailDao.createTable(sql);
        List<AreaDetail> list =  AreaDetailService.getAllAreaDetail();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getPassWord()+"\t"+list.get(i).getAreaId() + "\t" + list.get(i).getShopNum() + "\t" + list.get(i).getAverageConsume() + "\t" + list.get(i).getEnvironmentScore() + "\t" + list.get(i).getFlavorScore() + "\t" + list.get(i).getCategoryName()+"\t"+list.get(i).getUpdateTime());
        }
    }

}

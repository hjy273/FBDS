package test;

import util.DaoSupport;


/**
 * 该程序用于更新hive数据库的信息，可于为web段点击更新命令运行。
 *
 * Created by hadoop on 17-9-15.
 */
public class UpdateView {
    public static void main(String[] args) {
        DaoSupport daoSupport = new DaoSupport();
        //更新表ShopDetail
        String sqlShopDetail = "insert overwrite table  ShopDetail  \n" +
                "select s.shopid as shopid,s.shopname as shopname,\n" +
                "s.shopaddress as shopaddress,s.AverageConsume as AverageConsume,\n" +
                "si.CategoryId as CategoryId,a.AreaId as AreaId,s.EvaluateNumber as EvaluateNumber,\n" +
                "s.FlavorScore as FlavorScore,s.EnvironmentScore as EnvironmentScore,\n" +
                "s.ServiceScore as ServiceScore,s.PhoneNumber as PhoneNumber,\n" +
                "s.CategoryName as CategoryName,s.AreaName as AreaName,unix_timestamp() as updatetime from shop_details s \n" +
                "join area_info a on s.areaname = a.areaname \n" +
                "join shop_cate_info si on s.CategoryName = si.CategoryName";
        daoSupport.createTable(sqlShopDetail);

        //更新表AreaTotalSale";
      String sqlAreaTotalSale="insert overwrite table AreaTotalSale  select s.areaname,sum(p.productprice*p.productsalenumber) as TotalSales,unix_timestamp() as updatetime from shop_details s join product p on p.shopid=s.shopid \n" +" join area_info a on s.areaname=a.areaname group by s.areaname";
        daoSupport.createTable(sqlAreaTotalSale);

        //更新表ShopRank
        String sqlShopRank = "insert overwrite table ShopRank select s.shopname as shopname,sum(p.productprice * p.productsalenumber)as totalsales,a.areaid as areaid,a.areaname as areaname,unix_timestamp() as updatetime from product p join shop_details s on p.shopid = s.shopid join area_info a on s.areaname = a.areaname group by a.areaid,s.shopname,a.areaname order by areaid,totalsales desc";
        daoSupport.createTable(sqlShopRank);

        //更新表areadetail
        String sqlareadetail =  "insert overwrite table areadetail select s.categoryname as categoryname,avg(s.AverageConsume) as AverageConsume," +
                "count(*) as shopnum,avg(s.environmentscore) as environmentscore,avg(s.flavorscore) as flavorscore," +
                "avg(s.servicescore) as servicescore ,a.areaid,a.areaname,unix_timestamp() as updatetime, " +
                "ac.CategoryId as categoryid"+
                " from shop_details s join area_info a on s.areaname = a.areaname join shop_cate_info ac on ac.categoryname=s.categoryname group by s.categoryname,categoryid,a.areaid,a.areaname";
        daoSupport.createTable(sqlareadetail);

        //更新CommentKeyWord
        String sqlCommentKeyWord = "insert overwrite table CommentKeyWord select shopid,case when star<3 then '0' else '1' end,unix_timestamp(),keyword from consumer_comment";
        daoSupport.createTable(sqlCommentKeyWord);


    }
}

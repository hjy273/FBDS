package dao.impl;

import dao.ShopRankDao;
import model.ShopRank;
import util.DaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class ShopRankDaoImpl extends DaoSupport implements ShopRankDao {
    @Override
    public List<ShopRank> getShopRankByAreaId(int areaId) {
        List<ShopRank> list = new ArrayList<>();
        //查询Sql语言
        String sql = "SELECT * FROM ShopRank where areaid = ?";
        ResultSet rs = executeQuery(sql,areaId);
        try {
            while (rs.next()){
                ShopRank shopRank = new ShopRank();
                shopRank.setAreaId(rs.getInt("areaId"));
               // shopRank.setRangNum(rs.getInt("rangNum"));
                shopRank.setShopName(rs.getString("shopName"));
                shopRank.setTatolSales(rs.getDouble("totalSales"));
                shopRank.setAreaName(rs.getString("areaName"));
                shopRank.setUpdateTime(rs.getLong("updateTime"));
                list.add(shopRank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(connection);
        }
        return list;
    }
}

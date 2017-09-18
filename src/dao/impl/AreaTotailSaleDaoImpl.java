package dao.impl;

import dao.AreaTotailSaleDao;
import model.AreaTotailSale;
import util.DaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class AreaTotailSaleDaoImpl extends DaoSupport implements AreaTotailSaleDao{
    @Override
    public List<AreaTotailSale> getAreaTotalSale() {
        List<AreaTotailSale> list = new ArrayList<>();
        //查询Sql语言
        String sql = "SELECT * FROM AreaTotalSale";
        ResultSet rs = executeQuery(sql);
        try {
            while(rs.next()){
                AreaTotailSale areaTotalSale = new AreaTotailSale();
                areaTotalSale.setAreaName(rs.getString("areaName"));
                areaTotalSale.setTotalSales(rs.getInt("totalSales"));
                areaTotalSale.setUpdateTime(rs.getInt("updateTime"));
                list.add(areaTotalSale);
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

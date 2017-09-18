package dao.impl;

import dao.AreaDetailDao;
import model.AreaDetail;
import util.DaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class AreaDetailDaoImpl extends DaoSupport implements AreaDetailDao {
    @Override
    public List<AreaDetail> getAllAreaDetail() {
        List<AreaDetail> list = new ArrayList<>();
        //查询Sql语言
        String sql = "SELECT * FROM AreaDetail";
        ResultSet rs = executeQuery(sql);
        try {
            while (rs.next()){
                AreaDetail areaDetail = new AreaDetail();
                areaDetail.setAreaId(rs.getInt("areaid"));
                areaDetail.setAverageConsume(rs.getDouble("averageConsume"));
                areaDetail.setCategoryName(rs.getString("categoryName"));
                areaDetail.setFlavorScore(rs.getDouble("flavorScore"));
                areaDetail.setServiceScore(rs.getDouble("serviceScore"));
                areaDetail.setShopNum(rs.getInt("shopNum"));
                areaDetail.setEnvironmentScore(rs.getDouble("environmentScore"));
                areaDetail.setAreaName(rs.getString("areaName"));
                areaDetail.setUpdateTime(rs.getLong("updateTime"));
                areaDetail.setCategoryID(rs.getInt("categoryID"));
                areaDetail.setPassWord(rs.getString("password"));
                list.add(areaDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(connection);
        }
        return list;
    }

    @Override
    public int getAreaId(String areaName) {
        //查询Sql语言
        int areaId = -1;
        String sql = "SELECT areaid FROM AreaDetail where areaname=?";
        ResultSet rs = executeQuery(sql,areaName);
        try {
            if(rs.next()) {
                areaId = rs.getInt("areaId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            close(rs);
            close(connection);
        }
        return areaId;
    }

    @Override
    public List<AreaDetail> getAreaDetailByAreaId(int areaId) {
        List<AreaDetail> list = new ArrayList<>();
        //查询Sql语言
        String sql = "SELECT * FROM AreaDetail where areaid = ?";
        ResultSet rs = executeQuery(sql,areaId);
        try {
            while(rs.next()){
                AreaDetail areaDetail = new AreaDetail();
                areaDetail.setAreaId(rs.getInt("areaId"));
                areaDetail.setAverageConsume(rs.getDouble("averageConsume"));
                areaDetail.setCategoryName(rs.getString("categoryName"));
                areaDetail.setFlavorScore(rs.getDouble("flavorScore"));
                areaDetail.setServiceScore(rs.getDouble("serviceScore"));
                areaDetail.setShopNum(rs.getInt("shopNum"));
                areaDetail.setEnvironmentScore(rs.getDouble("environmentScore"));
                areaDetail.setAreaName(rs.getString("areaName"));
                areaDetail.setUpdateTime(rs.getLong("updateTime"));
                areaDetail.setCategoryID(rs.getInt("categoryID"));
                areaDetail.setPassWord(rs.getString("password"));
                list.add(areaDetail);
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

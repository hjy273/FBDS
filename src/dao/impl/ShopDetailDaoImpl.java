package dao.impl;

import dao.ShopDetailDao;
import model.ShopDetail;
import util.DaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class ShopDetailDaoImpl extends DaoSupport implements ShopDetailDao {
    @Override
    public ShopDetail getShopDetailByShopId(int shopId) {
        ShopDetail shopDetail = new ShopDetail();
        //查询Sql语言
        String sql = "SELECT * FROM ShopDetail where shopid = ?";
        ResultSet rs = executeQuery(sql,shopId);
        try {
            while(rs.next()){
                shopDetail.setAreaId(rs.getInt("AreaId"));
                shopDetail.setAverageConsume(rs.getDouble("averageConsume"));
                shopDetail.setCategoryId(rs.getInt("categoryId"));
                shopDetail.setEnvironmentScore(rs.getDouble("environmentScore"));
                shopDetail.setEvaluateNumber(rs.getInt("evaluateNumber"));
                shopDetail.setFlavorScore(rs.getDouble("flavorScore"));
                shopDetail.setPhoneNumber(rs.getString("phoneNumber"));
                shopDetail.setServiceScore(rs.getDouble("serviceScore"));
                shopDetail.setShopAddress(rs.getString("shopAddress"));
                shopDetail.setShopId(rs.getInt("ShopId"));
                shopDetail.setShopName(rs.getString("shopName"));
                shopDetail.setUpdateTime(rs.getLong("updateTime"));
                shopDetail.setAreaName(rs.getString("areaName"));
                shopDetail.setCategoryName(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(connection);
        }
        return shopDetail;
    }

    @Override
    public ShopDetail getShopDetailByShopName(String shopName) {
        ShopDetail shopDetail = new ShopDetail();
        //查询Sql语言
        String sql = "SELECT * FROM ShopDetail where shopName = ?";
        ResultSet rs = executeQuery(sql,shopName);
        try {
            while(rs.next()){
                shopDetail.setAreaId(rs.getInt("AreaId"));
                shopDetail.setAverageConsume(rs.getDouble("averageConsume"));
                shopDetail.setCategoryId(rs.getInt("categoryId"));
                shopDetail.setEnvironmentScore(rs.getDouble("environmentScore"));
                shopDetail.setEvaluateNumber(rs.getInt("evaluateNumber"));
                shopDetail.setFlavorScore(rs.getDouble("flavorScore"));
                shopDetail.setPhoneNumber(rs.getString("phoneNumber"));
                shopDetail.setServiceScore(rs.getDouble("serviceScore"));
                shopDetail.setShopAddress(rs.getString("shopAddress"));
                shopDetail.setShopId(rs.getInt("ShopId"));
                shopDetail.setShopName(rs.getString("shopName"));
                shopDetail.setUpdateTime(rs.getLong("updateTime"));
                shopDetail.setAreaName(rs.getString("areaName"));
                shopDetail.setCategoryName(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(connection);
        }
        return shopDetail;
    }

    @Override
    public List<ShopDetail> getAllShopDetail() {
        List<ShopDetail>  list = new ArrayList<>();
        //查询Sql语言
        String sql = "SELECT * FROM ShopDetail";
        ResultSet rs = executeQuery(sql);
        try {
            while(rs.next()){
                ShopDetail shopDetail = new ShopDetail();
                shopDetail.setAreaId(rs.getInt("AreaId"));
                shopDetail.setAverageConsume(rs.getDouble("averageConsume"));
                shopDetail.setCategoryId(rs.getInt("categoryId"));
                shopDetail.setEnvironmentScore(rs.getDouble("environmentScore"));
                shopDetail.setEvaluateNumber(rs.getInt("evaluateNumber"));
                shopDetail.setFlavorScore(rs.getDouble("flavorScore"));
                shopDetail.setPhoneNumber(rs.getString("phoneNumber"));
                shopDetail.setServiceScore(rs.getDouble("serviceScore"));
                shopDetail.setShopAddress(rs.getString("shopAddress"));
                shopDetail.setShopId(rs.getInt("ShopId"));
                shopDetail.setShopName(rs.getString("shopName"));
                shopDetail.setUpdateTime(rs.getLong("updateTime"));
                shopDetail.setAreaName(rs.getString("areaName"));
                shopDetail.setCategoryName(rs.getString("categoryName"));
                list.add(shopDetail);
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

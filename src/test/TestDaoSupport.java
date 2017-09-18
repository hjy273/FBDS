package test;

import util.DaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hadoop on 9/13/17.
 */
public class TestDaoSupport{
    public static void main(String[] args) {
        DaoSupport daoSupport = new DaoSupport();
//        String sql = "SELECT * FROM user_log limit 10";
//        ResultSet rs = daoSupport.executeQuery(sql);
//        try {
//            while (rs.next()) {
//                System.out.print(rs.getInt(1)+"\t");
//                System.out.print(rs.getInt(2)+"\t");
//                System.out.print(rs.getInt(3)+"\t");
//                System.out.println(rs.getInt(4));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String filepath = "yz.csv";
        String loadsql = "load data local inpath '" + filepath + "' into table yz";
        String sql = "create table yz (key int, value string)  row format delimited fields terminated by '\t'";
//        daoSupport.createTable(sql);
        daoSupport.loadData(loadsql);
        String Selectsql = "SELECT * FROM yz limit 10";
        ResultSet rs = daoSupport.executeQuery(Selectsql);
        try {
            while (rs.next()) {
                System.out.print(rs.getInt(1)+"\t");
                System.out.print(rs.getInt(2)+"\t");
//                System.out.print(rs.getInt(3)+"\t");
//                System.out.println(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

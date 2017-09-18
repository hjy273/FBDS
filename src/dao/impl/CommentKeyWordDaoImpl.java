package dao.impl;

import dao.CommentKeyWordDao;
import util.DaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 9/14/17.
 */
public class CommentKeyWordDaoImpl extends DaoSupport implements CommentKeyWordDao {
    @Override
    public List<String> getCommentKeyWordByShopIdAndCommentCate(int shopid, int CommentCate) {
        List<String> list = new ArrayList<>();
        //查询Sql语言
        String sql = "SELECT * FROM CommentKeyWord where shopid = ? and CommentCate = ?";
        Object[] params = new Object[]{
                shopid,
                CommentCate
        };
        ResultSet rs = executeQuery(sql,params);
        try {
            while(rs.next()){
                String str = rs.getInt("shopid")+","+rs.getInt("CommentCate")+","+rs.getInt("updatetime")+","+rs.getString("word");
                list.add(str);
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

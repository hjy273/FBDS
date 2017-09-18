package dao;

import model.CommentKeyWord;

import java.util.List;

/**
 * 评价分类获取评价内容分词统计
 * Created by hadoop on 9/14/17.
 */
public interface CommentKeyWordDao {
    /**
     * 获取评价分类获取评价内容分词统计
     * @return CommentKeyWord 评价内容分词统计
     */
    public List<String> getCommentKeyWordByShopIdAndCommentCate(int shopId, int CommentCate);
}

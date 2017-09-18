package service;

import model.CommentKeyWord;

import java.util.List;
import java.util.Map;

/**
 * 评价分类获取评价内容分词统计
 * Created by hadoop on 9/14/17.
 */
public interface CommentKeyWordService {
    /**
     * 获取评价分类获取评价内容分词统计
     * @param shopId 店铺id
     * @param commentCate 评价分类 评价分类（好评1，差评0）
     * @return Map<String,Integer> 评价内容分词统计
     */
    public Map<String,Integer> getCommentKeyWordByShopIdAndCommentCate(int shopId, int commentCate);
}

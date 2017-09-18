package model;

import java.io.Serializable;

/**
 * 评价分类获取评价内容分词统计
 * Created by hadoop on 9/14/17.
 */
public class CommentKeyWord implements Serializable {
    private String word;           // 分词
    private int    shopId;         // 商铺id
    private int    updatetime;
    private int    commentCate;    // 评价分类

    public CommentKeyWord() {}

    public CommentKeyWord(String word, int shopId, int updatetime,int commentCate) {
        this.word        = word;
        this.shopId      = shopId;
        this.updatetime = updatetime;
        this.commentCate = commentCate;
    }

    public int getCommentCate() {
        return commentCate;
    }

    public void setCommentCate(int commentCate) {
        this.commentCate = commentCate;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getUpdatetime(){return updatetime;}

    public void setUpdatetime(int updatetime){this.updatetime=updatetime;}
}


//~ Formatted by Jindent --- http://www.jindent.com

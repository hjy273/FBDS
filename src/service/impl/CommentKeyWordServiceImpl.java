package service.impl;

import dao.CommentKeyWordDao;
import dao.impl.CommentKeyWordDaoImpl;
import service.CommentKeyWordService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 9/14/17.
 */
public class CommentKeyWordServiceImpl implements CommentKeyWordService {
    @Override
    public Map<String, Integer> getCommentKeyWordByShopIdAndCommentCate(int shopId, int commentCate) {
        CommentKeyWordDao commentKeyWordDao = new CommentKeyWordDaoImpl();
        Map<String,Integer> map = new HashMap<>();
        List<String> wordList = commentKeyWordDao.getCommentKeyWordByShopIdAndCommentCate(shopId,commentCate);

        for (String string:wordList) {
            String [] words = string.split(",");
            String  word = words[words.length-1];
            String [] w = word.split(" ");

            for (String str :w ) {
                if(!str.equals("")){
                    if (map.containsKey(str)){
                        Integer count =  map.get(str);
                        map.put(str,count+1);
                    }else {
                        map.put(str,1);
                    }
                }
            }

        }
        return map;
    }
}

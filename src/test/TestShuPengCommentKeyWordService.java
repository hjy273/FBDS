package test;

import service.CommentKeyWordService;
import service.impl.CommentKeyWordServiceImpl;

import java.util.Map;

/**
 * Created by hadoop on 17-9-15.
 */
public class TestShuPengCommentKeyWordService {
    public static void main(String[] args) {
        //创建业务层的类的对象
        CommentKeyWordService commentKeyWordService = new CommentKeyWordServiceImpl();

        Map<String, Integer> w = commentKeyWordService.getCommentKeyWordByShopIdAndCommentCate(2101501, 0);

        for (String str : w.keySet()) {
            System.out.println(str + ":" + w.get(str));
        }
    }
}

package test;

import model.ShopDetail;
import service.impl.AreaDetailServiceImpl;
import service.impl.CommentKeyWordServiceImpl;
import service.impl.ShopDetailServiceImpl;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hadoop on 17-9-16.
 */
public class Test {
    public static void main(String args[]){
//        ShopDetailServiceImpl shopDetailService = new ShopDetailServiceImpl();
//        ShopDetail shopDetail = shopDetailService.getShopDetailByShopName("烤匠");
//        int shopId = shopDetail.getShopId();
//        System.out.println(shopId);
//        CommentKeyWordServiceImpl commentKeyWordService = new CommentKeyWordServiceImpl();
//        Map<String, Integer> goodComments = commentKeyWordService.getCommentKeyWordByShopIdAndCommentCate(50605312,1);
//        Set<String> keys = goodComments.keySet();
//        for(String key : keys){
//            System.out.println(key+"\t"+goodComments.get(key));
//        }
//        ShopDetailServiceImpl shopDetailService = new ShopDetailServiceImpl();
//        ShopDetail shopDetail = shopDetailService.getShopDetailByShopName("hahaha");
//        int shopId = shopDetail.getShopId();
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher("-123");
        System.out.println(matcher.matches());
    }
}

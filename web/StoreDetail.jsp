<%@ page import="service.impl.ShopDetailServiceImpl" %>
<%@ page import="model.ShopDetail" %>
<%@ page import="service.impl.CommentKeyWordServiceImpl" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 17-9-15
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--商圈管理，店铺排名，店铺详情-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/fontsImports.css"/>
    <link rel="stylesheet" href="bootstrap-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="dist/css/bootstrap-select.css">
    <link rel="stylesheet" href="bootstrap-dist/css/daterangepicker-bs3.css"/>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/dataMange.css"/>
    <link rel="stylesheet" href="css/Store.css"/>
    <link rel="stylesheet" href="createPage/page.css"/>
    <link rel="stylesheet" href="css/goodComment.css"/>
    <script src="js/echarts.min.js"></script>
    <title>商圈管理</title>
</head>
<body>
<div class="userTitle border_box">您所在位置 &gt; 商圈管理  &gt;<a href="javascript:history.go(-1);">店铺排名</a>  &gt;店铺详情
    <button class="exit"><a href="login.jsp" class="color">退出系统</a> </button></div><!--最上面的内容-->
<div class="dataShowList box_reset"><!--数据展示-->
    <div class="searchGroups"><!--搜索输入框-->
        <div class="input-prepend input-group">
            <ul>
                <li class="inputGroups">店铺名
                    <input type="text" class="classTypeNameQuery" placeholder="请输入你要查找的店铺名"/>
                </li>
                <%--<li class="inputGroups">店铺所属类型--%>
                    <%--<select class="left_upper_limb_fat_select show-menu-arrow selectpicker" id="searchClassState">--%>
                        <%--<option value="不限">不限</option>--%>
                        <%--<option value="火锅">火锅</option>--%>
                        <%--<option value="小吃">小吃快餐</option>--%>
                        <%--<option value="西餐">西餐</option>--%>
                        <%--<option value="烧烤">烧烤</option>--%>
                        <%--<option value="中餐">中餐</option>--%>
                        <%--<option value="茶馆">茶馆</option>--%>
                        <%--<option value="自助餐">自助餐</option>--%>
                        <%--<option value="咖啡厅">咖啡厅</option>--%>
                        <%--<option value="日本料理">日本料理</option>--%>
                        <%--<option value="串串香">串串香</option>--%>
                        <%--<option value="韩国料理">韩国料理</option>--%>
                    <%--</select>--%>
                <%--</li>--%>
                <li>
                    <button class="classTypeQueryBtn">查询</button>
                </li>
            </ul>
            <%
                request.setCharacterEncoding("UTF-8");
                String shopId = request.getParameter("shopId");
                ShopDetailServiceImpl shopDetailService = new ShopDetailServiceImpl();
                ShopDetail shopDetail = shopDetailService.getShopDetailByShopId(Integer.parseInt(shopId));
                String shopName = shopDetail.getShopName();
                Double averageConsume = shopDetail.getAverageConsume();
                String shopAddress = shopDetail.getShopAddress();
                String phoneNumber = shopDetail.getPhoneNumber();
                String categoryName = shopDetail.getCategoryName();
                CommentKeyWordServiceImpl commentKeyWordService = new CommentKeyWordServiceImpl();
                Map<String, Integer> goodComments = commentKeyWordService.getCommentKeyWordByShopIdAndCommentCate(Integer.parseInt(shopId),1);
                Set<String> goodKeys = goodComments.keySet();
                Map<String, Integer> badComments = commentKeyWordService.getCommentKeyWordByShopIdAndCommentCate(Integer.parseInt(shopId),0);
                Set<String> badKeys = badComments.keySet();
//                if (areaDetail!=null&& areaDetail.getPassWord().equals(inPwd)){
//                    request.getRequestDispatcher("shopManage.jsp").forward(request,response);
//                }else{
//                    response.sendRedirect("login.jsp");
//                }
            %>
            <div class="introduce">
                <div>
                    <div id="introduce">
                        <h4 class="xx"><%=shopName%></h4>
                        <li class="mm">人均消费: <%=averageConsume%>元</li>
                        <li class="rate">所属分类：<%=categoryName%></li>
                        <li class="address">地址: <%=shopAddress%></li>
                        <li class="phone">联系电话: <%=phoneNumber%></li>
                    </div>
                    <%--<div id="rank">--%>
                        <%--<h3 class="rr">店铺排名：2</h3>--%>
                    <%--</div>--%>
                </div>

            </div>

        </div>
        <div class="comment">
            <div>
                <div id="comment1"></div>
                <div id="comment2"></div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="js/jquery-1.11.2.js"></script>
<script src="bootstrap-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-select-1.12.2/dist/js/bootstrap-select.js"></script>
<script src="createPage/jquery.page.js"></script>
<script src="js/adManage.js"></script>
<!--<script src="js/echarts-wordcloud.min.js"></script>-->
<!--<script src="js/jqcloud.js"></script>-->
<!--<script src="build/dist/echarts.js"></script>-->
<script src="js/word.js"></script>
<script src="js/echarts-wordcloud.js"></script>
<script>
    /**
     * Created by xiaosi on 2017/9/11.
     */
    $(function() {
        var chart = echarts.init(document.getElementById('comment1'));
        var commentWordCount=new Array
        <%
            for (String key :goodKeys ) {
        %>
            commentWordCount.push({name:"<%=key%>",value:<%=goodComments.get(key)%>})
        <%
            }
        %>
        var option = {
            title: {
                text: '好评词云',
                x: 'center',
            },
            tooltip: {},
            backgroundColor: '#f7f7f7',
            series: [ {
                type: 'wordCloud',
                gridSize: 2,
                sizeRange: [12, 50],
                rotationRange: [-90, 90],
                shape: 'pentagon',
                width: 600,
                height: 400,
                drawOutOfBound: true,
                textStyle: {
                    normal: {
                        color: function () {
                            return 'rgb(' + [
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160)
                                ].join(',') + ')';
                        }
                    },
                    emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                data:commentWordCount
            } ]
        };

        chart.setOption(option);
        window.onresize = chart.resize;
    });
</script>
<script>
    /**
     * Created by xiaosi on 2017/9/11.
     */
    $(function() {
        var chart = echarts.init(document.getElementById('comment2'));
        var badCommentWordCount=new Array
        <%
            for (String key :badKeys ) {
        %>
        badCommentWordCount.push({name:"<%=key%>",value:<%=badComments.get(key)%>})
        <%
            }
        %>
        var option = {
            title: {
                text: '差评词云',
                x: 'center',
            },
            tooltip: {},
            backgroundColor: '#f7f7f7',
            series: [ {
                type: 'wordCloud',
                gridSize: 2,
                sizeRange: [12, 50],
                rotationRange: [-90, 90],
                shape: 'pentagon',
                width: 600,
                height: 400,
                drawOutOfBound: true,
                textStyle: {
                    normal: {
                        color: function () {
                            return 'rgb(' + [
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160)
                                ].join(',') + ')';
                        }
                    },
                    emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                data: badCommentWordCount
            } ]
        };
        chart.setOption(option);
        window.onresize = chart.resize;
    });
</script>
</body>
</html>
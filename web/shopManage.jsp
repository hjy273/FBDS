<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 17-9-15
  Time: 上午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.impl.AreaDetailServiceImpl" %>
<%@ page import="model.AreaDetail" %>
<%@ page import="dao.impl.ShopRankDaoImpl" %>
<%@ page import="service.impl.ShopRankServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="model.ShopRank" %>
<%@ page import="service.impl.ShopDetailServiceImpl" %>
<%@ page import="model.ShopDetail" %>
<!--商圈管理，店铺排名-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/fontsImports.css"/>
    <link rel="stylesheet" href="bootstrap-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="dist/css/bootstrap-select.css">
    <link rel="stylesheet" href="bootstrap-dist/css/daterangepicker-bs3.css"/>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/dataMange.css"/>
    <link rel="stylesheet" href="css/adManage.css"/>
    <link rel="stylesheet" href="createPage/page.css"/>
    <link rel="stylesheet" href="css/defaultShow.css"/>
    <script src="js/echarts.min.js"></script>
    <title>商圈管理</title>
</head>
<%
    request.setCharacterEncoding("UTF-8");
    String inId = request.getParameter("areaId");
    ShopRankServiceImpl shopRankService = new ShopRankServiceImpl();
    List<ShopRank> list = shopRankService.getShopRankByAreaId(Integer.parseInt(inId));


//    if (areaDetail!=null&& areaDetail.getPassWord().equals(inPwd)){
//        request.getRequestDispatcher("shopManage.html").forward(request,response);
//    }else{
//        response.sendRedirect("login.jsp");
//    }
%>
<body>
<div class="userTitle border_box">您所在位置 &gt; 商圈管理  &gt; 店铺排名
    <button class="exit"><a href="login.jsp">退出系统</a> </button></div><!--最上面的内容-->

<div class="dataShowList box_reset"><!--数据展示-->
    <div class="searchGroups"><!--搜索输入框-->
        <div class="input-prepend input-group">
            <ul>
                <li class="inputGroups">店铺名
                    <input type="text" class="classTypeNameQuery" placeholder="请输入你要查找的店铺名" id="searchShop"/>
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
                    <button class="classTypeQueryBtn" onclick="searchShop()">查询</button>
                    <button class="classTypeQueryShop" ><a href='<%="ShopDetails.jsp?areaId="+inId%>'>进入商圈详情</a></button>
                    <!--<button class="exit">退出系统 </button>-->
                </li>
            </ul>

            <div class="bmiAnalysis"><!--指数分析-->
                <h3></h3>
                <div>
                    <div id="main"></div>
                </div>
            </div>
            <div class="tableBottom">
            <ul>
            <li>
            <div class="tcdPageCode"></div>
            </li>
            </ul>
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
<script>
    function searchShop(){
        var name = document.getElementById("searchShop").value;
        window.location.href="SearchShop.jsp?shopName="+name;
    }
</script>
<script>
    /**
     * Created by liuyong on 2017/1/11.
     * 用户控制数据图表的显示
     */
//商圈管理，店铺排名
    $(function(){
        var myChart = echarts.init(document.getElementById('main'));
        var shops = new Array
        var sales = new Array
        var max = <%=(int)(list.get(0).getTatolSales()/10000)%>
        <% for (int i = 0;i < 40;i++){ %>
        shops[<%=i%>] = "<%=list.get(i).getShopName()%>"
        sales[<%=i%>] = <%=(int)(list.get(i).getTatolSales()/10000)%>
        <% } %>

        option = {
            tooltip: {
                trigger: 'axis'
            },
            toolbox: {
                show:false,
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data:['体重']
            },
            xAxis: [
                {
                    type: 'category',
                    axisLabel:{
                        formatter:function(val){
                            return val.split("").join("\n");
                        }
                    },
                    data: shops
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '销售额(万元)',
                    min: 0,
                    max: max,
                    interval:max/10,
                    axisLabel: {
                        formatter: '{value}万'
                    }
                },
            ],
            series: [
                {
                    name:'销售额',
                    type:'bar',
                    clickable : true,
                    itemStyle: {
                        normal: {
                            //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                            color: function(params) {
                                // build a color map as your need.
                                var colorList = [
                                    '#e5a24f','#e5a24f','#e5a24f','#e5a24f',
                                    '#e5a24f','#e5a24f','#e5a24f','#e5a24f',
                                    '#e5a24f','#e5a24f','#e5a24f','#e5a24f'
                                ];
                                return colorList[params.dataIndex]
                            },
                            //以下为是否显示，显示位置和显示格式的设置了
                            label: {
                                show: true,
                                position: 'top'
                            }
                        }
                    },
                    data:sales

                },

            ]
        };

// 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.onresize = myChart.resize;

        myChart.on('click', function (param){
            var name=param.name;
            window.location.href="StoreDetail.jsp?shopName="+name;
//            if(name=="用户数"){
//                window.location.href="StoreDetail.html";
//            }else if(name=="栏目数"){
//                window.location.href="StoreDetail.html";
//            }else if(name=="新闻数"){
//                window.location.href="StoreDetail.html";
//            }else{
//                window.location.href="StoreDetail.html";
//            }
        });

    });
</script>
</body>
</html>
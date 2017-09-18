<%@ page import="service.impl.AreaTotailSaleServiceImpl" %>
<%@ page import="model.AreaTotailSale" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="service.impl.AreaDetailServiceImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 17-9-15
  Time: 上午11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--我要开店-->
<html lang="en">
<head>
    <meta charset="UTF-8">
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
    <title>我要开店</title>
</head>
<%
    AreaTotailSaleServiceImpl areaTotailSaleService = new AreaTotailSaleServiceImpl();
    List<AreaTotailSale> list = areaTotailSaleService.getAreaTotalSale();
    List<Integer> totalSales = new ArrayList<Integer>();
    for (AreaTotailSale areaTotalSale:list) {
        totalSales.add(areaTotalSale.getTotalSales());
    }
    int maxSales = Collections.max(totalSales);


//    if (areaDetail!=null&& areaDetail.getPassWord().equals(inPwd)){
//        request.getRequestDispatcher("shopManage.html").forward(request,response);
//    }else{
//        response.sendRedirect("login.jsp");
//    }
%>
<div class="userTitle border_box">您所在位置 &gt; 我要开店
    <button class="exit1"><a href="login.jsp">退出系统</a> </button></div><!--最上面的内容-->
<div class="dataShowList box_reset"><!--数据展示-->
    <div class="searchGroups"><!--搜索输入框-->
        <div class="input-prepend input-group">
            <ul>
                <li class="inputGroups">请选择商圈名
                    <select class="left_upper_limb_fat_select show-menu-arrow selectpicker" id="searchClassState">
                        <%
                            for(AreaTotailSale areaTotailSale:list){
                        %>
                            <option value=<%=areaTotailSale.getAreaName()%>><%=areaTotailSale.getAreaName()%></option>
                        <%
                            }
                        %>
                    </select>
                </li>
                <li>
                    <button class="classTypeQueryBtn" onclick="searchArea()">查询</button>
                </li>
            </ul>
            <div class="start"><!--商圈详情-->

                <div>
                    <div id="starts"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function searchArea(){
        var name = document.getElementById("searchClassState").value;
        window.location.href="AreaManager.jsp?areaName="+name;
    }
</script>
<script src="js/jquery-1.11.2.js"></script>
<script src="bootstrap-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-select-1.12.2/dist/js/bootstrap-select.js"></script>
<script src="createPage/jquery.page.js"></script>
<script src="js/adManage.js"></script>
<script>
    /**
     * Created by liuyong on 2017/1/11.
     * 用户控制数据图表的显示
     */
//商圈管理，店铺排名
    $(function(){
        var myChart = echarts.init(document.getElementById('starts'));
        var areas = new Array
        var sales = new Array
        var max = <%=maxSales%>
            <%
                for (AreaTotailSale areaTotalSale:list) {
            %>
                areas.push("<%=areaTotalSale.getAreaName()%>")
                sales.push(<%=areaTotalSale.getTotalSales()/10000%>)
            <%
                }
            %>

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
                        data: areas
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '销售额(万元)',
                        min: 0,
                        max: 18934,
                        interval:18934/10,
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
            window.location.href="AreaManager.jsp?areaName="+name;
        });

    });

</script>
<body>

</body>
</html>

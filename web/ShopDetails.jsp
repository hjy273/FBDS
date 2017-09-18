<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 17-9-16
  Time: 下午7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.impl.AreaDetailServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="model.AreaDetail" %>
<!DOCTYPE html>
<!--商圈管理，商圈详情-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/fontsImports.css"/>
    <link rel="stylesheet" href="bootstrap-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="dist/css/bootstrap-select.css">
    <link rel="stylesheet" href="bootstrap-dist/css/daterangepicker-bs3.css"/>
    <script src="js/echarts.min.js"></script>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/dataMange.css"/>
    <link rel="stylesheet" href="css/adManage.css"/>
    <link rel="stylesheet" href="createPage/page.css"/>
    <link rel="stylesheet" href="css/shopDetail1.css"/>
    <link rel="stylesheet" href="css/shopDetail2.css"/>
    <link rel="stylesheet" href="css/shopDetail3.css"/>
    <title>商圈管理</title>
</head>
<%
    request.setCharacterEncoding("UTF-8");
    String inId = request.getParameter("areaId");
    AreaDetailServiceImpl areaDetailService = new AreaDetailServiceImpl();
    List<AreaDetail> list = areaDetailService.getAreaDetailByAreaId(Integer.parseInt(inId));

//    if (areaDetail!=null&& areaDetail.getPassWord().equals(inPwd)){
//        request.getRequestDispatcher("shopManage.html").forward(request,response);
//    }else{
//        response.sendRedirect("login.jsp");
//    }
%>
<body>
<div class="userTitle border_box">>您所在位置 &gt; 商圈管理  &gt; 商圈详情
    <button class="exit"><a href="login.jsp">退出系统</a> </button></div>
<div class="dataShowList box_reset"><!--数据展示-->
    <div class="searchGroups"><!--搜索输入框-->
        <div class="input-prepend input-group">
            <ul>
                <li>
                    <button class="classTypeQueryDetail"><a href=''<%="shopManage.jsp?aeraId="+inId%>'"shopManage.html">进入店铺排名</a></button>
                </li>
            </ul>
            <div class="bmiAnalysis"><!--商圈详情-->
                <div>
                    <div id="main2"></div>
                    <div id="main3" ></div>
                    <div id="main"></div>
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
    /**
     * Created by xiaosi on 2017/9/11.
     */
    $(function(){
        var myChart1 = echarts.init(document.getElementById('main'));
        var categories=new Array
        var sales=new Array
        <%
            for (AreaDetail areaDtail : list) {
        %>
            categories.push("<%=areaDtail.getCategoryName()%>")
            sales.push(<%=areaDtail.getAverageConsume()%>)
        <%
            }
        %>

        option = {
            title: {
                text: '店铺人均消费额',
                x: 'center'
            },
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
                data:['店铺分类']
            },
            xAxis: [
                {
                    type: 'category',
                    //axisLabel:{
                    //    formatter:function(val){
                    //        return val.split("").join("\n");
                    //    }
                    //},
                    data: categories
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '人均消费额（元）',
                    min: 0,
                    max: 200,
                    interval:40,
                    axisLabel: {
                        formatter: '{value}元'
                    }
                },
            ],
            series: [
                {
                    name:'消费额',
                    type:'bar',
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
        myChart1.setOption(option);
        window.onresize = myChart1.resize;
    });
</script>
<script>
    /**
     * Created by xiaosi on 2017/9/11.
     */
    $(function() {
        var myChart2 = echarts.init(document.getElementById('main2'));
        var scores=new Array
        var categories=new Array
        <%
            for (AreaDetail areaDtail : list) {
        %>
            scores.push({name:"<%=areaDtail.getCategoryName()%>",value:[<%=areaDtail.getEnvironmentScore()%>,<%=areaDtail.getFlavorScore()%>,<%=areaDtail.getServiceScore()%>]})
            categories.push("<%=areaDtail.getCategoryName()%>")
        <%
            }
        %>
        option = {
            tooltip: {},
            legend: {
                data: categories
            },
            radar: {
                // shape: 'circle',
                name: {
                    textStyle: {
                        color: '#fff',
                        backgroundColor: '#999',
                        borderRadius: 3,
                        padding: [3, 5]
                    }
                },
                indicator: [
                    { name: '环境', max: 10},
                    { name: '口味', max: 10},
                    { name: '服务', max: 10},

                ]
            },
            series: [{
                name: '评分',
                type: 'radar',
                // areaStyle: {normal: {}},
                data: scores
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart2.setOption(option);
        window.onresize = myChart2.resize;
    });

</script>
<script>
    /**
     * Created by xiaosi on 2017/9/11.
     */
    $(function() {
        var myChart3 = echarts.init(document.getElementById('main3'));
        var shopNums=new Array
        var categories=new Array
        <%
            for (AreaDetail areaDtail : list) {
        %>
            shopNums.push({name:"<%=areaDtail.getCategoryName()%>",value:<%=areaDtail.getShopNum()%>})
            categories.push("<%=areaDtail.getCategoryName()%>")
        <%
            }
        %>
        option = {
            title: {
                text: '店铺占比',
                x: 'center'
            },
            display:'inline-block',
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: categories
            },
            toolbox: {
                show: false,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                x: '25%',
                                width: '50%',
                                funnelAlign: 'left',
                                max: 1548
                            }
                        }
                    },
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            series: [
                {
                    name: '店铺分类',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: shopNums
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart3.setOption(option);
        window.onresize = myChart3.resize;
    });

</script>
</body>
</html>
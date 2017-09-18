<%@ page import="service.impl.ShopDetailServiceImpl" %>
<%@ page import="model.ShopDetail" %><%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 17-9-17
  Time: 上午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询店铺</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String shopName = request.getParameter("shopName");
    ShopDetailServiceImpl shopDetailService = new ShopDetailServiceImpl();
    ShopDetail shopDetail = shopDetailService.getShopDetailByShopName(shopName);
    int shopId = shopDetail.getShopId();
    if(shopName.equals("")){
        out.print("<script language='javascript'>alert('查询店铺不存在！');window.location.href='javascript:history.go(-1)';</script>");
    }
    else if(shopId!=0){
        response.sendRedirect("StoreDetail.jsp?shopId="+shopId);
    }else {
        out.print("<script language='javascript'>alert('查询店铺不存在！');window.location.href='javascript:history.go(-1)';</script>");
    }
%>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.impl.AreaDetailServiceImpl" %>
<%@ page import="model.AreaDetail" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.swing.*" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>
<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 17-9-11
  Time: 下午1:16
  To change this template use File | Settings | File Templates.
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
--%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String inName = request.getParameter("areaId");
    String inPwd = request.getParameter("userPassword");
    Pattern pattern = Pattern.compile("^[0-9]*$");
    Matcher matcher = pattern.matcher(inName);
    if(!matcher.matches()){
        out.print("<script language='javascript'>alert('用户名或密码错误，请重新登陆！');window.location.href='login.jsp';</script>");
    }else {
        AreaDetailServiceImpl areaDetailService = new AreaDetailServiceImpl();
        List<AreaDetail> list = areaDetailService.getAreaDetailByAreaId(Integer.parseInt(inName));
        if (list.size() > 0) {
            AreaDetail areaDetail = list.get(0);
            if (areaDetail != null && areaDetail.getPassWord().equals(inPwd)) {
                response.sendRedirect("shopManage.jsp?areaId=" + inName);
            } else {
//            JOptionPane.showMessageDialog(null, "登录失败请重新登录");
//            response.sendRedirect("login.jsp");
                out.print("<script language='javascript'>alert('用户名或密码错误，请重新登陆！');window.location.href='login.jsp';</script>");
            }
        } else {
//        JOptionPane.showMessageDialog(null, "登录失败请重新登录");
//        response.sendRedirect("login.jsp");
            out.print("<script language='javascript'>alert('用户名或密码错误，请重新登陆！');window.location.href='login.jsp';</script>");
        }
    }
%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--登录界面-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel = "Shortcut Icon" href=images/index/favicon.ico/>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/fontsImports.css"/>
    <link rel="stylesheet" href="css/login.css"/>
    <link rel="stylesheet" href="css/adManage.css"/>
    <title>欢迎登陆</title>
</head>
<body>
<div class="biggest">
    <div class="left_content">
        <h2><img src="images/login/logo.png"/></h2>
        <div class="main_ball">
            <img src="images/login/main_ball1.png" />
        </div>
        <img src="images/login/main_yun.png" class="main_yun"/>
    </div>
    <div class="amc_login">
    <div class="login_Content">
        <h2>餐饮大数据平台</h2>
        <p class="informationTips"></p>
        <form name="form" method="post" action="control.jsp">
            <li><img src="images/login/mian_user.png"/> <input type="text" placeholder="请输入账号" name="areaId"/> </li>
            <li><img src="images/login/mian_pass.png"/> <input type="password" placeholder="请输入密码" name="userPassword"/> </li>
            <div class="two_btns"><!--两个按钮-->
                <button type="submit" class="loginBtn" >登陆</button>
                <button class="resetBtn" ><a href="StartShop.jsp">我要开店</a></button>
            </div>
        </form>

        <%--<div class="two_btns"><!--两个按钮-->--%>
            <%--<button type="reset" class="resetBtn" href="StartShop.html">我要开店</button>--%>
        <%--</div>--%>
    </div>
    </div>
    <span class="amc_copyRight">版权所有&copy;成都金数智谷开发室</span>
</div>
</body>

</html>
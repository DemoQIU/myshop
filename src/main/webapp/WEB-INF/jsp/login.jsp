<%--
  Created by IntelliJ IDEA.
  User: qiu
  Date: 2017/11/9
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名" maxlength="20"/>
        <br>
        密码：<input type="password" name="password" placeholder="请输入密码"/>
        <br>
        <input type="submit" name="login" value="登录"/>
    </form>
</body>
</html>

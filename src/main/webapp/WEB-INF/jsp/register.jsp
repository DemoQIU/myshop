<%--
  Created by IntelliJ IDEA.
  User: qiu
  Date: 2017/11/9
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        用户名：<input type="text" name="username" placeholder="请输入用户名"/>
        <br>
        密码：<input type="password" name="password" placeholder="请输入密码"/>
        <br>
        <input type="submit" name="submit" value="提交"/>
    </form>
</body>
</html>

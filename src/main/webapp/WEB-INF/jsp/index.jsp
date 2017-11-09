<%--
  Created by IntelliJ IDEA.
  User: qiu
  Date: 2017/11/7
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <c:if test="${sessionScope.user == null}">
        <a href="${pageContext.request.contextPath}/userRegister" name="register">注册</a>
        <br>
        <a href="${pageContext.request.contextPath}/userLogin" name="login">登录</a>
    </c:if>
    
    <c:if test="${sessionScope.user != null}">
        <span>欢迎你，${user.username}</span>
        <br>
        <a href="${pageContext.request.contextPath}/logout" name="register">退登</a>
    </c:if>
</body>
</body>
</html>

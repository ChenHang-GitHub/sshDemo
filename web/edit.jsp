<%--
  Created by IntelliJ IDEA.
  User: chenshihang
  Date: 2019/7/15
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<form action="edit.action" method="post">
<input type="hidden" name="param" value="1">
  id:  <input type="text" name="user.id" value="${user.id}"> </br>
  name:  <input type="text" name="user.username" value="${user.username}"></br>
  pwd:  <input type="text" name="user.userpassword" value="${user.userpassword}"></br>
  mes:  <input type="text" name="user.usermessage" value="${user.usermessage}"></br>

    <input type="submit" value="修改">
</form>

</body>
</html>

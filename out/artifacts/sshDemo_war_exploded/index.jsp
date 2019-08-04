<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>SSH</title>
</head>
<body>

<form action="add.action" method="get">
    UserName:<input type="text" name="user.username"><br/>
    UserPassword:<input type="password" name="user.userpassword"><br/>
    UserMessage:<input type="text" name="user.usermessage"><br/>
    <input type="submit" value="提交">
    <input type="reset" value="重置">

</form>

<form action="query.action" method="post">
    <input type="text" name="queryText" value="${queryText}"/>
    <input type="submit" value="查询"/>
</form>
<table border="1" width="300px">
    <tr>
        <td>1</td>
        <td>2</td>
        <td>3</td>
        <td>4</td>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.usermessage}</td>
            <td><a href="edit.action?param=0&id=${user.id}">编辑</a>
                <a href="delete.action?id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>

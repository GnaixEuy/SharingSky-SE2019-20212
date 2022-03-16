<%--
  Created by IntelliJ IDEA.
  User: gnaixeuy
  Date: 2022/3/16
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加学生</h1>
<form action="${pageContext.request.contextPath}/SpringBootWithJsp/stu/add" method="post">
    <label for="id">id:</label>
    <input type="text" name="id"  id="id"/>

    <label for="name">name:</label>
    <input type="text" name="name"  id="name"/>

    <label for="classInfo">classInfo:</label>
    <input type="text" name="classInfo"  id="classInfo"/>
    <input type="submit">
</form>
</body>
</html>

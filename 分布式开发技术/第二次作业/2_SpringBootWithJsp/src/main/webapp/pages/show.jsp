<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show.jsp</title>
</head>
<body>
<h1>Hello, test.jsp</h1>
<h1>
${sessionScope.user.id}
</h1>
<h2>
    ${sessionScope.user.name}
</h2>
<h2>
    ${sessionScope.user.classInformation}
</h2>
</body>
</html>
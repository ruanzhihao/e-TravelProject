<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login" method="post">
    <label>用户名：</label><input type="text" name="username">
    <label>密码：</label><input type="password" name="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
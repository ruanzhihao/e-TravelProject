<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h2>欢迎 ${userInfo.username} 登出<a href="${pageContext.request.contextPath }/logout">退出</a></h2>
<br>
<!--权限需求 管理员登录 拥有 查询、修改、添加、删除权限  经理用户 查询 修改 添加权限  普通用户 查询和导出权限-->

<shiro:hasPermission name="user:query">
    <a href="${pageContext.request.contextPath }/user/userQuery">查询用户</a><br>
</shiro:hasPermission>
<shiro:hasPermission name="user:add">
    <a href="${pageContext.request.contextPath }/user/userAdd">添加用户</a><br>
</shiro:hasPermission>
<shiro:hasPermission name="user:delete">
    <a href="${pageContext.request.contextPath }/user/userDelete">删除用户</a><br>
</shiro:hasPermission>
<shiro:hasPermission name="user:update">
    <a href="${pageContext.request.contextPath }/user/userUpdate">修改用户</a><br>
</shiro:hasPermission>
<shiro:hasPermission name="user:export">
    <a href="${pageContext.request.contextPath }/user/userExport">导出用户</a><br>
</shiro:hasPermission>

</body>
</html>

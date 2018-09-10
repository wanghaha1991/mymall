<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/9/4
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
</head>

<body>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>编号</th>
            <th>用户名</th>
            <th>生日</th>
            <th>电话号码</th>
            <th>性别</th>
            <th>操作</th>
        </thead>
        <tbody>

        <c:forEach items="${accounts}" var="account" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${account.id}</td>
                <td>${account.username}</td>
                <td>
                    <fmt:formatDate value="${account.birthday}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${account.phone}</td>
                <td>
                    <c:if test="${account.gender eq'1'}">男</c:if>
                    <c:if test="${account.gender eq'0'}">女</c:if>
                </td>
                <td class="td-manage">
                    <a title="编辑" onclick="x_admin_show('商品编辑','/account/${account.id}')" href="javascript:;">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

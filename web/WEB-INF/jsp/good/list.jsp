<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <th>商品名</th>
            <th>价格</th>
            <th>类别</th>
            <th>库存</th>
            <th>商品描述</th>
            <th>是否上架</th>
            <th>操作</th>
        </thead>
        <tbody>

        <c:forEach items="${goods}" var="good" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${good.id}</td>
                <td>${good.name}</td>
                <td>${good.price}</td>
                <td>${good.group}</td>
                <td>${good.inventory}</td>
                <td>${good.description}</td>
                <td>
                    <c:if test="${good.isSale eq'0'}">已上架</c:if>
                    <c:if test="${good.isSale eq'1'}">未上架</c:if>
                </td>
                <td class="td-manage">
                    <a title="编辑" onclick="x_admin_show('商品编辑','/good/${good.id}')" href="javascript:;">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" onclick="delGood(${good.id})" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<form id="delForm" method="post">
    <input type="hidden" name="_method" value="DELETE"></form>
<script>
    function delGood(id) {
        var action = '/good/';
        if (confirm("确定删除吗？")) {
            $('#delForm').attr('action', action + id).submit();
            window.parent.location.reload();
        }
    }
</script>
</body>
</html>

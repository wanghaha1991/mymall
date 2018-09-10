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
    <table class="layui-table layui-form">
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
                    <input type="checkbox" lay-filter="isSale" value="${good.id}" name="switch"  lay-text="上架|下架"  lay-skin="switch">
                    <input type="hidden" value="${good.isSale}" id="sale">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    layui.use(['form'], function(){
        var form = layui.form;
        var layer =layui.layer;
        form.on('switch(isSale)',function (data) {
            var id = data.value;
            var sale = $('#sale').val();
            $.ajax({
                url:'/updateSale',
                type:'Post',
                data:{'id':id,'status':sale},
                success:function (data) {
                    console.log(data);
                    if (data){
                        alert("上架成功！");
                        location.reload();
                    }
                }
            })
        })
    });
</script>
</body>
</html>

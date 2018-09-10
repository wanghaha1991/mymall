<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/9/4
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>类别修改</title>
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
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/classify" id="form">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="id" value="${classify.id}">
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>类名
            </label>
            <div class="layui-input-inline">
                <input type="text" value="${classify.name}" id="name" name="name" required=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="description" class="layui-form-label">
                <span class="x-red">*</span>描述
            </label>
            <div class="layui-input-inline">
                <input type="text" value="${classify.description}" id="description" name="description" required=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="parentId" class="layui-form-label">
                <span class="x-red">*</span>父类名(一级类别请勿选择)
            </label>
            <div class="layui-input-inline">
                <select name="parentId" id="parentId">
                    <option value="0" selected>-一级类别请勿选择-</option>
                    <c:forEach items="${roots}" var="root" >
                        <option value="${root.id}">${root.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" onclick="f()">
                提交
            </button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    function f() {
        $('#form').submit();
        layer.alert("修改成功，请重新加载", {icon: 6}, function () {
            // 获得frame索引
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
        });
    }
</script>
</html>

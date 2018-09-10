<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
    <title>会员信息修改</title>
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
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/account" id="form">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="id" value="${account.id}">
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>用户名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" readonly name="username" required="" lay-verify="required"
                       autocomplete="off" value="${account.username}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="birthday" class="layui-form-label">
                <span class="x-red">*</span>生日
            </label>
            <div class="layui-input-inline">
                <input type="date" value='<fmt:formatDate value="${account.birthday}" pattern="yyyy-MM-dd"/>' id="birthday" name="birthday"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text" value="${account.phone}" id="phone" name="phone" required=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="gender" class="layui-form-label">
                <span class="x-red">*</span>性别
            </label>
            <div class="layui-input-inline">
                <div class="layui-input-inline" id="gender">
                    男:<input name="gender" type="radio" value="1">
                    女:<input name="gender" type="radio" value="0">
                </div>
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
    $(function () {
        $("input[name='gender'][value=${account.gender}]").attr("checked", "checked");
    })

</script>
</html>

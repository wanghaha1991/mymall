<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/9/1
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>后台登录</title>
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
  <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
  <div class="message">管理员登录</div>
  <div id="darkbannerwrap"></div>

  <form method="post" class="layui-form" action="/login" >
    <input name="name" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
    <hr class="hr15">
    <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
    <hr class="hr15">
    <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
    <hr class="hr20" >
  </form>
</div>
</body>
</html>
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
            <th>图片编号</th>
            <th>商品编号</th>
            <th>商品名</th>
            <th>图片</th>
            <th>操作</th>
        </thead>
        <tbody>

        <c:forEach items="${images}" var="image" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${image.id}</td>
                <td>${image.goodId}</td>
                <td>${image.goodName}</td>
                <td>
                    <img src="${image.img}" width="100px" height="80px">
                </td>
                <td class="td-manage">
                    <div class="layui-row" align="center" style="margin-top: 30px;">
                        <button type="button" class="layui-btn" id="upload">
                            <i class="layui-icon">&#xe67c;</i>选择图片</button>
                        <input type="hidden" id="goodId" value="${image.goodId}">
                    </div>
                    <a title="删除" href="/delImage?id=${image.id}">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    layui.use(['upload','layer'],function () {
        var upload = layui.upload,layer = layui.layer;
        //普通图片上传
        var uploadInst = upload.render({
            elem: '#upload',//绑定的元素
            url: '/updateItem',//提交的url
            auto:true,//是否自动上传
            accept:"images",//指定允许上传的文件类型
            multiple:false,//支持多文件上传
            acceptMime:"image/*",//规定打开文件选择框时，筛选出的文件类型
            before: function(obj){
                this.data={"goodId": $("#goodId").val()}//携带额外的数据
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#imgPreview').attr('src', result); //图片链接（base64）
                });
                var index = layer.load(); //开始上传之后打开load层
                $("#hidden_tmp_index").val(index);//将load层的index隐藏到页面中
            },
            done: function(res, index, upload){ //假设code=0代表上传成功
                layer.close(layer.index); //它获取的始终是最新弹出的某个层，值是由layer内部动态递增计算的
            }
        });
    })


</script>
</body>


</html>

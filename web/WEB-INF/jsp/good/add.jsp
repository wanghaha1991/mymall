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
    <title>商品修改</title>
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
    <form class="layui-form"method="post" action="${pageContext.request.contextPath}/good" id="form">

        <input type="hidden" name="id" >
        <div class="layui-form-item">
            <label for="goodname" class="layui-form-label">
                <span class="x-red">*</span>商品名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="goodname" name="name" required  lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="price" class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" required
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="inventory" class="layui-form-label">
                <span class="x-red">*</span>库存
            </label>
            <div class="layui-input-inline">
                <input type="text" id="inventory" name="inventory" required
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>商品分类
            </label>
            <div class="layui-input-inline">
                <div class="layui-input-inline">
                    <select lay-filter="test" id="one">
                        <option disabled selected>---请选择---</option>
                        <c:forEach items="${groups}" var="group">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                    <select name="group" id="two">

                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="description" class="layui-form-label">
                <span class="x-red">*</span>商品描述
            </label>
            <div class="layui-text">
                <textarea id="description" name="description" required
                          autocomplete="off" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="isSale" class="layui-form-label">
                <span class="x-red">*</span>是否上架
            </label>
            <div class="layui-input-block" id="isSale">
                <input type="radio" name="isSale" value="1" title="上架" checked>
                <input type="radio" name="isSale" value="0" title="不上架">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" onclick="f()">
                添加
            </button>
        </div>
    </form>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/ckeditor/ckeditor.js"></script>
<!--将相应的控件替换成编辑器代码 -->
<script type="text/javascript">
    var editor = CKEDITOR.replace('description', {
            filebrowserUploadUrl : "${pageContext.request.contextPath}/updateItem",
            enterMode :CKEDITOR.ENTER_BR //换行直接加br
        }
    );
    function f() {
        $('#form').submit();
        layer.alert("添加成功，请重新加载", {icon: 6}, function () {
            // 获得frame索引
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
        });
    }
    layui.use('form', function(){
        var form = layui.form;
        form.on('select(test)', function(data){
            $('#two').html('');
            var parentId = $('#one').val();
            $.ajax({
                type: 'POST',
                url: '/getClassifies',
                data: {'parentId': parentId},
                success: function (data) {
                    console.log(data);
                    if (data != null && data.length > 0) {
                        $.each(data,function(index,item){
                            $('#two').append(new Option(item.name,item.name));// 下拉菜单里添加元素
                        })
                        form.render();
                    }
                }
            })
        });
    });
</script>
</html>

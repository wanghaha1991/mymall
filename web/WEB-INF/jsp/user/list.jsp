<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/9/7
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.all.js"></script>
</head>
<body>
<table class="layui-table" style="width: 800px">
    <thead>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>部门</th>
        <th>创建时间</th>
    </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
</table>
<!-- 分页标签 -->
<div id="page1"></div>
</body>
<script type="text/javascript">
    //直接使用layui-v2.0.2里面的分页功能，没有用到core.js里面的方法
    layui.use('laypage', function(){
        var laypage = layui.laypage;
        var url = "/admin";
        var config = {page:1,pageSize:2};
        $.getJSON(url,config,function(res){
            laypage.render({
                elem: 'page1',
                count: res.total, //总条数
                limit:config.pageSize, //每页条数
                theme: '#FFB800', //自定义颜色
                jump: function(obj, first){
                    if(!first){ //首次则不进入
                        config.page = obj.curr;
                        getUserListByPage(url,config);
                    }
                }
            });
            parseUserList(res,config.page);
        });
    });
    //点击页数从后台获取数据
    function getUserListByPage(url,config){
        $.getJSON(url,config,function(res){
            parseUserList(res,config.page);
        });
    }
    //解析数据，currPage参数为预留参数，当删除一行刷新列表时，可以记住当前页而不至于显示到首页去
    function parseUserList(res,currPage){
        var content = "";
        $.each(res.rows, function (i, o) {
            content += "<tr>";
            content += "<td>"+o.id+"</td>";
            content += "<td>"+o.name+"</td>";
            content += "<td>"+o.password+"</td>";
            content += "<td>"+o.department+"</td>";
            content += "<td>"+dateFormat(o.createTime)+"</td>";
            content += "</tr>";
        });
        $('#tbody').html(content);
    }
     function dateFormat(unixTime) {
        if (typeof (timeZone) == 'number')
        {
            unixTime = parseInt(unixTime);
        }
        var time = new Date(unixTime);
        var ymdhis = "";
        ymdhis += time.getUTCFullYear() + "-";
        ymdhis += (time.getUTCMonth()+1) + "-";
        ymdhis += time.getUTCDate();
        return ymdhis;
    }
</script>
</html>
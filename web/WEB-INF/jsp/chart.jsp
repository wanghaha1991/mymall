<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/9/6
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>echarts</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
</head>
<body>
<%--图标容器--%>
    <div id="main" style="width: 800px;height:600px;"></div>
<script type="text/javascript">
    var myChart=echarts.init(document.getElementById("main"));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '商品库存表'
        },
        tooltip: {},
        legend: {
            data:['库存']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '存量',
            type: 'bar',
            data: []
        }]
    });
    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
    var names=[];    //类别数组（实际用来盛放X轴坐标值）
    var nums=[];    //存量数组（实际用来盛放Y坐标值）
    $.ajax({
        type : "post",
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "/getInventory",    //请求发送到TestServlet处
        dataType : "json",        //返回数据形式为json
        success : function(result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                for(var i=0;i<result.length;i++){
                    names.push(result[i].name);    //挨个取出类别并填入类别数组
                }
                for(var i=0;i<result.length;i++){
                    nums.push(result[i].inventory);    //挨个取出销量并填入销量数组
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: names
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '库存量',
                        data: nums
                    }]
                });

            }
        },
        error : function(errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })
</script>
</body>
</html>

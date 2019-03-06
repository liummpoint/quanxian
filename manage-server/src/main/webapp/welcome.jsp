<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=basePath%>lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>花生理财后台管理系统</title>
</head>
<body>
<div class="page-container">
    <table class="table" style="background-color: #F5F5F5">
        <thead>
        <%-- <tr>
             <th colspan="7" scope="col">信息统计</th>
         </tr>--%>
        <tr class="text-c">
            <th style="font-size: 15px;text-align: center">累计净流入（元）</th>
            <th style="font-size: 15px;text-align: center">累计交易用户（人）</th>
            <th style="font-size: 15px;text-align: center">累计交易额（元）</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c">
            <td id="d" style="font-size:20px;color: #0066cc;text-align: center"></td>
            <td id="e" style="font-size:20px;color: #0066cc;text-align: center"></td>
            <td id="f" style="font-size:20px;color: #0066cc;text-align: center"></td>
        </tr>
        </tbody>
    </table>
    <table class="table" class="table" style="background-color: #F5F5F5">
        <thead>
        <tr class="text-c">
            <th style="font-size: 15px;text-align: center">当日净流入（元）</th>
            <th style="font-size: 15px;text-align: center">当日交易用户（人）</th>
            <th style="font-size: 15px;text-align: center">当日交易额（元）</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c">
            <td id="a" style="font-size:20px;color: #0066cc;text-align: center"></td>
            <td id="b" style="font-size:20px;color: #0066cc;text-align: center"></td>
            <td id="c" style="font-size:20px;color: #0066cc;text-align: center"></td>
        </tr>
        </tbody>
    </table>
</div>


<table>
    <tr>
        <td style="padding-bottom: 40px">
            <div id="container1"></div>
        </td>
        <td style="padding-bottom: 40px">
            <div id="container2"></div>
        </td>
    </tr>
    <tr>
        <td style="padding-left: 70px;">
            <div id="container3"></div>
        </td>
        <td>
            <div id="container4"></div>
        </td>
    </tr>
    <%--<tr>
        <td><div id="container5"></div></td>
    </tr>--%>
</table>


<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->


<script type="text/javascript" src="<%=basePath%>js/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="<%=basePath%>js/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script type="text/javascript" src="<%=basePath%>js/hcharts/Highcharts/5.0.6/js/highcharts-3d.js"></script>
<script type="text/javascript">


    $(function () {
        var selectsum =
            $.ajax({
                type: "POST",
                url: "index/selectbysum.do",
                dataType: "json",
                success: function (data) {
                    if (data.data == null) {
                        $('#d').html(0);
                        $('#e').html(0);
                        $('#f').html(0);
                    }
                    else {
                        if(data.data.netInflowVo == null||data.data.netInflowVo ==''||data.data.netInflowVo ==0){
                            $('#d').html(0);
                        }else{
                            $('#d').html(data.data.netInflowVo);
                        }

                        if(data.data.tranUserCountVo == null||data.data.tranUserCountVo ==''||data.data.tranUserCountVo ==0){
                            $('#e').html(0);
                        }else{
                            $('#e').html(data.data.tranUserCountVo);
                        }

                        if(data.data.transAmountVo == null||data.data.transAmountVo ==''||data.data.transAmountVo ==0){
                            $('#f').html(0);
                        }else{
                            $('#f').html(data.data.transAmountVo);
                        }
                    }

                }
            })

        var selectday =
            $.ajax({
                type: "POST",
                url: "index/selectbyday.do",
                dataType: "json",
                success: function (data) {
                    if(data.data == null){
                        $('#a').html(0);
                        $('#b').html(0);
                        $('#c').html(0);
                    }else {
                        if(data.data.netInflow == null||data.data.netInflow ==''||data.data.netInflow ==0){
                            $('#a').html(0);
                        }else{
                            $('#a').html(data.data.netInflow);
                        }

                        if(data.data.tranUserCount == null||data.data.tranUserCount ==''||data.data.tranUserCount ==0){
                            $('#b').html(0);
                        }else{
                            $('#b').html(data.data.tranUserCount);
                        }

                        if(data.data.transAmount == null||data.data.transAmount ==''||data.data.transAmount ==0){
                            $('#c').html(0);
                        }else{
                            $('#c').html(data.data.transAmount);
                        }
                    }
                }
            })


        var zhuzhuangtu =
            $.ajax({
                type: "POST",
                url: "index/zhuzhuangtu.do",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    $('#container1').highcharts({
                        chart: {
                            width: 600,
//                            type: 'column'
                            renderTo: 'container',
                            type: 'column',
                            margin: 55,
                            options3d: {
                                enabled: true,
                                alpha: 15,
                                beta: 15,
                                depth: 50,
                                viewDistance: 25
                            }
                        },
                        title: {
                            text: '净流入（万元）'
                        },
                        xAxis: {
                            categories: data.data.x,
                            labels:{
                                rotation:-45

                            }
                        },
                        yAxis: {
                            title: {
                                text: ''
                            }
                        },
                        legend: {                 //图例的样式
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                        },
                        credits: {                //右下角的水印
                            text: '',
                            href: ''
                        },
                        colors: [ '#FF9655', '#058DC7','#24CBE5','#50B432',  '#ED561B', '#DDDF00', '#64E572', '#FFF263', '#6AF9C4'],//定义颜色
                        tooltip: {
                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:.2f} </b></td></tr>',
                            footerFormat: '</table>',
                            shared: true,
                            useHTML: true
                        },
                        plotOptions: {
                            column: {
                               /* pointPadding: 0.2,
                                borderWidth: 0*/
                                depth: 25
                            }
                        },
                        series: [{
                            name: '值',
                            data: data.data.y

                        }]
                    });

                }
            })


        var zhexian =
            $.ajax({
                type: "POST",
                url: "index/zhexiantu.do",
                dataType: "json",
                success: function (data) {
                    $('#container4').highcharts({
                        chart: {
                            width: 550

                        },
                        title: {
                            text: '投资与转出(万元)',
                            x: -20 //center
                        },
                        xAxis: {
                            categories: data.data.x,
                            labels:{
                                rotation:-45

                            }
                        },
                        yAxis: {
                            title: {
                                text: ''
                            },
                            plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#50B432'
                            }]
                        },
                        credits: {
                            text: '',
                            href: ''
                        },
                        tooltip: {
                            valueSuffix: ''
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                        },
                        plotOptions: {
                            series: {
                                lineWidth:1,
                                marker: {
                                    radius: 3,  //曲线点半径，默认是4
                                    symbol: 'diamond' //曲线点类型："circle", "square", "diamond", "triangle","triangle-down"，默认是"circle"
                                }
                            }

                        },
                        colors: [ '#FF9655', '#058DC7','#24CBE5','#50B432',  '#ED561B', '#DDDF00', '#64E572', '#FFF263', '#6AF9C4'],//定义颜色
                        series: [{
                            name: '投资',
                            data: data.data.y1
                        }, {
                            name: '转出',
                            data: data.data.y2
                        }]
                    });

                }
            })


        var zhexian2 =
            $.ajax({
                type: "POST",
                url: "index/zhucejiaoyi.do",
                dataType: "json",
                success: function (data) {
                    $('#container3').highcharts({
                        chart: {
                            width: 550
                        },
                        title: {
                            text: '注册用户    交易用户',
                            x: -20 //center
                        },
                        xAxis: {
                            categories: data.data.x,
                            labels:{
                                rotation:-45

                            }
                        },
                        yAxis: {
                            title: {
                                text: ''
                            },
                            plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }]
                        },
                        tooltip: {
                            valueSuffix: ''
                        },
                        credits: {
                            text: '',
                            href: ''
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                        },
                        plotOptions: {
                            series: {
                                lineWidth:1,
                                marker: {
                                    radius: 3,  //曲线点半径，默认是4
                                    symbol: 'diamond' //曲线点类型："circle", "square", "diamond", "triangle","triangle-down"，默认是"circle"
                                }
                            }
                        },
                        colors: [ '#FF9655', '#058DC7','#24CBE5','#50B432',  '#ED561B', '#DDDF00', '#64E572', '#FFF263', '#6AF9C4'],//定义颜色
                        series: [{
                            name: '注册',
                            data: data.data.y1
                        }, {
                            name: '交易',
                            data: data.data.y2
                        }]
                    });

                }
            })


        var bingzhuantu =
            $.ajax({
                type: "POST",
                url: "index/bingzhuangtu.do",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    var sumlist = data.rows;

                    $('#container2').highcharts({
                        chart: {
                           width: 500,
                            /*plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false*/
                            type: 'pie',
                            options3d: {
                                enabled: true,
                                alpha: 45,
                                beta: 0
                            }
                        },
                        title: {
                            text: '累计利息分布（元）：' + data.data
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
                        },
                        credits: {
                            text: '',
                            href: ''
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                depth:35,
                                dataLabels: {
                                    enabled: true,
                                    color: '#000000',
                                    connectorColor: '#000000',
                                    format: '<b>{point.name}</b>: {point.percentage:.2f} %'
                                }
                            }
                        },
                        colors: [ '#FF9655', '#058DC7','#24CBE5','#50B432',  '#ED561B', '#DDDF00', '#64E572', '#FFF263', '#6AF9C4'],//定义颜色
                        series: [{
                            type: 'pie',
                            name: '百分比：',
                            data: [
                                ['特权本金', data.rows[0]],
                                ['投资利息', data.rows[1]],
                                ['加息券利息', data.rows[2]]
                            ]
                        }]
                    });
                }
            })

    });


</script>

</body>
</html>


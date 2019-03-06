<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h5data/css/h5data.css"/>

    <title>花生投统计数据</title>
    <script type="text/javascript" src="<%=basePath%>static/h5data/js/zepto.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/h5data/js/global.js"></script>
	<style type="text/css">
        .pb2 {
        	padding-bottom: .5rem;
        }
        .tc {text-align: center;}
	</style>
</head>
<body>
<div class="container">
    <p class="info">最新更新时间：<span id="createtime" class="mr0-16"></span><span class="c-red">每小时整点更新</span></p>
    <div class="table-list mb clearfix">
        <div class="table-li"><div class="bak-red"><div class="txt-div"><p class="big" id="netInflow1">0.00</p><p>总净流入（万元）</p></div></div></div>
        <div class="table-li"><div class="bak-blue"><div class="txt-div"><span class="arrow-icon" id="netInflowPercent"></span><p class="big" id="netInflow2">0.00</p><p>当日净流入（万元）</p></div></div></div>
    </div>
    <div class="table-list c-gray border-bottom clearfix">
        <div class="table-li"><div class="txt-div"><p><img class="icon" src="<%=basePath%>static/h5data/images/user_icon.png"/>总注册用户数</p><p class="f40 pl1-5" id="registerCount1">0</p></div></div>
        <div class="table-li"><div class="txt-div pl1-5"><p>当日注册用户数<span class="arrow-icon" id="registerCountPercent"></span></p><p class="f40" id="registerCount2">0</p></div></div>
    </div>
    <div class="table-list c-gray border-bottom clearfix">
        <div class="table-li"><div class="txt-div"><p><img class="icon" src="<%=basePath%>static/h5data/images/line_icon.png"/>总投资用户数</p><p class="f40 pl1-5" id="investCount1">0</p></div></div>
        <div class="table-li"><div class="txt-div pl1-5"><p>当日投资用户数<span class="arrow-icon" id="investCountPercent"></span></p><p class="f40" id="investCount2">0</p></div></div>
    </div>
</div>
<div class="container mb5" style="padding: 1rem 0  0;">
    <div id="containerLine"></div>
</div>
<div class="container mb5" style="padding:.5rem 0 0;">
    <div id="container" class="mb5"></div>
</div>
<div class="container mb5" style="padding-right: 0;padding-left: 0;">
    <div id="containerUser" class="mb5"></div>
</div>
<div class="container pb2">
    <p class="pie-title">总净流入产品占比（万元）</p>
    <div id="containerCircle" style="height: 20rem;"></div>
    <div class="table-list box-shadow c-3 clearfix">
        <div class="table-li"><div class="txt-div"><p class="f50" id="transferMatch">0.0</p><p>转出待匹配（万元）</p></div></div>
        <div class="table-li"><div class="txt-div"><p class="f50" id="InvestMatch">0.0</p><p>投资待匹配（万元）</p></div></div>
    </div>
</div>
<div class="container">
	<p class="info tc">转出成功平均时间：<span id="outTime"></span></p>
</div>
<script type="text/javascript">
    var width = window.innerWidth;
    if(width < 1024){
        var height = $("#containerLine").height();
        height = (((height+(width - height))/16)-9);
        $("#containerLine").css("height",height+"rem");
        $("#container").css("height",height+"rem");
        $("#containerUser").css("height",(height+2)+"rem");
    }else{
        $("#containerLine,#container,#containerUser").css("height","15rem");
    }
</script>
<script type="text/javascript" src="<%=basePath%>static/h5data/js/echarts.min.js"></script>
<script type="text/javascript">
    var amountDom = document.getElementById("container")
    var userDom = document.getElementById("containerUser")
    var dom = document.getElementById("containerCircle");
    var lineDom = document.getElementById("containerLine");
    var myChart = echarts.init(dom);
    var amountChart = echarts.init(amountDom);
    var userChart = echarts.init(userDom);
    var lineChart = echarts.init(lineDom);
    var amountColors = ['#5e98fb','#ff3030'];
    var userColors = ['#ff9700','#5e98fb'];
    var pieColors = ['#2196f2','#3e50b5','#ff9700','#cde230','#fa4d4d'];
    optionLine = {
        tooltip: {
            trigger: 'axis',
            formatter: "",
            backgroundColor:"#4783eb",
            fontSize:10,
            padding:[2,7],
            transitionDuration:0,
            hideDelay:0,
            showDelay:0,
           // triggerOn:'none',
        },
        legend: {
            data:['7日净流入（万元）'],
            left:'2%',
            selectedMode:false,
            itemWidth:25,
            itemHeight:15,
            textStyle:{
                fontSize:14
            }
        },
        color:['#4783eb'],
        grid: {
            top:'17%',
            left: '4%',
            right: '7%',
            bottom: '10%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: [],
            axisLabel: {
                interval: 0,
            },
            axisLine:{
                lineStyle:{
                    color:'#d2d2d2'
                }
            },
            axisTick:{
                inside:true,
                show:false,
            },
            boundaryGap:false,
            splitLine:{
                show:true,
                lineStyle:{
                    color:['#f7f7f7']
                }
            },
            axisPointer:{
                lineStyle:{
                    color:'#27c42b',
                },
                value:0,
                handle:{
                    show:false,
                    size:0
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLine:{
                lineStyle:{
                    color:'#d2d2d2'
                }
            },
            splitNumber:4,
            splitLine:{
                show:true,
                lineStyle:{
                    color:['#f7f7f7']
                }
            },
            axisTick:{
                inside:true,
                show:false
            }
        },
        series: [
            {
                name:'7日净流入（万元）',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#5e98fb'
                    }, {
                        offset: 1,
                        color: '#fff'
                    }])
                }},
                hoverAnimation:false,
                legendHoverLink:false,
                data:[],
                silent:true,
                label:{
                    normal:{
                        show:false,
                        position:'top',
                        fontSize:10
                    }
                }
            }

        ]
    },
        optionUser = {
            tooltip: {
                trigger: 'item',
                formatter: '',
                backgroundColor:"#4783eb",
                padding:[2,7],
                transitionDuration:0,
                hideDelay:0,
                showDelay:0,
                triggerOn:'none',

            },
            color:userColors,
            legend: {
                data:['7日内注册用户数（人）','7日内投资用户数（人）'],
                left:'1.5%',
                selectedMode:false,
                itemWidth:24,
                itemHeight:15,
                textStyle:{
                    fontSize:14
                }
            },
            grid: {
                top:'15%',
                left: '4%',
                right: '7%',
                bottom: '10%',
                containLabel: true,
                zlevel:3
            },
            xAxis: {
                type: 'category',
                data: [],
                axisLabel: {
                    interval: 0,
                },
                axisLine:{
                    lineStyle:{
                        color:'#d2d2d2'
                    }
                },
                axisTick:{
                    inside:true,
                    show:false
                },
                boundaryGap:false,
                splitLine:{
                    show:true,
                    lineStyle:{
                        color:['#f7f7f7']
                    }
                },
                axisPointer:{
                    lineStyle:{
                        color:'#27c42b',
                    },
                    value:0,
                    handle:{
                        show:false,
                        size:0
                    }
                }
            },
            yAxis: {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:'#d2d2d2'
                    }
                },
                splitNumber:4,
                splitLine:{
                    show:true,
                    lineStyle:{
                        color:['#f7f7f7']
                    }
                },
                axisTick:{
                    inside:true,
                    show:false
                }
            },
            series: [
                {
                    name:'7日内注册用户数（人）',
                    type:'line',
                    smooth:true,
                    hoverAnimation:false,
                    legendHoverLink:false,
                    data:[],
                    silent:true,
                    label:{
	                    normal:{
	                        show:true,
	                        position:'top',
	                        fontSize:10
	                    }
	                }
                    
                },
                {
                    name:'7日内投资用户数（人）',
                    type:'line',
                    smooth:true,
                    hoverAnimation:false,
                    legendHoverLink:false,
                    data:[],
                    silent:true,
                    label:{
	                    normal:{
	                        show:true,
	                        position:'top',
	                        fontSize:10
	                    }
	                }
                }

            ]

        },
        optionAmount = {
            tooltip: {
                trigger: 'axis',
                formatter: '',
                backgroundColor:"#4783eb",
                padding:[2,7],
                transitionDuration:0,
                hideDelay:0,
                showDelay:0,
               // triggerOn:'none',
            },
            color:amountColors,
            legend: {
                data:['7日内投资额（万元）','7日内转出额（万元）'],
                left:'2%',
                selectedMode:false,
                itemWidth:25,
                itemHeight:15,
                textStyle:{
                    fontSize:14
                }
            },
            grid: {
                top:'17%',
                left: '4%',
                right: '7%',
                bottom: '10%',
                containLabel: true,
                zlevel:2
            },
            xAxis: {
                type: 'category',
                data: [],
                axisLabel: {
                    interval: 0,
                },
                axisLine:{
                    lineStyle:{
                        color:'#d2d2d2'
                    }
                },
                axisTick:{
                    inside:true,
                    show:false
                },
                boundaryGap:false,
                splitLine:{
                    show:true,
                    lineStyle:{
                        color:['#f7f7f7']
                    }
                },
                axisPointer:{
                    lineStyle:{
                        color:'#27c42b',
                    },
                    value:0,
                    handle:{
                        show:false,
                        size:0
                    }
                }
            },
            yAxis: {
                type: 'value',
                axisLine:{
                    lineStyle:{
                        color:'#d2d2d2'
                    }
                },
                splitNumber:4,
                splitLine:{
                    show:true,
                    lineStyle:{
                        color:['#f7f7f7']
                    }
                },
                axisTick:{
                    inside:true,
                    show:false
                }
            },
            series: [
                {
                    name:'7日内投资额（万元）',
                    type:'line',
                    smooth:true,
                    hoverAnimation:false,
                    legendHoverLink:false,
                    data:[],
                    silent:true,
                   
                },
                {
                    name:'7日内转出额（万元）',
                    type:'line',
                    smooth:true,
                    hoverAnimation:false,
                    legendHoverLink:false,
                    data:[],
                    silent:true,
                }

            ]

        },
        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{b} {d}% <br/>{c}",
                padding:[2,7],
                show:false
            },
            color:pieColors,
            legend: {
                // orient: 'vertical',
                x: 'left',
                y:'10%',
                selectedMode:false,
                data:[],
                textStyle:{
                    fontSize:14
                }
            },
            series: [
                {
                    type:'pie',
                    radius: ['35%', '55%'],
                    center: ['50%', '70%'],
                    avoidLabelOverlap: true,
                    label: {
                        normal: {
                            show: true,
                            position: 'outside',
                            formatter:'{d}%',
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '16',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: true,
                            smooth: 0.2,
                            length: 5,
                            length2: 10,

                        }
                    },
                    data:[],
                    silent:true,

                }
            ]
        }
    piechart();
    daydata();
    sumdata();
    weekdata();

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
    if (optionAmount && typeof optionAmount === "object") {
        amountChart.setOption(optionAmount, true);
    }
    if (optionLine && typeof optionLine === "object") {
        lineChart.setOption(optionLine, true);
    }
    if (optionUser && typeof optionUser === "object") {
        userChart.setOption(optionUser, true);
    }
    function weekdata(){
        var url = "/h5data/weekdata.do"; // 线性图表
        Hs.getAjaxWithAsync(url,function(data){
            var xDate = [];
            var yInvestAmount = [];
            var transferAmount = [];
            var netInflow = [];
            var registerCount = [];
            var investCount = [];
            var date = new Date();
            var year = date.getFullYear();
            for (var i=0;i<data.createtime.length;i++) {
                xDate.push(data.createtime[i]);
            }
            for (var k=0;k<data.investAmount.length;k++) {
                yInvestAmount.push(data.investAmount[k]);
            }
            for(var j=0;j<data.transferAmount.length;j++){
                transferAmount.push(data.transferAmount[j]);
            }
            for(var t=0;t<data.netInflow.length;t++){
                netInflow.push(data.netInflow[t]);
            }
            for(var a=0;a<data.registerCount.length;a++){
                registerCount.push(data.registerCount[a]);
            }
            for(var b=0;b<data.investCount.length;b++){
                investCount.push(data.investCount[b]);
            }
            optionAmount.tooltip.formatter=year+"-{b0} </br> 投资额：{c0} </br> 转出额：{c1}";
            optionLine.tooltip.formatter = year+"-{b} <br/>净流入 : {c}";
            optionUser.tooltip.formatter=year+"-{b0} </br> 注册数：{c0} </br> 投资数：{c1}";
            optionAmount.yAxis.max = data.maxAmount;
            optionAmount.yAxis.min = data.minAmount;
            optionAmount.xAxis.data = xDate;
            optionLine.xAxis.data = xDate;
            optionUser.xAxis.data = xDate;
            optionLine.yAxis.min = data.minTotal;
            optionLine.yAxis.max = data.maxTotal;
            optionUser.yAxis.min = data.minUsers;
            optionUser.yAxis.max = data.maxUsers;
            optionLine.series[0].data = netInflow;
            optionAmount.series[0].data = yInvestAmount;
            optionAmount.series[1].data = transferAmount;
            optionUser.series[0].data = registerCount;
            optionUser.series[1].data = investCount;
        },"",'json','POST',function(){});
    }
    function piechart(){
        var url = "/h5data/piechart.do"; // 饼图
        Hs.getAjaxWithAsync(url,function(data){
            var  pieTitle = [];
            var pieValue = [];
            var value = [];
            var name = [];
            for(var i=0;i<data.productNameList.length;i++){
                var str = data.productNameList[i]+"  "+data.productValue[i].value;
                pieTitle.push(str)
                //pieTitle.push(data.productNameList[i])
            }
            for(var j=0;j<data.productValue.length;j++){
                value = data.productValue[j].value;
                name = data.productValue[j].name+"  "+value;
                if(value.indexOf(",")>-1){
                    value = value.replace(/,/g,"");
                }
                pieValue.push({"value":value,"name":name});
            }
            option.legend.data = pieTitle;
            option.series[0].data = pieValue;

        },"",'json','POST',function(){});
    }
    function daydata(){
        var url = "/h5data/daydata.do";
        Hs.getAjaxWithAsync(url,function(data){
            $("#createtime").text(data.createtime);
            $("#netInflow2").text(data.netInflow);
            $("#registerCount2").text(data.registerCount);
            $("#investCount2").text(data.investCount);
            $("#netInflowPercent").text(data.netInflowPercent);
            $("#registerCountPercent").text(data.registerCountPercent);
            $("#investCountPercent").text(data.investCountPercent);

            if(data.outTime==0){

                $("#outTime").text("暂无");
            }else{

                $("#outTime").text(data.outTime+"小时");
            }

            if((data.netInflowPercent).indexOf("-")>-1){
                $("#netInflowPercent").addClass("down-light");
            }else{
                $("#netInflowPercent").addClass("up-light");
            }
            if((data.registerCountPercent).indexOf("-")>-1){
                $("#registerCountPercent").addClass("down")
            }else{
                $("#registerCountPercent").addClass("up")
            }
            if((data.investCountPercent).indexOf("-")>-1){
                $("#investCountPercent").addClass("down")
            }else{
                $("#investCountPercent").addClass("up")
            }
        },"",'json','POST',function(){});
    }
    function sumdata(){
        var url = "/h5data/sumdata.do"; // /h5data/sumdata
        Hs.getAjaxWithAsync(url,function(data){

            $("#netInflow1").text(data.netInflow);
            $("#registerCount1").text(data.registerCount);
            $("#investCount1").text(data.investCount);
            $("#transferMatch").text(data.transferMatch);
            $("#InvestMatch").text(data.investMatch);
        },"",'json','POST',function(){});
    }

</script>

</body>
</html>

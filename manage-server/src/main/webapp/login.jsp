<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport"
	          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
	    <meta http-equiv="Cache-Control" content="no-siteapp"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<link rel="Shortcut Icon" href="<%=basePath%>images/huasheng.ico" />
		<title>花生投后台管理系统</title>
		<script src="<%=basePath%>js/zepto.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>js/global.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			 html,body{
                min-width:100%;
                min-height:100%;
                background:#f7f7f7;
                font-family: -apple-system-font, "Helvetica Neue", sans-serif;
                background: #fff;
                background-size: cover;
                -webkit-background-size: cover;
            }
            *{
                margin:0;
                padding:0;
            }
            .clearfix:after { content:'.'; display:block; height:0; clear:both; visibility:hidden; font-size:0;}
            .clearfix { min-height:1%;}
            div,aside{
                box-sizing:border-box;
            }
            ul,li {
            	list-style: none;
            }
            input:focus,input,button,
        	button:focus {
        		outline: none;
        		border: none;
        	}
            .container {
            	width: 42%;
            	position: relative;
            	margin: 0 auto;
            	padding-top: 50px ;
            	color: #878787;
            	font-size: .875rem;
            	text-align: left;
            	float: left;
            }
             .container-right {
             	float: right;
            	width: 58%;
            	height: 100%;
    			position: relative;
             }
             .container-right img {
             	width: 100%;
             	position: absolute;
    			height: 100%;
    			top: 0;
    			left: 0;
             }
            h1 {
            	font-size: 38px;
            	color: #000;
            	margin: 75px 0 30px;
            }
            .text {
            	font-size: 28px;
            	margin-bottom: 50px;
            }
            .logo {
            	height: 60px;
            	width: auto;
            }
            .btn {
        		height: 50px;
        		width: 406px;
        		border-radius: 50px;
        		-webkit-border-radius: 50px;
        		-moz-border-radius:50px;
        		text-align: center;
        		vertical-align: middle;
        		font-size: 18px;
        		margin-bottom: 27px;
        		padding: 0 30px;
        	}
			 .btn-small {
				 height: 50px;
				 width: 220px;
				 border-radius: 50px;
				 -webkit-border-radius: 50px;
				 -moz-border-radius:50px;
				 text-align: center;
				 vertical-align: middle;
				 font-size: 18px;
				 margin-bottom: 27px;
				 padding: 0 30px;
			 }
        	.btn-color {
        		background: linear-gradient(to right,#5960EA,#6889F2 );
        		background: -webkit-linear-gradient(to right,#5960EA,#6889F2 );
        		background: -ms-linear-gradient(to right,#5960EA,#6889F2 );
        		background: -moz-linear-gradient(to right,#5960EA,#6889F2 );
        		color: #fff;
        		font-size: 20px;
        		margin-right: 40px;
        	}
        	.btn-border {
    		    border: 1px solid #5A63EB ;
    		    color: #5A63EB ;
    		    background-color: #fff;
        	}
        	.btn-border:focus { border: 1px solid #5A63EB ;}
        	.btn-color,.btn-border {
        		margin-top: 10px;
        		width: 180px;
        		display: inline-block;
        	}
        	.btn-blank,.btn-blank:focus {
        		border: 1px solid #fff;
        		color: #878787;
        		background-color: #F7F5FB;
        	}
        	.tr {text-align: right;}
        	.container input {text-align: left;font-size: 22px;}
        	input::-ms-input-placeholder {
        		color: #878787;
        	}
        	input::-moz-input-placeholder {
        		color: #878787;
        	}
        	input::-webkit-input-placeholder {
        		color: #878787;
        	}
        	input::input-placeholder {
        		color: #878787;
        	}
        	.margin0 {margin: 0 auto;width: 410px;}
        </style>
</head>
<body >
	<input type="hidden" id="TenantId" name="TenantId" value=""/>
	<div id="loginform" class="clearfix">
    <form class="form form-horizontal" action="<%=basePath%>menu/first.do?parentId=0" method="post" id="form_add" name="Form1" onsubmit="return false;">
    <input type="hidden" id="tag" value=""/>
	<div class="container">
		<div class="margin0">
			<img class="logo" src="images/index/pc_logo.png"/>
			<h1 id="greetings">上午好！</h1>
			<p class="text">欢迎来到花生投后台管理系统</p>
			<input id="username" name="username" type="text" placeholder="用户名" class="btn btn-blank"
                           onkeydown=KeyDown()>
            <input id="password" name="passowrd" type="password" placeholder="密码" class="btn btn-blank" 
                           onkeydown=KeyDown()>
			<div class="">
			<input id="smscode" name="smscode" type="text" placeholder="验证码" class="btn-small btn-blank"
				   onkeydown=KeyDown()>
				<button class="btn btn-border" id="smscode_t" name="btnsmscode" onclick="sendMessage()">获取验证码</button>
			</div>
			<div class="">
				<button class="btn btn-color" id="submit_t" name="btnsubmit">登录</button>
				<button id="cz" name="reset1"  onclick="resert()" class="btn btn-border">重置</button>
			</div>
		</div>
	</div>
	</form>
	<div class="container-right">
		<img src="images/index/pc_bg_icon.png"/>
	</div>
	</div>
<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.md5.js"></script>
	<script type="text/javascript">
		function KeyDown() {
	        if (event.keyCode == 13) {
	            event.returnValue = false;
	            event.cancel = true;
	            Form1.btnsubmit.click();
	        }
	    }
		function resert(){
			$("input").val("");
		}
		 $(function(){
			 var myDate = new Date();
			 var hours = myDate.getHours()  ;
			 if(hours >= 12){
				 $("#greetings").html("下午好");
			 }else{
				 $("#greetings").html("上午好");
			 }
        $("#submit_t").click(function () {
            //判断参数
            var username = $("#username").val();
            var password1 = $("#password").val();
            var smscode = $("#smscode").val();
            if (username == '') {
                layer.msg("用户名不能为空")
                return false;
            }
            if (password1 == '') {
                layer.msg("密码不能为空")
                return false;
            }
            if (password1.length < 6) {
                layer.msg("密码最少6位数！");
                return false;
            }
            if (smscode == '') {
                layer.msg("验证码不能为空")
                return false;
            }
            var password = $.md5(password1);
            $.ajax({
                type: "post",
                data: {"userName": username, "password": password, "password2": smscode},
                url: '<%=basePath%>user/login.do',
                async: false,
                success: function (data) {
                    if (data.resultstrcode == "0000") {
                    	window.location = "<%=basePath%>menu/first.do?parentId=0";
                    } else if (data.resultstrcode == "1000") {
                        window.location = "<%=basePath%>change_password.jsp";
                    } else if (data.resultstrcode == "0002") {
                        layer.msg("用户名密码或者验证码错误！");
                        return false;
                    } else if (data.resultstrcode == "0018") {
                        layer.msg("输入密码次数过多，请24小时后！");
                        return false;
                    }else {
                        layer.msg("登录失败重新登录！");
                        return false;
                    }
                }
            });
        })
    })

        var InterValObj; //timer变量，控制时间
        var count = 60; //间隔函数，1秒执行
        var curCount;//当前剩余秒数
        //发送验证码
        function sendMessage() {
            var dealType; //验证方式
            var username=$("#username").val();//电话号
            var password1 = $("#password").val();
            var smscode = $("#smscode").val();
            if (username == '') {
                layer.msg("用户名不能为空")
                return false;
            }
            if (password1 == '') {
                layer.msg("密码不能为空")
                return false;
            }
            if (password1.length < 6) {
                layer.msg("密码最少6位数！");
                return false;
            }
            var password = $.md5(password1);
            var data = "username="+username+"&password="+password;
            $.ajax({
                url: '<%=basePath%>user/getsmscode.do',
                type: "GET",
                async: false,
                contentType: "application/json;charset=utf-8",
                data: data,
                timeout: 600000,
                success: function(data) {
                    if(data.resultstrcode == "0000"){
                    } else if (data.resultstrcode == "0002") {
                        layer.msg("用户名或者密码错误！");
                        return false;
                    } else if (data.resultstrcode == "0018") {
                        layer.msg("输入密码次数过多，请24小时后！");
                        return false;
                    }else {
                        layer.msg("发送验证码错误！");
                        return false;
                    }
                },
                error:function(e){
                    layer.msg("发送验证码错误！");
                    return false;
                }
            });


            var dataString="";
            curCount = count;
            //设置button效果，开始计时
            $("#smscode_t").attr("disabled", "true");
            $("#smscode_t").html( + curCount + "秒再获取");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
            //向后台发送处理数据
        };
        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);//停止计时器
                $("#smscode_t").removeAttr("disabled");//启用按钮
                $("#smscode_t").html("重新发送");
                code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
            }else {
                curCount--;
                $("#smscode_t").html( + curCount + "秒再获取");
            }
        };
	</script>
</body>
</html>
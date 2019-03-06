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
		<title>花生投统计数据</title>
		<script src="<%=basePath%>js/zepto.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>js/global.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			 html,body{
                min-width:100%;
                min-height:100%;
                background:#f7f7f7;
                font-family: -apple-system-font, "Helvetica Neue", sans-serif;
                background: url(<%=basePath%>images/index/app_bg_icon.png) no-repeat;
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
            	position: relative;
            	margin: 0 auto;
            	padding: 1.25rem 3.375rem;
            	color: #fff;
            	font-size: .875rem;
            	text-align: center;
            }
            h1 {
            	font-size: 1.25rem;
            	margin: 2rem 0 1.25rem;
            }
            .text {
            	margin-bottom: 2.8rem;
            }
            .logo {
            	height: 2.1rem;
            	width: auto;
            }
            .btn {
        		height: 2.1rem;
        		width: 100%;
        		border-radius: 3.125rem;
        		-webkit-border-radius: 3.125rem;
        		-moz-border-radius: 3.125rem;
        		text-align: center;
        		vertical-align: middle;
        		font-size: 1rem;
        		margin-bottom: 1.125rem;
        		padding: 0 1rem;
        	}
        	.btn-color {
        		background: #fff;
        		color: #8095fc;
        		margin-top: .34rem;
        	}
        	.btn-blank,.btn-blank:focus {
        		border: 1px solid #fff;
        		color: #fff;
        		background-color: #8095fc;
        	}
        	.tr {text-align: right;}
        	.container input {text-align: left;font-size: .8125rem;}
        	input::-ms-input-placeholder {
        		color: #fff;
        	}
        	input::-moz-input-placeholder {
        		color: #fff;
        	}
        	input::-webkit-input-placeholder {
        		color: #fff;
        	}
        	input::input-placeholder {
        		color: #fff;
        	}
        	input.btn {width: 88%;}
        </style>
</head>
<body >
<input type="hidden" id="TenantId" name="TenantId" value=""/>
	<div class="container">
		<img class="logo" src="<%=basePath%>images/index/app_logo.png"/>
		<h1 id="greetings">上午好！</h1>
		<p class="text">欢迎来到花生投后台管理系统</p>
		<form class="form form-horizontal" action="" method="post" id="form_add" name="Form1" onsubmit="return false;">
       <input type="hidden" id="tag" value=""/>
       <input id="username" name="username" type="text" placeholder="用户名" class="btn btn-blank"
                           onkeydown=KeyDown()>
        <input id="password" name="passowrd" type="password" placeholder="密码" class="btn btn-blank"
                           onkeydown=KeyDown()>
		<button class="btn btn-color" id="submit_t" name="btnsubmit">登录</button>
		<p id="cz" name="reset1" onclick="resert()" class="tr">重置</p>
		</form>
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
		  $(function () {
			  
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
            $.ajax({
                type: "post",
                data: {"userName": username, "password": password},
                url: '<%=basePath%>user/login.do',
                async: false,
                success: function (data) {
                    if (data.resultstrcode == "0000") {
                        window.location = "<%=basePath%>menu/first.do?parentId=0";
                    } else if (data.resultstrcode == "0002") {
                        layer.msg("用户名或者密码错误！");
                    } else {
                        layer.msg("登录失败重新登录！");
                    }
                }
            });
        })


    })
	</script>
</body>
</html>
﻿﻿
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String id = request.getParameter("id");
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
    <script type="text/javascript" src="<%=basePath%>js/html5shiv.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/respond.min.js"></script>
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
    <!--/meta 作为公共模版分离出去-->

    <title>花生理财后台管理系统</title>
<body>

<article class="page-container">

    <form id="ChangePassword" method="post" class="form form-horizontal">
        <div class="row cl">
            <input type="text" class="input-text" value='${sessionScope.user.id}' hidden="true" placeholder="" id="id" name="id">

            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value='${sessionScope.user.userName}' readonly="true" placeholder="" id="userName" name="userName">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>旧密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" value="" placeholder="" id="oldpass" name="oldpass">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" value="" placeholder="" id="newpass" name="newpass">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认新密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" value="" placeholder="" id="newpassConfirm" name="newpassConfirm">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" id="submit_t" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>


<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.md5.js"></script>
<script type="text/javascript">


    $(function () {
        // 添加验证方法：至少包含两种规则
        $.validator.addMethod("strongPsw", function(value, element) {
            if(passwordLevel(value) <= 2){return false;}
            return true
        }, "密码应包含英文字母大小写和数字");

        $("#ChangePassword").validate({
            rules: {
                oldpass: {
                    required: true,
                    minlength: 6,
                    maxlength: 16
                },
                newpass: {
                    required: true,
                    minlength: 8,
                    maxlength: 16,
                    strongPsw: true    //密码强度
                },
                newpassConfirm: {
                    required: true,
                    minlength: 8,
                    maxlength: 16

                },
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",

            submitHandler: function () {
                var newpass = $("#newpass").val();
                var userName = $("#userName").val();
                var oldpass = $("#oldpass").val();
                var id = $("#id").val();
                var newpassConfirm = $("#newpassConfirm").val();
                if (newpass != newpassConfirm) {
                    layer.msg("俩次输入的密码不相同，请重新输入");
                    return false;
                }
                if (newpass == oldpass) {
                    layer.msg("新密码与旧密码一致");
                    return false;
                }
                if (confirm("请确认信息是否准确")) {
                    var fromdate = {
                        "userName": userName,
                        "id":id,
                        "password": $.md5(oldpass),
                        "password2": $.md5(newpass),
                        "updator":userName
                    };
                    $.ajax({
                        type: 'POST',
                        data: JSON.stringify(fromdate),
                        url: '/user/editPassword.do',
                        contentType: 'application/json;charset=utf-8',
                        success: function (data) {
                            if (data.resultstrcode == "0000") {
                                layer.msg(data.msg);
                                setTimeout("window.parent.location.reload()",1000);
                                setTimeout("top.location.href = '/login.jsp'",1000);
                            } else {
                                layer.alert(data.msg);
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            if(XMLHttpRequest.status == 502){
                                layer.alert("服务器暂停，请服务器恢复后再试"+XMLHttpRequest.status)
                            }else if(XMLHttpRequest.status == 500){
                                layer.alert("返回结果异常，请联系后台"+XMLHttpRequest.status)
                            }else if (XMLHttpRequest.status == 401) {
                                layer.alert("登录超时，请重新登录"+XMLHttpRequest.status)
                                top.location.href = '/login.jsp';
                            }else{
                                layer.alert("未知错误，请联系后台"+XMLHttpRequest.status)
                            }

                        }

                    })
                }
            }
        });
    });

    function passwordLevel(password) {
        var Modes = 0;
        for (i = 0; i < password.length; i++) {
            Modes |= CharMode(password.charCodeAt(i));
        }
        return bitTotal(Modes);

        //CharMode函数
        function CharMode(iN) {
            if (iN >= 48 && iN <= 57)//数字
                return 1;
            if (iN >= 65 && iN <= 90) //大写字母
                return 2;
            if ((iN >= 97 && iN <= 122) || (iN >= 65 && iN <= 90)) //大小写
                return 4;
        }

        //bitTotal函数
        function bitTotal(num) {
            modes = 0;
            for (i = 0; i < 4; i++) {
                if (num & 1) modes++;
                num >>>= 1;
            }
            return modes;
        }
    }

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
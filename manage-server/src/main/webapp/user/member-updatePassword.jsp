<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/6 0006
  Time: 下午 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String id = request.getParameter("id");
%>
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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>修改密码</title>
    <STYLE type="text/css">
        .input_width {
            width: 300px;
        }
    </STYLE>
</head>
<body>
<article class="page-container">
    <form action="" method="post" class="form form-horizontal" id="form-member-update-password">
        <input type="hidden" id="tag" value=""/>
        <input type="hidden" name="userId" id="userId"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>旧密码：</label>
            <div class="formControls col-xs-8 col-sm-9 input_width">
                <input type="password" class="input-text" value="" placeholder="" id="password" name="password">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
            <div class="formControls col-xs-8 col-sm-9 input_width">
                <input type="password" class="input-text" value="" placeholder="" id="newpass" name="newpass">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
            <div class="formControls col-xs-8 col-sm-9 input_width">
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

<!--_footer 作为公共模版分离出去-->
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
    $(function () {
        var id = '<%=id%>'
        $("#colonid").val(id);
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#password2").blur(function () {

        });

        // 添加验证方法：至少包含两种规则
        $.validator.addMethod("strongPsw", function(value, element) {
            if(passwordLevel(value) <= 2){return false;}
            return true
        }, "密码应包含英文字母大小写和数字");
        $("#form-member-update-password").validate({
            rules: {
                password: {
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
                var password1 = $("#newpass").val();
                var password2 = $("#newpassConfirm").val();
                if (password1 != password2) {
                    layer.msg("俩次输入的密码不相同");
                    return false;
                }
                var password = $("#password").val();
                var password = $.md5(password);
                var password2 = $.md5(password2);
                var id = '<%=id%>'
                var formdate = {
                    "password": password,
                    "password2": password2,
                    "id": id
                };
                $.ajax({
                    type: 'post',
                    data: JSON.stringify(formdate),
                    dataType: "json",
                    contentType: "application/json",
                    url: '<%=basePath%>user/updatePassword.do',
                    success: function (data) {
                        if (data.resultstrcode == "0000") {
                            alert("修改成功");
                            window.parent.location.reload();
                        } else {
                            layer.msg("旧密码错误，请重新输入");
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        if (XMLHttpRequest.status == 401) {
                            alert("登录超时,请重新登录");
                            top.location.href = '/login.jsp';
                        }
                    }
                });
            }
        })
        ;

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
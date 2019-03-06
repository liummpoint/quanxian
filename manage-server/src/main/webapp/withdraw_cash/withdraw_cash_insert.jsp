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

    <title>新增申请提现</title>
    <style>
        .widthSty{
            width: 400px;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form action="<%=basePath%>" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>真实姓名：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" value="" placeholder="" id="realname" name="realname"  >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>身份证号：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
				<input  type="text" class="input-text" value="" placeholder="" id="idCardNo" name="idCardNo" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>银行卡号：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="bankCardNo" name="bankCardNo">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开户行：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="openCard" name="openCard">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机号：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="cellphone" name="cellphone">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3 widthSty">
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
<script type="text/javascript">
    $(function () {


        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });




        $("#form-member-add").validate({

            rules: {
                realname: {
                    required: true,
                    minlength: 2,
                    maxlength: 16
                },
                idCardNo: {
                    required: true,
                    minlength: 1,
                    maxlength: 18
                },
                cellphone: {
                    required: true,
                    isMobile: true,
                },
                bankCardNo: {
                    required: true,
                    minlength: 2,
                    maxlength: 32
                },
                openCard: {
                    required: true,
                    minlength: 2,
                    maxlength: 32
                }

            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                var realname = $("#realname").val();
                var idCardNo = $("#idCardNo").val();
                var bankCardNo = $("#bankCardNo").val();
                var openCard = $("#openCard").val();
                var cellphone = $("#cellphone").val();
                $.ajax({
                    type: 'POST',
                    data: {
                        "bizUserId":"11",
                        "realname":realname,
                        "idCardNo":idCardNo,
                        "bankCardNo": bankCardNo,
                        "openCard": openCard,
                        "cellphone": cellphone
                    },
                    url: '<%=basePath%>withdrawCash/insertWithdrawCash.do',
                    dataType: "json",
                    success: function (data) {
                        if (data.resultstrcode == "0000") {
                            alert("新增成功");
                            window.parent.location.reload();
                        } else {
                            layer.msg("新增失败!");
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

    });
</script>

<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
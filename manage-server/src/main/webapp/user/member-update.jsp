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

    <title>添加用户</title>
    <style>
        .widthSty{
            width: 400px;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form action="<%=basePath%>" method="post" class="form form-horizontal" id="form-member-add">
        <input type="hidden" id="tag" value=""/>
        <input type="hidden" name="userId" id="userId"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" value="" placeholder="" id="name" name="name" readonly="true">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户角色：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty"> <span class="select-box">
				<select class="select" size="1" name="userRole" id="userRole">
                    <option value="">请选择角色</option>
				</select>
				</span></div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="mobile" name="mobile">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" placeholder="@" name="email" id="email">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <textarea name="remark" cols="" rows="" id="remark" class="textarea" placeholder="说点什么...最少输入10个字符"
                          onKeyUp="$.Huitextarealength(this,100)"></textarea>
                <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
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
        var id = '<%=id%>';
        $("#userId").val(id);
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $.ajax({
            type: "post",
            url: '<%=basePath%>user/selectUserRole.do',
            contentType: 'application/json;charset=utf-8',
            async: false,
            success: function (data) {
                var options = '';
                for (var i = 0; i < data.rows.length; i++) {
                    options += '<option value="' + data.rows[i].roleId + '">' + data.rows[i].roleName + '</option>';
                }
                $("#userRole").append(options);
            }
        });
        $.ajax({
            type: 'post',
            data: {"id": id},
            dataType: 'json',
            async: false,
            url: '<%=basePath%>user/selectById.do',
            success: function (data) {
                $("#name").val(data.data.userName);
                $("#mobile").val(data.data.mobile);
                $("#email").val(data.data.email);
                $("#remark").val(data.data.remark);
                var roleId = data.data.roleId;
                $("select[name=userRole] option").each(function () {
                    if ($(this).val() == roleId) {
                        $(this).attr('selected', 'selected');
                    }
                })
            }
        })


        $("#form-member-add").validate({

            rules: {
                username: {
                    required: true,
                    minlength: 2,
                    maxlength: 16
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 16
                },
                mobile: {
                    required: true,
                    isMobile: true,
                },
                email: {
                    required: true,
                    email: true,
                },
                uploadfile: {
                    required: true,
                },

            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                var name = $("#name").val();
                var mobile = $("#mobile").val();
                var email = $("#email").val();
                var remark = $("#remark").val();
                var roleId = $("#userRole").val();
                if (roleId == '') {
                    alert("请添加角色信息！");
                    return false;
                }
                var fromdate = {
                    "userName": name,
                    "mobile": mobile,
                    "email": email,
                    "remark": remark,
                    "id": id,
                    "roleId": roleId
                };
                $.ajax({
                    type: 'POST',
                    data: JSON.stringify(fromdate),
                    url: '<%=basePath%>user/updateUser.do',
                    contentType: 'application/json;charset=utf-8',
                    success: function (data) {
                        if (data.resultstrcode == "0000") {
                            alert("修改成功");
                            window.parent.location.reload();
                        } else {
                            layer.msg("修改失败!");
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
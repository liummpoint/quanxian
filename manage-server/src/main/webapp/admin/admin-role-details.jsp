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

</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-admin-role-edit">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" readonly="true" id="roleName" name="roleName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" readonly="true" placeholder="" id="remark" name="remark">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">网站角色：</label>
			<div class="formControls col-xs-8 col-sm-9" id="menuList">


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
<script type="text/javascript">


    $(function () {
        var id = '<%=id%>';
        $.ajax({
            type: 'POST',
            url: '/role/findMenu.do',
            success: function (data) {

                if (data.resultstrcode == "0000") {

                    for (var i = 0; i < data.rows.length; i++) {
                        var str = "";

                        if (data.rows[i].parentId == 0) {
                            str += "<dl class=\"permission-list\">";
                            str += "<dt><label>";
                            str += "<input type=\"checkbox\"   disabled=\"disabled\" value=" + data.rows[i].id + " name =\"check\" onclick =\"allselect(this)\" id=" + data.rows[i].id + ">" + data.rows[i].name;
                            str += "</label></dt>"
                            str += "<dd><dl class=\"cl permission-list2\">"
                            for (var j = 0; j < data.rows.length; j++) {
                                if (data.rows[j].parentId == data.rows[i].id) {
                                    str += "<label class=\"\">";
                                    str += "<input type=\"checkbox\" disabled=\"disabled\"  value=" + data.rows[j].id + " onclick =\"selectChild(this)\" name=\"check\" id=" + data.rows[j].id + ">" + data.rows[j].name;
                                    str += "</label><dd>";
                                    for (var k = 0; k < data.rows.length; k++) {
                                        if (data.rows[k].parentId == data.rows[j].id) {
                                            str += "<label class=\"\">";
                                            str += "<input type=\"checkbox\" disabled=\"disabled\"  value=" + data.rows[k].id + " onclick =\"selectChildItem(this)\" name=\"check\" id=" + data.rows[k].id + ">" + data.rows[k].name + "";
                                            str += "</label>";
                                        }
                                    }
                                    str += "</dd>";
                                }
                            }
                            str += "</dl>";
                            str += "</dd>";
                            str += "</dl>"
                        }
                        $('#menuList').append(str);
                    }

                    //layer.alert(id)
                    $.ajax({
                        type: 'post',
//                        data: JSON.stringify({"id":id}),
                        url: '/role/findAdminRoleById/' + id + '.do',
                        contentType: 'application/json;charset=utf-8',
                        success: function (data) {
                            $("#roleName").val(data.rows[0].roleName)
                            $("#remark").val(data.rows[0].remark);
                            //$("#websiteRole").val(data.rows[0].websiteRole);
                            var str = data.rows[0].websiteRole;
                            var strs = str.split(",");
                            var id = "";
                            for (var i = 0; i < strs.length; i++) {

                                id = strs[i].replace(/-/g, '');
                                // alert(id);
                                $('#' + id).attr("checked", true);
                            }

                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            alert("登录超时,请重新登录")
                            if (XMLHttpRequest.status == 401) {
                                top.location.href = '/login.jsp';
                            }
                        }

                    })

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("登录超时,请重新登录")
                if (XMLHttpRequest.status == 401) {
                    top.location.href = '/login.jsp';
                }
            }
        })


    });




</script>
</body>
</html>
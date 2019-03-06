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

    <title>修改菜单配置</title>
    <style>
        .widthSty{
            width: 400px;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form  method="post" class="form form-horizontal" id="form-menu-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单名称：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" value="" placeholder="" id="name" name="name"  >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单类别：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty"> <span class="select-box">
				<select class="select"   name="type" id="type">
                    <option value="0">菜单</option>
                    <option value="1">按钮</option>
				</select>
				</span>
            </div>

        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"> 菜单链接地址：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" value="" placeholder="" id="url" name="url"  >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单等级：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty"> <span class="select-box">
				<select class="select" size="1" name="menuGrade" id="menuGrade">
                    <option value="1">一级菜单</option>
                    <option value="2">二级菜单</option>
                    <option value="3">三级菜单</option>
				</select>
				</span>
            </div>

        </div>
        <div class="row cl" id="parentMenu_div">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>父1级菜单：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty"> <span class="select-box">
				<select class="select" size="1" name="parentMenu" id="parentMenu">
				</select>
				</span>
            </div>

        </div>
        <div class="row cl" id="parent2Menu_div">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>父2级菜单：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty"> <span class="select-box">
				<select class="select" size="1" name="parent2Menu" id="parent2Menu">
				</select>
				</span>
            </div>

        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"> 菜单图标：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" style="width: 200px;" value="" placeholder="" id="icon" name="icon"  >
                <a href="http://www.h-ui.net/Hui-3.7-Hui-iconfont.shtml" target="_blank">图标库</a>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>session键值：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="sessionKey" name="sessionKey">
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
        $("#parentMenu_div").hide()
        $("#parent2Menu_div").hide()
        $("#menuGrade").on('change',function () {
            parentMenu($(this).val());
        });
        $("#parentMenu").on('change',function () {
            loadParentMenu($(this).val(),"parent2Menu")
        });
        $("#form-menu-add").validate({

            rules: {
                name: {
                    required: true,
                    minlength: 1,
                    maxlength: 20
                },
                url: {
                    required: false,
                    minlength: 1,
                    maxlength: 255
                },
                sort: {
                    required: true,
                    minlength: 1,
                    maxlength: 5
                },
                icon: {
                    required: false,
                    minlength: 1,
                    maxlength: 255
                },
                sessionKey: {
                    required: true,
                    minlength: 1,
                    maxlength: 255
                },

            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                var name = $("#name").val();
                var url = $("#url").val();
                var sort = $("#sort").val();
                var icon = $("#icon").val();
                var sessionKey = $("#sessionKey").val();
                var menuGrade = $("#menuGrade").val();
                var type= $("#type").val();
                var parentId="";
                if(menuGrade == 2){
                    var parentMenu = $("#parentMenu").val();
                    if(parentMenu == ''){
                        alert("请选择父1级菜单");
                        return false;
                    }
                    parentId=parentMenu;
                }else if(menuGrade == 3){
                    var parentMenu = $("#parentMenu").val();
                    if(parentMenu == ''){
                        alert("请选择父1级菜单");
                        return false;
                    }
                    var parent2Menu = $("#parent2Menu").val();
                    if(parent2Menu == ''){
                        alert("请选择父2级菜单");
                        return false;
                    }
                    parentId=parent2Menu;
                }
                var fromdate = {
                    "name": name,
                    "url": url,
                    "sort": sort,
                    "icon": icon,
                    "sessionKey": sessionKey,
                    "menuGrade": menuGrade,
                    "parentId": parentId,
                    "type":type
                };
                $.ajax({
                    type: 'POST',
                    data: JSON.stringify(fromdate),
                    url: '<%=basePath%>menu/addMenu.do',
                    contentType: 'application/json;charset=utf-8',
                    success: function (data) {
                        if (data.resultstrcode == "0000") {
                            alert("添加成功");
                            window.parent.location.reload();
                        } else {
                            layer.msg("添加失败!");
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
    })


    function parentMenu(menuGradeValue) {
        if(menuGradeValue == 1){
            $("#parentMenu_div").hide()
            $("#parent2Menu_div").hide()
        }else if(menuGradeValue == 2){
            $("#parentMenu_div").show()
            $("#parent2Menu_div").hide()
            loadParentMenu(0,"parentMenu")
        }else if(menuGradeValue == 3){
            $("#parentMenu_div").show()
            $("#parent2Menu_div").show()

            $.ajax({
                type: 'post',
                data: {"id": 0},
                dataType: 'json',
                async: false,
                url: '<%=basePath%>menu/menuOne.do',
                success: function (data) {
                    loadParentMenu(0,"parentMenu")//加载1级菜单
                }
            })
        }
    }
    function loadParentMenu(parentId,id){
        $.ajax({
            type: 'post',
            data: {parentId:parentId},
            dataType: 'json',
            async: false,
            url: '<%=basePath%>menu/byParentId.do',
            success: function (data) {
                $("#"+id).empty();
                $("#"+id).prepend("<option value=''>请选择</option>");//添加第一个option值
                for (var i = 0; i < data.rows.length; i++) {
                    //如果在select中传递其他参数，可以在option 的value属性中添加参数
                    $("#"+id).append("<option value='"+data.rows[i].id+"'>"+data.rows[i].name+"</option>");

                }
            }
        })
    }
</script>

<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
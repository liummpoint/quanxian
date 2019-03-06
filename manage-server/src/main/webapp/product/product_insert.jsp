<%--
  Created by IntelliJ IDEA.
  User: liumingming
  Date: 2019-03-02
  Time: 15:51
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

    <title>新增产品</title>
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
        <input type="hidden" name="status" id="status" value="1"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>产品类型：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" value="" placeholder="" id="productType" name="productType"  >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>产品名称：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input  type="text" class="input-text" value="" placeholder="" id="productName" name="productName" >
            </div>
        </div>
        <!--
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图片：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="pictureUrl" name="pictureUrl">
            </div>
        </div>
        -->
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3" ><span style="padding-right:50px;"></span> <span class="c-red" >*</span>图片：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="file" name="pictureUrl" id="pictureUrl" value="上传图片" on/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>链接：</label>
            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input type="text" class="input-text" value="" placeholder="" id="link" name="link">
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
                productType: {
                    required: true,
                    minlength: 1,
                    maxlength: 1
                },
                productName: {
                    required: true,
                    minlength: 1,
                    maxlength: 100
                },
                pictureUrl: {
                    required: true,
                    checkPic:true
                },
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                var productType = $("#productType").val();
                var productName = $("#productName").val();
                var pictureUrl = $("#pictureUrl").val();
                var link = $("#link").val();
                var status = $("#status").val();

                $.ajax({
                    type: 'POST',
                    data: {"productType": productType,"productName": productName,"pictureUrl": pictureUrl,"link": link,"status": status,
                    "createTime":"15310198091","updateTime":"15310198091"},
                    url: '<%=basePath%>product/insertProduct.do',
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

    jQuery.validator.addMethod("checkPic", function (value, element) {

        var filepath = $("#pictureUrl").val();
        //获得上传文件名
        var fileArr = filepath.split("\\");
        var fileTArr = fileArr[fileArr.length - 1].toLowerCase().split(".");
        var filetype = fileTArr[fileTArr.length - 1];
        //切割出后缀文件名
        if (filetype == "jpg" || filetype == "png"){
            return true;
        } else {
            return false;
        }

    }, "上传图片格式不适合");
</script>

<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>

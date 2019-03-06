﻿﻿﻿
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
    <form  method="post" class="form form-horizontal" id="form-findPage-add"  onsubmit="return false;">
        <input type="hidden" id="tag" value=""/>
        <input type="hidden" name="activityType" id="activityType"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                    class="c-red">*</span>标题：</label>

            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input class="input-text"
                       name="title" id="title"
                       placeholder="标题">
            </div>

        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;子标题：</label>

            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input class="input-text"
                       name="subTitle" id="subTitle"
                       placeholder="子标题">
            </div>

        </div>

         <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                    class="c-red">*</span>预设开始时间：</label>

            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input class="Wdate"
                       onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm',minDate:'new date()',maxDate:'#F{$dp.$D(\'endTime\')}'})"
                       name="startTime" id="startTime"
                       placeholder="选择时间">
            </div>

        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                    class="c-red">*</span>预设结束时间：</label>

            <div class="formControls col-xs-8 col-sm-9 widthSty">
                <input class="Wdate"
                       onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime\')}'})"
                       name="endTime" id="endTime"
                       placeholder="选择时间">
            </div>
        </div> 
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
                    class="c-red"></span>URL：</label>

            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="200个字符以内" id="jumpUrl" name="jumpUrl">
            </div>
        </div>


       <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3" ><span style="padding-right:50px;"></span> <span class="c-red" >*</span>图片</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="file" name="file" id="file" value="上传图片" on/>
            </div>
        </div>
        <div class="formControls col-xs-8 col-sm-9">
            <input type="text" class="input-text" value='${sessionScope.user.userName}' hidden readonly="true"
                   placeholder="" id="createor" name="createor">
        </div>

         
         <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" id="submit_t" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                <button class="btn btn-primary radius" id="button" onclick="cancel()"
                        value="&nbsp;&nbsp;取消&nbsp;&nbsp;">取消
                </button>
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
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">


    $(function () {
        var id = '<%=id%>';
        $("#activityType").val(id);

        $("#form-findPage-add").validate({
		rules: {
                startTime: {
                    required: true,
                },
                endTime: {
                    required: true,
                },
                JumpUrl: {
                    required: true,
                    maxlength: 200
                },
                title: {
                    required: true,
                    maxlength: 30
                },
                startTime: {
                    required: true,
                },
                file: {
                    required: true,
                    checkPic:true
                },


            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                
                var formData = new FormData($("#form-findPage-add")[0]);
                $.ajax({

                    url: '/bannernew/insertBanner.do',
                    type: 'POST',
                    contentType: "application/json;charset=utf-8",
                    data: formData,
                    async: true,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (returndata) {
                    	layer.alert(returndata.msg);
                    	if (returndata.resultstrcode=="0000"){
                            window.parent.find(id,"/bannernew/bannerList.do")
                            layer_close();
//                          window.parent.find(id,"/bannernew/bannerList.do")
//                    	    setTimeout("window.parent.find(id,\"/bannernew/bannerList.do\")",500);
                    	}
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        if (XMLHttpRequest.status == 502) {
                            layer.alert("服务器暂停，请服务器恢复后再试" + XMLHttpRequest.status)
                        } else if (XMLHttpRequest.status == 500) {
                            layer.alert("返回结果异常，请联系后台" + XMLHttpRequest.status)
                        } else if (XMLHttpRequest.status == 401) {
                            layer.alert("登录超时，请重新登录" + XMLHttpRequest.status)
                            top.location.href = '/login.jsp';
                        } else {
                            layer.alert("未知错误，请联系后台" + XMLHttpRequest.status)
                        }
                    }
                });
                
                
                
            }
        });

    });

    function cancel() {
        layer_close();
    }

    jQuery.validator.addMethod("checkPic", function (value, element) {

        var filepath = $("#file").val();
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
</body>
</html>
﻿﻿﻿
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <script type="text/javascript" src="js/respond.min.js"></script>
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
    <title>菜单管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span
        class="c-gray en">&gt;</span> 菜单管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">

    <%--<label id="zj">45456546456546</label>--%>
    <div id="">
        <label>查询条件：</label>
        <span class="select-box" style="height: 25px;width: 200px;border-radius:2px;">
				<select class="select" size="1" name="query" id="query">
                    <option value="0">根据菜单名称查询</option>
                    <option value="1">根据一级菜单查询</option>
				</select>
				</span>
        <div style="width:300px; height:auto;  display:inline" id="namediv">
        <label>菜单名称：</label>
        <input name="menuname" id="menuname" placeholder="菜单名称" class="input-text radius size-S"
               style="height: 25px;width: 200px;border-radius:2px;"
               value=""/>&nbsp;&nbsp;
        </div>
        <div style="width:300px; height:auto;  display:inline" id="menudiv">
        <label>父级菜单：</label>
        <span class="select-box" style="height: 25px;width: 200px;border-radius:2px;">
				<select class="select" size="1" name="parentMenu" id="parentMenu">
				</select>
				</span>
        </div>

        <button class="btn btn-primary radius" onclick="query()"> 查询</button>
        <input type="button" class="btn btn-primary radius" onclick="add()" value="新增">
    </div>


    <div class="mt-20">
        <!-- class="table-responsive"：设置响应式设计 -->

        <table id="table" class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr>
                <th width="60" height="20" nowrap="nowrap">&nbsp;&nbsp;序号&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;菜单名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;菜单链接地址&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;父级&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;排序&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;菜单图标&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;session键值&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;创建时间&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th width="150" nowrap="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;&nbsp;</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>

    </div>

</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


    var CONSTANT = {
        DATA_TABLES: {
            DEFAULT_OPTION: { //DataTables初始化选项
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "每页 _MENU_ 项",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
                    "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页",
                        "sJump": "跳转"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },
                "fnDrawCallback": function () {
                    this.api().column(0).nodes().each(function (cell, i) {
                        cell.innerHTML = i + 1;
                    });
                },
                destroy: true,
                ordering: false,
                autoWidth: false,   //禁用自动调整列宽
                stripeClasses: ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合
                order: [],          //取消默认排序查询,否则复选框一列会出现小箭头
                processing: false,  //隐藏加载提示,自行处理
                serverSide: true,   //启用服务器端分页
                searching: false    //禁用原生搜索
            },
            COLUMN: {
                CHECKBOX: { //复选框单元格
                    className: "td-checkbox",
                    orderable: false,
                    width: "30px",
                    data: null,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" class="iCheck">';
                    }
                }
            },
            RENDER: {   //常用render可以抽取出来，如日期时间、头像等
                ELLIPSIS: function (data, type, row, meta) {
                    data = data || "";
                    return '<span title="' + data + '">' + data + '</span>';
                }
            }
        }
    };
    $(function () {
        $("#menudiv").hide()
        $("#query").on('change',function () {
            parentMenu($(this).val());
        });
        find();
    });

    function parentMenu(menuGradeValue) {
        if(menuGradeValue == 0){
            $("#menudiv").hide();
            $("#parentMenu").empty();
            $("#namediv").show();
        }else if(menuGradeValue == 1) {
            $("#menudiv").show();
            $("#namediv").hide();
            $("#menuname").val(""),
            $.ajax({
                type: 'post',
                data: {parentId: 0},
                dataType: 'json',
                async: false,
                url: '<%=basePath%>menu/byParentId.do',
                success: function (data) {
                    $("#parentMenu").empty();
                    $("#parentMenu").prepend("<option value='0'>请选择</option>");//添加第一个option值
                    for (var i = 0; i < data.rows.length; i++) {
                        //如果在select中传递其他参数，可以在option 的value属性中添加参数
                        $("#parentMenu").append("<option value='" + data.rows[i].id + "'>" + data.rows[i].name + "</option>");

                    }


                }
            })
        }
    }

    var userManage = {
        getQueryCondition: function (data) {
            var param = {
                "startIndex": data.start,
                "pageSize": data.length,
                "draw": data.draw

            };
            return param;
        }
    };


    function find() {
        var $table = $("#table");
        var _table = $table.dataTable($.extend(true, {}, CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = userManage.getQueryCondition(data);
                var param1 = {
                    "name": $("#menuname").val(),
                    "parentId": $("#parentMenu").val()
                };
                $.ajax({
                    type: "POST",
                    url: "/menu/menuList.do",
                    cache: false,  //禁用缓存
                    data: JSON.stringify({"page": param, "menuManage": param1}),    //传入已封装的参数
                    dataType: "json",
                    async: false,
                    contentType: 'application/json;charset=utf-8',
                    success: function (data) {
                        //异常判断与处理
                        //  var data=result.data;
                        /*if (data.errorCode) {
                            alert("查询失败");
                            return;
                        }*/
                        //封装返回数据

                        var returnData = {};
                        //debugger;
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = data.total;//总记录数
                        returnData.recordsFiltered = data.total;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = data.rows;
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        console.log(returnData);
                        callback(returnData);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("登录超时,请重新登录")
                        if (XMLHttpRequest.status == 401) {
                            parent.window.location = "/login.jsp";
                        }
                    }
                });
            },
            //绑定数据
            columns: [
                {
                    data: "id",//编号
                },
                {
                    data: "name",//菜单名称
                },
                {
                    data: "url",//菜单链接地址
                },
                {
                    data: "parentName",//父级
                },
                {
                    data: "sort",//排序
                },
                {
                    data: "icon",//菜单图标
                },
                {
                    data: "sessionKey",//session键值
                },
                {
                    data: "createTime"//创建时间
                },
                {
                    data: "createTime"//操作
                }

            ],
            "createdRow": function (row, data, index) {
                //不使用render，改用jquery文档操作呈现单元格
                $('td', row).eq(5).html("<i class=\"Hui-iconfont\">" + data.icon + "</i>");
                var td_str = '<a title="修改菜单配置" href="javascript:void(0)" onclick="menuEdit(\'修改菜单配置\',\'<%=basePath%>system/menu_edit.jsp\',' + data.id + ')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>' +
                    '<a title="删除" href="javascript:;" onclick="del(' + data.id + ')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i>' + '</a>';
                $('td', row).eq(8).html(td_str);


            },
            "drawCallback": function (settings) {
                //渲染完毕后的回调
                //默认选中第一行
                //$("tbody tr",$table).eq(0).click();
            }
        })).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
    }


    function query() {
        find();
    }

    function del(id) {
        $.ajax({
            type: "POST",
            url: "/menu/delmenu/" + id + ".do",
            cache: false,  //禁用缓存
            data: JSON.stringify({"id": id}),    //传入已封装的参数
            dataType: "json",
            async: false,
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                layer.alert(data.msg);
                find();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("登录超时,请重新登录")
                if (XMLHttpRequest.status == 401) {
                    parent.window.location = "/login.jsp";
                }
            }
        });
    }

    function menuEdit(title, url, idvalue) {
        url += "?id=" + idvalue;
        layer_show(title, url, '800', '600');
    }

    function add() {
        layer_show('添加菜单', '<%=basePath%>system/menu_add.jsp', '800', '600');
    }
</script>
</body>
</html>
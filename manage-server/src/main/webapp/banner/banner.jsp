﻿﻿
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
    <style type="text/css">
        .clearfix:after {
            content: "\20";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden
        }

        .clearfix {
            zoom: 1
        }

        .tabBar {
            border-bottom: 2px solid #222
        }

        .tabBar span {
            background-color: #e8e8e8;
            cursor: pointer;
            display: inline-block;
            float: left;
            font-weight: bold;
            height: 30px;
            line-height: 30px;
            padding: 0 15px
        }

        .tabBar span.current {
            background-color: #222;
            color: #fff
        }

        .tabCon {
            display: none
        }
    </style>
    <!--[if IE 6]>
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>发现</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 发现页管理 <span
        class="c-gray en">&gt;</span> banner <a class="btn btn-success radius r"
                                                style="line-height:1.6em;margin-top:3px"
                                                href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <input type="hidden" name="activityType" id="activityType" value="0"/>
    <div id="tab_demo" class="HuiTab">

        <div class="tabBar clearfix"><span>首页banner</span><span>发现页banner</span></div>
        APP已上线数量：<b id="number1">0</b>&nbsp;&nbsp;&nbsp;预计上线数量：<b id="number2">0</b>&nbsp;&nbsp;&nbsp;<button
            class="btn btn-primary radius" onclick="insert()"> 新增
    </button>

        <div class="tabCon">

            <input type="text" id="creator" name="creator" class="input-text radius size-L"
                   value='${sessionScope.user.userName}' hidden="true"
                   style="height: 30px;width: 300px;border-radius:2px;">
            <div class="mt-20">

                <table id="table0" align="center"
                       class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                    <tr>
                        <th height="20" nowrap="nowrap">序号</th>
                        <th nowrap="nowrap" align="center" width="120px">后台上传时间</th>
                        <th nowrap="nowrap" align="center" width="350px">图片</th>
                        <th nowrap="nowrap" align="center" width="50px">状态</th>
                        <th nowrap="nowrap" align="center" width="100px">开始时间</th>
                        <th nowrap="nowrap" align="center" width="100px">结束时间</th>
                        <th nowrap="nowrap" align="center" width="80px">位置操作</th>
                        <th nowrap="nowrap" align="center" width="80px">状态操作</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>

            </div>
        </div>

        <div class="tabCon">
            <div class="mt-20">

                <table id="table1" align="center"
                       class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                    <tr>
                        <th height="20" nowrap="nowrap">序号</th>
                        <th nowrap="nowrap" align="center" width="120px">后台上传时间</th>
                        <th nowrap="nowrap" align="center" width="350px">图片</th>
                        <th nowrap="nowrap" align="center" width="50px">状态</th>
                        <th nowrap="nowrap" align="center" width="100px">开始时间</th>
                        <th nowrap="nowrap" align="center" width="100px">结束时间</th>
                        <th nowrap="nowrap" align="center" width="80px">位置操作</th>
                        <th nowrap="nowrap" align="center" width="80px">状态操作</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>

            </div>
        </div>
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

    var userManage = {
        getQueryCondition: function (id, data) {
            var param = {
                "startIndex": data.start,
                "pageSize": data.length,
                "draw": data.draw,
                "activityType": id
            };
            return param;
        }
    };


    $(function () {
        jQuery.Huitab = function (tabBar, tabCon, class_name, tabEvent, i) {
            var $tab_menu = $(tabBar);
            // 初始化操作
            $tab_menu.removeClass(class_name);
            $(tabBar).eq(i).addClass(class_name);
            $(tabCon).hide();
            $(tabCon).eq(i).show();
            find(i, "/bannernew/bannerList.do");

            $tab_menu.bind(tabEvent, function () {
                $tab_menu.removeClass(class_name);
                $(this).addClass(class_name);
                var index = $tab_menu.index(this);
                $(tabCon).hide();
                $(tabCon).eq(index).show();
                find(index, "/bannernew/bannerList.do");
                $("#activityType").val(index);
            })
        };
        $.Huitab("#tab_demo .tabBar span", "#tab_demo .tabCon", "current", "click", "0");
    })

    function find(id, url) {
//        alert(id);
        var $table = $("#table" + id);
        var _table = $table.dataTable($.extend(true, {}, CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
//            "scrollY": "100%",//整个页面的显示宽高的调整
//            "scrollX": "1300px",
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = userManage.getQueryCondition(id, data);
                $.ajax({
                    type: "POST",
                    url: url,
                    cache: false,  //禁用缓存
                    data: JSON.stringify(param),    //传入已封装的参数
                    dataType: "json",
                    contentType: 'application/json;charset=utf-8',
                    success: function (data) {
                        $("#number1").html(data.data.appOnline);
                        $("#number2").html(data.data.expectOnline);
//                        alert(JSON.stringify(data.data));
                        //封装返回数据
                        var returnData = {};

                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = data.total;//总记录数
                        returnData.recordsFiltered = data.total;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = data.rows;
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕

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
                    data: "id",//序号
                },
                {
                    data: "createTime",//后台上传时间
                },
                {
                    data: "downLoadUrl",//图片url2
                },
                {
                    data: "status",//开始时间3
                },
                {
                    data: "startTime",//开始时间3
                },
                {
                    data: "endTime",//结束时间4
                },
                {
                    "sWidth": "80px",
                    data: "",//字段名5
                    "defaultContent": ""
                },
                {
                    "sWidth": "80px",
                    data: "",//字段名6
                    "defaultContent": ""
                }
            ],
            "createdRow":

                function (row, data, index) {
                    //不使用render，改用jquery文档操作呈现单元格
//                    alert(data.downLoadUrl);
                    $('td', row).eq(2).html('<img  src=' + data.downLoadUrl + ' width="350" height="100"/>');

                    var status_str = "";
                    if (data.status == 0) {
                        status_str = "已上线";
                    } else if (data.status == 1) {
                        status_str = "已下线";
                    } else if (data.status == 2) {
                        status_str = "待上线";
                    }
                    $('td', row).eq(3).html(status_str);

                    var btnUP1 = '<a style="text-decoration:none;color: cornflowerblue;" class="ml-5" onClick="up(' + data.id + ')">上移' + '</a><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>';
                    var btnEdit = '<a style="text-decoration:none;color: cornflowerblue;" onClick="down(' + data.id + ')" >下移</a>';


                    $('td', row).eq(6).html(btnUP1 + btnEdit);

                    var update = '<a style="text-decoration:none;color: cornflowerblue;" onClick="updateTitle(' + data.id + ',' + id + ')" >修改</a><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>'
                    $('td', row).eq(7).html(update);


                },
            "drawCallback": function (settings) {
                //渲染完毕后的回调
                //默认选中第一行

            }
        })).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象

    };


    function up(id) {
        var type = $("#activityType").val();
//        alert(id);
        var url = "<%=basePath%>bannernew/upBannerPos.do?id=" + id + "&type=" + type;
        $.ajax({
            type: "POST",
            url: url,
            cache: false,  //禁用缓存
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data.result == false) {

                    layer.msg(data.errorMsg);
                    find(type, "/bannernew/bannerList.do")
                } else {
                    find(type, "/bannernew/bannerList.do")
                }
            }
        });
    }

    function down(id) {
        var type = $("#activityType").val();
//       alert(id);
        var url = "<%=basePath%>bannernew/downBannerPos.do?id=" + id + "&type=" + type;
        $.ajax({
            type: "POST",
            url: url,
            cache: false,  //禁用缓存
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
//                alert(JSON.stringify(data));
                if (data.result == false) {
                    layer.msg(data.errorMsg);
                    find(type, "/bannernew/bannerList.do")
                } else {
                    find(type, "/bannernew/bannerList.do")
                }

            }
        });
    }

    function updateTitle(id, activityType) {
        var url = "<%=basePath%>banner/banner-update.jsp?id=" + id + "&activityType=" + activityType;
        layer_show('修改', url, '', '510');
    }

    function insert() {
        var id = $("#activityType").val();
        var url = "<%=basePath%>banner/banner-insert.jsp?id=" + id;
        layer_show('新增', url, '700', '400');
    }
</script>
</body>
</html>
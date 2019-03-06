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
    <script type="text/javascript" src="<%=basePath%>lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/respond.min.js"></script>

    <script type="text/javascript" src="scripts/jquery.tmpl.js"></script>
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
    <title>花生理财后台管理系统</title>

</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span
        class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div id="tmpl" class="cl pd-5 bg-1 bk-gray">
        <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.role_add)}">
            <span class="l"> <a class="btn btn-primary radius" href="javascript:;"
                                onclick="admin_role_add('添加角色','<%=basePath%>admin/admin-role-add.jsp','800')"><i
                    class="Hui-iconfont">&#xe600;</i> 添加角色</a> </span>
        </c:if>
        <span class="r"></span></div>
    <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.role_list)}">
        <table id="table" class="table table-border table-bordered table-hover table-bg table-sort text-c">
            <thead>
            <tr>
                <th scope="col" colspan="6">角色管理</th>
            </tr>
            <tr class="text-c">

                <th width="40">ID</th>
                <th width="200">角色名</th>
                <th>创建时间</th>
                <th width="300">描述</th>
                <th width="70">操作</th>
            </tr>
            </thead>
            <tbody class="text-c" id="listEach">
            </tbody>
        </table>
    </c:if>
</div>

</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datatables/1.10.0/jquery.dataTables.min.js"></script>
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
        findall();
    })

    /*管理员-角色-添加*/
    function admin_role_add(title, url, w, h) {
        layer_show(title, url, w, h);

    }

    /*管理员-角色-编辑*/
    function admin_role_edit(title, url, idvalue) {
        url += "?id=" + idvalue;
        layer_show(title, url, '800', '600');
    }

    function admin_role_details(title, url, idvalue) {
        url += "?id=" + idvalue;
        layer_show(title, url, '800', '600');
    }

    function findall() {
        var $table = $("#table");
        var _table = $table.dataTable($.extend(true, {}, CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = Manage.getQueryCondition(data);

                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    url: '/role/findAllRole.do',
                    contentType: 'application/json;charset=UTF-8',
                    success: function (data) {

                        var returnData = {};
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
                            top.location.href = '/login.jsp';
                        }
                    }
                });

            }, columns: [
                {
                    data: "",//字段名
                    "defaultContent": ""
                },
                {
                    data: "roleName",//字段名
                },
                {
                    data: "createTime",//字段名
                },
                {
                    data: "remark",//字段名
                },
                {
                    data: "",//字段名
                    "defaultContent": ""
                }
            ],
            "createdRow": function (row, data, index) {
                var operation = "";

                <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.role_edit)}">
                operation += "<a title=\"编辑\" href=\"javascript:;\" onclick=\"admin_role_edit('角色编辑','<%=basePath%>admin/admin-role-edit.jsp','" + data.roleId + "')\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> ";
                </c:if>

                <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.role_detail)}">
                operation += "<a title=\"详情\" href=\"javascript:;\" onclick=\"admin_role_details('角色详情','<%=basePath%>admin/admin-role-details.jsp','" + data.roleId + "')\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6c6;</i></a> ";
                </c:if>

                if (data.roleName != '超级管理员') {
                    <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.role_delete)}">

                    operation += "<a title=\"删除\" href=\"javascript:;\" onclick=\"admin_role_del(this,'" + data.roleId + "')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
                    </c:if>
                }
                $('td', row).eq(4).append(operation);
            },
            "drawCallback": function (settings) {

            }
        })).api();
    }

    var Manage = {
        getQueryCondition: function (data) {
            var param = {
                "startIndex": data.start,
                "pageSize": data.length,
                "draw": data.draw

            };
            return param;
        }
    };

    /*管理员-角色-删除*/
    function admin_role_del(obj, id) {
        layer.confirm('角色删除须谨慎，确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '/role/deleteAdminRoleById/' + id + '.do',
                dataType: 'json',
                success: function (data) {
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!', {icon: 1, time: 1000});
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("登录超时,请重新登录")
                    if (XMLHttpRequest.status == 401) {
                        top.location.href = '/login.jsp';
                    }
                }
            });
        });
    }

</script>
</body>
</html>
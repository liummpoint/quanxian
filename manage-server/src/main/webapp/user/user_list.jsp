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
    <title>系统用户</title>
    <style type="text/css">
        .table-bordered th, .table-bordered td {
            border-left: 1px solid #ddd;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统用户 <span
        class="c-gray en">&gt;</span> 用户列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.user_add)}">
    <div class="cl pd-5 bg-1 bk-gray mt-20"><span class="l"><a
            href="javascript:;" onclick="member_add('添加用户','member-add.jsp','','510')" class="btn btn-primary radius"><i
            class="Hui-iconfont">&#xe600;</i> 添加用户</a></span></div>
</c:if>
<c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.user_list)}">
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort text-c " id="table">
            <thead>
            <tr class="text-c">
                <th id="id" width="80">ID</th>
                <th width="100">用户名</th>
                <th width="90">手机</th>
                <th width="150">邮箱</th>
                <th width="130">加入时间</th>
                <th width="130">用户角色</th>
                <th width="70">状态</th>
                <th width="100">操作</th>
            </tr>
            </thead>
                <%--<tbody>
                </tbody>--%>
        </table>
    </div>
</c:if>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

    var CONSTANT = {
        DATA_TABLES: {
            DEFAULT_OPTION: { //DataTables初始化选项
                language: {
                    "sProcessing":  "<span style='color: #ff5c3c'>&nbsp;&nbsp;数据较多，请稍等...</span>",
                    "sLengthMenu": "每页 _MENU_ 项",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 条，共 _TOTAL_ 条数据。",
                    "sInfoEmpty": "显示第 0 至 0 条，共 0 条数据",
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
                ordering: false,
                autoWidth: false,   //禁用自动调整列宽
                stripeClasses: ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合
                order: [],          //取消默认排序查询,否则复选框一列会出现小箭头
                processing: true,  //隐藏加载提示,自行处理
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
                $("#roleId").append(options);
            }
        });
        var $table = $("#table");
        var _table = $table.dataTable($.extend(true, {}, CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
            ajax: function (data, callback, settings) {
                //封装请求参数

                var param = userManage.getQueryCondition(data);
                $.ajax({
                    type: "POST",
                    url: "/user/selectAll.do",
                    cache: false,  //禁用缓存
                    data: JSON.stringify(param),    //传入已封装的参数
                    dataType: "json",
                    contentType: 'application/json;charset=utf-8',
                    success: function (data) {
                        //异常判断与处理
                        /*var data = result.data;
                        if (data.resultstrcode == '0033') {
                            alert("查询失败");
                            return;
                        }

                        //封装返回数据*/

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
                        if (XMLHttpRequest.status == 401) {
                            alert("登录超时,请重新登录");
                            parent.window.location = "/login.jsp";
                        }
                    }
                });

            },

            //绑定数据

            columns: [
                {
                    data: "id",//字段名
                },
                {
                    data: "userName",//字段名
                },
                {
                    data: "mobile",//字段名
                },
                {
                    data: "email",//字段名
                },
                {
                    data: "createTime", //字段名
                },
                {
                    data: "roleName", //字段名
                },
                {
                    data: "status", //字段名

                },
                {
                    data: "oper"//字段名

                }

            ],
            "createdRow":

                function (row, data, index) {
                    //不使用render，改用jquery文档操作呈现单元格
                    var statusStr = "";
                    var statusCss = "";
                    if (data.status == 0) {
                        statusCss = "label-success";
                        statusStr = "已启用";
                    } else if (data.status == 1) {
                        statusCss = "label-danger";
                        statusStr = "已停用";
                    }
                    var statusTip = "";
                    if (data.status == 0) {
                        statusTip = "停用";
                    } else if (data.status == 1) {
                        statusTip = "启用";
                    }
                    $('td', row).eq(6).html('<span class="label ' + statusCss + ' radius">' + statusStr + '</span>');
                    var name = data.userName;
                    if (name == 'admin') {
                        <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.password_update)}">
                        var btnUP1 = '<a style="text-decoration:none" class="ml-5" onClick="change_password(' + data.id + ')" " title="修改密码"><i class="Hui-iconfont">&#xe63f;</i>' + '</a>';
                        $('td', row).eq(7).append(btnUP1);
                        </c:if>
                    } else {
                        <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.user_status)}">
                        var btnEdit = '<a style="text-decoration:none" onClick="member_stop(' + data.id + ',' + data.status + ')"title="' + statusTip + '" ><i class="Hui-iconfont">&#xe631;</i></a>';
                        $('td', row).eq(7).append(btnEdit);
                        </c:if>
                        <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.user_edit)}">
                        var btnUpd = '<a title="编辑" href="javascript:;" onclick="editInfo(' + data.id + ')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i>' + '</a>';
                        $('td', row).eq(7).append(btnUpd);
                        </c:if>
                        <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.password_update)}">
                        var btnUP = '<a style="text-decoration:none" class="ml-5" onClick="change_password(' + data.id + ')" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i>' + '</a>';
                        $('td', row).eq(7).append(btnUP);
                        </c:if>
                        <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.user_delete)}">
                        var btnDel = '<a title="删除" href="javascript:;" onclick="member_del(' + data.id + ')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i>' + '</a>';
                        $('td', row).eq(7).append(btnDel);
                        </c:if>
                    }
                },


            "drawCallback":


                function (settings) {
                    //渲染完毕后的回调
                    //默认选中第一行
                    //$("tbody tr",$table).eq(0).click();
                }
        })).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象


    });
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


    function editInfo(id) {
        var url = "<%=basePath%>user/member-update.jsp?id=" + id;
        member_add('修改用户', url, '', '510');
    }

    /!*用户-添加*!/

    function member_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /!*用户-查看*!/

    function member_show(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /!*用户-停用*!/

    function member_stop(id, status) {
        url = 'user/updateStatus.do';
        $.ajax({
            type: "post",
            url: '<%=basePath%>' + url,
            data: {"id": id, "status": status},
            dataType: "json",
            success: function (data) {
                layer.msg('修改成功!', {icon: 5, time: 5000});
                window.location.reload(); //刷新本页面
            }

        });


    }

    /!*用户-编辑*!/

    function member_edit(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /!*密码-修改*!/

    function change_password(id) {
        var url = "<%=basePath%>user/member-updatePassword.jsp?id=" + id;
        member_add('修改密码', url, '', '510');
    }

    /!*用户-删除*!/

    function member_del(id) {
        url = 'user/deleteUser.do?id=' + id;
        $.ajax({
            type: "post",
            url: '<%=basePath%>' + url,
            contentType: 'application/json;charset=utf-8',
            dataType: "json",
            success: function (data) {
                layer.msg('删除成功!', {icon: 5, time: 5000});
            }
        });
        window.location.reload(); //刷新本页面

    }
</script>
</body>
</html>
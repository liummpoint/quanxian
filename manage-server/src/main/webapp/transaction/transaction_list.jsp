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
    <title>申请信用卡</title>
    <style type="text/css">
        .table-bordered th, .table-bordered td {
            border-left: 1px solid #ddd;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 帐户交易 <span
        class="c-gray en">&gt;</span> 帐户交易列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                                href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.user_list)}">
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort text-c " id="table">
            <thead>
            <tr class="text-c">
                <th id="id" width="80">交易ID</th>
                <th width="100">订单ID</th>
                <th width="90">用户ID</th>
                <th width="150">金额或积分</th>
                <th width="130">交易类型</th>
                <th width="130">交易状态</th>
                <th width="100">创建时间</th>
                <th width="100">更新时间</th>
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

        var $table = $("#table");
        var _table = $table.dataTable($.extend(true, {}, CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
            ajax: function (data, callback, settings) {
                //封装请求参数

                var param = userManage.getQueryCondition(data);
                $.ajax({
                    type: "POST",
                    url: "/transaction/list.do",
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
                    data: "transactionId"//字段名

                },
                {
                    data: "serviceOrderId",//字段名
                },
                {
                    data: "bizUserId",//字段名
                },
                {
                    data: "amount",//字段名
                },
                {
                    data: "transactionType",//字段名
                },
                {
                    data: "status", //字段名
                },
                {
                    data: "createTime"//字段名

                },
                {
                    data: "updateTime"//字段名

                }

            ],
            "createdRow":

                function (row, data, index) {

//                    var delete_html='<a style="text-decoration:none;color: cornflowerblue;" onClick="deleteInfo('+ data.transactionId+')" >删除</a><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>'

//                    $('td', row).eq(10).append(delete_html)
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

</script>
</body>
</html>
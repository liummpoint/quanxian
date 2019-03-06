<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="Bookmark" href="<%=basePath%>images/huasheng.ico" >
  <link rel="Shortcut Icon" href="<%=basePath%>images/huasheng.ico" />
  <!--[if lt IE 9]>
  <script type="text/javascript" src="<%=basePath%>lib/html5shiv.js"></script>
  <script type="text/javascript" src="<%=basePath%>lib/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath%>js/Hui-iconfont/1.0.8/iconfont.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
  <link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
  <!--[if IE 6]>
  <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js" ></script>
  <script>DD_belatedPNG.fix('*');</script>
  <![endif]-->
  <title>花生投后台管理系统</title>
</head>
<body>
<c:if test="${sessionScope.os != 'Android' && sessionScope.os != 'IPhone'}">
<header class="navbar-wrapper">
  <div class="navbar navbar-fixed-top">
    <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/menu/first.do?parentId=0">花生投后台管理系统</a>
      <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
      <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
      <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">

        <ul class="cl">
          <li class="dropDown dropDown_hover">
            <a  href="javascript:;" onclick="change_password('重置密码','<%=basePath%>change_password.jsp','800')"><i class="Hui-iconfont"></i> 重置密码</a> </span>
          </li>
          <li>${sessionScope.role.roleName}</li>
          <li class="dropDown dropDown_hover">
            <a href="#" class="dropDown_A">${sessionScope.user.userName} <i class="Hui-iconfont">&#xe6d5;</i></a>
            <ul class="dropDown-menu menu radius box-shadow">
              <li><a href="<%=basePath%>user/exit.do">退出</a></li>
            </ul>
          </li>

          <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
            <ul class="dropDown-menu menu radius box-shadow">
              <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
              <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
              <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
              <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
              <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
              <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</header>

      		<aside class="Hui-aside">
  <div class="menu_dropdown bk_2">
<div style="display: none" id="role">${sessionScope.role.websiteRole}</div>
    <c:forEach items="${menuList}" var="menu" varStatus="list" >
      <c:set var="tag" value="-"/>
      <c:set var="menu_id" value="${tag}${menu.id}${tag}"/>
      <c:if test="${fn:contains(sessionScope.role.websiteRole,menu_id )}">
              <dl id="first_${menu.id}" ids="${menu.id}">
                <dt><i class="Hui-iconfont">${menu.icon}</i> ${menu.name}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
                <dd>
                  <ul id="second_${menu.id}">
                  </ul>
                </dd>
              </dl>
      </c:if>
    </c:forEach>
  </div>
</aside>

</c:if>


<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
  <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
    <div class="Hui-tabNav-wp">
      <ul id="min_title_list" class="acrossTab cl">
        <li class="active">
          <span title="我的桌面" data-href="<%=basePath%>welcome.jsp">我的桌面</span>
          <em></em></li>
      </ul>
    </div>
    <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
  </div>
  <div id="iframe_box" class="Hui-article">
    <div class="show_iframe">
      <div style="display:none" class="loading"></div>
      <%-- <c:if test="${sessionScope.user.id ne 126}">
      <iframe scrolling="yes" frameborder="0" src="<%=basePath%>welcome.jsp"></iframe>
      </c:if> --%>

      <c:if test="${fn:contains(sessionScope.role.websiteRole,sessionScope.destTop)}">

        <c:choose>
          <c:when test="${sessionScope.os == 'Android' || sessionScope.os == 'IPhone'}">
            <%-- <iframe scrolling="yes" frameborder="0" src="<%=basePath%>welcome.jsp"></iframe> --%>
            <iframe scrolling="yes" frameborder="0" src="<%=basePath%>h5data.jsp"></iframe>
          </c:when>
          <c:otherwise>
            <iframe scrolling="yes" frameborder="0" src="<%=basePath%>welcome.jsp"></iframe>
          </c:otherwise>
        </c:choose>

      </c:if>
      
      
    </div>
  </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
  <ul>
    <li id="closethis">关闭当前 </li>
    <li id="closeall">关闭全部 </li>
  </ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>js/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
    $(function(){
    	if($("#role").length == 0){
    		return ;
    	}
        var websiteRole=$("#role").html();
        $("dl").each(function(n){
            var ids=$(this).attr("ids");
            var second_ul=$("#second_"+ids)
            //second_ul.empty();
            $.ajax({
                type: "post",
                data: {"parentId": ids},
                url: '<%=basePath%>menu/byParentId.do',
                async: false,
                success: function (data) {
                    for(var i=0;i<data.rows.length;i++){
                        if(websiteRole.indexOf("-"+data.rows[i].id+"-") > 0){
                            second_ul.append("<li><a data-href=\"<%=basePath%>"+data.rows[i].url+"\" data-title=\""+data.rows[i].name+"\" href=\"javascript:void(0)\">"+data.rows[i].name+"</a></li>")
                        }
                    }
                }
            });
        })
    });
    function change_password(title, url, w, h) {
        layer_show(title, url, '800', '400');

    }

</script>



</body>
</html>
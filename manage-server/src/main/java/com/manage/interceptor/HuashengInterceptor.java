package com.manage.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.system.MenuManageMapper;
import com.manage.dao.user.UserManagerMapper;
import com.manage.model.admin.AdminRole;
import com.manage.model.user.UserManager;
import com.manage.system.MenuManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manage.utils.BrowserUtil;
public class HuashengInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(HuashengInterceptor.class);

    @Resource
    private MenuManageMapper menuManageMapper;

    @Resource
    private UserManagerMapper userManagerMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("========interceptor start======");

        String  url  =  "http://"  +  request.getServerName()  +  ":"  +  request.getServerPort()  +  request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
        logger.info("-----------1111-------------" + url);

        String uri = request.getRequestURI();
        logger.info("------------------------" + uri);
        //过滤登录接口
      if (uri.contains("/user/login") || uri.contains("/js/") || uri.contains("user/cardUnbindInit") || uri.contains("user/cardUnbindInitSign") || uri.contains("user/getsmscode")) {
            return true;
        } else {//其他接口都需要登录
            Object object = request.getSession().getAttribute("user");
            if (object == null) {
//                response.sendRedirect("/login.jsp");
                response.setContentType("text/html;charset=UTF-8");
                if (request.getHeader("x-requested-with") != null
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                    // Ajax请求, 前段根据此header进行处理
                    response.setHeader("sessionTimeout", "Session time out, you need relogin !");
                    // 返回未认证的状态码(401)
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    logger.debug("请求路径：" + uri + ", 请求方式 ：Ajax请求, Session超时, 需要重新登录!");
                } else {
                    // 普通请求
                    String path = request.getContextPath();
                    StringBuffer basePath = new StringBuffer()
                            .append(request.getScheme())
                            .append("://")
                            .append(request.getServerName())
                            .append(":")
                            .append(request.getServerPort())
                            .append(path)
                            .append("/");
                    
                String os = BrowserUtil.getOsAndBrowserInfo(request) ;
                request.getSession().setAttribute("os", os);
                StringBuffer responseStr = new StringBuffer()
                        .append("<html><header><script type=\"text/javascript\">")
                        .append("window.location.href=\"")
                        .append(basePath).append("login.jsp").append("\";")
                        .append("</script></header></html>");
               	 if(os.equals("IPhone") || os.equals("Android") ){
               		responseStr = new StringBuffer()
                            .append("<html><header><script type=\"text/javascript\">")
                            .append("window.location.href=\"")
                            .append(basePath).append("h5Login.jsp").append("\";")
                            .append("</script></header></html>");
               	 }
                    
                    
                    
                    response.getWriter().write(responseStr.toString());
                    logger.debug("请求路径：" + uri + ",请求方式 ：普通请求, Session超时, 需要重新登录!");
                }
                return false;
            }else{
                AdminRole adminRole = (AdminRole)((HttpServletRequest)request).getSession().getAttribute("role");
                String roleqx = adminRole.getWebsiteRole();
                try{
                    String[] urlstr = uri.split("/");
                    if (urlstr.length > 1){
                        MenuManage menuManage = menuManageMapper.selectMenuByUrl(urlstr[urlstr.length -2] +"/"+ urlstr[urlstr.length -1]);
                        if (menuManage == null){
                            //无权限要求
                        }else {
                            //有权限要求
                            if (!roleqx.contains("-" + menuManage.getId() + "-")){
                                response.setContentType("text/html;charset=UTF-8");
                                if (request.getHeader("x-requested-with") != null
                                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                                    // Ajax请求, 前段根据此header进行处理
                                    response.setHeader("sessionTimeout", "Session time out, you need relogin !");
                                    // 返回未认证的状态码(401)
                                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                                    logger.debug("请求路径：" + uri + ", 请求方式 ：Ajax请求, Session超时, 需要重新登录!");
                                } else {
                                    // 普通请求
                                    String path = request.getContextPath();
                                    StringBuffer basePath = new StringBuffer()
                                            .append(request.getScheme())
                                            .append("://")
                                            .append(request.getServerName())
                                            .append(":")
                                            .append(request.getServerPort())
                                            .append(path)
                                            .append("/");

                                    String os = BrowserUtil.getOsAndBrowserInfo(request) ;
                                    request.getSession().setAttribute("os", os);
                                    StringBuffer responseStr = new StringBuffer()
                                            .append("<html><header><script type=\"text/javascript\">")
                                            .append("window.location.href=\"")
                                            .append(basePath).append("login.jsp").append("\";")
                                            .append("</script></header></html>");
                                    if(os.equals("IPhone") || os.equals("Android") ){
                                        responseStr = new StringBuffer()
                                                .append("<html><header><script type=\"text/javascript\">")
                                                .append("window.location.href=\"")
                                                .append(basePath).append("h5Login.jsp").append("\";")
                                                .append("</script></header></html>");
                                    }



                                    response.getWriter().write(responseStr.toString());
                                    logger.debug("请求路径：" + uri + ",请求方式 ：普通请求, Session超时, 需要重新登录!");
                                }
                                request.getSession().setAttribute("user", null);
                                return false;
                            }
                        }
                    }

                    //单点
                    UserManager userManager = (UserManager)request.getSession().getAttribute("user");
                    UserManager userManagerdb  = userManagerMapper.selectUser(userManager);
                    String sessionid = request.getSession().getId();
                    if (!sessionid.equals(userManagerdb.getLoginsessionid())){
                        response.setContentType("text/html;charset=UTF-8");
                        if (request.getHeader("x-requested-with") != null
                                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                            // Ajax请求, 前段根据此header进行处理
                            response.setHeader("sessionTimeout", "Session time out, you need relogin !");
                            // 返回未认证的状态码(401)
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            logger.debug("请求路径：" + uri + ", 请求方式 ：Ajax请求, Session超时, 需要重新登录!");
                        } else {
                            // 普通请求
                            String path = request.getContextPath();
                            StringBuffer basePath = new StringBuffer()
                                    .append(request.getScheme())
                                    .append("://")
                                    .append(request.getServerName())
                                    .append(":")
                                    .append(request.getServerPort())
                                    .append(path)
                                    .append("/");

                            String os = BrowserUtil.getOsAndBrowserInfo(request) ;
                            request.getSession().setAttribute("os", os);
                            StringBuffer responseStr = new StringBuffer()
                                    .append("<html><header><script type=\"text/javascript\">")
                                    .append("window.location.href=\"")
                                    .append(basePath).append("login.jsp").append("\";")
                                    .append("</script></header></html>");
                            if(os.equals("IPhone") || os.equals("Android") ){
                                responseStr = new StringBuffer()
                                        .append("<html><header><script type=\"text/javascript\">")
                                        .append("window.location.href=\"")
                                        .append(basePath).append("h5Login.jsp").append("\";")
                                        .append("</script></header></html>");
                            }



                            response.getWriter().write(responseStr.toString());
                            logger.debug("请求路径：" + uri + ",请求方式 ：普通请求, Session超时, 需要重新登录!");
                        }
                        request.getSession().setAttribute("user", null);
                        return false;
                    }

                }catch (Exception ex){

                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView var4)
            throws Exception {


    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}

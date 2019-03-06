package com.manage.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.system.MenuManageMapper;
import com.manage.model.admin.AdminRole;
import com.manage.system.MenuManage;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class WebFilter implements Filter {
	
	//*** interceptor 只过滤请求 filter功能大于interceptor
	
	private String encoding = "";

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		String uri = ((HttpServletRequest)request).getRequestURI();
		HttpServletResponse res = (HttpServletResponse) response;
		if (!uri.contains("login.jsp")){
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(((HttpServletRequest)request).getSession().getServletContext());
			MenuManageMapper menuManageMapper = (MenuManageMapper)webApplicationContext.getBean("MenuManageMapper");

			AdminRole adminRole = (AdminRole)((HttpServletRequest)request).getSession().getAttribute("role");
			String roleqx = adminRole.getWebsiteRole();
			try{
				String[] urlstr = uri.split("/");
				if (urlstr.length > 2){
					MenuManage menuManage = menuManageMapper.selectMenuByUrl(urlstr[urlstr.length -2] +"/"+ urlstr[urlstr.length -1]);
					if (menuManage == null){
						//无权限要求
					}else {
						//有权限要求
						if (!roleqx.contains("-" + menuManage.getId() + "-")){
							String url = "http://"+((HttpServletRequest)request).getHeader("Host")+((HttpServletRequest)request).getContextPath()+"/login.jsp";
							((HttpServletRequest)request).setAttribute("user", null);
							res.sendRedirect(url);
							return ;
						}
					}
				}else{
					MenuManage menuManage = menuManageMapper.selectMenuByUrl(urlstr[urlstr.length -1]);
					if (menuManage == null){
						//无权限要求
					}else {
						//有权限要求
						if (!roleqx.contains("-" + menuManage.getId() + "-")){
							String url = "http://"+((HttpServletRequest)request).getHeader("Host")+((HttpServletRequest)request).getContextPath()+"/login.jsp";
							((HttpServletRequest)request).setAttribute("user", null);
							res.sendRedirect(url);
							return ;
						}
					}
				}
			}catch (Exception ex){

			}
			chain.doFilter(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}
	
	public void init(FilterConfig config) throws ServletException {
		System.out.println("****** Web - " + config.getInitParameter("encoding")+ "******");
		encoding = config.getInitParameter("encoding");
	}

}

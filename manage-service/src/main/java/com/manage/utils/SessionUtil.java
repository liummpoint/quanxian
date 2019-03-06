package com.manage.utils;

import com.manage.system.MenuManage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SessionUtil {
    /**
     * 将菜单信息保存到session中
     * @param menuManageList  菜单列表
     */
    public static void setMenuId(List<MenuManage> menuManageList){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        for (MenuManage menuManage:menuManageList) {
            request.getSession().setAttribute(menuManage.getSessionKey(), "-"+menuManage.getId()+"-");
        }
    }
}

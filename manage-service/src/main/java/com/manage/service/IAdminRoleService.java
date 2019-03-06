package com.manage.service;

import com.manage.datasourceAnnotation.SourcesEnum;
import com.manage.datasourceAnnotation.TargetDataSource;
import com.manage.model.ResultMsg;
import com.manage.model.admin.AdminRole;
import com.manage.model.page.Page;
import com.manage.system.MenuManage;


/**
 * Created by 59458 on 2017/5/17.
 */
public interface IAdminRoleService {
    /**
     * 查询全部角色
     * @param
     */
    ResultMsg<AdminRole> findAllRole(Page page) throws Exception;

    /**
     *
     * 根据id查询adminRole
     * @throws Exception
     */
    ResultMsg findRoleById(int roleId) throws Exception;

    @TargetDataSource(SourcesEnum.write)
    ResultMsg insertAdminRole(AdminRole adminRole) throws Exception;
    
    @TargetDataSource(SourcesEnum.write)
    ResultMsg updateAdminRole(AdminRole adminRole) throws Exception;

    @TargetDataSource(SourcesEnum.write)
    ResultMsg  deleteAdminRole(AdminRole adminRole) throws Exception;
   
    ResultMsg<MenuManage> findMenu() throws Exception;
}

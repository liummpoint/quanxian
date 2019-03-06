package com.manage.dao.admin;

import com.manage.model.admin.AdminRole;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRoleMapper {
    List<AdminRole> selectAllAdminRole();
    int insertAdminRole(AdminRole adminRole);
    int updateAdminRole(AdminRole adminRole);
    AdminRole selectAdminRoleById(int  roleId);
    int deleteAdminRoleById(AdminRole adminRole);
    List<AdminRole> selectAdminRole(AdminRole adminRole);

}

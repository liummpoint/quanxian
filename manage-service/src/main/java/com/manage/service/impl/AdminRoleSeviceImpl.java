package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.commom.enums.ErrorCode;
import com.manage.commom.utils.StringUtil;
import com.manage.dao.admin.AdminRoleMapper;
import com.manage.dao.system.MenuManageMapper;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.admin.AdminRole;
import com.manage.model.page.Page;
import com.manage.service.IAdminRoleService;
import com.manage.system.MenuManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminRoleSeviceImpl implements IAdminRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminRoleSeviceImpl.class);

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Resource
    private MenuManageMapper menuManageMapper;

    @Override
    public ResultMsg<AdminRole> findAllRole(Page page) throws Exception {
        if(page.getStartIndex()>0){
            page.setStartIndex(page.getStartIndex()/page.getPageSize()+1);
        }else{
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        List<AdminRole> list=new ArrayList<>();
        list=adminRoleMapper.selectAllAdminRole();
        PageInfo pageInfo=new PageInfo(list);
        return  PageInfoResult.PageInfoMsg(pageInfo);

    }

    @Override
    public ResultMsg findRoleById(int roleId) throws Exception {
        ResultMsg<AdminRole> resultMsg = new ResultMsg<>();
        List<AdminRole> list = new ArrayList<>();
        list.add(adminRoleMapper.selectAdminRoleById(roleId));
        resultMsg.setRows(list);
        LOGGER.info("================findRoleById:[resultMsg={}]", resultMsg);


        return resultMsg;
    }

    @Override
    public ResultMsg updateAdminRole(AdminRole adminRole) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        List<AdminRole> adminRoleList = new ArrayList<>();
        String rolename = adminRole.getRoleName().trim();
        AdminRole adminRole1 = new AdminRole();
        adminRole1.setRoleName(rolename);

        if (StringUtil.isEmpty(adminRole.getRoleName().trim())) {
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0011.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0011.getMessage());
        } else {
            adminRoleList = adminRoleMapper.selectAdminRole(adminRole1);
            if (adminRoleList.size() < 1 || adminRoleList.get(0).getRoleId() == adminRole.getRoleId()) {
            	 adminRoleMapper.updateAdminRole(adminRole);
                resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
                resultMsg.setErrorMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
            } else {
                resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0012.getCode());
                resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0012.getMessage());

            }
        }

        return resultMsg;
    }


    @Override
    public ResultMsg deleteAdminRole(AdminRole adminRole) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        int i =adminRoleMapper.deleteAdminRoleById(adminRole);
        if (i == 0) {
            LOGGER.info("删除异常");
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0006.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0006.getMessage());
        } else {
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        }

        return resultMsg;
    }


    @Override
    public ResultMsg findMenu() throws Exception {
        ResultMsg<MenuManage> resultMsg = new ResultMsg<>();
        List<MenuManage> menuManageList = new ArrayList<>();

        menuManageList = menuManageMapper.selectMenu();
        resultMsg.setRows(menuManageList);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setErrorMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());

        return resultMsg;
    }


    @Override
    public ResultMsg insertAdminRole(AdminRole adminRole) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        List<AdminRole> adminRoleList = new ArrayList<>();
        String rolename = adminRole.getRoleName().trim();
        AdminRole adminRole1 = new AdminRole();
        adminRole1.setRoleName(rolename);

        if (StringUtil.isEmpty(rolename)) {
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0011.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0011.getMessage());
            return resultMsg ;
        } 
        
        adminRoleList = adminRoleMapper.selectAdminRole(adminRole1);
        if (adminRoleList.size() > 0) {
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0012.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0012.getMessage());
            return resultMsg ;
        } 
        
        adminRoleMapper.insertAdminRole(adminRole);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setErrorMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        

        return resultMsg;
    }

}

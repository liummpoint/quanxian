package com.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.manage.model.ResultMsg;
import com.manage.model.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.commom.enums.ErrorCode;
import com.manage.model.admin.AdminRole;
import com.manage.system.MenuManage;
import com.manage.service.IAdminRoleService;
@Controller
@RequestMapping(value = "/role")
public class AdminRoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminRoleController.class);
    @Resource
    private IAdminRoleService iAdminRoleService;

    /**
     * 查询所有adminRole
     */
    @RequestMapping(value = "/findAllRole", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg<AdminRole> findAllRole(@RequestBody Page page) {
        ResultMsg<AdminRole> resultMsg = new ResultMsg<>();
        try {
            LOGGER.info("=======begin find adminRole");
            resultMsg = iAdminRoleService.findAllRole(page);
            LOGGER.info("=======end find adminRole");
        } catch (Exception e) {
            LOGGER.error("查询异常", e);

        }
        return resultMsg;
    }

    /**
     * 添加adminrole
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/addAdminRole", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg addAdminRole(@RequestBody AdminRole adminRole) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            LOGGER.info("=======begin insert adminRole");
            resultMsg = iAdminRoleService.insertAdminRole(adminRole);
            LOGGER.info("=======end insert adminRole");
        } catch (Exception e) {
            LOGGER.error(ErrorCode.CHANNEL_ERROR_3005.getMessage(), e);
            resultMsg.setResultstrcode(ErrorCode.CHANNEL_ERROR_3005.getCode());
            resultMsg.setErrorMsg(ErrorCode.CHANNEL_ERROR_3005.getMessage());
        }
        return resultMsg;
    }

    /**
     * 修改adminrole
     *
     * @param adminRole
     * @return
     */
    @RequestMapping(value = "/updateAdminRole", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg updateAdminRole(@RequestBody AdminRole adminRole) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            LOGGER.info("=======begin update adminRole");
            resultMsg = iAdminRoleService.updateAdminRole(adminRole);
            LOGGER.info("=======end update adminRole");
        } catch (Exception e) {
            LOGGER.error(ErrorCode.CHANNEL_ERROR_3005.getMessage(), e);
            resultMsg.setResultstrcode(ErrorCode.CHANNEL_ERROR_3005.getCode());
            resultMsg.setErrorMsg(ErrorCode.CHANNEL_ERROR_3005.getMessage());
        }
        return resultMsg;
    }

    /**
     * 根据id查询adminrole
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/findAdminRoleById/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg findAdminRoleById(@PathVariable String id ) {

        ResultMsg<AdminRole> roleResultMsg = new ResultMsg<>();
//        AdminRole adminRole = new AdminRole();
//        adminRole.setRoleId(id);
        try {
            LOGGER.info("========begin find========");
            roleResultMsg = iAdminRoleService.findRoleById(Integer.parseInt(id));
            LOGGER.info("======== find  end========");
        } catch (Exception e) {
            LOGGER.error(ErrorCode.CHANNEL_ERROR_3005.getMessage(), e);
            roleResultMsg.setResultstrcode(ErrorCode.CHANNEL_ERROR_3005.getCode());
            roleResultMsg.setErrorMsg(ErrorCode.CHANNEL_ERROR_3005.getMessage());
        }
        return roleResultMsg;
    }

    /**
     * 逻辑删除adminrole
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteAdminRoleById/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg deleteAdminRoleById(@PathVariable String id) {
        ResultMsg resultMsg = new ResultMsg();
        AdminRole adminRole = new AdminRole();
        adminRole.setRoleId(Integer.parseInt(id));
        try {
            LOGGER.info("=======begin delete adminrole id=" + id);
            resultMsg = iAdminRoleService.deleteAdminRole(adminRole);
            LOGGER.info("=======end delete adminrole id=" + id);
        } catch (Exception e) {
            LOGGER.error(ErrorCode.CHANNEL_ERROR_3005.getMessage(), e);
            resultMsg.setResultstrcode(ErrorCode.CHANNEL_ERROR_3005.getCode());
            resultMsg.setErrorMsg(ErrorCode.CHANNEL_ERROR_3005.getMessage());
        }
        return resultMsg;
    }

    /**
     * 查询权限列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/findMenu", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg findMenu(HttpServletRequest request) {
        ResultMsg<MenuManage> resultMsg = new ResultMsg<>();
        try {
            LOGGER.info("=======begin find menuManage ");
            resultMsg = iAdminRoleService.findMenu();
            LOGGER.info("=======end find menuManage ");
        } catch (Exception e) {
            LOGGER.error(ErrorCode.CHANNEL_ERROR_3005.getMessage(), e);
            resultMsg.setResultstrcode(ErrorCode.CHANNEL_ERROR_3005.getCode());
            resultMsg.setErrorMsg(ErrorCode.CHANNEL_ERROR_3005.getMessage());
        }
        return resultMsg;
    }

}

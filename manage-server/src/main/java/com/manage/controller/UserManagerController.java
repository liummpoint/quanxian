package com.manage.controller;

import com.manage.commom.enums.ErrorCode;
import com.manage.commom.exception.CddException;
import com.manage.model.ResultMsg;
import com.manage.model.page.Page;
import com.manage.model.user.UserManager;
import com.manage.service.IUserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserManagerController {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);

    @Resource
    private IUserManagerService userManagerService;


    @RequestMapping(value = "/updateStatus1")
    @ResponseBody
    public void updateStatus11() {
        userManagerService.findTest();
        userManagerService.insertTest();
    }

    /**
     * 添加用户
     *
     * @Param UserManag
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg add(@RequestBody UserManager userManager) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = userManagerService.addUser(userManager);
        } catch (CddException e) {
            logger.error("<<<<<<<insert user exception=", e);
            resultMsg.setResultstrcode(e.getErrorCode());
            resultMsg.setErrorMsg(e.getErrorMsg());
        } catch (Exception e) {
            logger.error("<<<<<<<insert user exception=", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());

        }
        return resultMsg;
    }

    /**
     * 查询所有用户信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/selectAll", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg data(@RequestBody Page page) throws Exception {
        ResultMsg resultMsg = null;
        try {
            resultMsg = userManagerService.findUserManager(page);
        } catch (CddException e) {
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getCode());
            logger.error("<<<<<<<select userManager status exception=", e);
        }
        return resultMsg;
    }

    /**
     * 修改用户状态
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/updateStatus", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateStatus(UserManager userManager) {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>>updateStatus userManager:【{}】", userManager);
        try {
            userManagerService.updateStatus(userManager);
        } catch (CddException e) {
            logger.error("<<<<<<EXCEPTION=", e);
            resultMsg.setResultstrcode(e.getErrorCode());
            resultMsg.setErrorMsg(e.getErrorMsg());

        } catch (Exception e) {
            logger.error("<<<<<<<update user status exception=", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());

        }
        logger.info("<<<<<update status end");
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 根据ID查询用户信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/selectById", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectById(UserManager userManager) {
        logger.info(">>>>>>selectById userManager:【{}】", userManager);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = userManagerService.selectUserById(userManager);
        } catch (Exception e) {
            logger.error("<<<<<<<<select by id--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }


    /**
     * 修改用户信息
     *
     * @param userManager
     * @return
     */
    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateUser(@RequestBody UserManager userManager) {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>>>updateUser userManager:【{}】", userManager);
        try {
            userManagerService.updateUser(userManager);
        } catch (CddException e) {
            logger.error("<<<<<<<<exception=", e);
            resultMsg.setResultstrcode(e.getErrorCode());
            resultMsg.setErrorMsg(e.getErrorMsg());
            return resultMsg;

        } catch (Exception e) {
            logger.error("<<<<<<<<<update user exception=", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
            return resultMsg;

        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 逻辑删除用户
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteUser(UserManager userManager) {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>deleteUser userManager:【{}】", userManager);
        try {
            userManagerService.deleteUser(userManager);
        } catch (Exception e) {
            logger.error("<<<<<delete user exception =", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
            return resultMsg;
        }
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 修改密码
     *
     * @param
     * @return
     */

    @RequestMapping(value = "/updatePassword", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg updatePassword(@RequestBody UserManager userManager, HttpServletRequest request) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>>updatePassword userManager:【{}】", userManager);
        try {
            resultMsg = userManagerService.updatePassword(request, userManager);
        } catch (Exception e) {
            logger.error("<<<<<<<<update-password-exception =", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
        }
        return resultMsg;
    }

    /**
     * editPassword
     */
    @RequestMapping(value = "/editPassword", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg editPassword(@RequestBody UserManager userManager, HttpServletRequest request) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>>updatePassword userManager:【{}】", userManager);
        try {
            resultMsg = userManagerService.updatePassword(request, userManager);
        } catch (Exception e) {
            logger.error("<<<<<<<<update-password-exception =", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
        }
        return resultMsg;
    }

    /**
     * 用户登录
     *
     * @param
     * @return
     */

    @RequestMapping(value = "login", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg login(UserManager userManager,  HttpServletRequest request) {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>>>start  login userManager:【{}】", userManager);
        try {
            userManager.setLoginsessionid(request.getSession().getId());
            resultMsg = userManagerService.userLogin(userManager);
        } catch (CddException e) {
            logger.error("<<<<<<<<user login exception=", e);
            resultMsg.setResultstrcode(e.getErrorCode());
            resultMsg.setErrorMsg(e.getErrorMsg());
            return resultMsg;

        } catch (Exception e) {
            logger.error("<<<<<<<user login exception=", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }

    /**
     * 查询用户角色
     *
     * @return
     */
    @RequestMapping(value = "selectUserRole", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectUserRole() {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg.setRows(userManagerService.selectUserRole());
        } catch (Exception e) {
            logger.error("<<<<<<<select user role exception=", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }

    /**
     * 并清理session
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = userManagerService.exit(request);
        } catch (Exception e) {
            logger.error("<<<<<<<exit exception=", e);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setErrorMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
        }
        logger.info("<<<<<<clear session success");
        response.sendRedirect("/login.jsp");
    }


}
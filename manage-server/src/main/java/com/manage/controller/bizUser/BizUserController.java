package com.manage.controller.bizUser;

import com.manage.commom.enums.ErrorCode;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.bizUser.BizUser;
import com.manage.service.bizUser.IBizUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/bizUser")
public class BizUserController {
    private static final Logger logger = LoggerFactory.getLogger(BizUserController.class);


    @Resource
    private IBizUserService bizUserService;

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg<?> getProductList(@RequestBody Page page) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = bizUserService.selectBizUserList(page);

        } catch (Exception e) {
            logger.error("获取用户列表失败", e);
        }
        return resultMsg;
    }

    /**
     * 获取某条用户信息
     *
     * @param bizUser
     * @return
     */
    @RequestMapping(value = "/selectById", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectBizUserById(BizUser bizUser) {
        logger.info(">>>>>>selectBizUserById:【{}】", bizUser);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = bizUserService.selectBizUserById(bizUser.getBizUserId());
        } catch (Exception e) {
            logger.error("<<<<<<<<selectBizUserById--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }

    /**
     * 修改某条用户信息
     *
     * @param bizUser
     * @return
     */
    @RequestMapping(value = "/updateBizUser", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateBizUser(@RequestBody BizUser bizUser) {
        logger.info(">>>>>>updateBizUser:【{}】", bizUser);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = bizUserService.updateBizUser(bizUser);
        } catch (Exception e) {
            logger.error("<<<<<<<< updateBizUser--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 新增用户信息
     *
     * @param bizUser
     * @return
     */
    @RequestMapping(value = "/insertBizUser", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg insertBizUser(BizUser bizUser) {
        logger.info(">>>>>>insertBizUser:【{}】", bizUser);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = bizUserService.insertBizUser(bizUser);
        } catch (Exception e) {
            logger.error("<<<<<<<< insertBizUser--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 删除用户信息
     *
     * @param bizUser
     * @return
     */
    @RequestMapping(value = "/deleteBizUser", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteBizUser(BizUser bizUser) {
        logger.info(">>>>>>deleteBizUser:【{}】", bizUser);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = bizUserService.deleteBizUser(bizUser);
        } catch (Exception e) {
            logger.error("<<<<<<<< deleteBizUser--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }
}

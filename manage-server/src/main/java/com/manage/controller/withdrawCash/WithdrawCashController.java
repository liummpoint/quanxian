package com.manage.controller.withdrawCash;

import com.manage.commom.enums.ErrorCode;
import com.manage.model.withdrawCash.WithdrawCash;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.service.withdrawCash.IWithdrawCashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/withdrawCash")
public class WithdrawCashController {
    private static final Logger logger = LoggerFactory.getLogger(WithdrawCashController.class);


    @Resource
    private IWithdrawCashService withdrawCashService;

    /**
     * 获取申请提现列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg<?> getProductList(@RequestBody Page page) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = withdrawCashService.selectWithdrawCashList(page);

        } catch (Exception e) {
            logger.error("获取申请提现列表失败", e);
        }
        return resultMsg;
    }

    /**
     * 获取某条申请提现信息
     *
     * @param withdrawCash
     * @return
     */
    @RequestMapping(value = "/selectById", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectWithdrawCashById(WithdrawCash withdrawCash) {
        logger.info(">>>>>>selectWithdrawCashById:【{}】", withdrawCash);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = withdrawCashService.selectWithdrawCashById(withdrawCash.getWithdrawCashId());
        } catch (Exception e) {
            logger.error("<<<<<<<<selectWithdrawCashById--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }

    /**
     * 修改某条申请提现信息
     *
     * @param withdrawCash
     * @return
     */
    @RequestMapping(value = "/updateWithdrawCash", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateWithdrawCash(@RequestBody WithdrawCash withdrawCash) {
        logger.info(">>>>>>updateWithdrawCash:【{}】", withdrawCash);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = withdrawCashService.updateWithdrawCash(withdrawCash);
        } catch (Exception e) {
            logger.error("<<<<<<<< updateWithdrawCash--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 新增申请提现信息
     *
     * @param withdrawCash
     * @return
     */
    @RequestMapping(value = "/insertWithdrawCash", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg insertWithdrawCash(WithdrawCash withdrawCash) {
        logger.info(">>>>>>insertWithdrawCash:【{}】", withdrawCash);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = withdrawCashService.insertWithdrawCash(withdrawCash);
        } catch (Exception e) {
            logger.error("<<<<<<<< insertWithdrawCash--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 删除申请提现信息
     *
     * @param withdrawCash
     * @return
     */
    @RequestMapping(value = "/deleteWithdrawCash", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteWithdrawCash(WithdrawCash withdrawCash) {
        logger.info(">>>>>>deleteWithdrawCash:【{}】", withdrawCash);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = withdrawCashService.deleteWithdrawCash(withdrawCash);
        } catch (Exception e) {
            logger.error("<<<<<<<< deleteWithdrawCash--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }
}

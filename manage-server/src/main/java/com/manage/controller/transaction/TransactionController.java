package com.manage.controller.transaction;

import com.manage.commom.enums.ErrorCode;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.transaction.Transaction;
import com.manage.service.transaction.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);


    @Resource
    private ITransactionService transactionService;

    /**
     * 获取帐户交易列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg<?> getProductList(@RequestBody Page page) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = transactionService.selectTransactionList(page);

        } catch (Exception e) {
            logger.error("获取帐户交易列表失败", e);
        }
        return resultMsg;
    }

    /**
     * 获取某条帐户交易信息
     *
     * @param transaction
     * @return
     */
    @RequestMapping(value = "/selectById", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectTransactionById(Transaction transaction) {
        logger.info(">>>>>>selectTransactionById:【{}】", transaction);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = transactionService.selectTransactionById(transaction.getTransactionId());
        } catch (Exception e) {
            logger.error("<<<<<<<<selectTransactionById--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }


    /**
     * 新增帐户交易信息
     *
     * @param transaction
     * @return
     */
    @RequestMapping(value = "/insertTransaction", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg insertTransaction(Transaction transaction) {
        logger.info(">>>>>>insertTransaction:【{}】", transaction);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = transactionService.insertTransaction(transaction);
        } catch (Exception e) {
            logger.error("<<<<<<<< insertTransaction--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 删除帐户交易信息
     *
     * @param transaction
     * @return
     */
    @RequestMapping(value = "/deleteTransaction", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteTransaction(Transaction transaction) {
        logger.info(">>>>>>deleteTransaction:【{}】", transaction);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = transactionService.deleteTransaction(transaction);
        } catch (Exception e) {
            logger.error("<<<<<<<< deleteTransaction--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }
}

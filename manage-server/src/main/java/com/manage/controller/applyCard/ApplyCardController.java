package com.manage.controller.applyCard;

import com.manage.commom.enums.ErrorCode;
import com.manage.model.applyCard.ApplyCard;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.service.applyCard.IApplyCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/applyCard")
public class ApplyCardController {
    private static final Logger logger = LoggerFactory.getLogger(ApplyCardController.class);


    @Resource
    private IApplyCardService applyCardService;

    /**
     * 获取申请信用卡列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg<?> getProductList(@RequestBody Page page) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = applyCardService.selectApplyCardList(page);

        } catch (Exception e) {
            logger.error("获取申请信用卡列表失败", e);
        }
        return resultMsg;
    }

    /**
     * 获取某条申请信用卡信息
     *
     * @param applyCard
     * @return
     */
    @RequestMapping(value = "/selectById", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectApplyCardById(ApplyCard applyCard) {
        logger.info(">>>>>>selectApplyCardById:【{}】", applyCard);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = applyCardService.selectApplyCardById(applyCard.getApplyCardId());
        } catch (Exception e) {
            logger.error("<<<<<<<<selectApplyCardById--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }

    /**
     * 获取某条申请信用卡信息
     *
     * @param applyCard
     * @return
     */
    @RequestMapping(value = "/updateApplyCard", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateApplyCard(@RequestBody ApplyCard applyCard) {
        logger.info(">>>>>>updateApplyCard:【{}】", applyCard);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = applyCardService.updateApplyCard(applyCard);
        } catch (Exception e) {
            logger.error("<<<<<<<< updateApplyCard--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 新增申请信用卡
     *
     * @param applyCard
     * @return
     */
    @RequestMapping(value = "/insertApplyCard", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg insertApplyCard(ApplyCard applyCard) {
        logger.info(">>>>>>insertApplyCard:【{}】", applyCard);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = applyCardService.insertApplyCard(applyCard);
        } catch (Exception e) {
            logger.error("<<<<<<<< insertApplyCard--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 删除申请信用卡
     *
     * @param applyCard
     * @return
     */
    @RequestMapping(value = "/deleteApplyCard", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteApplyCard(ApplyCard applyCard) {
        logger.info(">>>>>>deleteApplyCard:【{}】", applyCard);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = applyCardService.deleteApplyCard(applyCard);
        } catch (Exception e) {
            logger.error("<<<<<<<< deleteApplyCard--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }
}

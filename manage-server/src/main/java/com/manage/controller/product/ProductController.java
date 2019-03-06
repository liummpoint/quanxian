package com.manage.controller.product;

import com.manage.commom.enums.ErrorCode;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.product.Product;
import com.manage.service.product.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @Resource
    private IProductService productService;

    /**
     * 获取产品列表
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg<?> getProductList(@RequestBody Page page) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = productService.getProductList(page);

        } catch (Exception e) {
            logger.error("发现页查询失败", e);
        }
        return resultMsg;
    }

    @RequestMapping(value = "/insertProduct", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg insertProduct(Product product) {
        logger.info(">>>>>>insertProduct:【{}】", product);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = productService.insertProduct(product);
        } catch (Exception e) {
            logger.error("<<<<<<<< insertProduct--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 获取某条申请信用卡信息
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "/selectById", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg selectProductById(Product product){
        logger.info(">>>>>>selectProductById:【{}】", product);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = productService.selectProductById(product.getProductId());
        } catch (Exception e) {
            logger.error("<<<<<<<<selectProductById--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        return resultMsg;
    }

    @RequestMapping(value = "/deleteProduct", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteProduct(Product product) {
        logger.info(">>>>>>deleteProduct:【{}】", product);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = productService.deleteProduct(product);
        } catch (Exception e) {
            logger.error("<<<<<<<< deleteProduct--exception", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0015.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0015.getMessage());
            return resultMsg;
        }
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }
}

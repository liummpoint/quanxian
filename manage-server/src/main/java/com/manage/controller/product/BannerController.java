package com.manage.controller.product;


import com.manage.commom.enums.ErrorCode;
import com.manage.commom.utils.LogUtil;
import com.manage.model.ResultMsg;
import com.manage.model.product.Banner;
import com.manage.model.user.UserManager;
import com.manage.service.product.IBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


@Controller
@RequestMapping(value = "/bannernew")
public class BannerController {
    private static final Logger logger = LoggerFactory.getLogger(BannerController.class);
    @Autowired
    IBannerService iBannerService;

    @RequestMapping(value = "/bannerList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg bannerList(@RequestBody Banner banner, HttpServletRequest request) {

        LogUtil.printRequestLog("发现页参数[product={}]", banner);
        ResultMsg<?> resultMsg = new ResultMsg<>();
        try {

            if (banner.getActivityType() == 0) {
                banner.setType("0");
            } else {
                banner.setType("1");
            }
            resultMsg = iBannerService.getBannerList(banner);
        } catch (Exception e) {
            logger.error("发现页查询失败", e);
        }
        return resultMsg;
    }

    @RequestMapping(value = "/insertBanner", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg<Banner> insertBanner(HttpServletRequest request, Banner banner) {

        ResultMsg<Banner> resultMsg = new ResultMsg<>();
        try {
            iBannerService.insertBanner(banner);
            logger.info("**************************" + banner);
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        } catch (Exception e) {
            logger.error("insertBannerException", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getMessage());
        }
        return resultMsg;
    }

    @RequestMapping(value = "/updateBanner")
    @ResponseBody
    public ResultMsg editCompany(Banner banner, HttpServletRequest request) {
        ResultMsg resultMsg = new ResultMsg();
        logger.info("*******************************" + banner);
        try {

            UserManager userManager = (UserManager) request.getSession().getAttribute("user");
            banner.setUpdateor(userManager.getUserName());
            iBannerService.upBanner(banner);
            resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        } catch (Exception e) {
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getMessage());
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            logger.error("updateBanner Exception", e);
        }
        return resultMsg;
    }

    @RequestMapping(value = "/selectoldupdata", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg<Banner> selectOldUpdata(@RequestBody Banner banner, HttpServletRequest request) {
        ResultMsg resultMsg = new ResultMsg();

        try {
            logger.info("*********************** selectOldUpdata" +banner.getId());
            Banner banner1 = iBannerService.getBanneroldList(banner);
            resultMsg.setData(banner1);
        } catch (Exception e) {
            logger.error("selectoldupdataException", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getMessage());
        }
        return resultMsg;
    }

    @RequestMapping(value = "/downBannerPos", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg downBannerPos(HttpServletRequest request) {
        ResultMsg<?> resultMsg = new ResultMsg<>();
        Banner banner = new Banner();
        try {
            banner.setId(Integer.parseInt(request.getParameter("id")));
            banner.setActivityType(Integer.valueOf(request.getParameter("type")));
            UserManager userManager = (UserManager) request.getSession().getAttribute("user");
            banner.setUpdateor(userManager.getUserName());
            logger.info("bannner页下移参数[id={}]", banner.getId());
            resultMsg = iBannerService.downBanner(banner);
        } catch (Exception e) {
            logger.error("bannner页下移失败", e);
            resultMsg.setResult(false);
            resultMsg.setErrorMsg("系统异常");
        }
        return resultMsg;
    }

    @RequestMapping(value = "/upBannerPos", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg upBannerPos(HttpServletRequest request) {
        ResultMsg<?> resultMsg = new ResultMsg<>();
        Banner banner = new Banner();
        try {
            banner.setId(Integer.parseInt(request.getParameter("id")));
            banner.setActivityType(Integer.valueOf(request.getParameter("type")));
            UserManager userManager = (UserManager) request.getSession().getAttribute("user");
            banner.setUpdateor(userManager.getUserName());
            logger.info("bannner页上移参数[id={}]", banner.getId());
            resultMsg = iBannerService.uppBanner(banner);
        } catch (Exception e) {
            logger.error("bannner页上移失败", e);
            resultMsg.setResult(false);
            resultMsg.setErrorMsg("系统异常");
        }
        return resultMsg;
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public void downLoad(HttpServletResponse response, Integer id) {
        try {
            byte[] b = iBannerService.downLoad(id);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            logger.error("download exception", e);
        }
    }

    private String getBasePath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + contextPath + "/";
        int port = request.getServerPort();
        if (port != 80 && port != 8443) {
            basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
        }
        return basePath;
    }


}

package com.manage.controller.system;

import com.alibaba.fastjson.JSON;
import com.manage.commom.enums.ErrorCode;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.service.system.IMenuService;
import com.manage.system.MenuManage;
import com.manage.utils.BrowserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private IMenuService menuService;

    /**
     * 查询第一级菜单
     *
     * @param parentId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/first", method = {RequestMethod.POST, RequestMethod.GET})
    public void first(@RequestParam(value = "parentId", required = true) Integer parentId, HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("=======begin find first menu");
            List<MenuManage> menuList = menuService.first(parentId);
            request.setAttribute("menuList", menuList);
            if(request.getSession().getAttribute("os") == null){
            	String os = BrowserUtil.getOsAndBrowserInfo(request) ;
                request.getSession().setAttribute("os", os);
            }
            
            logger.info("=======end find first menu");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            logger.error("========find first menu is error=============", e);
            e.printStackTrace();
        }

    }

    /**
     * 根据 父级id查询子菜单
     *
     * @param parentId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/byParentId", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg menuByParentId(@RequestParam(value = "parentId", required = true) Integer parentId, HttpServletRequest request, HttpServletResponse response) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>begin find menuByParentId");
            resultMsg = menuService.menuByParentId(parentId);
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<end find menuByParentId");
        } catch (Exception e) {
            logger.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<find menuByParentId is error", e);
            e.printStackTrace();
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0003.getCode());
            resultMsg.setMsg(ErrorCode.BUSSINESS_ERROR_0003.getMessage());
        }
        return resultMsg;
    }

    /**
     * 查询菜单列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/menuList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg menuList(@RequestBody Map<String, Object> map) {
        Page page = JSON.parseObject(JSON.toJSONString(map.get("page")), Page.class);
        if(page != null){
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[page={}]", page);
        }
        MenuManage menuManage = JSON.parseObject(JSON.toJSONString(map.get("menuManage")), MenuManage.class);
        if(menuManage != null){
            logger.info("[menuManage={}]", menuManage);
        }
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = menuService.selectMenuAll(page, menuManage);
        } catch (Exception e) {
            logger.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<find menuList is error", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getCode());
        }
        return resultMsg;
    }

    /**
     * 查询单个菜单信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/menuOne", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg menuOne(@RequestParam(value = "id", required = true) Integer id) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[id={}]", id);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = menuService.selectMenuById(id);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>find menuList is error", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getCode());
        }
        return resultMsg;
    }

    /**
     * 修改菜单信息
     * @param menuManage
     * @return
     */
    @RequestMapping(value = "/updateMenu", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg updateMenu(@RequestBody MenuManage menuManage) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[menuManage={}]", menuManage);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = menuService.updateMenu(menuManage);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>updateMenu is error", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getCode());
        }
        return resultMsg;
    }

    /**
     * 添加菜单
     * @param menuManage
     * @return
     */
    @RequestMapping(value = "/addMenu", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg addMenu(@RequestBody MenuManage menuManage) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[menuManage={}]", menuManage);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = menuService.addMenu(menuManage);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>updateMenu is error", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getCode());
        }
        return resultMsg;
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @RequestMapping(value = "/delmenu/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg delmenu(@PathVariable int id) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>[menu id={}]", id);
        ResultMsg resultMsg = new ResultMsg();
        try {
            resultMsg = menuService.delMenu(id);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>updateMenu is error", e);
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0033.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0033.getMessage());
        }
        return resultMsg;
    }
}

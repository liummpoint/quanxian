package com.manage.service.impl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.commom.enums.ErrorCode;
import com.manage.commom.utils.LogUtil;
import com.manage.dao.admin.AdminRoleMapper;
import com.manage.dao.system.MenuManageMapper;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.admin.AdminRole;
import com.manage.model.page.Page;
import com.manage.model.user.UserManager;
import com.manage.service.system.IMenuService;
import com.manage.system.MenuManage;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuManageMapper menuManageMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    /**
     * 查询第一级菜单
     * @param parentId  父级id
     * @return
     * @throws Exception
     */
    @Override
    public List<MenuManage> first(Integer parentId) throws Exception {
        logger.info("---------------parentId={}", parentId);
        List<MenuManage> menuList = menuManageMapper.selectByParentId(parentId);
        logger.info("find first menu  success");
        return menuList;
    }

    /**
     * 根据 父级id查询子菜单
     * @param parentId  父级id
     * @return
     * @throws Exception
     */
    @Override
    public ResultMsg menuByParentId(Integer parentId) throws Exception {
        logger.info("---------------parentId={}", parentId);
        ResultMsg resultMsg = new ResultMsg();
        List<MenuManage> menuList = menuManageMapper.selectByParentId(parentId);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object object = request.getSession().getAttribute("user");
        if (object != null) {
            UserManager userManager = (UserManager) object;
            AdminRole adminRole = adminRoleMapper.selectAdminRoleById(userManager.getRoleId());
            request.getSession().setAttribute("role", adminRole);
        }

        resultMsg.setRows(menuList);
        logger.info("menuByParentId  success");
        return resultMsg;
    }

    @Override
    public ResultMsg selectMenuAll(Page page, MenuManage menuManage){
        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        List<MenuManage> menuManageList = menuManageMapper.selectMenuAll(menuManage);
        for (MenuManage menuManage1:menuManageList){
            MenuManage menuManageNew=menuManageMapper.selectMenuById(menuManage1.getParentId());
            if(menuManageNew != null){
                menuManage1.setParentName(menuManageNew.getName());
            }
        }
        if(CollectionUtils.isNotEmpty(menuManageList)){
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> selectMenuAll Success "+menuManageList.size());
        }else{
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> selectMenuAll Success "+0);
        }
        PageInfo pageInfo = new PageInfo(menuManageList);
        return PageInfoResult.PageInfoMsg(pageInfo);
    }

    @Override
    public ResultMsg selectMenuById(int id){
        ResultMsg resultMsg=new ResultMsg();
        MenuManage menuManageNew=menuManageMapper.selectMenuById(id);
        resultMsg.setData(menuManageNew);
        return resultMsg;
    }

    @Override
    public ResultMsg updateMenu(MenuManage menuManage){
        ResultMsg resultMsg=new ResultMsg();
        if(menuManage.getMenuGrade() == 1){
            menuManage.setParentId(0);
            menuManage.setParentName("");
        }
        menuManageMapper.updateMenu(menuManage);
        resultMsg.setData(menuManage);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getCode());
        return resultMsg;
    }

    @Override
    public ResultMsg addMenu(MenuManage menuManage) {
        ResultMsg resultMsg=new ResultMsg();
        if(menuManage.getMenuGrade() == 1){
            menuManage.setParentId(0);
            menuManage.setParentName("");
        }
        menuManageMapper.addMenu(menuManage);
        resultMsg.setData(menuManage);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getCode());
        return resultMsg;
    }

    @Override
    public ResultMsg delMenu(int id) {
        LogUtil.printRequestLog("delMenu id={}",id);
        ResultMsg resultMsg=new ResultMsg();
        menuManageMapper.delMenu(id);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }
}

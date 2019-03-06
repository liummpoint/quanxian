package com.manage.service.impl;

import com.manage.commom.enums.ErrorCode;
import com.manage.commom.exception.CddException;
import com.manage.commom.utils.ParamValidUtil;
import com.manage.dao.admin.AdminRoleMapper;
import com.manage.dao.system.MenuManageMapper;
import com.manage.dao.user.UserManagerMapper;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.admin.AdminRole;
import com.manage.model.page.Page;
import com.manage.model.user.UserManager;
import com.manage.service.IUserManagerService;
import com.manage.utils.SessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserManagerServiceImpl implements IUserManagerService {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerServiceImpl.class);
    @Resource
    private UserManagerMapper userManagerMapper;
    @Resource
    private AdminRoleMapper adminRoleMapper;
    @Resource
    private MenuManageMapper menuManageMapper;

    /**
     * 添加用户
     *
     * @param userManager
     * @return
     * @throws Exception
     */
    @Override
    public ResultMsg addUser(UserManager userManager) throws CddException {
        ResultMsg<UserManager> resultMsg = new ResultMsg<>();
        int num = userManagerMapper.selectUserName(userManager.getUserName());
        if (num != 0) {
            logger.info("<<<<<<<User already exist");
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0012.getCode());
            resultMsg.setErrorMsg(ErrorCode.RETURN_ERROR_0012.getMessage());
            return resultMsg;
        }

        ParamValidUtil.checkNull("用户名", userManager.getUserName());
        ParamValidUtil.checkNull("密码", userManager.getPassword());
        ParamValidUtil.checkNull("手机号", userManager.getMobile());
        ParamValidUtil.checkNull("邮箱", userManager.getEmail());
        userManagerMapper.addUser(userManager);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        logger.info("<<<<<<addUser insert success");
        return resultMsg;
    }

    /**
     * 展示所有用户信息
     *
     * @return
     */
    @Override
    public ResultMsg findUserManager(Page page) throws Exception {
       /* UserManager userManager = new UserManager();

        userManager.setStartSize(page.getStartIndex());
        userManager.setSize(page.getPageSize());
        Map<Object, Object> info = new HashMap<Object, Object>();
        List<UserManager> list = userManagerMapper.selectUserManager(userManager);
        info.put("pageData", list);

        List<UserManager> user = userManagerMapper.selectUserManagerAll();
        if (user != null) {
            info.put("total", user.size());
        } else {
            info.put("total", 0);
        }

        info.put("draw", page.getDraw());
        logger.info(JSONObject.fromObject(info) + "");
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(JSONObject.fromObject(info));
        return resultMsg;*/
        UserManager userManager = new UserManager();
        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);                  /////////////////////////
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        List<UserManager> list = userManagerMapper.selectUserManager(userManager);
        PageInfo pageInfo = new PageInfo(list);
        return PageInfoResult.PageInfoMsg(pageInfo);
    }


    /**
     * 修改用户状态
     *
     * @param
     * @return
     */
    @Override
    public ResultMsg updateStatus(UserManager userManager) throws CddException {
        ResultMsg resultMsg = new ResultMsg();
        logger.info(">>>>>tart update status");

        ParamValidUtil.checkNull("id", userManager.getId());
        ParamValidUtil.checkNull("状态", userManager.getStatus());

        int status = userManager.getStatus();
        if (status == 0) {
            userManager.setStatus(1);
        } else {
            userManager.setStatus(0);
        }

        userManagerMapper.updateStatus(userManager);
        logger.info("<<<<<update status success");
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;

    }

    /**
     * 根据ID查找用户信息
     *
     * @param
     * @return
     */

    @Override
    public ResultMsg selectUserById(UserManager paramUserManager) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        UserManager userManager = userManagerMapper.selectUserById(paramUserManager);
        Integer roleId = userManager.getRoleId();
        AdminRole adminRole = adminRoleMapper.selectAdminRoleById(roleId);
        String roleName = adminRole.getRoleName();
        userManager.setRoleName(roleName);
        resultMsg.setData(userManager);
        return resultMsg;
    }

    /**
     * 修改用户信息
     *
     * @param userManager
     * @return
     */
    @Override
    public ResultMsg updateUser(UserManager userManager) throws Exception {
        ResultMsg resultMsg = new ResultMsg();

        ParamValidUtil.checkNull("id", userManager.getUserName());
        ParamValidUtil.checkNull("角色id", userManager.getRoleId());
        ParamValidUtil.checkNull("手机号", userManager.getMobile());
        ParamValidUtil.checkNull("邮箱", userManager.getEmail());

        userManagerMapper.updateUser(userManager);
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }


    /**
     * 逻辑删除用户
     *
     * @param
     * @return
     */
    @Override
    public ResultMsg deleteUser(UserManager userManager) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        userManagerMapper.deleteUser(userManager);
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        logger.info(">>>>>>delete user end");
        return resultMsg;
    }

    @Override
    public ResultMsg editPassword(HttpServletRequest request, UserManager userManager) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int num = userManagerMapper.selectPassword(userManager);
        if (num == 0) {
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0014.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0014.getMessage());
            logger.info("the old password error");
        } else {
            String password = userManager.getPassword2();
            userManager.setPassword(password);
            userManager.setUpdateTime(simpleDateFormat.format(new Date()));
            userManager.setNeedtime(String.valueOf(new Date().getTime() + 90 *  24 * 60 * 60 * 1000));
            userManagerMapper.updatePassword(userManager);
            request.getSession().setAttribute("user", null);
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());

        }
        return resultMsg;
    }

    /**
     * 修改密码
     *
     * @param
     * @return
     */
    @Override
    public ResultMsg updatePassword(HttpServletRequest request, UserManager userManager) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserManager userManagermd5 = userManagerMapper.selectPasswordMD5Byid(userManager);
        if (Integer.valueOf(userManagermd5.getInputnum()) >= 5 && String.valueOf(new Date().getTime()).compareTo(userManagermd5.getLocktime()) < 0){
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0018.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0018.getMessage());
            return resultMsg;
        }

        int num = userManagerMapper.selectPassword(userManager);
        if (num == 0) {
            logger.info("<<<<<<<Old password error");
            if (Integer.valueOf(userManagermd5.getInputnum()) >= 4){
                userManagermd5.setInputnum("5");
                Date vericodeExpired = new Date();
                vericodeExpired.setTime(new Date().getTime() + 24 * 60 * 60 * 1000 );//24小时有效
                userManagermd5.setLocktime(String.valueOf(vericodeExpired.getTime()));
                userManagerMapper.updateLocktime(userManagermd5);
            }else{
                userManagermd5.setInputnum(String.valueOf(Integer.valueOf(userManagermd5.getInputnum()) + 1));
                userManagermd5.setLocktime("");
                userManagerMapper.updateLocktime(userManagermd5);
                String password = userManager.getPassword2();
                userManager.setPassword(password);
                userManager.setUpdateTime(simpleDateFormat.format(new Date()));
                long addtime = 24 * 60 * 60 * 1000;
                addtime =addtime * 90;
                userManager.setNeedtime(String.valueOf(new Date().getTime() + addtime));
                userManagerMapper.updatePassword(userManager);
            }
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0014.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0014.getMessage());

        } else {
            logger.info("<<<<<start update password");
            //清空锁定记录
            userManagermd5.setInputnum("0");
            userManagermd5.setLocktime("");
            userManagerMapper.updateLocktime(userManagermd5);
            String password = userManager.getPassword2();
            userManager.setPassword(password);
            userManager.setUpdateTime(simpleDateFormat.format(new Date()));
            long addtime = 24 * 60 * 60 * 1000;
            addtime =addtime * 90;
            userManager.setNeedtime(String.valueOf(new Date().getTime() + addtime));
            userManagerMapper.updatePassword(userManager);
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        }
        return resultMsg;
    }


    /**
     * 用户登录
     *
     * @param
     * @param
     * @return
     */
    @Override
    public ResultMsg checkuser(UserManager paramUserManager){
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("用户名", paramUserManager.getUserName());
        ParamValidUtil.checkNull("密码", paramUserManager.getPassword());

        UserManager userManager = userManagerMapper.selectUser(paramUserManager);
        if (userManager == null) {
            userManager = userManagerMapper.selectPasswordMD5(paramUserManager);
            if (userManager != null ){
                if (Integer.valueOf(userManager.getInputnum()) >= 5 && String.valueOf(new Date().getTime()).compareTo(userManager.getLocktime()) < 0){
                    resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0018.getCode());
                    resultMsg.setMsg(ErrorCode.RETURN_ERROR_0018.getMessage());
                    return resultMsg;
                }

                if (Integer.valueOf(userManager.getInputnum()) >= 4){
                    userManager.setInputnum("5");
                    Date vericodeExpired = new Date();
                    vericodeExpired.setTime(new Date().getTime() + 24 * 60 * 60 * 1000 );//24小时有效
                    userManager.setLocktime(String.valueOf(vericodeExpired.getTime()));
                    userManagerMapper.updateLocktime(userManager);
                }else{
                    userManager.setInputnum(String.valueOf(Integer.valueOf(userManager.getInputnum()) + 1));
                    userManager.setLocktime("");
                    userManagerMapper.updateLocktime(userManager);
                }
            }
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
            return resultMsg;
        }else{
            if (Integer.valueOf(userManager.getInputnum()) >= 5 && String.valueOf(new Date().getTime()).compareTo(userManager.getLocktime()) < 0){
                resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0018.getCode());
                resultMsg.setMsg(ErrorCode.RETURN_ERROR_0018.getMessage());
                return resultMsg;
            }
        }
        resultMsg.setData(userManager);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    /**
     * 用户登录
     *
     * @param
     * @param
     * @return
     */
    @Override
    public ResultMsg userLogin(UserManager paramUserManager) throws CddException {
        ResultMsg resultMsg = new ResultMsg();

        ParamValidUtil.checkNull("用户名", paramUserManager.getUserName());
        ParamValidUtil.checkNull("密码", paramUserManager.getPassword());

        UserManager userManager = userManagerMapper.selectUser(paramUserManager);
        if (userManager == null) {
            userManager = userManagerMapper.selectPasswordMD5(paramUserManager);
            resultMsg.setResultstrcode(ErrorCode.BUSSINESS_ERROR_0002.getCode());
            resultMsg.setMsg(ErrorCode.BUSSINESS_ERROR_0002.getMessage());
            if (userManager != null){
                if (Integer.valueOf(userManager.getInputnum()) >= 5 && String.valueOf(new Date().getTime()).compareTo(userManager.getLocktime()) < 0){
                    resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0018.getCode());
                    resultMsg.setMsg(ErrorCode.RETURN_ERROR_0018.getMessage());
                    return resultMsg;
                }

                if (Integer.valueOf(userManager.getInputnum()) >= 4){
                    userManager.setInputnum("5");
                    Date vericodeExpired = new Date();
                    vericodeExpired.setTime(new Date().getTime() + 24 * 60 * 60 * 1000 );//24小时有效
                    userManager.setLocktime(String.valueOf(vericodeExpired.getTime()));
                    userManagerMapper.updateLocktime(userManager);
                }else{
                    userManager.setInputnum(String.valueOf(Integer.valueOf(userManager.getInputnum()) + 1));
                    userManager.setLocktime("");
                    userManagerMapper.updateLocktime(userManager);
                }
            }
            return resultMsg;
        }
        if (Integer.valueOf(userManager.getInputnum()) >= 5 && String.valueOf(new Date().getTime()).compareTo(userManager.getLocktime()) < 0){
            resultMsg.setResultstrcode(ErrorCode.RETURN_ERROR_0018.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_ERROR_0018.getMessage());
            return resultMsg;
        }
        userManager.setInputnum("0");
        userManager.setLocktime("");
        userManager.setLoginsessionid(paramUserManager.getLoginsessionid());
        userManagerMapper.updateLocktimeloginsession(userManager);

        AdminRole adminRole = adminRoleMapper.selectAdminRoleById(userManager.getRoleId());

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("role", adminRole);
        request.getSession().setAttribute("user", userManager);
        SessionUtil.setMenuId(menuManageMapper.selectMenu());//保存菜单信息到session

        if (userManager.getNeedtime() == null || String.valueOf(new Date().getTime()).compareTo(userManager.getNeedtime()) >= 0){
            resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_1000.getCode());
            resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_1000.getMessage());
            return resultMsg;
        }

        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        logger.info("<<<<<<<login success");
        return resultMsg;
    }

    /**
     * 查询用户角色
     *
     * @return
     */
    @Override
    public List selectUserRole() {
        logger.info(">>>>>select user role");
        List userManager = adminRoleMapper.selectAllAdminRole();
        return userManager;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<UserManager> findUserManagerAll() throws Exception {
        logger.info(">>>>>select user all");
        return userManagerMapper.selectUserManagerAll();
    }


    /**
     * 退出并清除session
     */
    @Override
    public ResultMsg exit(HttpServletRequest request) throws Exception {
        logger.info(">>>>>>exit clear away session------");
        ResultMsg resultMsg = new ResultMsg();
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("user", null);
        resultMsg.setResultstrcode(ErrorCode.RETURN_SUCCESS_0000.getCode());
        resultMsg.setMsg(ErrorCode.RETURN_SUCCESS_0000.getMessage());
        return resultMsg;
    }

    @Override
    public void findTest() {
        List<UserManager> list = userManagerMapper.selectUserManager(new UserManager());
        System.out.println(list.size());
    }

    @Override
    public void insertTest() {
        List<UserManager> list = userManagerMapper.selectUserManager(new UserManager());
        System.out.println(list.size());
    }


}

package com.manage.service;


import com.manage.datasourceAnnotation.SourcesEnum;
import com.manage.datasourceAnnotation.TargetDataSource;
import com.manage.model.ResultMsg;
import com.manage.model.page.Page;
import com.manage.model.user.UserManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserManagerService {
    /**
     * 添加用户
     *
     * @param userManager
     * @return
     */
	 @TargetDataSource(SourcesEnum.write)
     ResultMsg<UserManager> addUser(UserManager userManager) throws Exception;

    /**
     * 查询所有用户
     *
     * @param
     */
    ResultMsg findUserManager(Page page) throws Exception;

    /**
     * 修改用户状态
     */
    @TargetDataSource(SourcesEnum.write)
    ResultMsg updateStatus(UserManager userManager) throws Exception;

    /**
     * 修改用户页面传值
     */
    ResultMsg selectUserById(UserManager userManager) throws Exception;

    /**
     * 修改用户信息
     */
    @TargetDataSource(SourcesEnum.write)
    ResultMsg updateUser(UserManager userManager) throws Exception;

    /**
     * 逻辑删除用户
     */
    @TargetDataSource(SourcesEnum.write)
    ResultMsg deleteUser(UserManager userManager) throws Exception;

    /**
     * 修改密码
     */
    @TargetDataSource(SourcesEnum.write)
    ResultMsg editPassword(HttpServletRequest request,UserManager userManager) throws Exception;

    @TargetDataSource(SourcesEnum.write)
    ResultMsg updatePassword(HttpServletRequest request,UserManager userManager) throws Exception;

    /**
     * 用户登录
     *
     * @param
     * @param
     * @return
     */
    @TargetDataSource(SourcesEnum.write)
    ResultMsg userLogin(UserManager userManager) throws Exception;

    /**
     * 查询用户角色
     *
     * @return
     */
    List selectUserRole();

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserManager> findUserManagerAll() throws Exception;

    /**
     * 退出并清除session
     */
    ResultMsg exit(HttpServletRequest request) throws Exception;

    void findTest();
    void insertTest();

    /**
     *
     *
     * @return
     */
    @TargetDataSource(SourcesEnum.write)

    /**
     * 查询用户
     *
     * @return
     */
    public ResultMsg  checkuser(UserManager paramUserManager);
}

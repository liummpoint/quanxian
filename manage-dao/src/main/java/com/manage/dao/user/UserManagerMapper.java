package com.manage.dao.user;

import com.manage.model.user.UserManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserManagerMapper {
    /**
     * 添加用户
     *
     * @param userManagers
     * @return
     */
    int addUser(UserManager userManagers);

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    int selectUserName(String name);

    /**
     * 修改用户状态
     *
     * @param
     * @return
     */
    int updateStatus(UserManager userManager);

    /**
     * 根据ID查询用户
     *
     * @param
     * @return
     */
    UserManager selectUserById(UserManager userManager);

    /**
     * 修改用户信息
     *
     * @param userManager
     * @return
     */
    int updateUser(UserManager userManager);

    /**
     * 逻辑删除用户
     *
     * @param
     * @return
     */
    int deleteUser(UserManager userManager);

    /**
     * 根据ID查询密码
     *
     * @param
     * @return
     */
    int selectPassword(UserManager userManager);

    /**
     * 修改密码
     *
     * @param
     * @return
     */
    int updatePassword(UserManager userManager);

    /**
     * 用户登录
     *
     * @param
     * @return
     */
    UserManager selectUser(UserManager userManager);

    /**
     * 查询用户
     *
     * @return
     */
    List<UserManager> selectUserManager(UserManager userManager);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<UserManager> selectUserManagerAll();

    /**
     * 用户登录
     *
     * @param
     * @return
     */
    UserManager selectPasswordMD5(UserManager userManager);

    /**
     * 修改锁定时间
     *
     * @param
     * @return
     */
    int updateLocktime(UserManager userManager);

    /**
     * 用户登录
     *
     * @param
     * @return
     */
    UserManager selectPasswordMD5Byid(UserManager userManager);

    /**
     * 修改锁定时间和session记录
     *
     * @param
     * @return
     */
    int updateLocktimeloginsession(UserManager userManager);

}

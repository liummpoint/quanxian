package com.manage.dao.user;

import com.manage.model.user.UserList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserListMapper {


    //查询用户列表
    List<UserList> selectUserList(UserList userList);
    List<UserList> selectUserListGL(UserList userList);
    List<UserList> selectUserInfoList(UserList userList);
    UserList getFirstInvestInfo(String id);
    UserList getSecondInvestInfo(String id);
    //投资次数
    String selectInvestCount(String id);
   
    //用户管理下
    List<UserList> selectUserListExp(UserList userList);
    //截止当日数据汇总—用户
    List<UserList>  selectUserSumExp(UserList userList);
    List<UserList>  selectUserSumExpGL(UserList userList);
}

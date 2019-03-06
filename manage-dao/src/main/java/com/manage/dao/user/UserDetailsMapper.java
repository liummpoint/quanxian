package com.manage.dao.user;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.manage.model.user.UserDetails;
import com.manage.model.user.UserDetailsList;
import com.manage.model.user.UserRisk;

@Repository
public interface UserDetailsMapper {
    UserDetails selectUserDetails(String id);
    String selectRiskType(String id);
    UserDetails selectreCashAndChargeAmount(String id);
    String selectTotalAmount(String id);
    String selectAmount(String id);
    UserDetails selectNoviceAndCurrent(String id);
    UserDetails selectRegular(String id);
    String selectTransferAmount(String id);
    String selectMatchingAmount(String id);
    UserDetails selectTotolNoviceAndCurrent(String id);
    String  selectTotalRegular(String id);
    String getPlanTotalAmount(UserDetailsList userDetailsList);
    String getCurrentTotleAmount(UserDetailsList userDetailsList);
    String getPlanAmount(UserDetailsList userDetailsList);
    String getCurrentAmount(UserDetailsList userDetailsList);
    String getCurrentMatchingAmount(UserDetailsList userDetailsList);
    String getPlanMatchingAmount(UserDetailsList userDetailsList);
    String getCurrentInterest(UserDetailsList userDetailsList);
    String getPlanInterest(UserDetailsList userDetailsList);
    String getPlanTransferAmount(UserDetailsList userDetailsList);
    String getTransferAmount(String id);
    String getPlanFirstInvestTime(UserDetailsList userDetailsList);
    String getFirstInvestTime(UserDetailsList userDetailsList);
    UserDetails selectNoInvestUserDetails(String id);
    String selectTotalAccountBalance(String id);
    String getFirstNoviceInvestTime(String id);
    String getNoviceTotleAmount(String id);
    String getNoviceAmount(String id);
    List<UserRisk> getUserRisk(String id);
    String selectParentChannel(String parentId);
    UserDetails selectParentChannelDetails(String parentId);
    Map<String,Object> selectChannel(String parentId);

}

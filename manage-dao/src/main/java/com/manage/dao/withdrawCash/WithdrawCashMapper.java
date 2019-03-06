package com.manage.dao.withdrawCash;

import com.manage.model.withdrawCash.WithdrawCash;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawCashMapper {

    List<WithdrawCash> selectWithdrawCashList();

    WithdrawCash selectWithdrawCashById(Integer withdrawCashId);

    int deleteWithdrawCash(WithdrawCash withdrawCash);

    int insertWithdrawCash(WithdrawCash withdrawCash);

    int updateWithdrawCash(WithdrawCash withdrawCash);


}

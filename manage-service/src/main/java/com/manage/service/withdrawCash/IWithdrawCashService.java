package com.manage.service.withdrawCash;

import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.withdrawCash.WithdrawCash;

public interface IWithdrawCashService {

    ResultMsg selectWithdrawCashList(Page page) throws Exception;

    ResultMsg selectWithdrawCashById(Integer applyCardId) throws Exception;

    ResultMsg updateWithdrawCash(WithdrawCash withdrawCash) throws Exception;

    ResultMsg insertWithdrawCash(WithdrawCash withdrawCash) throws Exception;

    ResultMsg deleteWithdrawCash(WithdrawCash withdrawCash) throws Exception;
}

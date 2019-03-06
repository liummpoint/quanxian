package com.manage.dao.user;

import com.manage.model.user.BankCard;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardMapper {
    /**
     * 根据手机号或者签约账号查询银行卡
     * @param bankCard
     * @return
     */
    BankCard selectBankCard(BankCard bankCard);
    BankCard selectBankCardInfo(BankCard bankCard);
    int updateBankCard(BankCard bankCard);
    BankCard selectBankCardInfoByuserid(String userid);
}

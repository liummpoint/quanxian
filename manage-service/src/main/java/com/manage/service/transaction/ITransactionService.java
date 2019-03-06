package com.manage.service.transaction;

import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.transaction.Transaction;

public interface ITransactionService {
    ResultMsg selectTransactionList(Page page) throws Exception;

    ResultMsg selectTransactionById(Integer applyCardId) throws Exception;

    ResultMsg insertTransaction(Transaction transaction) throws Exception;

    ResultMsg deleteTransaction(Transaction transaction) throws Exception;
}

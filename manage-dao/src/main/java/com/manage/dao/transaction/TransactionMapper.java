package com.manage.dao.transaction;

import com.manage.model.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionMapper {

    List<Transaction> selectTransactionList();

    Transaction selectTransactionById(Integer withdrawCashId);

    int deleteTransaction(Transaction withdrawCash);

    int insertTransaction(Transaction withdrawCash);

    int updateTransaction(Transaction withdrawCash);
}

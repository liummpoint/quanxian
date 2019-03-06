package com.manage.service.impl.transaction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.commom.utils.ParamValidUtil;
import com.manage.dao.transaction.TransactionMapper;
import com.manage.model.page.Page;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.transaction.Transaction;
import com.manage.model.user.UserManager;
import com.manage.service.transaction.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements ITransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    @Autowired
    private TransactionMapper transactionMapper;


    /**
     * 展示所有用户信息
     *
     * @return
     */
    @Override
    public ResultMsg selectTransactionList(Page page) throws Exception {


        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        List<Transaction> list = transactionMapper.selectTransactionList();
        PageInfo pageInfo = new PageInfo(list);
        return PageInfoResult.PageInfoMsg(pageInfo);
    }

    @Override
    public ResultMsg selectTransactionById(Integer transactionId) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        Transaction transaction = transactionMapper.selectTransactionById(transactionId);
        resultMsg.setData(transaction);
        return resultMsg;
    }


    @Override
    public ResultMsg insertTransaction(Transaction transaction) throws Exception {
        ResultMsg<UserManager> resultMsg = new ResultMsg<>();
        ParamValidUtil.checkNull("订单ID", transaction.getServiceOrderId());
        ParamValidUtil.checkNull("金额或积分", transaction.getAmount());
        ParamValidUtil.checkNull("交易类型", transaction.getTransactionType());
        ParamValidUtil.checkNull("交易状态", transaction.getStatus());

        transaction.setBizUserId(11111);
        transaction.setIsDeleted(0);
        transaction.setCreateTime(System.currentTimeMillis());
        transaction.setUpdateTime(System.currentTimeMillis());
        transactionMapper.insertTransaction(transaction);
        return resultMsg;
    }

    @Override
    public ResultMsg deleteTransaction(Transaction transaction) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("交易ID", transaction.getTransactionId());
        transactionMapper.deleteTransaction(transaction);
        return resultMsg;
    }
}


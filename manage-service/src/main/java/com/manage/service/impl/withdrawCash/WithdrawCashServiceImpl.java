package com.manage.service.impl.withdrawCash;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.commom.utils.ParamValidUtil;
import com.manage.dao.withdrawCash.WithdrawCashMapper;
import com.manage.model.page.Page;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.user.UserManager;
import com.manage.model.withdrawCash.WithdrawCash;
import com.manage.service.withdrawCash.IWithdrawCashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawCashServiceImpl implements IWithdrawCashService {

    private static final Logger logger = LoggerFactory.getLogger(WithdrawCashServiceImpl.class);
    @Autowired
    private WithdrawCashMapper withdrawCashMapper;


    /**
     * 展示所有提现信息
     *
     * @return
     */
    @Override
    public ResultMsg selectWithdrawCashList(Page page) throws Exception {


        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        List<WithdrawCash> list = withdrawCashMapper.selectWithdrawCashList();
        PageInfo pageInfo = new PageInfo(list);
        return PageInfoResult.PageInfoMsg(pageInfo);
    }

    @Override
    public ResultMsg selectWithdrawCashById(Integer withdrawCashId) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        WithdrawCash withdrawCash = withdrawCashMapper.selectWithdrawCashById(withdrawCashId);
        resultMsg.setData(withdrawCash);
        return resultMsg;
    }

    @Override
    public ResultMsg updateWithdrawCash(WithdrawCash withdrawCash) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("真实姓名", withdrawCash.getRealname());
        ParamValidUtil.checkNull("身份证号", withdrawCash.getIdCardNo());
        ParamValidUtil.checkNull("银行卡号", withdrawCash.getBankCardNo());
        ParamValidUtil.checkNull("开户行", withdrawCash.getOpenCard());
        ParamValidUtil.checkNull("手机号", withdrawCash.getCellphone());

        WithdrawCash withdrawCashOld=withdrawCashMapper.selectWithdrawCashById(withdrawCash.getWithdrawCashId());
        withdrawCashOld.setRealname(withdrawCash.getRealname());
        withdrawCashOld.setIdCardNo(withdrawCash.getIdCardNo());
        withdrawCashOld.setBankCardNo(withdrawCash.getBankCardNo());
        withdrawCashOld.setOpenCard(withdrawCash.getOpenCard());
        withdrawCashOld.setCellphone(withdrawCash.getCellphone());
        withdrawCashOld.setUpdateTime(System.currentTimeMillis());
        withdrawCashMapper.updateWithdrawCash(withdrawCashOld);
        return resultMsg;
    }


    @Override
    public ResultMsg insertWithdrawCash(WithdrawCash withdrawCash) throws Exception {
        ResultMsg<UserManager> resultMsg = new ResultMsg<>();
        ParamValidUtil.checkNull("用户ID", withdrawCash.getBizUserId());
        ParamValidUtil.checkNull("真实姓名", withdrawCash.getRealname());
        ParamValidUtil.checkNull("身份证号", withdrawCash.getIdCardNo());
        ParamValidUtil.checkNull("银行卡号", withdrawCash.getBankCardNo());
        ParamValidUtil.checkNull("开户行", withdrawCash.getOpenCard());
        ParamValidUtil.checkNull("手机号", withdrawCash.getCellphone());

        withdrawCash.setWithdrawStatus(0);
        withdrawCash.setIsDeleted(0);
        withdrawCash.setCreateTime(System.currentTimeMillis());
        withdrawCash.setUpdateTime(System.currentTimeMillis());
        withdrawCashMapper.insertWithdrawCash(withdrawCash);
        return resultMsg;
    }

    @Override
    public ResultMsg deleteWithdrawCash(WithdrawCash withdrawCash) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("提现申请ID", withdrawCash.getWithdrawCashId());
        withdrawCashMapper.deleteWithdrawCash(withdrawCash);
        return resultMsg;
    }
}

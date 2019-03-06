package com.manage.service.impl.bizUser;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.commom.utils.ParamValidUtil;
import com.manage.dao.bizUser.BizUserMapper;
import com.manage.model.page.Page;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.user.UserManager;
import com.manage.model.bizUser.BizUser;
import com.manage.service.bizUser.IBizUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BizUserServiceImpl implements IBizUserService {

    private static final Logger logger = LoggerFactory.getLogger(BizUserServiceImpl.class);
    @Autowired
    private BizUserMapper bizUserMapper;


    /**
     * 展示所有提现信息
     *
     * @return
     */
    @Override
    public ResultMsg selectBizUserList(Page page) throws Exception {


        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        List<BizUser> list = bizUserMapper.selectBizUserList();
        PageInfo pageInfo = new PageInfo(list);
        return PageInfoResult.PageInfoMsg(pageInfo);
    }

    @Override
    public ResultMsg selectBizUserById(Integer bizUserId) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        BizUser bizUser = bizUserMapper.selectBizUserById(bizUserId);
        resultMsg.setData(bizUser);
        return resultMsg;
    }

    @Override
    public ResultMsg updateBizUser(BizUser bizUser) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("用户ID", bizUser.getBizUserId());

        BizUser bizUserOld=bizUserMapper.selectBizUserById(bizUser.getBizUserId());
        bizUserOld.setGrade(bizUser.getGrade());
        bizUserOld.setOrderStatistics(bizUser.getOrderStatistics());
        bizUserOld.setFinishDistributeFee(bizUser.getFinishDistributeFee());
        bizUserOld.setPreDistributeFee(bizUser.getPreDistributeFee());
        bizUserOld.setUpdateTime(System.currentTimeMillis());
        bizUserMapper.updateBizUser(bizUserOld);
        return resultMsg;
    }


    @Override
    public ResultMsg insertBizUser(BizUser bizUser) throws Exception {
        ResultMsg<UserManager> resultMsg = new ResultMsg<>();
        ParamValidUtil.checkNull("用户昵称", bizUser.getBizUserName());
        ParamValidUtil.checkNull("手机号", bizUser.getCellphone());
        ParamValidUtil.checkNull("类型", bizUser.getType());

        bizUser.setIsDeleted(0);
        bizUser.setCreateTime(System.currentTimeMillis());
        bizUser.setUpdateTime(System.currentTimeMillis());
        bizUserMapper.insertBizUser(bizUser);
        return resultMsg;
    }

    @Override
    public ResultMsg deleteBizUser(BizUser bizUser) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("用户ID", bizUser.getBizUserId());
        bizUserMapper.deleteBizUser(bizUser);
        return resultMsg;
    }
}

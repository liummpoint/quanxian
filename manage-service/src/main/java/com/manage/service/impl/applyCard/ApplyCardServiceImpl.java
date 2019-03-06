package com.manage.service.impl.applyCard;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.commom.utils.ParamValidUtil;
import com.manage.model.page.Page;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.user.UserManager;
import com.manage.service.applyCard.IApplyCardService;
import com.manage.dao.applyCard.ApplyCardMapper;
import com.manage.model.applyCard.ApplyCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyCardServiceImpl implements IApplyCardService {

    private static final Logger logger = LoggerFactory.getLogger(ApplyCardServiceImpl.class);
    @Autowired
    private ApplyCardMapper applyCardMapper;


    /**
     * 展示所有用户信息
     *
     * @return
     */
    @Override
    public ResultMsg selectApplyCardList(Page page) throws Exception {


        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
//        List<ApplyCard> list =new ArrayList<ApplyCard>();
        List<ApplyCard> list = applyCardMapper.selectApplyCardList();
        PageInfo pageInfo = new PageInfo(list);
        return PageInfoResult.PageInfoMsg(pageInfo);
    }

    @Override
    public ResultMsg selectApplyCardById(Integer applyCardId) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ApplyCard applyCard = applyCardMapper.selectApplyCardById(applyCardId);
        resultMsg.setData(applyCard);
        return resultMsg;
    }

    @Override
    public ResultMsg updateApplyCard(ApplyCard applyCard) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("申请信用卡ID", applyCard.getApplyCardId());
        ParamValidUtil.checkNull("申请者姓名", applyCard.getApplyName());
        ParamValidUtil.checkNull("申请者身份证号", applyCard.getApplyIdCardNo());
        ParamValidUtil.checkNull("申请者手机号码", applyCard.getApplyPhone());
        applyCard.setUpdateTime(System.currentTimeMillis());
        applyCardMapper.updateApplyCard(applyCard);
        return resultMsg;
    }


    @Override
    public ResultMsg insertApplyCard(ApplyCard applyCard) throws Exception {
        ResultMsg<UserManager> resultMsg = new ResultMsg<>();
        ParamValidUtil.checkNull("用户ID", applyCard.getBizUserId());
        ParamValidUtil.checkNull("订单号", applyCard.getServiceOrderId());
        ParamValidUtil.checkNull("产品活动ID", applyCard.getProductActivityId());
        ParamValidUtil.checkNull("申请者姓名", applyCard.getApplyName());
        ParamValidUtil.checkNull("申请者身份证号", applyCard.getApplyIdCardNo());
        ParamValidUtil.checkNull("申请者手机号码", applyCard.getApplyPhone());

        applyCard.setStatus(0);
        applyCard.setIsDeleted(0);
        applyCard.setCreateTime(System.currentTimeMillis());
        applyCard.setUpdateTime(System.currentTimeMillis());
        applyCardMapper.insertApplyCard(applyCard);
        return resultMsg;
    }

    @Override
    public ResultMsg deleteApplyCard(ApplyCard applyCard) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        ParamValidUtil.checkNull("申请信用卡ID", applyCard.getApplyCardId());
        applyCardMapper.deleteApplyCard(applyCard);
        return resultMsg;
    }
}

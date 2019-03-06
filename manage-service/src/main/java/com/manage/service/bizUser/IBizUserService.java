package com.manage.service.bizUser;

import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.bizUser.BizUser;

public interface IBizUserService {

    ResultMsg selectBizUserList(Page page) throws Exception;

    ResultMsg selectBizUserById(Integer applyCardId) throws Exception;

    ResultMsg updateBizUser(BizUser bizUser) throws Exception;

    ResultMsg insertBizUser(BizUser bizUser) throws Exception;

    ResultMsg deleteBizUser(BizUser bizUser) throws Exception;
}

package com.manage.service.applyCard;

import com.manage.model.applyCard.ApplyCard;
import com.manage.model.page.Page;
import com.manage.model.ResultMsg;

public interface IApplyCardService {

    ResultMsg selectApplyCardList(Page page) throws Exception;

    ResultMsg selectApplyCardById(Integer applyCardId) throws Exception;

    ResultMsg updateApplyCard(ApplyCard applyCard) throws Exception;

    ResultMsg insertApplyCard(ApplyCard applyCard) throws Exception;

    ResultMsg deleteApplyCard(ApplyCard applyCard) throws Exception;
}

package com.manage.dao.applyCard;

import com.manage.model.applyCard.ApplyCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyCardMapper {

    /**
     * 查询申请信用卡列表
     *
     * @return
     */
    List<ApplyCard> selectApplyCardList();

    /**
     * 按id查询申请信用卡信息
     * @param applyCardId
     * @return
     */
    ApplyCard selectApplyCardById(Integer applyCardId);


    int updateApplyCard(ApplyCard applyCard);

    int insertApplyCard(ApplyCard applyCard) ;

    int deleteApplyCard(ApplyCard applyCard) ;

}

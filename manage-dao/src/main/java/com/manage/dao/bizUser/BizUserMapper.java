package com.manage.dao.bizUser;

import com.manage.model.bizUser.BizUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BizUserMapper {

    List<BizUser> selectBizUserList();

    BizUser selectBizUserById(Integer bizUserId);

    int deleteBizUser(BizUser bizUser);

    int insertBizUser(BizUser bizUser);

    int updateBizUser(BizUser bizUser);


}

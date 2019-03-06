package com.manage.dao.product;


import com.manage.model.product.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BannerMapper {
    List<Banner> selectBannerList(Banner banner);

    Integer selectBannerNum(String type);

    Banner selectByPrimary(Integer id);

    int insertBanner(Banner banner);

    Integer selectBannerMaxSort(String type);

    int updateStatusToOnline(Banner banner);

    int updateStatusToOffline(Banner banner);

    Banner selectBannerold(Banner banner);

    int updataBanner(Banner banner);

    String selectById(Banner banner);

    Banner selectBySort(Banner banner);

    Banner selectByToSort(Banner banner);

    int updateSortUpById(Banner banner);


    String selectMaxSort(String type);

    String selectMinSort(String type);

    String selectAppSum(int type);

    String selectExpectSum(int type);
}

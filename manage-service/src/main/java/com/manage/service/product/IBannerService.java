package com.manage.service.product;


import com.manage.datasourceAnnotation.SourcesEnum;
import com.manage.datasourceAnnotation.TargetDataSource;
import com.manage.model.ResultMsg;
import com.manage.model.product.Banner;

public interface IBannerService {

    ResultMsg getBannerList(Banner banner);
    Banner getBanneroldList(Banner banner);
    Banner selectByPrimary(Integer id);

    @TargetDataSource(SourcesEnum.write)
    int insertBanner(Banner banner)  throws Exception;
    @TargetDataSource(SourcesEnum.write)
    int upBanner(Banner banner)  throws Exception;
    @TargetDataSource(SourcesEnum.write)
    ResultMsg downBanner(Banner banner);
    @TargetDataSource(SourcesEnum.write)
    ResultMsg uppBanner(Banner banner);

    @TargetDataSource(SourcesEnum.write)
    void updateStatusByTime()throws Exception;

    byte[]  downLoad(Integer id);

}

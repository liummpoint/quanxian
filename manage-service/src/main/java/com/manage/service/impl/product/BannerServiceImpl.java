package com.manage.service.impl.product;


import com.manage.commom.enums.ModuleRedisKeyEnum;
import com.manage.commom.utils.DataUtil;
import com.manage.commom.utils.FastDFSClient;
import com.manage.commom.utils.FileUtil;
import com.manage.commom.utils.LogUtil;
import com.manage.dao.product.BannerMapper;
import com.manage.model.ResultMsg;
import com.manage.model.product.Banner;
import com.manage.service.product.IBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class BannerServiceImpl implements IBannerService {
    private static final Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);
    @Resource
    private BannerMapper bannerMapper;

    /**
     * 查询列表
     *
     * @throws Exception
     */
    @Override
    public ResultMsg getBannerList(Banner banner) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<Banner> bannerList = bannerMapper.selectBannerList(banner);
            for (Banner banner1 : bannerList) {
                logger.info("********" + banner1.getId());
                banner1.setDownLoadUrl(DataUtil.fsHttpUrl+banner1.getImageUrl());
            }
            Integer count = bannerMapper.selectBannerNum(banner.getType());
            String appOnline = bannerMapper.selectAppSum(banner.getActivityType());
            String expectOnline = bannerMapper.selectExpectSum(banner.getActivityType());
            Banner online = new Banner();
            online.setAppOnline(appOnline);
            online.setExpectOnline(expectOnline);
            resultMsg.setData(online);
            resultMsg.setResult(true);
            resultMsg.setRows(bannerList);
            resultMsg.setTotal(new Long(count));
        } catch (Exception e) {
            logger.error("查询banner出现异常", e);
            resultMsg.setResult(false);
        }

        return resultMsg;

    }

    @Override
    public Banner getBanneroldList(Banner banner) {
        Banner banner1=bannerMapper.selectBannerold(banner);
        banner1.setDownLoadUrl(DataUtil.fsHttpUrl+banner1.getImageUrl());
        return banner1;
    }

    @Override
    public Banner selectByPrimary(Integer id) {
        return bannerMapper.selectByPrimary(id);
    }

    /**
     * 插入新增列表
     *
     * @throws Exception
     */
    @Override
    public int insertBanner(Banner banner) throws Exception {
        MultipartFile imageFile = banner.getFile();
        String suffix = FileUtil.getFileSuffix(imageFile.getOriginalFilename());

        String[] image = FastDFSClient.uploadFileByDefaultGroup(imageFile.getBytes(), suffix);
        banner.setImageUrl(DataUtil.fsImageGroup+image[1]);
        String type = String.valueOf(banner.getActivityType());
        //发现页或者首页的排序最大值
        Integer sort = bannerMapper.selectBannerMaxSort(type);
        if (sort == null) {
            sort = 1;
        } else {
            sort = sort + 1;
        }

        banner.setSort(sort);
        banner.setStatus(2);
        banner.setType(type);
        banner.setIsDeleted((byte) 0);
        banner.setUpdateor(banner.getCreateor());
        int i = bannerMapper.insertBanner(banner);
        int activityTypetype = banner.getActivityType();
        if (i > 0 && activityTypetype == 0) {
            DataUtil.delRedisBykey(ModuleRedisKeyEnum.BANNERINFO_3_5.getKey());
        }
        if (i > 0 && activityTypetype == 1) {
            DataUtil.delRedisBykey(ModuleRedisKeyEnum.INDEXBANNER_3_5.getKey());
        }
        return i;
    }

    /**
     * 通过开始结束时间更改状态
     *
     * @throws Exception
     */
    @Override
    public void updateStatusByTime() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int tag = 0;
        Banner indexBannerParam = new Banner();
        indexBannerParam.setType("0");
        int result = bannerMapper.updateStatusToOnline(indexBannerParam);
        if (result > 0) {
            tag = 1;
            LogUtil.printResponseLog(" index product updateStatusToOnline Success");
        }
        result = bannerMapper.updateStatusToOffline(indexBannerParam);
        if (result > 0) {
            tag = 1;
            LogUtil.printResponseLog(" index product updateStatusToOffline Success");
        }
        Banner findBannerParam = new Banner();
        findBannerParam.setType("1");
        result = bannerMapper.updateStatusToOnline(findBannerParam);
        if (result > 0) {
            tag = 1;
            LogUtil.printResponseLog(" find product updateStatusToOnline Success");
        }
        result = bannerMapper.updateStatusToOffline(findBannerParam);
        if (result > 0) {
            tag = 1;
            LogUtil.printResponseLog(" find product updateStatusToOffline Success");
        }
        if (tag == 1) {
            DataUtil.delRedisBykey(ModuleRedisKeyEnum.BANNERINFO_3_5.getKey());
        }
    }

    @Override
    public byte[] downLoad(Integer id) {
        Banner banner = selectByPrimary(id);
        if (banner != null) {
            try {
                byte[] b = FastDFSClient.download_bytes(DataUtil.fsImageGroup,banner.getImageUrl());
                return b;
            } catch (Exception e) {
                logger.error("download exception", e);
            }
        }
        return null;
    }

    /**
     * 更新列表
     *
     * @throws Exception
     */
    @Override
    public int upBanner(Banner banner) throws Exception {
        Banner updateBanner = new Banner();
        MultipartFile imageFile = banner.getFile();
        if (imageFile != null && imageFile.getSize() > 0) {
            String suffix = FileUtil.getFileSuffix(imageFile.getOriginalFilename());
            String[] image = FastDFSClient.uploadFileByDefaultGroup(imageFile.getBytes(), suffix);
            updateBanner.setImageUrl(DataUtil.fsImageGroup+image[1]);
        } else {
            updateBanner.setImageUrl(banner.getImageUrl());
        }
        updateBanner.setStartTime(banner.getStartTime());
        updateBanner.setEndTime(banner.getEndTime());
        updateBanner.setUpdateor(banner.getUpdateor());
        updateBanner.setId(banner.getId());
        updateBanner.setTitle(banner.getTitle());
        updateBanner.setSubTitle(banner.getSubTitle());
        updateBanner.setActivityType(banner.getActivityType());
        updateBanner.setJumpUrl(banner.getJumpUrl());
        int i = bannerMapper.updataBanner(updateBanner);
        int activityTypetype = updateBanner.getActivityType();
        if (i > 0 && activityTypetype == 0) {
            DataUtil.delRedisBykey(ModuleRedisKeyEnum.BANNERINFO_3_5.getKey());
        }
        if (i > 0 && activityTypetype == 1) {
            DataUtil.delRedisBykey(ModuleRedisKeyEnum.INDEXBANNER_3_5.getKey());
        }

        return i;
    }

    /**
     * 下移
     *
     * @throws Exception
     */
    @Override
    public ResultMsg downBanner(Banner banner) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            //查询最小的sort值
            String minSort = bannerMapper.selectMinSort(String.valueOf(banner.getActivityType()));
            //查询点击那条的sort值
            String sort = bannerMapper.selectById(banner);

            //与现在的sort值比较
            if (minSort.equals(sort)) {
                resultMsg.setErrorMsg("该页优先级已最低");
                resultMsg.setResult(false);
                return resultMsg;
            }
            banner.setSort(Integer.valueOf(sort));
            //下移的id和sort
            Banner upId = bannerMapper.selectBySort(banner);
            banner.setSort(upId.getSort());
            bannerMapper.updateSortUpById(banner);
            //互换上下的sort值
            upId.setSort(Integer.valueOf(sort));
            upId.setUpdateor(banner.getUpdateor());
            int i = bannerMapper.updateSortUpById(upId);
            int activityTypetype = banner.getActivityType();
            if (i > 0 && activityTypetype == 0) {
                DataUtil.delRedisBykey(ModuleRedisKeyEnum.BANNERINFO_3_5.getKey());
            }
            if (i > 0 && activityTypetype == 1) {
                DataUtil.delRedisBykey(ModuleRedisKeyEnum.INDEXBANNER_3_5.getKey());
            }

            resultMsg.setErrorMsg("下移成功");
            resultMsg.setResult(false);
            return resultMsg;
        } catch (Exception e) {
            logger.error("banner页下移出现异常", e);
            resultMsg.setErrorMsg("系统异常");
            resultMsg.setResult(false);
        }


        return resultMsg;
    }

    /**
     * 上移
     *
     * @throws Exception
     */
    @Override
    public ResultMsg uppBanner(Banner banner) {
        ResultMsg resultMsg = new ResultMsg();
        try {
            //查询最小的sort值
            String maxSort = bannerMapper.selectMaxSort(String.valueOf(banner.getActivityType()));
            //查询点击那条的sort值
            String sort = bannerMapper.selectById(banner);
            //与现在的sort值比较
            if (maxSort.equals(sort)) {
                resultMsg.setErrorMsg("该页优先级已最高");
                resultMsg.setResult(false);
                return resultMsg;
            }
            banner.setSort(Integer.valueOf(sort));
            //上移的id和sort
            Banner upId = bannerMapper.selectByToSort(banner);
            banner.setSort(upId.getSort());
            bannerMapper.updateSortUpById(banner);
            //互换上下的sort值
            upId.setSort(Integer.valueOf(sort));
            upId.setUpdateor(banner.getUpdateor());
            int i = bannerMapper.updateSortUpById(upId);
            int activityTypetype = banner.getActivityType();
            if (i > 0 && activityTypetype == 1) {
                DataUtil.delRedisBykey(ModuleRedisKeyEnum.INDEXBANNER_3_5.getKey());
            }
            if (i > 0 && activityTypetype == 0) {
                DataUtil.delRedisBykey(ModuleRedisKeyEnum.BANNERINFO_3_5.getKey());
            }
            resultMsg.setErrorMsg("上移成功");
            resultMsg.setResult(false);
            return resultMsg;
        } catch (Exception e) {
            logger.error("banner页下移出现异常", e);
            resultMsg.setErrorMsg("系统异常");
            resultMsg.setResult(false);
        }

        return resultMsg;
    }
}

package com.manage.commom.enums;

/**
 * 花生后台和app后台约定redis key
 */
public enum ModuleRedisKeyEnum {
    //热门活动
    HOTACTIVITYINFO_3_5("hotActivityInfo","热门活动"),
    //模块
    FINDMODULEINFO_3_5("findModuleInfo","模块"),
    //企业资讯
    NEWSINFO_3_5("newsInfo","企业资讯"),
    //发现页banner
    INDEXBANNER_3_5("bannerInfo","发现页banner"),
    //首页banner
    BANNERINFO_3_5("indexInfo","首页banner"),
    //入口球
    OPERATIONINFOBALL_3_5("operationInfoBall","入口球"),
    // 平台公告
    NOTICEARRAY_3_4("noticeArray","平台公告");

    private String key;
    private String value;

    ModuleRedisKeyEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

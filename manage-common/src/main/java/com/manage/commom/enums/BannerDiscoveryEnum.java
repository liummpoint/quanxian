package com.manage.commom.enums;

/**
 * @author dudianbo
 * @ClassName: BannerDiscoveryEnum
 * @Description: ${DESCRIPTION}
 * @date 2018/3/28
 */
public enum BannerDiscoveryEnum {

    BANNER("banner","banner"),
    ACTIVITY("activity","activity发现页"),
    DISCOVERY("discovery","热门活动"),
    INFOSLIP("infoSlip","公司动态");

    private String code;
    private String message;

    BannerDiscoveryEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

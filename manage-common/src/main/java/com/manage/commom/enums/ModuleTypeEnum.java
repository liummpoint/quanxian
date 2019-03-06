package com.manage.commom.enums;

public enum  ModuleTypeEnum {

    //热门活动
    HOTACTIVITY(1,"热门活动"),
    //平台资讯
    PLATFORMINFO(2,"平台资讯"),
    //banner
    BANNER(3,"banner"),
    //入口球
    OPERATIONBALL(4,"入口球"),
    //媒体资讯
    MEDIA(5,"媒体资讯");

    private Integer code;
    private String message;

    ModuleTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

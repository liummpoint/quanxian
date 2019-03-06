package com.manage.commom.enums;

/**
 * @author dudianbo
 * @ClassName: BannerDiscoveryEnum
 * @Description: ${DESCRIPTION}
 * @date 2018/3/28
 */
public enum LoanImageEnum {

    VEHICLEFRONT(0,"车辆前身照"),
    MANANDCAR(1,"人车合影"),
    IDCARDNOONE(2,"借款人身份证1"),
    IDCARDNOTWO(3,"借款人身份证2"),
    DRIVERLICENSEONE(4,"驾驶证1"),
    DRIVERLICENSETWO(5,"驾驶证2"),
    DRIVERPERMITONE(6,"行驶证1"),
    DRIVERPERMITTWO(7,"行驶证2"),
    INTERVIEWONE(8,"借款人面签1"),
    INTERVIEWTWO(9,"借款人面签2");

    private Integer code;
    private String message;

    LoanImageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

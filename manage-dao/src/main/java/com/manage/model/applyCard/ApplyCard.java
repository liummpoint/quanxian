package com.manage.model.applyCard;

/**
 * 申请信用卡
 */
public class ApplyCard {
    /**
     * 申请信用卡ID
     */
    private Integer applyCardId;
    /**
     * 用户ID
     */
    private Integer bizUserId;
    /**
     * 订单号
     */
    private Integer serviceOrderId;
    /**
     * 产品活动ID
     */
    private Integer productActivityId;
    /**
     * 申请者姓名
     */
    private String applyName;
    /**
     * 申请者身份证号
     */
    private String applyIdCardNo;
    /**
     * 申请者手机号码
     */
    private String applyPhone;
    /**
     * 申请状态
     */
    private int status;

    /**
     * 是否删除  0：未删  1：已删
     */
    private  int isDeleted;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;


    public Integer getApplyCardId() {
        return applyCardId;
    }

    public void setApplyCardId(Integer applyCardId) {
        this.applyCardId = applyCardId;
    }

    public Integer getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(Integer bizUserId) {
        this.bizUserId = bizUserId;
    }

    public Integer getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Integer serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getProductActivityId() {
        return productActivityId;
    }

    public void setProductActivityId(Integer productActivityId) {
        this.productActivityId = productActivityId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getApplyIdCardNo() {
        return applyIdCardNo;
    }

    public void setApplyIdCardNo(String applyIdCardNo) {
        this.applyIdCardNo = applyIdCardNo;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ApplyCard{" +
                "applyCardId=" + applyCardId +
                ", bizUserId=" + bizUserId +
                ", serviceOrderId=" + serviceOrderId +
                ", productActivityId=" + productActivityId +
                ", applyName='" + applyName + '\'' +
                ", applyIdCardNo='" + applyIdCardNo + '\'' +
                ", applyPhone='" + applyPhone + '\'' +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

package com.manage.model.withdrawCash;

/**
 * 申请提现表
 */
public class WithdrawCash {

    /**
     * 提现申请ID
     */
    private Integer  withdrawCashId;
    /**
     * 用户ID
     */
    private Integer  bizUserId;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 身份证号
     */
    private String idCardNo;
    /**
     * 银行卡号
     */
    private String bankCardNo;
    /**
     * 开户行
     */
    private String openCard;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 提现状态
     */
    private Integer  withdrawStatus;
    /**
     * 创建时间
     */
    private Long  createTime;
    /**
     * 更新时间
     */
    private Long  updateTime;

    /**
     * 是否删除  0：未删  1：已删
     */
    private  int isDeleted;

    public Integer getWithdrawCashId() {
        return withdrawCashId;
    }

    public void setWithdrawCashId(Integer withdrawCashId) {
        this.withdrawCashId = withdrawCashId;
    }

    public Integer getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(Integer bizUserId) {
        this.bizUserId = bizUserId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getOpenCard() {
        return openCard;
    }

    public void setOpenCard(String openCard) {
        this.openCard = openCard;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
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
        return "WithdrawCash{" +
                "withdrawCashId=" + withdrawCashId +
                ", bizUserId=" + bizUserId +
                ", realname='" + realname + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", bankCardNo='" + bankCardNo + '\'' +
                ", openCard='" + openCard + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", withdrawStatus=" + withdrawStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

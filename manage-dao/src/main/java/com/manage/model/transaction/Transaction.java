package com.manage.model.transaction;

/**
 * 帐户交易表
 */
public class Transaction {
    /**
     * 交易ID
     */
    private Integer transactionId;
    /**
     * 订单ID
     */
    private Integer serviceOrderId;
    /**
     * 用户ID
     */
    private Integer bizUserId;
    /**
     * 金额或积分
     */
    private Integer  amount;
    /**
     * 交易类型,与表biz_user_account中的类型一致
     */
    private Integer transactionType;
    /**
     * 交易状态
     */
    private Integer status;
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

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Integer serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(Integer bizUserId) {
        this.bizUserId = bizUserId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", serviceOrderId=" + serviceOrderId +
                ", bizUserId=" + bizUserId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

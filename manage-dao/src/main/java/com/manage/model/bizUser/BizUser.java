package com.manage.model.bizUser;

/**
 * 用户
 */
public class BizUser {
    /**
     * 用户ID
     */
    private Integer bizUserId;
    /**
     * 用户昵称
     */
    private String bizUserName;
    /**
     * 类型1:消费者2:渠道
     */
    private Integer type;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 父用户ID
     */
    private Integer parentBizUserId;
    /**
     * 级别
     */
    private Integer grade;
    /**
     * 订单统计
     */
    private Integer orderStatistics;
    /**
     * 预结算费用
     */
    private Integer preDistributeFee;
    /**
     * 已结算费用
     */
    private Integer finishDistributeFee;
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

    public Integer getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(Integer bizUserId) {
        this.bizUserId = bizUserId;
    }

    public String getBizUserName() {
        return bizUserName;
    }

    public void setBizUserName(String bizUserName) {
        this.bizUserName = bizUserName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParentBizUserId() {
        return parentBizUserId;
    }

    public void setParentBizUserId(Integer parentBizUserId) {
        this.parentBizUserId = parentBizUserId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getOrderStatistics() {
        return orderStatistics;
    }

    public void setOrderStatistics(Integer orderStatistics) {
        this.orderStatistics = orderStatistics;
    }

    public Integer getPreDistributeFee() {
        return preDistributeFee;
    }

    public void setPreDistributeFee(Integer preDistributeFee) {
        this.preDistributeFee = preDistributeFee;
    }

    public Integer getFinishDistributeFee() {
        return finishDistributeFee;
    }

    public void setFinishDistributeFee(Integer finishDistributeFee) {
        this.finishDistributeFee = finishDistributeFee;
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
        return "BizUser{" +
                "bizUserId=" + bizUserId +
                ", bizUserName='" + bizUserName + '\'' +
                ", type=" + type +
                ", cellphone='" + cellphone + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", parentBizUserId=" + parentBizUserId +
                ", grade=" + grade +
                ", orderStatistics=" + orderStatistics +
                ", preDistributeFee=" + preDistributeFee +
                ", finishDistributeFee=" + finishDistributeFee +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

package com.manage.model.bizUserAccount;

/**
 * 用户帐户表
 */
public class BizUserAccount {
    /**
     * 用户账户ID
     */
    private Integer biz_user_account_id;
    /**
     * 用户ID
     */
    private Integer biz_user_id;
    /**
     * 帐户类型1:运营商积分2:信用卡积分3:订单分佣
     */
    private Integer account_type;
    /**
     * 金额或积分
     */
    private Integer amount;
    /**
     * 帐户状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Integer create_time;
    /**
     * 更新时间
     */
    private Integer update_time;

    public Integer getBiz_user_account_id() {
        return biz_user_account_id;
    }

    public void setBiz_user_account_id(Integer biz_user_account_id) {
        this.biz_user_account_id = biz_user_account_id;
    }

    public Integer getBiz_user_id() {
        return biz_user_id;
    }

    public void setBiz_user_id(Integer biz_user_id) {
        this.biz_user_id = biz_user_id;
    }

    public Integer getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Integer account_type) {
        this.account_type = account_type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public Integer getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Integer update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "BizUserAccount{" +
                "biz_user_account_id=" + biz_user_account_id +
                ", biz_user_id=" + biz_user_id +
                ", account_type=" + account_type +
                ", amount=" + amount +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}

package com.manage.model.user;

public class BankCard {
    private String userName;//姓名
    private String userMobile;//手机号
    private String idNo;//身份证号
    private String signNo;//签约账号
    private String orgOrderId;
    private String bankName;//银行名称
    private String cardNo;//银行卡号
    private String mobile;//预留手机号
    private int status;//状态
    private String createTime;//绑定时间
    private String accountId;
    private String id;
    private String updator;
    private int payPWFlag;
    private String uId;

    public void setOrgOrderId(String orgOrderId) {
        this.orgOrderId = orgOrderId;
    }

    public String getOrgOrderId() {
        return orgOrderId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuId() {

        return uId;
    }

    public void setPayPWFlag(int payPWFlag) {
        this.payPWFlag = payPWFlag;
    }

    public int getPayPWFlag() {

        return payPWFlag;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", idNo='" + idNo + '\'' +
                ", signNo='" + signNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                ", accountId='" + accountId + '\'' +
                ", id='" + id + '\'' +
                ", updator='" + updator + '\'' +
                '}';
    }
}

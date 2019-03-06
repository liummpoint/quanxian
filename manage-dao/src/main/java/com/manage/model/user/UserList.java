package com.manage.model.user;

public class UserList {
    private String id;
    private String createTime;
    private String userName;
    private String phone;
    private String channelId;
    private String totalInvest;
    private String onlineInvest;
    private String firstInvestAmount;
    private String firstInvestTime;
    private String secondInvestAmount;
    private String secondInvestTime;
    private String investCount;
    private String withdrawAmount;
    private String withdrawCount;
    private String tranAmount;
    private Integer status;
    private String channelName;
    private String channelParentName;
    private String rechargeAmount;
    private String regularInvest;
    private String currentInvest;
    private String noviceInvest;
    private String secondType;
    private String firstType;
    private String transferAmount;
    private String statusType;
    private String safeMatch;
    private String safeJune;
    private String safeTwelve;

    public String getSafeTwelve() {
        return safeTwelve;
    }

    public void setSafeTwelve(String safeTwelve) {
        this.safeTwelve = safeTwelve;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getChannelParentName() {
        return channelParentName;
    }

    public void setChannelParentName(String channelParentName) {
        this.channelParentName = channelParentName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getRegularInvest() {
        return regularInvest;
    }

    public void setRegularInvest(String regularInvest) {
        this.regularInvest = regularInvest;
    }

    public String getCurrentInvest() {
        return currentInvest;
    }

    public void setCurrentInvest(String currentInvest) {
        this.currentInvest = currentInvest;
    }

    public String getNoviceInvest() {
        return noviceInvest;
    }

    public void setNoviceInvest(String noviceInvest) {
        this.noviceInvest = noviceInvest;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    private int startSize;
    private int size;

    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(String totalInvest) {
        this.totalInvest = totalInvest;
    }

    public String getOnlineInvest() {
        return onlineInvest;
    }

    public void setOnlineInvest(String onlineInvest) {
        this.onlineInvest = onlineInvest;
    }

    public String getFirstInvestAmount() {
        return firstInvestAmount;
    }

    public void setFirstInvestAmount(String firstInvestAmount) {
        this.firstInvestAmount = firstInvestAmount;
    }

    public String getFirstInvestTime() {
        return firstInvestTime;
    }

    public void setFirstInvestTime(String firstInvestTime) {
        this.firstInvestTime = firstInvestTime;
    }

    public String getSecondInvestAmount() {
        return secondInvestAmount;
    }

    public void setSecondInvestAmount(String secondInvestAmount) {
        this.secondInvestAmount = secondInvestAmount;
    }

    public String getSecondInvestTime() {
        return secondInvestTime;
    }

    public void setSecondInvestTime(String secondInvestTime) {
        this.secondInvestTime = secondInvestTime;
    }

    public String getInvestCount() {
        return investCount;
    }

    public void setInvestCount(String investCount) {
        this.investCount = investCount;
    }

    public String getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(String withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getWithdrawCount() {
        return withdrawCount;
    }

    public void setWithdrawCount(String withdrawCount) {
        this.withdrawCount = withdrawCount;
    }

    public String getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(String tranAmount) {
        this.tranAmount = tranAmount;
    }

    public int getStartSize() {
        return startSize;
    }

    public void setStartSize(int startSize) {
        this.startSize = startSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSafeMatch() {
        return safeMatch;
    }

    public void setSafeMatch(String safeMatch) {
        this.safeMatch = safeMatch;
    }

    public String getSafeJune() {
        return safeJune;
    }

    public void setSafeJune(String safeJune) {
        this.safeJune = safeJune;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", channelId='" + channelId + '\'' +
                ", totalInvest='" + totalInvest + '\'' +
                ", onlineInvest='" + onlineInvest + '\'' +
                ", firstInvestAmount='" + firstInvestAmount + '\'' +
                ", firstInvestTime='" + firstInvestTime + '\'' +
                ", secondInvestAmount='" + secondInvestAmount + '\'' +
                ", secondInvestTime='" + secondInvestTime + '\'' +
                ", investCount='" + investCount + '\'' +
                ", withdrawAmount='" + withdrawAmount + '\'' +
                ", withdrawCount='" + withdrawCount + '\'' +
                ", tranAmount='" + tranAmount + '\'' +
                ", status=" + status +
                ", channelName='" + channelName + '\'' +
                ", channelParentName='" + channelParentName + '\'' +
                ", rechargeAmount='" + rechargeAmount + '\'' +
                ", regularInvest='" + regularInvest + '\'' +
                ", currentInvest='" + currentInvest + '\'' +
                ", noviceInvest='" + noviceInvest + '\'' +
                ", secondType='" + secondType + '\'' +
                ", firstType='" + firstType + '\'' +
                ", transferAmount='" + transferAmount + '\'' +
                ", statusType='" + statusType + '\'' +
                ", safeMatch='" + safeMatch + '\'' +
                ", safeJune='" + safeJune + '\'' +
                ", startSize=" + startSize +
                ", size=" + size +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}

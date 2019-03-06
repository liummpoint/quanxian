package com.manage.model.user;

public class UserDetails {

    private String id;
    private String userName;
    private String mobile;
    private String sex;
    private String age;
    private String parentId;

    /**
     * 用户创建时间
     */
    private String createTime;
    /**
     * 注册渠道
     */
    private String channelName;
    private String remarks;

    /**
     * 签约号
     */
    private String signNo;
    /**
     * 开户姓名
     */
    private String openAccountName;
    /**
     *银行名称
     */
    private String bankName;
    /**
     *银行卡号
     */
    private String cardNo;
    /**
     *预留手机号
     */
    private String reservedMobile;
    /**
     *身份证号
     */
    private String idNo;
    /**
     *开户时间
     */
    private String accountopeningTime;
    /**
     * 总投资额
     */
    private String totalAmount;
    /**
     * 再投金额
     */
    private String amount;
    /**
     * 账户余额
     */
    private String accountBalance;
    /**
     * 充值金额
     */
    private String rechargeAmount;
    /**
     * 提现金额
     */
    private String cashAmount;

    /**
     *提现次数
     */
    private int cashNum;
    /**
     * 新手投资金额
     */
    private String noviceInvest;
    /**
     * 活期投资金额
     */
    private String currentInvest;
    /**
     * 灵活投资金额
     */
    private String regularInvest;
    /**
     * 转出中金额
     */
    private String transferAmount;
    /**
     * 匹配中金额
     */
    private String MatchingAmount;
    /**
     * 总收益
     */
    private String interestTotal;
    /**
     * 安心三月在投金额
     */
    private String marchInvest;
    /**
     * 安心六月
     */
    private String JuneInvest;
    /**
     * 安心六月
     */
    private String twelveInvest;
    /**
     * 新手首投时间
     */
    private String firstNoviceInvestTime;
    /**
     *活期首投时间
     */
    private String firstCurrentInvestTime;
    /**
     *定期首投时间
     */
    private String firstRegularInvestTime;
    /**
     *安心三月手头时间
     */
    private String firstAnxinThreeInvestTime;
    /**
     *安心六月首投时间
     */
    private String firstAnxinSixInvestTime;
    /**
     * 风险类型
     */
    private String riskType ;

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public UserDetails() {
    }
    public UserDetails(String id, String userName, String mobile, String sex, String age, String createTime, String channelName, String signNo, String openAccountName, String bankName, String cardNo, String reservedMobile, String idNo, String accountopeningTime, String totalAmount, String amount, String accountBalance, String rechargeAmount, String cashAmount, int cashNum, String noviceInvest, String currentInvest, String regularInvest, String transferAmount, String matchingAmount, String interestTotal, String marchInvest, String juneInvest) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
        this.sex = sex;
        this.age = age;
        this.createTime = createTime;
        this.channelName = channelName;
        this.signNo = signNo;
        this.openAccountName = openAccountName;
        this.bankName = bankName;
        this.cardNo = cardNo;
        this.reservedMobile = reservedMobile;
        this.idNo = idNo;
        this.accountopeningTime = accountopeningTime;
        this.totalAmount = totalAmount;
        this.amount = amount;
        this.accountBalance = accountBalance;
        this.rechargeAmount = rechargeAmount;
        this.cashAmount = cashAmount;
        this.cashNum = cashNum;
        this.noviceInvest = noviceInvest;
        this.currentInvest = currentInvest;
        this.regularInvest = regularInvest;
        this.transferAmount = transferAmount;
        MatchingAmount = matchingAmount;
        this.interestTotal = interestTotal;
        this.marchInvest = marchInvest;
        JuneInvest = juneInvest;
    }



    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMarchInvest() {
        return marchInvest;
    }

    public void setMarchInvest(String marchInvest) {
        this.marchInvest = marchInvest;
    }

    public String getFirstNoviceInvestTime() {
        return firstNoviceInvestTime;
    }

    public void setFirstNoviceInvestTime(String firstNoviceInvestTime) {
        this.firstNoviceInvestTime = firstNoviceInvestTime;
    }

    public String getFirstCurrentInvestTime() {
        return firstCurrentInvestTime;
    }

    public void setFirstCurrentInvestTime(String firstCurrentInvestTime) {
        this.firstCurrentInvestTime = firstCurrentInvestTime;
    }

    public String getFirstRegularInvestTime() {
        return firstRegularInvestTime;
    }

    public void setFirstRegularInvestTime(String firstRegularInvestTime) {
        this.firstRegularInvestTime = firstRegularInvestTime;
    }

    public String getFirstAnxinThreeInvestTime() {
        return firstAnxinThreeInvestTime;
    }

    public void setFirstAnxinThreeInvestTime(String firstAnxinThreeInvestTime) {
        this.firstAnxinThreeInvestTime = firstAnxinThreeInvestTime;
    }

    public String getFirstAnxinSixInvestTime() {
        return firstAnxinSixInvestTime;
    }

    public void setFirstAnxinSixInvestTime(String firstAnxinSixInvestTime) {
        this.firstAnxinSixInvestTime = firstAnxinSixInvestTime;
    }

    public String getJuneInvest() {
        return JuneInvest;
    }

    public void setJuneInvest(String juneInvest) {
        JuneInvest = juneInvest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    public String getOpenAccountName() {
        return openAccountName;
    }

    public void setOpenAccountName(String openAccountName) {
        this.openAccountName = openAccountName;
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

    public String getReservedMobile() {
        return reservedMobile;
    }

    public void setReservedMobile(String reservedMobile) {
        this.reservedMobile = reservedMobile;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getAccountopeningTime() {
        return accountopeningTime;
    }

    public void setAccountopeningTime(String accountopeningTime) {
        this.accountopeningTime = accountopeningTime;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }

    public int getCashNum() {
        return cashNum;
    }

    public void setCashNum(int cashNum) {
        this.cashNum = cashNum;
    }

    public String getNoviceInvest() {
        return noviceInvest;
    }

    public void setNoviceInvest(String noviceInvest) {
        this.noviceInvest = noviceInvest;
    }

    public String getCurrentInvest() {
        return currentInvest;
    }

    public void setCurrentInvest(String currentInvest) {
        this.currentInvest = currentInvest;
    }

    public String getRegularInvest() {
        return regularInvest;
    }

    public void setRegularInvest(String regularInvest) {
        this.regularInvest = regularInvest;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getMatchingAmount() {
        return MatchingAmount;
    }

    public void setMatchingAmount(String matchingAmount) {
        MatchingAmount = matchingAmount;
    }

    public String getInterestTotal() {
        return interestTotal;
    }

    public void setInterestTotal(String interestTotal) {
        this.interestTotal = interestTotal;
    }

    public String getTwelveInvest() {
        return twelveInvest;
    }

    public void setTwelveInvest(String twelveInvest) {
        this.twelveInvest = twelveInvest;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", channelName='" + channelName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", signNo='" + signNo + '\'' +
                ", openAccountName='" + openAccountName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", reservedMobile='" + reservedMobile + '\'' +
                ", idNo='" + idNo + '\'' +
                ", accountopeningTime='" + accountopeningTime + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", amount='" + amount + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", rechargeAmount='" + rechargeAmount + '\'' +
                ", cashAmount='" + cashAmount + '\'' +
                ", cashNum=" + cashNum +
                ", noviceInvest='" + noviceInvest + '\'' +
                ", currentInvest='" + currentInvest + '\'' +
                ", regularInvest='" + regularInvest + '\'' +
                ", transferAmount='" + transferAmount + '\'' +
                ", MatchingAmount='" + MatchingAmount + '\'' +
                ", interestTotal='" + interestTotal + '\'' +
                ", marchInvest='" + marchInvest + '\'' +
                ", JuneInvest='" + JuneInvest + '\'' +
                ", firstNoviceInvestTime='" + firstNoviceInvestTime + '\'' +
                ", firstCurrentInvestTime='" + firstCurrentInvestTime + '\'' +
                ", firstRegularInvestTime='" + firstRegularInvestTime + '\'' +
                ", firstAnxinThreeInvestTime='" + firstAnxinThreeInvestTime + '\'' +
                ", firstAnxinSixInvestTime='" + firstAnxinSixInvestTime + '\'' +
                ", riskType='" + riskType + '\'' +
                '}';
    }
}

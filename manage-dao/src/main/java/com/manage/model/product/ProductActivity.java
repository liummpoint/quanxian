package com.manage.model.product;

public class ProductActivity {
    /**
     * 产品活动ID
     */
    private Integer  productActivityId;
    /**
     * 产品ID
     */
    private Integer  productId;
    /**
     * 参与活动的图片
     */
    private String activityPicture;
    /**
     * 产品介绍
     */
    private String introduction;
    /**
     * 截止日期
     */
    private Long endTime;
    /**
     * 结算百分比:万分比
     */
    private Integer   distributeRatio;
    /**
     * 分享图片
     */
    private String sharePic;
    /**
     * 分享标题
     */
    private String shareTitle;
    /**
     * 分享二维码图片
     */
    private String shareQRCPic;
    /**
     * 链接地址
     */
    private String link;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 是否删除  0：未删  1：已删
     */
    private  int isDeleted;

    public Integer getProductActivityId() {
        return productActivityId;
    }

    public void setProductActivityId(Integer productActivityId) {
        this.productActivityId = productActivityId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getActivityPicture() {
        return activityPicture;
    }

    public void setActivityPicture(String activityPicture) {
        this.activityPicture = activityPicture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getDistributeRatio() {
        return distributeRatio;
    }

    public void setDistributeRatio(Integer distributeRatio) {
        this.distributeRatio = distributeRatio;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareQRCPic() {
        return shareQRCPic;
    }

    public void setShareQRCPic(String shareQRCPic) {
        this.shareQRCPic = shareQRCPic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
}

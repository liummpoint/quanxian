package com.manage.model.serviceOrder;

/**
 * 订单表
 */
public class ServiceOrder {
    /**
     * 订单号
     */
    private Long service_order_id;
    /**
     * 用户ID
     */
    private Integer biz_user_id;
    /**
     * 产品活动ID
     */
    private Integer product_activity_id;
    /**
     * 合作方订单号
     */
    private String partner_order_id;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 总金额(单位:分)
     */
    private Long total_amount;
    /**
     * 分佣总金额(单位:分)
     */
    private Long distribute_amount;
    /**
     * 结算状态
     */
    private Integer distribute_status;
    /**
     * 扩展字段1
     */
    private String ext1;
    /**
     * 扩展字段2
     */
    private String ext2;
    /**
     * 创建时间
     */
    private Integer create_time;
    /**
     * 更新时间
     */
    private Integer update_time;

    public Long getService_order_id() {
        return service_order_id;
    }

    public void setService_order_id(Long service_order_id) {
        this.service_order_id = service_order_id;
    }

    public Integer getBiz_user_id() {
        return biz_user_id;
    }

    public void setBiz_user_id(Integer biz_user_id) {
        this.biz_user_id = biz_user_id;
    }

    public Integer getProduct_activity_id() {
        return product_activity_id;
    }

    public void setProduct_activity_id(Integer product_activity_id) {
        this.product_activity_id = product_activity_id;
    }

    public String getPartner_order_id() {
        return partner_order_id;
    }

    public void setPartner_order_id(String partner_order_id) {
        this.partner_order_id = partner_order_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Long total_amount) {
        this.total_amount = total_amount;
    }

    public Long getDistribute_amount() {
        return distribute_amount;
    }

    public void setDistribute_amount(Long distribute_amount) {
        this.distribute_amount = distribute_amount;
    }

    public Integer getDistribute_status() {
        return distribute_status;
    }

    public void setDistribute_status(Integer distribute_status) {
        this.distribute_status = distribute_status;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
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
        return "ServiceOrder{" +
                "service_order_id=" + service_order_id +
                ", biz_user_id=" + biz_user_id +
                ", product_activity_id=" + product_activity_id +
                ", partner_order_id='" + partner_order_id + '\'' +
                ", status=" + status +
                ", total_amount=" + total_amount +
                ", distribute_amount=" + distribute_amount +
                ", distribute_status=" + distribute_status +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}

package com.manage.model;

import java.math.BigDecimal;

/**
 * Created by ThinkPad on 2017/11/7.
 */
public class ReportDto {
    private BigDecimal totalAmount;
    private Integer personSum;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPersonSum() {
        return personSum;
    }

    public void setPersonSum(Integer personSum) {
        this.personSum = personSum;
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "totalAmount=" + totalAmount +
                ", personSum=" + personSum +
                '}';
    }
}

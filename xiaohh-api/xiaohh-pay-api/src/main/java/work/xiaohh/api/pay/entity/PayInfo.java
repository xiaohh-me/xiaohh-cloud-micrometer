package work.xiaohh.api.pay.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 支付信息实体
 * </p>
 *
 * @author XiaoHH
 * @version 1.0.0
 * @date 2024-12-12 星期四 14:55:57
 * @file PayInfo.java
 */
public class PayInfo implements Serializable {


    /**
     * 支付信息ID
     */
    private Long payInfoId;

    /**
     * 订单信息ID
     */
    private Long orderInfoId;

    /**
     * 支付金额
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal paidAmount;

    /**
     * 账户ID
     */
    private Long accountInfoId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public Long getPayInfoId() {
        return payInfoId;
    }

    public void setPayInfoId(Long payInfoId) {
        this.payInfoId = payInfoId;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Long getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(Long accountInfoId) {
        this.accountInfoId = accountInfoId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "payInfoId=" + payInfoId +
                ", orderInfoId=" + orderInfoId +
                ", paidAmount=" + paidAmount +
                ", accountInfoId=" + accountInfoId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

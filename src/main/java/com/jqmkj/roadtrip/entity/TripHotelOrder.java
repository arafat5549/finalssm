package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripHotelOrder extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //订单号
    private String orderSn;

    //物流单号
    private String deliverySn;

    //物流公司(配送方式)
    private String deliveryCompany;

    //订单来源：0->PC订单；1->app订单
    private Integer sourceType;

    //支付方式：0->未支付；1->支付宝；2->微信；3->银联
    private Integer payType;

    //订单类型：0->正常订单；1->秒杀订单
    private Integer orderType;

    //下单时间
    private Date orderTime;

    //发货时间
    private Date sendTime;

    //付款时间
    private Date payTime;

    //成交时间
    private Date transactionTime;

    //评价时间
    private Date commentTime;

    //订单总金额
    private BigDecimal totalAmount;

    //应付金额（实际支付金额）
    private BigDecimal payAmount;

    //运费金额
    private BigDecimal freightAmount;

    //促销优化金额（促销价、满减、阶梯价）
    private BigDecimal promotionAmount;

    //积分抵扣金额
    private BigDecimal scoreAmount;

    //优惠券抵扣金额
    private BigDecimal couponAmount;

    //管理员后台调整订单使用的折扣金额
    private BigDecimal discountAmount;

    //可以获得的积分
    private Integer score;

    //自驾游酒店发票ID
    private Long tripHotelBillId;

    //用户ID
    private Long userId;

    //商户ID
    private Long tripHotelStoreId;

    //自驾游酒店优惠券ID
    private Long tripHotelCouponId;

    //收货人姓名
    private String receiverName;

    //收货人电话
    private String receiverPhone;

    //收货人邮编
    private String receiverPostCode;

    //省份/直辖市
    private String receiverProvince;

    //城市
    private String receiverCity;

    //区
    private String receiverRegion;

    //详细地址
    private String receiverDetailAddress;

    //订单备注
    private String remark;

    //自动确认时间（天）目前默认15天
    private Integer autoConfirmDay;

    //确认收货状态：0->未确认；1->已确认
    private Integer confirmStatus;

    //删除状态：0->未删除；1->已删除
    private Integer deleteStatus;

    //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    private Integer orderStatus;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getScoreAmount() {
        return scoreAmount;
    }

    public void setScoreAmount(BigDecimal scoreAmount) {
        this.scoreAmount = scoreAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getTripHotelBillId() {
        return tripHotelBillId;
    }

    public void setTripHotelBillId(Long tripHotelBillId) {
        this.tripHotelBillId = tripHotelBillId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTripHotelStoreId() {
        return tripHotelStoreId;
    }

    public void setTripHotelStoreId(Long tripHotelStoreId) {
        this.tripHotelStoreId = tripHotelStoreId;
    }

    public Long getTripHotelCouponId() {
        return tripHotelCouponId;
    }

    public void setTripHotelCouponId(Long tripHotelCouponId) {
        this.tripHotelCouponId = tripHotelCouponId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", deliverySn=").append(deliverySn);
        sb.append(", deliveryCompany=").append(deliveryCompany);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", payType=").append(payType);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", transactionTime=").append(transactionTime);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", scoreAmount=").append(scoreAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", score=").append(score);
        sb.append(", tripHotelBillId=").append(tripHotelBillId);
        sb.append(", userId=").append(userId);
        sb.append(", tripHotelStoreId=").append(tripHotelStoreId);
        sb.append(", tripHotelCouponId=").append(tripHotelCouponId);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverPostCode=").append(receiverPostCode);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverRegion=").append(receiverRegion);
        sb.append(", receiverDetailAddress=").append(receiverDetailAddress);
        sb.append(", remark=").append(remark);
        sb.append(", autoConfirmDay=").append(autoConfirmDay);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        orderSn("order_sn"),
        deliverySn("delivery_sn"),
        deliveryCompany("delivery_company"),
        sourceType("source_type"),
        payType("pay_type"),
        orderType("order_type"),
        orderTime("order_time"),
        sendTime("send_time"),
        payTime("pay_time"),
        transactionTime("transaction_time"),
        commentTime("comment_time"),
        totalAmount("total_amount"),
        payAmount("pay_amount"),
        freightAmount("freight_amount"),
        promotionAmount("promotion_amount"),
        scoreAmount("score_amount"),
        couponAmount("coupon_amount"),
        discountAmount("discount_amount"),
        score("score"),
        tripHotelBillId("trip_hotel_bill_id"),
        userId("user_id"),
        tripHotelStoreId("trip_hotel_store_id"),
        tripHotelCouponId("trip_hotel_coupon_id"),
        receiverName("receiver_name"),
        receiverPhone("receiver_phone"),
        receiverPostCode("receiver_post_code"),
        receiverProvince("receiver_province"),
        receiverCity("receiver_city"),
        receiverRegion("receiver_region"),
        receiverDetailAddress("receiver_detail_address"),
        remark("remark"),
        autoConfirmDay("auto_confirm_day"),
        confirmStatus("confirm_status"),
        deleteStatus("delete_status"),
        orderStatus("order_status"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        updateTime("update_time");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}
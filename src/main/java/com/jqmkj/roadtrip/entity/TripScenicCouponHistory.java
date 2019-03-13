package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class TripScenicCouponHistory extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游景区优惠券ID
    private Long tripScenicCouponId;

    //自驾游景区优惠码
    private String tripScenicCouponCode;

    //用户ID
    private Long userId;

    //获取类型：0->后台赠送；1->主动获取
    private Integer getType;

    //使用状态：0->未使用；1->已使用；2->已过期
    private Integer useStatus;

    //订单id
    private Long tripScenicOrderId;

    //订单号码
    private String orderSn;

    //使用时间
    private Date useTime;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripScenicCouponId() {
        return tripScenicCouponId;
    }

    public void setTripScenicCouponId(Long tripScenicCouponId) {
        this.tripScenicCouponId = tripScenicCouponId;
    }

    public String getTripScenicCouponCode() {
        return tripScenicCouponCode;
    }

    public void setTripScenicCouponCode(String tripScenicCouponCode) {
        this.tripScenicCouponCode = tripScenicCouponCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getGetType() {
        return getType;
    }

    public void setGetType(Integer getType) {
        this.getType = getType;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Long getTripScenicOrderId() {
        return tripScenicOrderId;
    }

    public void setTripScenicOrderId(Long tripScenicOrderId) {
        this.tripScenicOrderId = tripScenicOrderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripScenicCouponId=").append(tripScenicCouponId);
        sb.append(", tripScenicCouponCode=").append(tripScenicCouponCode);
        sb.append(", userId=").append(userId);
        sb.append(", getType=").append(getType);
        sb.append(", useStatus=").append(useStatus);
        sb.append(", tripScenicOrderId=").append(tripScenicOrderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", useTime=").append(useTime);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicCouponId("trip_scenic_coupon_id"),
        tripScenicCouponCode("trip_scenic_coupon_code"),
        userId("user_id"),
        getType("get_type"),
        useStatus("use_status"),
        tripScenicOrderId("trip_scenic_order_id"),
        orderSn("order_sn"),
        useTime("use_time"),
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
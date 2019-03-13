package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripHotelBill extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游酒店订单ID
    private Long tripHotelOrderId;

    //自驾游酒店发票类型：0->不开发票；1->电子发票；2->纸质发票
    private Integer tripHotelBillType;

    //自驾游酒店发票抬头
    private String tripHotelBillHeader;

    //自驾游酒店发票内容
    private String tripHotelBillContent;

    //自驾游酒店发票收票人电话
    private String tripHotelBillReceiverPhone;

    //自驾游酒店发票收票人邮箱
    private String tripHotelBillReceiverEmail;

    //最后生成的发票网络图像
    private String tripHotelBillPic;

    //有效状态：0->有效；1->无效
    private Integer status;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripHotelOrderId() {
        return tripHotelOrderId;
    }

    public void setTripHotelOrderId(Long tripHotelOrderId) {
        this.tripHotelOrderId = tripHotelOrderId;
    }

    public Integer getTripHotelBillType() {
        return tripHotelBillType;
    }

    public void setTripHotelBillType(Integer tripHotelBillType) {
        this.tripHotelBillType = tripHotelBillType;
    }

    public String getTripHotelBillHeader() {
        return tripHotelBillHeader;
    }

    public void setTripHotelBillHeader(String tripHotelBillHeader) {
        this.tripHotelBillHeader = tripHotelBillHeader;
    }

    public String getTripHotelBillContent() {
        return tripHotelBillContent;
    }

    public void setTripHotelBillContent(String tripHotelBillContent) {
        this.tripHotelBillContent = tripHotelBillContent;
    }

    public String getTripHotelBillReceiverPhone() {
        return tripHotelBillReceiverPhone;
    }

    public void setTripHotelBillReceiverPhone(String tripHotelBillReceiverPhone) {
        this.tripHotelBillReceiverPhone = tripHotelBillReceiverPhone;
    }

    public String getTripHotelBillReceiverEmail() {
        return tripHotelBillReceiverEmail;
    }

    public void setTripHotelBillReceiverEmail(String tripHotelBillReceiverEmail) {
        this.tripHotelBillReceiverEmail = tripHotelBillReceiverEmail;
    }

    public String getTripHotelBillPic() {
        return tripHotelBillPic;
    }

    public void setTripHotelBillPic(String tripHotelBillPic) {
        this.tripHotelBillPic = tripHotelBillPic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripHotelOrderId=").append(tripHotelOrderId);
        sb.append(", tripHotelBillType=").append(tripHotelBillType);
        sb.append(", tripHotelBillHeader=").append(tripHotelBillHeader);
        sb.append(", tripHotelBillContent=").append(tripHotelBillContent);
        sb.append(", tripHotelBillReceiverPhone=").append(tripHotelBillReceiverPhone);
        sb.append(", tripHotelBillReceiverEmail=").append(tripHotelBillReceiverEmail);
        sb.append(", tripHotelBillPic=").append(tripHotelBillPic);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripHotelOrderId("trip_hotel_order_id"),
        tripHotelBillType("trip_hotel_bill_type"),
        tripHotelBillHeader("trip_hotel_bill_header"),
        tripHotelBillContent("trip_hotel_bill_content"),
        tripHotelBillReceiverPhone("trip_hotel_bill_receiver_phone"),
        tripHotelBillReceiverEmail("trip_hotel_bill_receiver_email"),
        tripHotelBillPic("trip_hotel_bill_pic"),
        status("status"),
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
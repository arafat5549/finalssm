package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripScenicBill extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游景区订单ID
    private Long tripScenicOrderId;

    //自驾游景区发票类型：0->不开发票；1->电子发票；2->纸质发票
    private Integer tripScenicBillType;

    //自驾游景区发票抬头
    private String tripScenicBillHeader;

    //自驾游景区发票内容
    private String tripScenicBillContent;

    //自驾游景区发票收票人电话
    private String tripScenicBillReceiverPhone;

    //自驾游景区发票收票人邮箱
    private String tripScenicBillReceiverEmail;

    //最后生成的发票网络图像
    private String tripScenicBillPic;

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

    public Long getTripScenicOrderId() {
        return tripScenicOrderId;
    }

    public void setTripScenicOrderId(Long tripScenicOrderId) {
        this.tripScenicOrderId = tripScenicOrderId;
    }

    public Integer getTripScenicBillType() {
        return tripScenicBillType;
    }

    public void setTripScenicBillType(Integer tripScenicBillType) {
        this.tripScenicBillType = tripScenicBillType;
    }

    public String getTripScenicBillHeader() {
        return tripScenicBillHeader;
    }

    public void setTripScenicBillHeader(String tripScenicBillHeader) {
        this.tripScenicBillHeader = tripScenicBillHeader;
    }

    public String getTripScenicBillContent() {
        return tripScenicBillContent;
    }

    public void setTripScenicBillContent(String tripScenicBillContent) {
        this.tripScenicBillContent = tripScenicBillContent;
    }

    public String getTripScenicBillReceiverPhone() {
        return tripScenicBillReceiverPhone;
    }

    public void setTripScenicBillReceiverPhone(String tripScenicBillReceiverPhone) {
        this.tripScenicBillReceiverPhone = tripScenicBillReceiverPhone;
    }

    public String getTripScenicBillReceiverEmail() {
        return tripScenicBillReceiverEmail;
    }

    public void setTripScenicBillReceiverEmail(String tripScenicBillReceiverEmail) {
        this.tripScenicBillReceiverEmail = tripScenicBillReceiverEmail;
    }

    public String getTripScenicBillPic() {
        return tripScenicBillPic;
    }

    public void setTripScenicBillPic(String tripScenicBillPic) {
        this.tripScenicBillPic = tripScenicBillPic;
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
        sb.append(", tripScenicOrderId=").append(tripScenicOrderId);
        sb.append(", tripScenicBillType=").append(tripScenicBillType);
        sb.append(", tripScenicBillHeader=").append(tripScenicBillHeader);
        sb.append(", tripScenicBillContent=").append(tripScenicBillContent);
        sb.append(", tripScenicBillReceiverPhone=").append(tripScenicBillReceiverPhone);
        sb.append(", tripScenicBillReceiverEmail=").append(tripScenicBillReceiverEmail);
        sb.append(", tripScenicBillPic=").append(tripScenicBillPic);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicOrderId("trip_scenic_order_id"),
        tripScenicBillType("trip_scenic_bill_type"),
        tripScenicBillHeader("trip_scenic_bill_header"),
        tripScenicBillContent("trip_scenic_bill_content"),
        tripScenicBillReceiverPhone("trip_scenic_bill_receiver_phone"),
        tripScenicBillReceiverEmail("trip_scenic_bill_receiver_email"),
        tripScenicBillPic("trip_scenic_bill_pic"),
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
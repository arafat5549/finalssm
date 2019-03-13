package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripRouteBill extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游线路订单ID
    private Long tripRouteOrderId;

    //自驾游线路发票类型：0->不开发票；1->电子发票；2->纸质发票
    private Integer tripRouteBillType;

    //自驾游线路发票抬头
    private String tripRouteBillHeader;

    //自驾游线路发票内容
    private String tripRouteBillContent;

    //自驾游线路发票收票人电话
    private String tripRouteBillReceiverPhone;

    //自驾游线路发票收票人邮箱
    private String tripRouteBillReceiverEmail;

    //最后生成的发票网络图像
    private String tripRouteBillPic;

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

    public Long getTripRouteOrderId() {
        return tripRouteOrderId;
    }

    public void setTripRouteOrderId(Long tripRouteOrderId) {
        this.tripRouteOrderId = tripRouteOrderId;
    }

    public Integer getTripRouteBillType() {
        return tripRouteBillType;
    }

    public void setTripRouteBillType(Integer tripRouteBillType) {
        this.tripRouteBillType = tripRouteBillType;
    }

    public String getTripRouteBillHeader() {
        return tripRouteBillHeader;
    }

    public void setTripRouteBillHeader(String tripRouteBillHeader) {
        this.tripRouteBillHeader = tripRouteBillHeader;
    }

    public String getTripRouteBillContent() {
        return tripRouteBillContent;
    }

    public void setTripRouteBillContent(String tripRouteBillContent) {
        this.tripRouteBillContent = tripRouteBillContent;
    }

    public String getTripRouteBillReceiverPhone() {
        return tripRouteBillReceiverPhone;
    }

    public void setTripRouteBillReceiverPhone(String tripRouteBillReceiverPhone) {
        this.tripRouteBillReceiverPhone = tripRouteBillReceiverPhone;
    }

    public String getTripRouteBillReceiverEmail() {
        return tripRouteBillReceiverEmail;
    }

    public void setTripRouteBillReceiverEmail(String tripRouteBillReceiverEmail) {
        this.tripRouteBillReceiverEmail = tripRouteBillReceiverEmail;
    }

    public String getTripRouteBillPic() {
        return tripRouteBillPic;
    }

    public void setTripRouteBillPic(String tripRouteBillPic) {
        this.tripRouteBillPic = tripRouteBillPic;
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
        sb.append(", tripRouteOrderId=").append(tripRouteOrderId);
        sb.append(", tripRouteBillType=").append(tripRouteBillType);
        sb.append(", tripRouteBillHeader=").append(tripRouteBillHeader);
        sb.append(", tripRouteBillContent=").append(tripRouteBillContent);
        sb.append(", tripRouteBillReceiverPhone=").append(tripRouteBillReceiverPhone);
        sb.append(", tripRouteBillReceiverEmail=").append(tripRouteBillReceiverEmail);
        sb.append(", tripRouteBillPic=").append(tripRouteBillPic);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripRouteOrderId("trip_route_order_id"),
        tripRouteBillType("trip_route_bill_type"),
        tripRouteBillHeader("trip_route_bill_header"),
        tripRouteBillContent("trip_route_bill_content"),
        tripRouteBillReceiverPhone("trip_route_bill_receiver_phone"),
        tripRouteBillReceiverEmail("trip_route_bill_receiver_email"),
        tripRouteBillPic("trip_route_bill_pic"),
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
package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripHotelOrderReturnApply extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游酒店订单id
    private Long tripHotelOrderId;

    //自驾游酒店店家id
    private Long tripHotelStoreId;

    //退货自驾游酒店id
    private Long tripHotelId;

    //订单编号
    private String orderSn;

    //会员用户名
    private String userUsername;

    //退款金额
    private BigDecimal returnAmount;

    //退货人姓名
    private String returnName;

    //退货人电话
    private String returnPhone;

    //处理时间
    private Date handleTime;

    //自驾游酒店图片
    private String tripHotelPic;

    //自驾游酒店名称
    private String tripHotelName;

    //自驾游酒店品牌
    private String tripHotelBrand;

    //自驾游酒店销售属性 json字符串存储： {颜色：红色,尺码：xl}
    private String tripHotelAttr;

    //退货数量
    private Integer tripHotelCount;

    //自驾游酒店单价
    private BigDecimal tripHotelPrice;

    //自驾游酒店实际支付单价
    private BigDecimal tripHotelRealPrice;

    //退货原因
    private String reason;

    //描述
    private String description;

    //凭证图片，以逗号隔开
    private String proofPics;

    //处理备注
    private String handleRemark;

    //处理人员
    private String handleMan;

    //收货人
    private String receiveMan;

    //收货时间
    private Date receiveTime;

    //收货备注
    private String receiveRemark;

    //申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
    private Integer returnApplyStatus;

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

    public Long getTripHotelStoreId() {
        return tripHotelStoreId;
    }

    public void setTripHotelStoreId(Long tripHotelStoreId) {
        this.tripHotelStoreId = tripHotelStoreId;
    }

    public Long getTripHotelId() {
        return tripHotelId;
    }

    public void setTripHotelId(Long tripHotelId) {
        this.tripHotelId = tripHotelId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnPhone() {
        return returnPhone;
    }

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getTripHotelPic() {
        return tripHotelPic;
    }

    public void setTripHotelPic(String tripHotelPic) {
        this.tripHotelPic = tripHotelPic;
    }

    public String getTripHotelName() {
        return tripHotelName;
    }

    public void setTripHotelName(String tripHotelName) {
        this.tripHotelName = tripHotelName;
    }

    public String getTripHotelBrand() {
        return tripHotelBrand;
    }

    public void setTripHotelBrand(String tripHotelBrand) {
        this.tripHotelBrand = tripHotelBrand;
    }

    public String getTripHotelAttr() {
        return tripHotelAttr;
    }

    public void setTripHotelAttr(String tripHotelAttr) {
        this.tripHotelAttr = tripHotelAttr;
    }

    public Integer getTripHotelCount() {
        return tripHotelCount;
    }

    public void setTripHotelCount(Integer tripHotelCount) {
        this.tripHotelCount = tripHotelCount;
    }

    public BigDecimal getTripHotelPrice() {
        return tripHotelPrice;
    }

    public void setTripHotelPrice(BigDecimal tripHotelPrice) {
        this.tripHotelPrice = tripHotelPrice;
    }

    public BigDecimal getTripHotelRealPrice() {
        return tripHotelRealPrice;
    }

    public void setTripHotelRealPrice(BigDecimal tripHotelRealPrice) {
        this.tripHotelRealPrice = tripHotelRealPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProofPics() {
        return proofPics;
    }

    public void setProofPics(String proofPics) {
        this.proofPics = proofPics;
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceiveRemark() {
        return receiveRemark;
    }

    public void setReceiveRemark(String receiveRemark) {
        this.receiveRemark = receiveRemark;
    }

    public Integer getReturnApplyStatus() {
        return returnApplyStatus;
    }

    public void setReturnApplyStatus(Integer returnApplyStatus) {
        this.returnApplyStatus = returnApplyStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripHotelOrderId=").append(tripHotelOrderId);
        sb.append(", tripHotelStoreId=").append(tripHotelStoreId);
        sb.append(", tripHotelId=").append(tripHotelId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", userUsername=").append(userUsername);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", returnName=").append(returnName);
        sb.append(", returnPhone=").append(returnPhone);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", tripHotelPic=").append(tripHotelPic);
        sb.append(", tripHotelName=").append(tripHotelName);
        sb.append(", tripHotelBrand=").append(tripHotelBrand);
        sb.append(", tripHotelAttr=").append(tripHotelAttr);
        sb.append(", tripHotelCount=").append(tripHotelCount);
        sb.append(", tripHotelPrice=").append(tripHotelPrice);
        sb.append(", tripHotelRealPrice=").append(tripHotelRealPrice);
        sb.append(", reason=").append(reason);
        sb.append(", description=").append(description);
        sb.append(", proofPics=").append(proofPics);
        sb.append(", handleRemark=").append(handleRemark);
        sb.append(", handleMan=").append(handleMan);
        sb.append(", receiveMan=").append(receiveMan);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", receiveRemark=").append(receiveRemark);
        sb.append(", returnApplyStatus=").append(returnApplyStatus);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripHotelOrderId("trip_hotel_order_id"),
        tripHotelStoreId("trip_hotel_store_id"),
        tripHotelId("trip_hotel_id"),
        orderSn("order_sn"),
        userUsername("user_username"),
        returnAmount("return_amount"),
        returnName("return_name"),
        returnPhone("return_phone"),
        handleTime("handle_time"),
        tripHotelPic("trip_hotel_pic"),
        tripHotelName("trip_hotel_name"),
        tripHotelBrand("trip_hotel_brand"),
        tripHotelAttr("trip_hotel_attr"),
        tripHotelCount("trip_hotel_count"),
        tripHotelPrice("trip_hotel_price"),
        tripHotelRealPrice("trip_hotel_real_price"),
        reason("reason"),
        description("description"),
        proofPics("proof_pics"),
        handleRemark("handle_remark"),
        handleMan("handle_man"),
        receiveMan("receive_man"),
        receiveTime("receive_time"),
        receiveRemark("receive_remark"),
        returnApplyStatus("return_apply_status"),
        createTime("create_time");

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
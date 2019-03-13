package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripScenicOrderReturnApply extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游景区订单id
    private Long tripScenicOrderId;

    //自驾游景区店家id
    private Long tripScenicStoreId;

    //退货自驾游景区id
    private Long tripScenicId;

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

    //自驾游景区图片
    private String tripScenicPic;

    //自驾游景区名称
    private String tripScenicName;

    //自驾游景区品牌
    private String tripScenicBrand;

    //自驾游景区销售属性 json字符串存储： {颜色：红色,尺码：xl}
    private String tripScenicAttr;

    //退货数量
    private Integer tripScenicCount;

    //自驾游景区单价
    private BigDecimal tripScenicPrice;

    //自驾游景区实际支付单价
    private BigDecimal tripScenicRealPrice;

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

    public Long getTripScenicOrderId() {
        return tripScenicOrderId;
    }

    public void setTripScenicOrderId(Long tripScenicOrderId) {
        this.tripScenicOrderId = tripScenicOrderId;
    }

    public Long getTripScenicStoreId() {
        return tripScenicStoreId;
    }

    public void setTripScenicStoreId(Long tripScenicStoreId) {
        this.tripScenicStoreId = tripScenicStoreId;
    }

    public Long getTripScenicId() {
        return tripScenicId;
    }

    public void setTripScenicId(Long tripScenicId) {
        this.tripScenicId = tripScenicId;
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

    public String getTripScenicPic() {
        return tripScenicPic;
    }

    public void setTripScenicPic(String tripScenicPic) {
        this.tripScenicPic = tripScenicPic;
    }

    public String getTripScenicName() {
        return tripScenicName;
    }

    public void setTripScenicName(String tripScenicName) {
        this.tripScenicName = tripScenicName;
    }

    public String getTripScenicBrand() {
        return tripScenicBrand;
    }

    public void setTripScenicBrand(String tripScenicBrand) {
        this.tripScenicBrand = tripScenicBrand;
    }

    public String getTripScenicAttr() {
        return tripScenicAttr;
    }

    public void setTripScenicAttr(String tripScenicAttr) {
        this.tripScenicAttr = tripScenicAttr;
    }

    public Integer getTripScenicCount() {
        return tripScenicCount;
    }

    public void setTripScenicCount(Integer tripScenicCount) {
        this.tripScenicCount = tripScenicCount;
    }

    public BigDecimal getTripScenicPrice() {
        return tripScenicPrice;
    }

    public void setTripScenicPrice(BigDecimal tripScenicPrice) {
        this.tripScenicPrice = tripScenicPrice;
    }

    public BigDecimal getTripScenicRealPrice() {
        return tripScenicRealPrice;
    }

    public void setTripScenicRealPrice(BigDecimal tripScenicRealPrice) {
        this.tripScenicRealPrice = tripScenicRealPrice;
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
        sb.append(", tripScenicOrderId=").append(tripScenicOrderId);
        sb.append(", tripScenicStoreId=").append(tripScenicStoreId);
        sb.append(", tripScenicId=").append(tripScenicId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", userUsername=").append(userUsername);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", returnName=").append(returnName);
        sb.append(", returnPhone=").append(returnPhone);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", tripScenicPic=").append(tripScenicPic);
        sb.append(", tripScenicName=").append(tripScenicName);
        sb.append(", tripScenicBrand=").append(tripScenicBrand);
        sb.append(", tripScenicAttr=").append(tripScenicAttr);
        sb.append(", tripScenicCount=").append(tripScenicCount);
        sb.append(", tripScenicPrice=").append(tripScenicPrice);
        sb.append(", tripScenicRealPrice=").append(tripScenicRealPrice);
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
        tripScenicOrderId("trip_scenic_order_id"),
        tripScenicStoreId("trip_scenic_store_id"),
        tripScenicId("trip_scenic_id"),
        orderSn("order_sn"),
        userUsername("user_username"),
        returnAmount("return_amount"),
        returnName("return_name"),
        returnPhone("return_phone"),
        handleTime("handle_time"),
        tripScenicPic("trip_scenic_pic"),
        tripScenicName("trip_scenic_name"),
        tripScenicBrand("trip_scenic_brand"),
        tripScenicAttr("trip_scenic_attr"),
        tripScenicCount("trip_scenic_count"),
        tripScenicPrice("trip_scenic_price"),
        tripScenicRealPrice("trip_scenic_real_price"),
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
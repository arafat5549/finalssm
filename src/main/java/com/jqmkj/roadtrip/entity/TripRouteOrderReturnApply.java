package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripRouteOrderReturnApply extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游线路订单id
    private Long tripRouteOrderId;

    //自驾游线路店家id
    private Long tripRouteStoreId;

    //退货自驾游线路id
    private Long tripRouteId;

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

    //自驾游线路图片
    private String tripRoutePic;

    //自驾游线路名称
    private String tripRouteName;

    //自驾游线路品牌
    private String tripRouteBrand;

    //自驾游线路销售属性 json字符串存储： {颜色：红色,尺码：xl}
    private String tripRouteAttr;

    //退货数量
    private Integer tripRouteCount;

    //自驾游线路单价
    private BigDecimal tripRoutePrice;

    //自驾游线路实际支付单价
    private BigDecimal tripRouteRealPrice;

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

    public Long getTripRouteOrderId() {
        return tripRouteOrderId;
    }

    public void setTripRouteOrderId(Long tripRouteOrderId) {
        this.tripRouteOrderId = tripRouteOrderId;
    }

    public Long getTripRouteStoreId() {
        return tripRouteStoreId;
    }

    public void setTripRouteStoreId(Long tripRouteStoreId) {
        this.tripRouteStoreId = tripRouteStoreId;
    }

    public Long getTripRouteId() {
        return tripRouteId;
    }

    public void setTripRouteId(Long tripRouteId) {
        this.tripRouteId = tripRouteId;
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

    public String getTripRoutePic() {
        return tripRoutePic;
    }

    public void setTripRoutePic(String tripRoutePic) {
        this.tripRoutePic = tripRoutePic;
    }

    public String getTripRouteName() {
        return tripRouteName;
    }

    public void setTripRouteName(String tripRouteName) {
        this.tripRouteName = tripRouteName;
    }

    public String getTripRouteBrand() {
        return tripRouteBrand;
    }

    public void setTripRouteBrand(String tripRouteBrand) {
        this.tripRouteBrand = tripRouteBrand;
    }

    public String getTripRouteAttr() {
        return tripRouteAttr;
    }

    public void setTripRouteAttr(String tripRouteAttr) {
        this.tripRouteAttr = tripRouteAttr;
    }

    public Integer getTripRouteCount() {
        return tripRouteCount;
    }

    public void setTripRouteCount(Integer tripRouteCount) {
        this.tripRouteCount = tripRouteCount;
    }

    public BigDecimal getTripRoutePrice() {
        return tripRoutePrice;
    }

    public void setTripRoutePrice(BigDecimal tripRoutePrice) {
        this.tripRoutePrice = tripRoutePrice;
    }

    public BigDecimal getTripRouteRealPrice() {
        return tripRouteRealPrice;
    }

    public void setTripRouteRealPrice(BigDecimal tripRouteRealPrice) {
        this.tripRouteRealPrice = tripRouteRealPrice;
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
        sb.append(", tripRouteOrderId=").append(tripRouteOrderId);
        sb.append(", tripRouteStoreId=").append(tripRouteStoreId);
        sb.append(", tripRouteId=").append(tripRouteId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", userUsername=").append(userUsername);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", returnName=").append(returnName);
        sb.append(", returnPhone=").append(returnPhone);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", tripRoutePic=").append(tripRoutePic);
        sb.append(", tripRouteName=").append(tripRouteName);
        sb.append(", tripRouteBrand=").append(tripRouteBrand);
        sb.append(", tripRouteAttr=").append(tripRouteAttr);
        sb.append(", tripRouteCount=").append(tripRouteCount);
        sb.append(", tripRoutePrice=").append(tripRoutePrice);
        sb.append(", tripRouteRealPrice=").append(tripRouteRealPrice);
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
        tripRouteOrderId("trip_route_order_id"),
        tripRouteStoreId("trip_route_store_id"),
        tripRouteId("trip_route_id"),
        orderSn("order_sn"),
        userUsername("user_username"),
        returnAmount("return_amount"),
        returnName("return_name"),
        returnPhone("return_phone"),
        handleTime("handle_time"),
        tripRoutePic("trip_route_pic"),
        tripRouteName("trip_route_name"),
        tripRouteBrand("trip_route_brand"),
        tripRouteAttr("trip_route_attr"),
        tripRouteCount("trip_route_count"),
        tripRoutePrice("trip_route_price"),
        tripRouteRealPrice("trip_route_real_price"),
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
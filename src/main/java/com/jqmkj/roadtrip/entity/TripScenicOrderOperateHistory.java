package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripScenicOrderOperateHistory extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //订单id
    private Long tripScenicOrderId;

    //操作人：用户；系统；后台管理员
    private String operatorMan;

    //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    private Integer orderStatus;

    //备注
    private String remark;

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

    public String getOperatorMan() {
        return operatorMan;
    }

    public void setOperatorMan(String operatorMan) {
        this.operatorMan = operatorMan;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripScenicOrderId=").append(tripScenicOrderId);
        sb.append(", operatorMan=").append(operatorMan);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicOrderId("trip_scenic_order_id"),
        operatorMan("operator_man"),
        orderStatus("order_status"),
        remark("remark"),
        createId("create_id"),
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
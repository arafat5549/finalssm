package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripAppointCollect extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //约游ID
    private Long tripAppointId;

    //收藏人用户ID
    private Long userId;

    //备注
    private String remark;

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

    public Long getTripAppointId() {
        return tripAppointId;
    }

    public void setTripAppointId(Long tripAppointId) {
        this.tripAppointId = tripAppointId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", tripAppointId=").append(tripAppointId);
        sb.append(", userId=").append(userId);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripAppointId("trip_appoint_id"),
        userId("user_id"),
        remark("remark"),
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
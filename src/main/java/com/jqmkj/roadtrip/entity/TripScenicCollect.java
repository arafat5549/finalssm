package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class TripScenicCollect extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //外键 收藏自驾游景区id
    private Long tripScenicId;

    //收藏-自驾游景区店家id
    private Long tripScenicStoreId;

    //备注
    private String remark;

    //最后操作时间
    private Date upateTime;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripScenicId() {
        return tripScenicId;
    }

    public void setTripScenicId(Long tripScenicId) {
        this.tripScenicId = tripScenicId;
    }

    public Long getTripScenicStoreId() {
        return tripScenicStoreId;
    }

    public void setTripScenicStoreId(Long tripScenicStoreId) {
        this.tripScenicStoreId = tripScenicStoreId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpateTime() {
        return upateTime;
    }

    public void setUpateTime(Date upateTime) {
        this.upateTime = upateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripScenicId=").append(tripScenicId);
        sb.append(", tripScenicStoreId=").append(tripScenicStoreId);
        sb.append(", remark=").append(remark);
        sb.append(", upateTime=").append(upateTime);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicId("trip_scenic_id"),
        tripScenicStoreId("trip_scenic_store_id"),
        remark("remark"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        upateTime("upate_time");

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
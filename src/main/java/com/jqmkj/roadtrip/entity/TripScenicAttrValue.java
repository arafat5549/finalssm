package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripScenicAttrValue extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //名称
    private Long tripScenicId;

    //自驾游景区属性参数ID
    private Long tripScenicAttrId;

    //手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
    private String value;

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

    public Long getTripScenicAttrId() {
        return tripScenicAttrId;
    }

    public void setTripScenicAttrId(Long tripScenicAttrId) {
        this.tripScenicAttrId = tripScenicAttrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripScenicId=").append(tripScenicId);
        sb.append(", tripScenicAttrId=").append(tripScenicAttrId);
        sb.append(", value=").append(value);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicId("trip_scenic_id"),
        tripScenicAttrId("trip_scenic_attr_id"),
        value("value");

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
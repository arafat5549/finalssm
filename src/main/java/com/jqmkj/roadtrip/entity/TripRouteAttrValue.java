package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripRouteAttrValue extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //名称
    private Long tripRouteId;

    //自驾游线路属性参数ID
    private Long tripRouteAttrId;

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

    public Long getTripRouteId() {
        return tripRouteId;
    }

    public void setTripRouteId(Long tripRouteId) {
        this.tripRouteId = tripRouteId;
    }

    public Long getTripRouteAttrId() {
        return tripRouteAttrId;
    }

    public void setTripRouteAttrId(Long tripRouteAttrId) {
        this.tripRouteAttrId = tripRouteAttrId;
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
        sb.append(", tripRouteId=").append(tripRouteId);
        sb.append(", tripRouteAttrId=").append(tripRouteAttrId);
        sb.append(", value=").append(value);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripRouteId("trip_route_id"),
        tripRouteAttrId("trip_route_attr_id"),
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
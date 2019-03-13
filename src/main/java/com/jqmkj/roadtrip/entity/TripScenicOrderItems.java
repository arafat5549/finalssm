package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;

public class TripScenicOrderItems extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //订单id
    private Long tripScenicOrderId;

    //自驾游景区id
    private Long tripScenicId;

    //自驾游景区数量
    private Integer count;

    //单价
    private BigDecimal price;

    //总价
    private BigDecimal total;

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

    public Long getTripScenicId() {
        return tripScenicId;
    }

    public void setTripScenicId(Long tripScenicId) {
        this.tripScenicId = tripScenicId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripScenicOrderId=").append(tripScenicOrderId);
        sb.append(", tripScenicId=").append(tripScenicId);
        sb.append(", count=").append(count);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicOrderId("trip_scenic_order_id"),
        tripScenicId("trip_scenic_id"),
        count("count"),
        price("price"),
        total("total"),
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
package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;

public class TripHotelOrderItems extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //订单id
    private Long tripHotelOrderId;

    //自驾游酒店id
    private Long tripHotelId;

    //自驾游酒店数量
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

    public Long getTripHotelOrderId() {
        return tripHotelOrderId;
    }

    public void setTripHotelOrderId(Long tripHotelOrderId) {
        this.tripHotelOrderId = tripHotelOrderId;
    }

    public Long getTripHotelId() {
        return tripHotelId;
    }

    public void setTripHotelId(Long tripHotelId) {
        this.tripHotelId = tripHotelId;
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
        sb.append(", tripHotelOrderId=").append(tripHotelOrderId);
        sb.append(", tripHotelId=").append(tripHotelId);
        sb.append(", count=").append(count);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripHotelOrderId("trip_hotel_order_id"),
        tripHotelId("trip_hotel_id"),
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
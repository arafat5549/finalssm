package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;

public class TripRouteOrderItems extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //订单id
    private Long tripRouteOrderId;

    //自驾游线路id
    private Long tripRouteId;

    //自驾游线路数量
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

    public Long getTripRouteOrderId() {
        return tripRouteOrderId;
    }

    public void setTripRouteOrderId(Long tripRouteOrderId) {
        this.tripRouteOrderId = tripRouteOrderId;
    }

    public Long getTripRouteId() {
        return tripRouteId;
    }

    public void setTripRouteId(Long tripRouteId) {
        this.tripRouteId = tripRouteId;
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
        sb.append(", tripRouteOrderId=").append(tripRouteOrderId);
        sb.append(", tripRouteId=").append(tripRouteId);
        sb.append(", count=").append(count);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripRouteOrderId("trip_route_order_id"),
        tripRouteId("trip_route_id"),
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
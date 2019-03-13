package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;

public class TripHotelUserPrice extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游酒店ID
    private Long tripHotelId;

    //会员等级ID
    private Long userLevelId;

    //会员价格百分比
    private BigDecimal userPricePercent;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripHotelId() {
        return tripHotelId;
    }

    public void setTripHotelId(Long tripHotelId) {
        this.tripHotelId = tripHotelId;
    }

    public Long getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Long userLevelId) {
        this.userLevelId = userLevelId;
    }

    public BigDecimal getUserPricePercent() {
        return userPricePercent;
    }

    public void setUserPricePercent(BigDecimal userPricePercent) {
        this.userPricePercent = userPricePercent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripHotelId=").append(tripHotelId);
        sb.append(", userLevelId=").append(userLevelId);
        sb.append(", userPricePercent=").append(userPricePercent);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripHotelId("trip_hotel_id"),
        userLevelId("user_level_id"),
        userPricePercent("user_price_percent"),
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
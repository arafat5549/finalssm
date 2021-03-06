package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripScenicBlacklist extends BaseEntity implements Serializable {
    //主键ID
    private Long id;

    //黑名单用户id
    private Long userId;

    //黑名单商户id
    private Long tripScenicStoreId;

    //紧闭时间
    private String forbidCount;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTripScenicStoreId() {
        return tripScenicStoreId;
    }

    public void setTripScenicStoreId(Long tripScenicStoreId) {
        this.tripScenicStoreId = tripScenicStoreId;
    }

    public String getForbidCount() {
        return forbidCount;
    }

    public void setForbidCount(String forbidCount) {
        this.forbidCount = forbidCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", tripScenicStoreId=").append(tripScenicStoreId);
        sb.append(", forbidCount=").append(forbidCount);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        userId("user_id"),
        tripScenicStoreId("trip_scenic_store_id"),
        forbidCount("forbid_count"),
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
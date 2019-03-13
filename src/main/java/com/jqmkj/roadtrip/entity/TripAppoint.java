package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class TripAppoint extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //标题
    private String title;

    //联系电话
    private String phone;

    //qq
    private String qq;

    //微信
    private String wechat;

    //出发地
    private String departure;

    //目的地
    private String destination;

    //出发时间
    private Date departureTime;

    //活动天数
    private Integer lastDays;

    //限制人数
    private Integer limitCount;

    //结伴描述
    private String description;

    //发起人用户ID
    private Long userId;

    //发布时间
    private Date publishTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getLastDays() {
        return lastDays;
    }

    public void setLastDays(Integer lastDays) {
        this.lastDays = lastDays;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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
        sb.append(", title=").append(title);
        sb.append(", phone=").append(phone);
        sb.append(", qq=").append(qq);
        sb.append(", wechat=").append(wechat);
        sb.append(", departure=").append(departure);
        sb.append(", destination=").append(destination);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", lastDays=").append(lastDays);
        sb.append(", limitCount=").append(limitCount);
        sb.append(", description=").append(description);
        sb.append(", userId=").append(userId);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        title("title"),
        phone("phone"),
        qq("qq"),
        wechat("wechat"),
        departure("departure"),
        destination("destination"),
        departureTime("departure_time"),
        lastDays("last_days"),
        limitCount("limit_count"),
        description("description"),
        userId("user_id"),
        publishTime("publish_time"),
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
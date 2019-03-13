package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripTravelArticleReview extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //游记ID
    private Long tripTravelArticleId;

    //用户ID
    private Long userId;

    //类型
    private Integer type;

    //标题
    private String title;

    //内容
    private String content;

    //备注信息
    private String remark;

    //点赞数量
    private Integer likeCount;

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

    public Long getTripTravelArticleId() {
        return tripTravelArticleId;
    }

    public void setTripTravelArticleId(Long tripTravelArticleId) {
        this.tripTravelArticleId = tripTravelArticleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
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
        sb.append(", tripTravelArticleId=").append(tripTravelArticleId);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", remark=").append(remark);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripTravelArticleId("trip_travel_article_id"),
        userId("user_id"),
        type("type"),
        title("title"),
        content("content"),
        remark("remark"),
        likeCount("like_count"),
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
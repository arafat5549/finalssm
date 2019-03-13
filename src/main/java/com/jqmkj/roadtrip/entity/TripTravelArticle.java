package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripTravelArticle extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //类型：0->亲子；1->休闲自驾
    private Integer type;

    //标题
    private String title;

    //自驾游景区名称
    private String tripScenicName;

    //看过数量
    private Integer readCount;

    //想去数量
    private Integer willCount;

    //点赞数量
    private Integer likeCount;

    //有效状态：0->草稿；1->正式发布
    private Integer articleStatus;

    //有效状态：0->有效；1->无效
    private Integer status;

    //内容
    private String content;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTripScenicName() {
        return tripScenicName;
    }

    public void setTripScenicName(String tripScenicName) {
        this.tripScenicName = tripScenicName;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getWillCount() {
        return willCount;
    }

    public void setWillCount(Integer willCount) {
        this.willCount = willCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", tripScenicName=").append(tripScenicName);
        sb.append(", readCount=").append(readCount);
        sb.append(", willCount=").append(willCount);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", articleStatus=").append(articleStatus);
        sb.append(", status=").append(status);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        type("type"),
        title("title"),
        tripScenicName("trip_scenic_name"),
        readCount("read_count"),
        willCount("will_count"),
        likeCount("like_count"),
        articleStatus("article_status"),
        status("status"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        updateTime("update_time"),
        content("content");

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
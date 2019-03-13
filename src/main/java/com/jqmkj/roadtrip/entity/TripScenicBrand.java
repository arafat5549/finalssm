package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripScenicBrand extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //名称
    private String name;

    //首字母
    private String firstLetter;

    //名称
    private Integer sort;

    //是否为品牌制造商：0->不是；1->是
    private Integer factoryStatus;

    //产品数量
    private Integer tripScenicCount;

    //产品评论数量
    private Integer tripScenicCommentCount;

    //品牌logo
    private String logo;

    //专区大图
    private String bigPic;

    //有效状态：0->有效；1->无效
    private Integer status;

    //品牌故事
    private String brandStory;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getTripScenicCount() {
        return tripScenicCount;
    }

    public void setTripScenicCount(Integer tripScenicCount) {
        this.tripScenicCount = tripScenicCount;
    }

    public Integer getTripScenicCommentCount() {
        return tripScenicCommentCount;
    }

    public void setTripScenicCommentCount(Integer tripScenicCommentCount) {
        this.tripScenicCommentCount = tripScenicCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", firstLetter=").append(firstLetter);
        sb.append(", sort=").append(sort);
        sb.append(", factoryStatus=").append(factoryStatus);
        sb.append(", tripScenicCount=").append(tripScenicCount);
        sb.append(", tripScenicCommentCount=").append(tripScenicCommentCount);
        sb.append(", logo=").append(logo);
        sb.append(", bigPic=").append(bigPic);
        sb.append(", status=").append(status);
        sb.append(", brandStory=").append(brandStory);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        name("name"),
        firstLetter("first_letter"),
        sort("sort"),
        factoryStatus("factory_status"),
        tripScenicCount("trip_scenic_count"),
        tripScenicCommentCount("trip_scenic_comment_count"),
        logo("logo"),
        bigPic("big_pic"),
        status("status"),
        brandStory("brand_story");

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
package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripScenicStore extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //GPS类型：0->景区；1->酒店；2->购物；3->租车服务；4->救援维修；5->商城；6>高速加油站信息；7->其他
    private Integer tripGpsType;

    //GPS ID
    private Long tripGpsId;

    //自驾游景区店家细节ID
    private Long tripScenicStoreDetailId;

    //自驾游景区店家ID
    private Long tripScenicId;

    //自驾游景区店家名称
    private String name;

    //自驾游景区店家描述
    private String describe;

    //备注
    private String remark;

    // 自驾游景区店家分类ID
    private Long tripScenicStoreCategoryId;

    //自驾游景区店家图片
    private String imagePic;

    //自驾游景区店家图片小
    private String imageSmallPic;

    //自驾游景区店家图片中
    private String imageMediumPic;

    //自驾游景区店家图片大
    private String imageLargePic;

    //均价
    private BigDecimal averagePrice;

    //最低价格
    private BigDecimal minPrice;

    //排序
    private Integer sort;

    //评级
    private Integer rate;

    //最后操作时间
    private Date upateTime;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTripGpsType() {
        return tripGpsType;
    }

    public void setTripGpsType(Integer tripGpsType) {
        this.tripGpsType = tripGpsType;
    }

    public Long getTripGpsId() {
        return tripGpsId;
    }

    public void setTripGpsId(Long tripGpsId) {
        this.tripGpsId = tripGpsId;
    }

    public Long getTripScenicStoreDetailId() {
        return tripScenicStoreDetailId;
    }

    public void setTripScenicStoreDetailId(Long tripScenicStoreDetailId) {
        this.tripScenicStoreDetailId = tripScenicStoreDetailId;
    }

    public Long getTripScenicId() {
        return tripScenicId;
    }

    public void setTripScenicId(Long tripScenicId) {
        this.tripScenicId = tripScenicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getTripScenicStoreCategoryId() {
        return tripScenicStoreCategoryId;
    }

    public void setTripScenicStoreCategoryId(Long tripScenicStoreCategoryId) {
        this.tripScenicStoreCategoryId = tripScenicStoreCategoryId;
    }

    public String getImagePic() {
        return imagePic;
    }

    public void setImagePic(String imagePic) {
        this.imagePic = imagePic;
    }

    public String getImageSmallPic() {
        return imageSmallPic;
    }

    public void setImageSmallPic(String imageSmallPic) {
        this.imageSmallPic = imageSmallPic;
    }

    public String getImageMediumPic() {
        return imageMediumPic;
    }

    public void setImageMediumPic(String imageMediumPic) {
        this.imageMediumPic = imageMediumPic;
    }

    public String getImageLargePic() {
        return imageLargePic;
    }

    public void setImageLargePic(String imageLargePic) {
        this.imageLargePic = imageLargePic;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getUpateTime() {
        return upateTime;
    }

    public void setUpateTime(Date upateTime) {
        this.upateTime = upateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripGpsType=").append(tripGpsType);
        sb.append(", tripGpsId=").append(tripGpsId);
        sb.append(", tripScenicStoreDetailId=").append(tripScenicStoreDetailId);
        sb.append(", tripScenicId=").append(tripScenicId);
        sb.append(", name=").append(name);
        sb.append(", describe=").append(describe);
        sb.append(", remark=").append(remark);
        sb.append(", tripScenicStoreCategoryId=").append(tripScenicStoreCategoryId);
        sb.append(", imagePic=").append(imagePic);
        sb.append(", imageSmallPic=").append(imageSmallPic);
        sb.append(", imageMediumPic=").append(imageMediumPic);
        sb.append(", imageLargePic=").append(imageLargePic);
        sb.append(", averagePrice=").append(averagePrice);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", sort=").append(sort);
        sb.append(", rate=").append(rate);
        sb.append(", upateTime=").append(upateTime);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripGpsType("trip_gps_type"),
        tripGpsId("trip_gps_id"),
        tripScenicStoreDetailId("trip_scenic_store_detail_id"),
        tripScenicId("trip_scenic_id"),
        name("name"),
        describe("describe"),
        remark("remark"),
        tripScenicStoreCategoryId("trip_scenic_store_category_id"),
        imagePic("image_pic"),
        imageSmallPic("image_small_pic"),
        imageMediumPic("image_medium_pic"),
        imageLargePic("image_large_pic"),
        averagePrice("average_price"),
        minPrice("min_price"),
        sort("sort"),
        rate("rate"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        upateTime("upate_time");

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
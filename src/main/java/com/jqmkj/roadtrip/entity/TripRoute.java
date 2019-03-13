package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripRoute extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //GPS类型：0->景区；1->酒店；2->购物；3->租车服务；4->救援维修；5->商城；6>高速加油站信息；7->其他
    private Integer tripGpsType;

    //GPS ID
    private Long tripGpsId;

    //自驾游线路名称
    private String name;

    //是否按会员折扣
    private Integer isDiscount;

    //自驾游线路描述
    private String describe;

    //赠送的积分
    private Integer score;

    //备注
    private String remark;

    //评级
    private Integer rate;

    //单价
    private BigDecimal price;

    //促销价格
    private BigDecimal promotionPrice;

    //市场价-原价
    private BigDecimal originalPrice;

    //删除状态：0->未删除；1->已删除
    private Integer deleteStatus;

    //上架状态：0->下架；1->上架
    private Integer publishStatus;

    //新品状态:0->不是新品；1->新品
    private Integer newStatus;

    //推荐状态；0->不推荐；1->推荐
    private Integer recommandStatus;

    //审核状态：0->未审核；1->审核通过
    private Integer verifyStatus;

    //自驾游线路编号-货号
    private String tripRouteSn;

    //排序
    private Integer sort;

    //销量
    private Integer sale;

    //库存
    private Integer stock;

    //库存预警值
    private Integer lowStock;

    //自驾游线路属性分类ID
    private Long tripRouteAttrCategoryId;

    // 自驾游线路品牌ID
    private Long tripRouteBrandId;

    // 自驾游线路分类ID
    private Long tripRouteCategoryId;

    //自驾游线路图片
    private String imagePic;

    //自驾游线路图片小
    private String imageSmallPic;

    //自驾游线路图片中
    private String imageMediumPic;

    //自驾游线路图片大
    private String imageLargePic;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getTripRouteSn() {
        return tripRouteSn;
    }

    public void setTripRouteSn(String tripRouteSn) {
        this.tripRouteSn = tripRouteSn;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public Long getTripRouteAttrCategoryId() {
        return tripRouteAttrCategoryId;
    }

    public void setTripRouteAttrCategoryId(Long tripRouteAttrCategoryId) {
        this.tripRouteAttrCategoryId = tripRouteAttrCategoryId;
    }

    public Long getTripRouteBrandId() {
        return tripRouteBrandId;
    }

    public void setTripRouteBrandId(Long tripRouteBrandId) {
        this.tripRouteBrandId = tripRouteBrandId;
    }

    public Long getTripRouteCategoryId() {
        return tripRouteCategoryId;
    }

    public void setTripRouteCategoryId(Long tripRouteCategoryId) {
        this.tripRouteCategoryId = tripRouteCategoryId;
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
        sb.append(", name=").append(name);
        sb.append(", isDiscount=").append(isDiscount);
        sb.append(", describe=").append(describe);
        sb.append(", score=").append(score);
        sb.append(", remark=").append(remark);
        sb.append(", rate=").append(rate);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", newStatus=").append(newStatus);
        sb.append(", recommandStatus=").append(recommandStatus);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", tripRouteSn=").append(tripRouteSn);
        sb.append(", sort=").append(sort);
        sb.append(", sale=").append(sale);
        sb.append(", stock=").append(stock);
        sb.append(", lowStock=").append(lowStock);
        sb.append(", tripRouteAttrCategoryId=").append(tripRouteAttrCategoryId);
        sb.append(", tripRouteBrandId=").append(tripRouteBrandId);
        sb.append(", tripRouteCategoryId=").append(tripRouteCategoryId);
        sb.append(", imagePic=").append(imagePic);
        sb.append(", imageSmallPic=").append(imageSmallPic);
        sb.append(", imageMediumPic=").append(imageMediumPic);
        sb.append(", imageLargePic=").append(imageLargePic);
        sb.append(", upateTime=").append(upateTime);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripGpsType("trip_gps_type"),
        tripGpsId("trip_gps_id"),
        name("name"),
        isDiscount("is_discount"),
        describe("describe"),
        score("score"),
        remark("remark"),
        rate("rate"),
        price("price"),
        promotionPrice("promotion_price"),
        originalPrice("original_price"),
        deleteStatus("delete_status"),
        publishStatus("publish_status"),
        newStatus("new_status"),
        recommandStatus("recommand_status"),
        verifyStatus("verify_status"),
        tripRouteSn("trip_route_sn"),
        sort("sort"),
        sale("sale"),
        stock("stock"),
        lowStock("low_stock"),
        tripRouteAttrCategoryId("trip_route_attr_category_id"),
        tripRouteBrandId("trip_route_brand_id"),
        tripRouteCategoryId("trip_route_category_id"),
        imagePic("image_pic"),
        imageSmallPic("image_small_pic"),
        imageMediumPic("image_medium_pic"),
        imageLargePic("image_large_pic"),
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
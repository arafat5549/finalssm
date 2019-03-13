package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;

public class TripHotelSKUStock extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游酒店ID
    private Long tripHotelId;

    //sku编码
    private String skuCode;

    //销售价格
    private BigDecimal price;

    //单品促销价格
    private BigDecimal promotionPrice;

    //库存
    private Integer stock;

    //预警库存
    private Integer lowStock;

    //销售属性1
    private String sp1;

    //销售属性2
    private String sp2;

    //销售属性3
    private String sp3;

    //展示图片
    private String pic;

    //销量
    private Integer sale;

    //锁定库存
    private Integer lockStock;

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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
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

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripHotelId=").append(tripHotelId);
        sb.append(", skuCode=").append(skuCode);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", stock=").append(stock);
        sb.append(", lowStock=").append(lowStock);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", pic=").append(pic);
        sb.append(", sale=").append(sale);
        sb.append(", lockStock=").append(lockStock);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripHotelId("trip_hotel_id"),
        skuCode("sku_code"),
        price("price"),
        promotionPrice("promotion_price"),
        stock("stock"),
        lowStock("low_stock"),
        sp1("sp1"),
        sp2("sp2"),
        sp3("sp3"),
        pic("pic"),
        sale("sale"),
        lockStock("lock_stock"),
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
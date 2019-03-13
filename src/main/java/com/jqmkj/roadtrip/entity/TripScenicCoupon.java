package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TripScenicCoupon extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //名称
    private String name;

    //优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
    private Integer type;

    //使用平台：0->全部；1->PC->移动端
    private Integer platform;

    //数量
    private Integer count;

    //优惠金额
    private BigDecimal amount;

    //每人限领张数
    private Integer perLimit;

    //起始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    //可以领取的日期
    private Date enableTime;

    //使用类型：0->全场通用；1->指定分类；2->指定商品
    private Integer useType;

    //使用条件：分类id#商品id
    private String useCondition;

    //备注
    private String remark;

    //发行数量
    private Integer publishCount;

    //已使用数量
    private Integer useCount;

    //领取数量
    private Integer receiveCount;

    //优惠码
    private String code;

    //可领取的用户类型：0->无限制 1-N 会员登记
    private Integer userLevel;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPerLimit() {
        return perLimit;
    }

    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    public String getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(String useCondition) {
        this.useCondition = useCondition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", platform=").append(platform);
        sb.append(", count=").append(count);
        sb.append(", amount=").append(amount);
        sb.append(", perLimit=").append(perLimit);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", enableTime=").append(enableTime);
        sb.append(", useType=").append(useType);
        sb.append(", useCondition=").append(useCondition);
        sb.append(", remark=").append(remark);
        sb.append(", publishCount=").append(publishCount);
        sb.append(", useCount=").append(useCount);
        sb.append(", receiveCount=").append(receiveCount);
        sb.append(", code=").append(code);
        sb.append(", userLevel=").append(userLevel);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        name("name"),
        type("type"),
        platform("platform"),
        count("count"),
        amount("amount"),
        perLimit("per_limit"),
        startTime("start_time"),
        endTime("end_time"),
        enableTime("enable_time"),
        useType("use_type"),
        useCondition("use_condition"),
        remark("remark"),
        publishCount("publish_count"),
        useCount("use_count"),
        receiveCount("receive_count"),
        code("code"),
        userLevel("user_level"),
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
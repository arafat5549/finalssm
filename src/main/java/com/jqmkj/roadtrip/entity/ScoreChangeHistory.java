package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ScoreChangeHistory extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //用户ID
    private Long userId;

    //改变类型：0->增加；1->减少
    private Integer changeType;

    //积分改变数量
    private Integer changeCount;

    //积分来源：0->购物；1->管理员修改
    private Integer sourceType;

    //操作人员
    private String operatorMan;

    //操作备注
    private String operatorRemark;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getOperatorMan() {
        return operatorMan;
    }

    public void setOperatorMan(String operatorMan) {
        this.operatorMan = operatorMan;
    }

    public String getOperatorRemark() {
        return operatorRemark;
    }

    public void setOperatorRemark(String operatorRemark) {
        this.operatorRemark = operatorRemark;
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
        sb.append(", userId=").append(userId);
        sb.append(", changeType=").append(changeType);
        sb.append(", changeCount=").append(changeCount);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", operatorMan=").append(operatorMan);
        sb.append(", operatorRemark=").append(operatorRemark);
        sb.append(", upateTime=").append(upateTime);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        userId("user_id"),
        changeType("change_type"),
        changeCount("change_count"),
        sourceType("source_type"),
        operatorMan("operator_man"),
        operatorRemark("operator_remark"),
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
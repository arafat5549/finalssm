package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class TripRouteComplaint extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //关键字相关ID，一对一
    private Long keywordId;

    //投诉关键字自定义内容-需要设置dictId为其他
    private String customContent;

    //投诉内容
    private String content;

    //投诉-自驾游线路店家id
    private Long tripRouteStoreId;

    //投诉-自驾游线路id
    private Long tripRouteId;

    //客户id
    private Long userId;

    //客服id employee
    private Long operatorId;

    //事件发生时间
    private Date startTime;

    //举报状态：0->未处理；1->已处理
    private Integer reportStatus;

    //处理结果：0->无效；1->有效；2->恶意
    private Integer handleStatus;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public String getCustomContent() {
        return customContent;
    }

    public void setCustomContent(String customContent) {
        this.customContent = customContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTripRouteStoreId() {
        return tripRouteStoreId;
    }

    public void setTripRouteStoreId(Long tripRouteStoreId) {
        this.tripRouteStoreId = tripRouteStoreId;
    }

    public Long getTripRouteId() {
        return tripRouteId;
    }

    public void setTripRouteId(Long tripRouteId) {
        this.tripRouteId = tripRouteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keywordId=").append(keywordId);
        sb.append(", customContent=").append(customContent);
        sb.append(", content=").append(content);
        sb.append(", tripRouteStoreId=").append(tripRouteStoreId);
        sb.append(", tripRouteId=").append(tripRouteId);
        sb.append(", userId=").append(userId);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", startTime=").append(startTime);
        sb.append(", reportStatus=").append(reportStatus);
        sb.append(", handleStatus=").append(handleStatus);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        keywordId("keyword_id"),
        customContent("custom_content"),
        content("content"),
        tripRouteStoreId("trip_route_store_id"),
        tripRouteId("trip_route_id"),
        userId("user_id"),
        operatorId("operator_id"),
        startTime("start_time"),
        reportStatus("report_status"),
        handleStatus("handle_status"),
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
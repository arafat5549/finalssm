package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SysEmployeeOperatorLog extends BaseEntity implements Serializable {
    //主键ID
    private Long id;

    //日志操作描述
    private String operatorRemark;

    //数据源
    private String operatorSource;

    //模板名称
    private String moduleName;

    //操作时间
    private Date operatorTime;

    //关联的操作记录id
    private Long operatorId;

    //方法名
    private String operatorMethod;

    //类型名称
    private String operatorTypeName;

    //参数类型
    private String operatorArgsType;

    //返回值
    private String operatorOutputData;

    //操作记录异常类型
    private String operatorExceptionType;

    //操作异常消息
    private String operatorExceptionMsg;

    //操作结果 0: 成功 1:失败
    private Integer operatorResult;

    //有效状态：0->有效；1->无效
    private Integer status;

    //输入参数
    private String operatorInputData;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorRemark() {
        return operatorRemark;
    }

    public void setOperatorRemark(String operatorRemark) {
        this.operatorRemark = operatorRemark;
    }

    public String getOperatorSource() {
        return operatorSource;
    }

    public void setOperatorSource(String operatorSource) {
        this.operatorSource = operatorSource;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorMethod() {
        return operatorMethod;
    }

    public void setOperatorMethod(String operatorMethod) {
        this.operatorMethod = operatorMethod;
    }

    public String getOperatorTypeName() {
        return operatorTypeName;
    }

    public void setOperatorTypeName(String operatorTypeName) {
        this.operatorTypeName = operatorTypeName;
    }

    public String getOperatorArgsType() {
        return operatorArgsType;
    }

    public void setOperatorArgsType(String operatorArgsType) {
        this.operatorArgsType = operatorArgsType;
    }

    public String getOperatorOutputData() {
        return operatorOutputData;
    }

    public void setOperatorOutputData(String operatorOutputData) {
        this.operatorOutputData = operatorOutputData;
    }

    public String getOperatorExceptionType() {
        return operatorExceptionType;
    }

    public void setOperatorExceptionType(String operatorExceptionType) {
        this.operatorExceptionType = operatorExceptionType;
    }

    public String getOperatorExceptionMsg() {
        return operatorExceptionMsg;
    }

    public void setOperatorExceptionMsg(String operatorExceptionMsg) {
        this.operatorExceptionMsg = operatorExceptionMsg;
    }

    public Integer getOperatorResult() {
        return operatorResult;
    }

    public void setOperatorResult(Integer operatorResult) {
        this.operatorResult = operatorResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperatorInputData() {
        return operatorInputData;
    }

    public void setOperatorInputData(String operatorInputData) {
        this.operatorInputData = operatorInputData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operatorRemark=").append(operatorRemark);
        sb.append(", operatorSource=").append(operatorSource);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", operatorTime=").append(operatorTime);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", operatorMethod=").append(operatorMethod);
        sb.append(", operatorTypeName=").append(operatorTypeName);
        sb.append(", operatorArgsType=").append(operatorArgsType);
        sb.append(", operatorOutputData=").append(operatorOutputData);
        sb.append(", operatorExceptionType=").append(operatorExceptionType);
        sb.append(", operatorExceptionMsg=").append(operatorExceptionMsg);
        sb.append(", operatorResult=").append(operatorResult);
        sb.append(", status=").append(status);
        sb.append(", operatorInputData=").append(operatorInputData);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        operatorRemark("operator_remark"),
        operatorSource("operator_source"),
        moduleName("module_name"),
        operatorTime("operator_time"),
        operatorId("operator_id"),
        operatorMethod("operator_method"),
        operatorTypeName("operator_type_name"),
        operatorArgsType("operator_args_type"),
        operatorOutputData("operator_output_data"),
        operatorExceptionType("operator_exception_type"),
        operatorExceptionMsg("operator_exception_msg"),
        operatorResult("operator_result"),
        status("status"),
        createId("create_id"),
        createTime("create_time"),
        updateId("update_id"),
        updateTime("update_time"),
        operatorInputData("operator_input_data");

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
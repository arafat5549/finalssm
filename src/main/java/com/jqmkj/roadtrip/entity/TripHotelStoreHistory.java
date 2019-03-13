package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripHotelStoreHistory extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //法人身份证号码
    private String legalIdcardSn;

    //法人身份证正面
    private String legalIdcardFrontPic;

    //法人身份证反面
    private String legalIdcardBackPic;

    //责任保险单
    private String liabilityPolicyPic;

    //经营许可证
    private String businessCertificatePic;

    //营业执照
    private String businessLicensePic;

    //审核店家ID
    private Long tripHotelStoreId;

    //审核结果：0->审核中；1->审核通过；2->审核失败
    private Integer auditResult;

    //审核人编号
    private String auditOperatorSn;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegalIdcardSn() {
        return legalIdcardSn;
    }

    public void setLegalIdcardSn(String legalIdcardSn) {
        this.legalIdcardSn = legalIdcardSn;
    }

    public String getLegalIdcardFrontPic() {
        return legalIdcardFrontPic;
    }

    public void setLegalIdcardFrontPic(String legalIdcardFrontPic) {
        this.legalIdcardFrontPic = legalIdcardFrontPic;
    }

    public String getLegalIdcardBackPic() {
        return legalIdcardBackPic;
    }

    public void setLegalIdcardBackPic(String legalIdcardBackPic) {
        this.legalIdcardBackPic = legalIdcardBackPic;
    }

    public String getLiabilityPolicyPic() {
        return liabilityPolicyPic;
    }

    public void setLiabilityPolicyPic(String liabilityPolicyPic) {
        this.liabilityPolicyPic = liabilityPolicyPic;
    }

    public String getBusinessCertificatePic() {
        return businessCertificatePic;
    }

    public void setBusinessCertificatePic(String businessCertificatePic) {
        this.businessCertificatePic = businessCertificatePic;
    }

    public String getBusinessLicensePic() {
        return businessLicensePic;
    }

    public void setBusinessLicensePic(String businessLicensePic) {
        this.businessLicensePic = businessLicensePic;
    }

    public Long getTripHotelStoreId() {
        return tripHotelStoreId;
    }

    public void setTripHotelStoreId(Long tripHotelStoreId) {
        this.tripHotelStoreId = tripHotelStoreId;
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    public String getAuditOperatorSn() {
        return auditOperatorSn;
    }

    public void setAuditOperatorSn(String auditOperatorSn) {
        this.auditOperatorSn = auditOperatorSn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", legalIdcardSn=").append(legalIdcardSn);
        sb.append(", legalIdcardFrontPic=").append(legalIdcardFrontPic);
        sb.append(", legalIdcardBackPic=").append(legalIdcardBackPic);
        sb.append(", liabilityPolicyPic=").append(liabilityPolicyPic);
        sb.append(", businessCertificatePic=").append(businessCertificatePic);
        sb.append(", businessLicensePic=").append(businessLicensePic);
        sb.append(", tripHotelStoreId=").append(tripHotelStoreId);
        sb.append(", auditResult=").append(auditResult);
        sb.append(", auditOperatorSn=").append(auditOperatorSn);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        legalIdcardSn("legal_idcard_sn"),
        legalIdcardFrontPic("legal_idcard_front_pic"),
        legalIdcardBackPic("legal_idcard_back_pic"),
        liabilityPolicyPic("liability_policy_pic"),
        businessCertificatePic("business_certificate_pic"),
        businessLicensePic("business_license_pic"),
        tripHotelStoreId("trip_hotel_store_id"),
        auditResult("audit_result"),
        auditOperatorSn("audit_operator_sn"),
        createId("create_id"),
        updateId("update_id"),
        createTime("create_time"),
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
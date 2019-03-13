package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class TripScenicAttr extends BaseEntity implements Serializable {
    //ID
    private Long id;

    //自驾游景区属性分类ID
    private Long tripScenicAttrCategoryId;

    //名称
    private String name;

    //属性选择类型：0->唯一；1->单选；2->多选
    private Integer selectType;

    //属性录入方式：0->手工录入；1->从列表中选取
    private Integer inputType;

    //可选值列表，以逗号隔开
    private String inputList;

    //排序字段：最高的可以单独上传图片
    private Integer sort;

    //分类筛选样式：1->普通；1->颜色
    private Integer filterType;

    //检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
    private Integer searchType;

    //相同属性产品是否关联；0->不关联；1->关联
    private Integer relatedStatus;

    //是否支持手动新增；0->不支持；1->支持
    private Integer handAddStatus;

    //属性的类型；0->规格；1->参数
    private Integer type;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripScenicAttrCategoryId() {
        return tripScenicAttrCategoryId;
    }

    public void setTripScenicAttrCategoryId(Long tripScenicAttrCategoryId) {
        this.tripScenicAttrCategoryId = tripScenicAttrCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tripScenicAttrCategoryId=").append(tripScenicAttrCategoryId);
        sb.append(", name=").append(name);
        sb.append(", selectType=").append(selectType);
        sb.append(", inputType=").append(inputType);
        sb.append(", inputList=").append(inputList);
        sb.append(", sort=").append(sort);
        sb.append(", filterType=").append(filterType);
        sb.append(", searchType=").append(searchType);
        sb.append(", relatedStatus=").append(relatedStatus);
        sb.append(", handAddStatus=").append(handAddStatus);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        tripScenicAttrCategoryId("trip_scenic_attr_category_id"),
        name("name"),
        selectType("select_type"),
        inputType("input_type"),
        inputList("input_list"),
        sort("sort"),
        filterType("filter_type"),
        searchType("search_type"),
        relatedStatus("related_status"),
        handAddStatus("hand_add_status"),
        type("type");

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
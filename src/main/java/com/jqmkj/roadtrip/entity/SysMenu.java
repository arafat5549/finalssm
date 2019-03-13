package com.jqmkj.roadtrip.entity;

import com.jqmkj.roadtrip.base.BaseEntity;
import java.io.Serializable;

public class SysMenu extends BaseEntity implements Serializable {
    //主键ID
    private Long id;

    //父类id
    private Long parentId;

    //父类id集合
    private String parentIds;

    //是否叶子结点
    private Integer isLeaf;

    //树层级
    private Integer level;

    //权限菜单资源名称
    private String name;

    //权限菜单资源URL
    private String url;

    //备注信息
    private String remark;

    //排序号
    private Integer sort;

    //有效状态：0->有效；1->无效
    private Integer status;

    private static final long serialVersionUID = 1L;

    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIds=").append(parentIds);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", level=").append(level);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", remark=").append(remark);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        parentId("parent_id"),
        parentIds("parent_ids"),
        isLeaf("is_leaf"),
        level("level"),
        name("name"),
        url("url"),
        remark("remark"),
        sort("sort"),
        status("status"),
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
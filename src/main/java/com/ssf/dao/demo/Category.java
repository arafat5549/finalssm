package com.ssf.dao.demo;

import com.ssf.common.mybatis.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Category extends BaseEntity implements Serializable {
    /**
     *  分类名称,所属表字段为sys_category.name
     */
    private String name;

    /**
     *  外键 父分类ID,所属表字段为sys_category.parent_id
     */
    private Long parentId;

    /**
     *  记录所有父分类的ID,所属表字段为sys_category.parent_ids
     */
    private String parentIds;

//    /**
//     *  创建时间,所属表字段为sys_category.create_time
//     */
//    private Date createTime;
//
//    /**
//     *  更新时间,所属表字段为sys_category.update_time
//     */
//    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIds=").append(parentIds);
        sb.append("]");
        return sb.toString();
    }
}
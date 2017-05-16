package com.ssf.dao;

import org.apache.ibatis.annotations.Param;

import com.ssf.common.mybatis.base.BaseMapper;
import com.ssf.model.Category;

public interface CategoryDao extends BaseMapper<Category> {
    int deleteByPrimaryKey(Long id);

    Category selectByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    int deleteByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
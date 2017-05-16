package com.ssf.dao.demo;

import com.ssf.common.mybatis.base.BaseMapper;
import com.ssf.dao.demo.Category;
import org.apache.ibatis.annotations.Param;;

public interface CategoryMapper extends BaseMapper<Category> {
    int deleteByPrimaryKey(Long id);

    Category selectByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    int deleteByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
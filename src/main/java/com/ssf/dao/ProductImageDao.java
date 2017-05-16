package com.ssf.dao;

import org.apache.ibatis.annotations.Param;

import com.ssf.common.mybatis.base.BaseMapper;
import com.ssf.model.ProductImage;

public interface ProductImageDao extends BaseMapper<ProductImage> {
    int deleteByPrimaryKey(Long id);

    ProductImage selectByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    int deleteByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    ProductImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}
package com.ssf.dao;

import com.ssf.model.ProductPropertyValue;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPropertyValueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductPropertyValue record);

    int insertSelective(ProductPropertyValue record);

    ProductPropertyValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductPropertyValue record);

    int updateByPrimaryKey(ProductPropertyValue record);

    List<ProductPropertyValue> selectList(String sql);

    Object selectProductPropertyValue(String sql);

    List<ProductPropertyValue> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
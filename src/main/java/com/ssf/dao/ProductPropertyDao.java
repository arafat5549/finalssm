package com.ssf.dao;

import com.ssf.model.ProductProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPropertyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductProperty record);

    int insertSelective(ProductProperty record);

    ProductProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductProperty record);

    int updateByPrimaryKey(ProductProperty record);

    List<ProductProperty> selectList(String sql);

    Object selectProductProperty(String sql);

    List<ProductProperty> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
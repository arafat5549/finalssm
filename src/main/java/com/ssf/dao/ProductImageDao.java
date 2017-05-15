package com.ssf.dao;

import com.ssf.model.ProductImage;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductImageDao extends IBaseDao<ProductImage> {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);

    List<ProductImage> selectList(String sql);

    Object selectProductImage(String sql);

    List<ProductImage> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
package com.ssf.dao;

import com.ssf.model.Product;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDao extends IBaseDao<Product>{
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectList(String sql);

    Object selectProduct(String sql);

    List<Product> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
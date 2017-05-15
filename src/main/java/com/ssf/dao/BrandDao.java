package com.ssf.dao;

import com.ssf.model.Brand;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKeyWithBLOBs(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectList(String sql);

    Object selectBrand(String sql);

    List<Brand> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
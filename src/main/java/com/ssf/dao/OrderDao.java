package com.ssf.dao;

import org.apache.ibatis.annotations.Param;

import com.ssf.common.mybatis.base.BaseMapper;
import com.ssf.model.Order;

public interface OrderDao extends BaseMapper<Order> {
    int deleteByPrimaryKey(Long id);

    Order selectByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    int deleteByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
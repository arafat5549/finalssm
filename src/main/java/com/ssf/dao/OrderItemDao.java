package com.ssf.dao;

import org.apache.ibatis.annotations.Param;

import com.ssf.common.mybatis.base.BaseMapper;
import com.ssf.model.OrderItem;

public interface OrderItemDao extends BaseMapper<OrderItem> {
    int deleteByPrimaryKey(Long id);

    OrderItem selectByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    int deleteByPrimaryKeyAndTableName(@Param("id") String id, @Param("dynamicTableName") String dynamicTableName);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}
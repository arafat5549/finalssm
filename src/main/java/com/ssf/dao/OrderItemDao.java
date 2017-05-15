package com.ssf.dao;

import com.ssf.model.OrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectList(String sql);

    Object selectOrderItem(String sql);

    List<OrderItem> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
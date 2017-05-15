package com.ssf.dao;

import com.ssf.model.Order;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectList(String sql);

    Object selectOrder(String sql);

    List<Order> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
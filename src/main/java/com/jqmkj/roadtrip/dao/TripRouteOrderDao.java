package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteOrder;

public interface TripRouteOrderDao extends BaseMapper<TripRouteOrder> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteOrder record);

    int updateByPrimaryKey(TripRouteOrder record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteOrder> list);

    int batchInsertSelective(java.util.List<TripRouteOrder> list, TripRouteOrder.Column ... selective);
}
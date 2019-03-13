package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteOrderItems;

public interface TripRouteOrderItemsDao extends BaseMapper<TripRouteOrderItems> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteOrderItems selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteOrderItems record);

    int updateByPrimaryKey(TripRouteOrderItems record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteOrderItems> list);

    int batchInsertSelective(java.util.List<TripRouteOrderItems> list, TripRouteOrderItems.Column ... selective);
}
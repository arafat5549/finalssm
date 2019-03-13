package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteStoreHistory;

public interface TripRouteStoreHistoryDao extends BaseMapper<TripRouteStoreHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteStoreHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteStoreHistory record);

    int updateByPrimaryKey(TripRouteStoreHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteStoreHistory> list);

    int batchInsertSelective(java.util.List<TripRouteStoreHistory> list, TripRouteStoreHistory.Column ... selective);
}
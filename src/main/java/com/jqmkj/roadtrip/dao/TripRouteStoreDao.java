package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteStore;

public interface TripRouteStoreDao extends BaseMapper<TripRouteStore> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteStore record);

    int updateByPrimaryKey(TripRouteStore record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteStore> list);

    int batchInsertSelective(java.util.List<TripRouteStore> list, TripRouteStore.Column ... selective);
}
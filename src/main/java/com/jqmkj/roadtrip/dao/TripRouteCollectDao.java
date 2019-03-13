package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteCollect;

public interface TripRouteCollectDao extends BaseMapper<TripRouteCollect> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteCollect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteCollect record);

    int updateByPrimaryKey(TripRouteCollect record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteCollect> list);

    int batchInsertSelective(java.util.List<TripRouteCollect> list, TripRouteCollect.Column ... selective);
}
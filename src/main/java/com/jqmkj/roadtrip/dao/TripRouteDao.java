package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRoute;

public interface TripRouteDao extends BaseMapper<TripRoute> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRoute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRoute record);

    int updateByPrimaryKey(TripRoute record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRoute> list);

    int batchInsertSelective(java.util.List<TripRoute> list, TripRoute.Column ... selective);
}
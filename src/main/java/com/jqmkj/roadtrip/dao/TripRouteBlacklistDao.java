package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteBlacklist;

public interface TripRouteBlacklistDao extends BaseMapper<TripRouteBlacklist> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteBlacklist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteBlacklist record);

    int updateByPrimaryKey(TripRouteBlacklist record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteBlacklist> list);

    int batchInsertSelective(java.util.List<TripRouteBlacklist> list, TripRouteBlacklist.Column ... selective);
}
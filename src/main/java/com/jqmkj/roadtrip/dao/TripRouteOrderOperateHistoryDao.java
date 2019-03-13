package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteOrderOperateHistory;

public interface TripRouteOrderOperateHistoryDao extends BaseMapper<TripRouteOrderOperateHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteOrderOperateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteOrderOperateHistory record);

    int updateByPrimaryKey(TripRouteOrderOperateHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteOrderOperateHistory> list);

    int batchInsertSelective(java.util.List<TripRouteOrderOperateHistory> list, TripRouteOrderOperateHistory.Column ... selective);
}
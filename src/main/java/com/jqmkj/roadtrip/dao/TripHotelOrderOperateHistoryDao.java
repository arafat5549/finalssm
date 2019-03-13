package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelOrderOperateHistory;

public interface TripHotelOrderOperateHistoryDao extends BaseMapper<TripHotelOrderOperateHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelOrderOperateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelOrderOperateHistory record);

    int updateByPrimaryKey(TripHotelOrderOperateHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelOrderOperateHistory> list);

    int batchInsertSelective(java.util.List<TripHotelOrderOperateHistory> list, TripHotelOrderOperateHistory.Column ... selective);
}
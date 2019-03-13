package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicOrderOperateHistory;

public interface TripScenicOrderOperateHistoryDao extends BaseMapper<TripScenicOrderOperateHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicOrderOperateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicOrderOperateHistory record);

    int updateByPrimaryKey(TripScenicOrderOperateHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicOrderOperateHistory> list);

    int batchInsertSelective(java.util.List<TripScenicOrderOperateHistory> list, TripScenicOrderOperateHistory.Column ... selective);
}
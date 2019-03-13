package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicStoreHistory;

public interface TripScenicStoreHistoryDao extends BaseMapper<TripScenicStoreHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicStoreHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicStoreHistory record);

    int updateByPrimaryKey(TripScenicStoreHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicStoreHistory> list);

    int batchInsertSelective(java.util.List<TripScenicStoreHistory> list, TripScenicStoreHistory.Column ... selective);
}
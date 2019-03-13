package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelStoreHistory;

public interface TripHotelStoreHistoryDao extends BaseMapper<TripHotelStoreHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelStoreHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelStoreHistory record);

    int updateByPrimaryKey(TripHotelStoreHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelStoreHistory> list);

    int batchInsertSelective(java.util.List<TripHotelStoreHistory> list, TripHotelStoreHistory.Column ... selective);
}
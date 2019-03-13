package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelBlacklist;

public interface TripHotelBlacklistDao extends BaseMapper<TripHotelBlacklist> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelBlacklist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelBlacklist record);

    int updateByPrimaryKey(TripHotelBlacklist record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelBlacklist> list);

    int batchInsertSelective(java.util.List<TripHotelBlacklist> list, TripHotelBlacklist.Column ... selective);
}
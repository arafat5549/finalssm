package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelCollect;

public interface TripHotelCollectDao extends BaseMapper<TripHotelCollect> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelCollect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelCollect record);

    int updateByPrimaryKey(TripHotelCollect record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelCollect> list);

    int batchInsertSelective(java.util.List<TripHotelCollect> list, TripHotelCollect.Column ... selective);
}
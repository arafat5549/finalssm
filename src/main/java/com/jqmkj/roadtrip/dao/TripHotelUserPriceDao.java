package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelUserPrice;

public interface TripHotelUserPriceDao extends BaseMapper<TripHotelUserPrice> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelUserPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelUserPrice record);

    int updateByPrimaryKey(TripHotelUserPrice record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelUserPrice> list);

    int batchInsertSelective(java.util.List<TripHotelUserPrice> list, TripHotelUserPrice.Column ... selective);
}
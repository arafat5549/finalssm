package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelOrder;

public interface TripHotelOrderDao extends BaseMapper<TripHotelOrder> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelOrder record);

    int updateByPrimaryKey(TripHotelOrder record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelOrder> list);

    int batchInsertSelective(java.util.List<TripHotelOrder> list, TripHotelOrder.Column ... selective);
}
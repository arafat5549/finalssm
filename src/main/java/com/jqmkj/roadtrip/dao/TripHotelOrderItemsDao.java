package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelOrderItems;

public interface TripHotelOrderItemsDao extends BaseMapper<TripHotelOrderItems> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelOrderItems selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelOrderItems record);

    int updateByPrimaryKey(TripHotelOrderItems record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelOrderItems> list);

    int batchInsertSelective(java.util.List<TripHotelOrderItems> list, TripHotelOrderItems.Column ... selective);
}
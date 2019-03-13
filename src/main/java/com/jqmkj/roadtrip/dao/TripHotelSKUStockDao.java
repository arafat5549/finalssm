package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelSKUStock;

public interface TripHotelSKUStockDao extends BaseMapper<TripHotelSKUStock> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelSKUStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelSKUStock record);

    int updateByPrimaryKey(TripHotelSKUStock record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelSKUStock> list);

    int batchInsertSelective(java.util.List<TripHotelSKUStock> list, TripHotelSKUStock.Column ... selective);
}
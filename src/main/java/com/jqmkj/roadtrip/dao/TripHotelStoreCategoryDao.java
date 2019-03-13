package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelStoreCategory;

public interface TripHotelStoreCategoryDao extends BaseMapper<TripHotelStoreCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelStoreCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelStoreCategory record);

    int updateByPrimaryKey(TripHotelStoreCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelStoreCategory> list);

    int batchInsertSelective(java.util.List<TripHotelStoreCategory> list, TripHotelStoreCategory.Column ... selective);
}
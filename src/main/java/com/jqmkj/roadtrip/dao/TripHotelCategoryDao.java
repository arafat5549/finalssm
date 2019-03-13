package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelCategory;

public interface TripHotelCategoryDao extends BaseMapper<TripHotelCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelCategory record);

    int updateByPrimaryKey(TripHotelCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelCategory> list);

    int batchInsertSelective(java.util.List<TripHotelCategory> list, TripHotelCategory.Column ... selective);
}
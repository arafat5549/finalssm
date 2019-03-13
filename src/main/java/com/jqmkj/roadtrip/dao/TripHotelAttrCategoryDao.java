package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelAttrCategory;

public interface TripHotelAttrCategoryDao extends BaseMapper<TripHotelAttrCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelAttrCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelAttrCategory record);

    int updateByPrimaryKey(TripHotelAttrCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelAttrCategory> list);

    int batchInsertSelective(java.util.List<TripHotelAttrCategory> list, TripHotelAttrCategory.Column ... selective);
}
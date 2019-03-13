package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelAttrValue;

public interface TripHotelAttrValueDao extends BaseMapper<TripHotelAttrValue> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelAttrValue record);

    int updateByPrimaryKey(TripHotelAttrValue record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelAttrValue> list);

    int batchInsertSelective(java.util.List<TripHotelAttrValue> list, TripHotelAttrValue.Column ... selective);
}
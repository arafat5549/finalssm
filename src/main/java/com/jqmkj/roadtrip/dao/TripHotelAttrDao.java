package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelAttr;

public interface TripHotelAttrDao extends BaseMapper<TripHotelAttr> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelAttr record);

    int updateByPrimaryKey(TripHotelAttr record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelAttr> list);

    int batchInsertSelective(java.util.List<TripHotelAttr> list, TripHotelAttr.Column ... selective);
}
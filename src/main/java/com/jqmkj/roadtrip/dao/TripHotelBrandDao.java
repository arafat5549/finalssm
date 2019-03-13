package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelBrand;

public interface TripHotelBrandDao extends BaseMapper<TripHotelBrand> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelBrand record);

    int updateByPrimaryKeyWithBLOBs(TripHotelBrand record);

    int updateByPrimaryKey(TripHotelBrand record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelBrand> list);

    int batchInsertSelective(java.util.List<TripHotelBrand> list, TripHotelBrand.Column ... selective);
}
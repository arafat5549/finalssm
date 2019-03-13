package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelDetail;

public interface TripHotelDetailDao extends BaseMapper<TripHotelDetail> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelDetail record);

    int updateByPrimaryKey(TripHotelDetail record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelDetail> list);

    int batchInsertSelective(java.util.List<TripHotelDetail> list, TripHotelDetail.Column ... selective);
}
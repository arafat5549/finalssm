package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelStoreDetail;

public interface TripHotelStoreDetailDao extends BaseMapper<TripHotelStoreDetail> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelStoreDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelStoreDetail record);

    int updateByPrimaryKey(TripHotelStoreDetail record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelStoreDetail> list);

    int batchInsertSelective(java.util.List<TripHotelStoreDetail> list, TripHotelStoreDetail.Column ... selective);
}
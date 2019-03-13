package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelBill;

public interface TripHotelBillDao extends BaseMapper<TripHotelBill> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelBill record);

    int updateByPrimaryKey(TripHotelBill record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelBill> list);

    int batchInsertSelective(java.util.List<TripHotelBill> list, TripHotelBill.Column ... selective);
}
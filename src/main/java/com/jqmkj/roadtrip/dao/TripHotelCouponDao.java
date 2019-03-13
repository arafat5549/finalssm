package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelCoupon;

public interface TripHotelCouponDao extends BaseMapper<TripHotelCoupon> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelCoupon record);

    int updateByPrimaryKey(TripHotelCoupon record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelCoupon> list);

    int batchInsertSelective(java.util.List<TripHotelCoupon> list, TripHotelCoupon.Column ... selective);
}
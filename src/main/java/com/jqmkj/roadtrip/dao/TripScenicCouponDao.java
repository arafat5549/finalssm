package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicCoupon;

public interface TripScenicCouponDao extends BaseMapper<TripScenicCoupon> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicCoupon record);

    int updateByPrimaryKey(TripScenicCoupon record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicCoupon> list);

    int batchInsertSelective(java.util.List<TripScenicCoupon> list, TripScenicCoupon.Column ... selective);
}
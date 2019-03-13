package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteCoupon;

public interface TripRouteCouponDao extends BaseMapper<TripRouteCoupon> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteCoupon record);

    int updateByPrimaryKey(TripRouteCoupon record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteCoupon> list);

    int batchInsertSelective(java.util.List<TripRouteCoupon> list, TripRouteCoupon.Column ... selective);
}
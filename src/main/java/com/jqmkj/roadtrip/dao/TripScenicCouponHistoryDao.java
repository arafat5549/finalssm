package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicCouponHistory;

public interface TripScenicCouponHistoryDao extends BaseMapper<TripScenicCouponHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicCouponHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicCouponHistory record);

    int updateByPrimaryKey(TripScenicCouponHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicCouponHistory> list);

    int batchInsertSelective(java.util.List<TripScenicCouponHistory> list, TripScenicCouponHistory.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteCouponHistory;

public interface TripRouteCouponHistoryDao extends BaseMapper<TripRouteCouponHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteCouponHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteCouponHistory record);

    int updateByPrimaryKey(TripRouteCouponHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteCouponHistory> list);

    int batchInsertSelective(java.util.List<TripRouteCouponHistory> list, TripRouteCouponHistory.Column ... selective);
}
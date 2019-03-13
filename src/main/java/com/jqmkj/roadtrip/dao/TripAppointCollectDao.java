package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripAppointCollect;

public interface TripAppointCollectDao extends BaseMapper<TripAppointCollect> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripAppointCollect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripAppointCollect record);

    int updateByPrimaryKey(TripAppointCollect record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripAppointCollect> list);

    int batchInsertSelective(java.util.List<TripAppointCollect> list, TripAppointCollect.Column ... selective);
}
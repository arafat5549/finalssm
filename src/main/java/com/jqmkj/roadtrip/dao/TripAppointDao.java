package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripAppoint;

public interface TripAppointDao extends BaseMapper<TripAppoint> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripAppoint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripAppoint record);

    int updateByPrimaryKey(TripAppoint record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripAppoint> list);

    int batchInsertSelective(java.util.List<TripAppoint> list, TripAppoint.Column ... selective);
}
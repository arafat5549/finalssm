package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripGps;

public interface TripGpsDao extends BaseMapper<TripGps> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripGps selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripGps record);

    int updateByPrimaryKey(TripGps record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripGps> list);

    int batchInsertSelective(java.util.List<TripGps> list, TripGps.Column ... selective);
}
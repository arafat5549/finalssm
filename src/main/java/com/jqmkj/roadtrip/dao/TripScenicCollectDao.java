package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicCollect;

public interface TripScenicCollectDao extends BaseMapper<TripScenicCollect> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicCollect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicCollect record);

    int updateByPrimaryKey(TripScenicCollect record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicCollect> list);

    int batchInsertSelective(java.util.List<TripScenicCollect> list, TripScenicCollect.Column ... selective);
}
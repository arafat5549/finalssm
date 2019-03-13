package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicStore;

public interface TripScenicStoreDao extends BaseMapper<TripScenicStore> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicStore record);

    int updateByPrimaryKey(TripScenicStore record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicStore> list);

    int batchInsertSelective(java.util.List<TripScenicStore> list, TripScenicStore.Column ... selective);
}
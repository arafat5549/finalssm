package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicStoreCategory;

public interface TripScenicStoreCategoryDao extends BaseMapper<TripScenicStoreCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicStoreCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicStoreCategory record);

    int updateByPrimaryKey(TripScenicStoreCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicStoreCategory> list);

    int batchInsertSelective(java.util.List<TripScenicStoreCategory> list, TripScenicStoreCategory.Column ... selective);
}
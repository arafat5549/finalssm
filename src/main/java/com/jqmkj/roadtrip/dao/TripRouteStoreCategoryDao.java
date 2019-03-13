package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteStoreCategory;

public interface TripRouteStoreCategoryDao extends BaseMapper<TripRouteStoreCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteStoreCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteStoreCategory record);

    int updateByPrimaryKey(TripRouteStoreCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteStoreCategory> list);

    int batchInsertSelective(java.util.List<TripRouteStoreCategory> list, TripRouteStoreCategory.Column ... selective);
}
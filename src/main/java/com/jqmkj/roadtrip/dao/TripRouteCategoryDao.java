package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteCategory;

public interface TripRouteCategoryDao extends BaseMapper<TripRouteCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteCategory record);

    int updateByPrimaryKey(TripRouteCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteCategory> list);

    int batchInsertSelective(java.util.List<TripRouteCategory> list, TripRouteCategory.Column ... selective);
}
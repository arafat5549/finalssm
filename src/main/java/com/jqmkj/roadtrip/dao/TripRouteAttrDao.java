package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteAttr;

public interface TripRouteAttrDao extends BaseMapper<TripRouteAttr> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteAttr record);

    int updateByPrimaryKey(TripRouteAttr record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteAttr> list);

    int batchInsertSelective(java.util.List<TripRouteAttr> list, TripRouteAttr.Column ... selective);
}
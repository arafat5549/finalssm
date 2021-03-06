package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteDetail;

public interface TripRouteDetailDao extends BaseMapper<TripRouteDetail> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteDetail record);

    int updateByPrimaryKey(TripRouteDetail record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteDetail> list);

    int batchInsertSelective(java.util.List<TripRouteDetail> list, TripRouteDetail.Column ... selective);
}
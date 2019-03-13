package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteStoreDetail;

public interface TripRouteStoreDetailDao extends BaseMapper<TripRouteStoreDetail> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteStoreDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteStoreDetail record);

    int updateByPrimaryKey(TripRouteStoreDetail record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteStoreDetail> list);

    int batchInsertSelective(java.util.List<TripRouteStoreDetail> list, TripRouteStoreDetail.Column ... selective);
}
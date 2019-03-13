package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteStoreReview;

public interface TripRouteStoreReviewDao extends BaseMapper<TripRouteStoreReview> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteStoreReview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteStoreReview record);

    int updateByPrimaryKey(TripRouteStoreReview record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteStoreReview> list);

    int batchInsertSelective(java.util.List<TripRouteStoreReview> list, TripRouteStoreReview.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteReview;

public interface TripRouteReviewDao extends BaseMapper<TripRouteReview> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteReview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteReview record);

    int updateByPrimaryKey(TripRouteReview record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteReview> list);

    int batchInsertSelective(java.util.List<TripRouteReview> list, TripRouteReview.Column ... selective);
}
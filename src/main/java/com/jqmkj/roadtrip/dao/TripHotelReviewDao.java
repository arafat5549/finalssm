package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelReview;

public interface TripHotelReviewDao extends BaseMapper<TripHotelReview> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelReview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelReview record);

    int updateByPrimaryKey(TripHotelReview record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelReview> list);

    int batchInsertSelective(java.util.List<TripHotelReview> list, TripHotelReview.Column ... selective);
}
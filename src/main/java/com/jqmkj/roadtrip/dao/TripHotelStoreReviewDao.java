package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelStoreReview;

public interface TripHotelStoreReviewDao extends BaseMapper<TripHotelStoreReview> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelStoreReview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelStoreReview record);

    int updateByPrimaryKey(TripHotelStoreReview record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelStoreReview> list);

    int batchInsertSelective(java.util.List<TripHotelStoreReview> list, TripHotelStoreReview.Column ... selective);
}
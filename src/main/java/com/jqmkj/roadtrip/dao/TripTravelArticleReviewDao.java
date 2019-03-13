package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripTravelArticleReview;

public interface TripTravelArticleReviewDao extends BaseMapper<TripTravelArticleReview> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripTravelArticleReview selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripTravelArticleReview record);

    int updateByPrimaryKey(TripTravelArticleReview record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripTravelArticleReview> list);

    int batchInsertSelective(java.util.List<TripTravelArticleReview> list, TripTravelArticleReview.Column ... selective);
}
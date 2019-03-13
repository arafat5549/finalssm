package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripTravelArticleContent;

public interface TripTravelArticleContentDao extends BaseMapper<TripTravelArticleContent> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripTravelArticleContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripTravelArticleContent record);

    int updateByPrimaryKey(TripTravelArticleContent record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripTravelArticleContent> list);

    int batchInsertSelective(java.util.List<TripTravelArticleContent> list, TripTravelArticleContent.Column ... selective);
}
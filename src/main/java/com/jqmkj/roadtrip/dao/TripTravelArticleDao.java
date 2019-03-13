package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripTravelArticle;

public interface TripTravelArticleDao extends BaseMapper<TripTravelArticle> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripTravelArticle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripTravelArticle record);

    int updateByPrimaryKeyWithBLOBs(TripTravelArticle record);

    int updateByPrimaryKey(TripTravelArticle record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripTravelArticle> list);

    int batchInsertSelective(java.util.List<TripTravelArticle> list, TripTravelArticle.Column ... selective);
}
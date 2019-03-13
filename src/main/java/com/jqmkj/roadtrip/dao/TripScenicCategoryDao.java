package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicCategory;

public interface TripScenicCategoryDao extends BaseMapper<TripScenicCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicCategory record);

    int updateByPrimaryKey(TripScenicCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicCategory> list);

    int batchInsertSelective(java.util.List<TripScenicCategory> list, TripScenicCategory.Column ... selective);
}
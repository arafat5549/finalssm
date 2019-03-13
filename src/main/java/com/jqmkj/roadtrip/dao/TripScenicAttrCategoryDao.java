package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicAttrCategory;

public interface TripScenicAttrCategoryDao extends BaseMapper<TripScenicAttrCategory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicAttrCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicAttrCategory record);

    int updateByPrimaryKey(TripScenicAttrCategory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicAttrCategory> list);

    int batchInsertSelective(java.util.List<TripScenicAttrCategory> list, TripScenicAttrCategory.Column ... selective);
}
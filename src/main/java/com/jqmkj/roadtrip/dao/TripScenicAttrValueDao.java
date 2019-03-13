package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicAttrValue;

public interface TripScenicAttrValueDao extends BaseMapper<TripScenicAttrValue> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicAttrValue record);

    int updateByPrimaryKey(TripScenicAttrValue record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicAttrValue> list);

    int batchInsertSelective(java.util.List<TripScenicAttrValue> list, TripScenicAttrValue.Column ... selective);
}
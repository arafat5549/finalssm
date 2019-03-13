package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicAttr;

public interface TripScenicAttrDao extends BaseMapper<TripScenicAttr> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicAttr record);

    int updateByPrimaryKey(TripScenicAttr record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicAttr> list);

    int batchInsertSelective(java.util.List<TripScenicAttr> list, TripScenicAttr.Column ... selective);
}
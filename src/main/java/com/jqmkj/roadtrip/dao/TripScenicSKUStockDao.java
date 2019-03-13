package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicSKUStock;

public interface TripScenicSKUStockDao extends BaseMapper<TripScenicSKUStock> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicSKUStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicSKUStock record);

    int updateByPrimaryKey(TripScenicSKUStock record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicSKUStock> list);

    int batchInsertSelective(java.util.List<TripScenicSKUStock> list, TripScenicSKUStock.Column ... selective);
}
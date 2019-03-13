package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicUserPrice;

public interface TripScenicUserPriceDao extends BaseMapper<TripScenicUserPrice> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicUserPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicUserPrice record);

    int updateByPrimaryKey(TripScenicUserPrice record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicUserPrice> list);

    int batchInsertSelective(java.util.List<TripScenicUserPrice> list, TripScenicUserPrice.Column ... selective);
}
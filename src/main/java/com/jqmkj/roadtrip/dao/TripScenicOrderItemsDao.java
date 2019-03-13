package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicOrderItems;

public interface TripScenicOrderItemsDao extends BaseMapper<TripScenicOrderItems> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicOrderItems selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicOrderItems record);

    int updateByPrimaryKey(TripScenicOrderItems record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicOrderItems> list);

    int batchInsertSelective(java.util.List<TripScenicOrderItems> list, TripScenicOrderItems.Column ... selective);
}
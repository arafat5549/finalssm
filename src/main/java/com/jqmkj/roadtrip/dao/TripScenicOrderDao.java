package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicOrder;

public interface TripScenicOrderDao extends BaseMapper<TripScenicOrder> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicOrder record);

    int updateByPrimaryKey(TripScenicOrder record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicOrder> list);

    int batchInsertSelective(java.util.List<TripScenicOrder> list, TripScenicOrder.Column ... selective);
}
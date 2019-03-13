package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicBill;

public interface TripScenicBillDao extends BaseMapper<TripScenicBill> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicBill record);

    int updateByPrimaryKey(TripScenicBill record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicBill> list);

    int batchInsertSelective(java.util.List<TripScenicBill> list, TripScenicBill.Column ... selective);
}
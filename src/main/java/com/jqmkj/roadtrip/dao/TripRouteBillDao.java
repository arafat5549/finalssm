package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteBill;

public interface TripRouteBillDao extends BaseMapper<TripRouteBill> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteBill record);

    int updateByPrimaryKey(TripRouteBill record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteBill> list);

    int batchInsertSelective(java.util.List<TripRouteBill> list, TripRouteBill.Column ... selective);
}
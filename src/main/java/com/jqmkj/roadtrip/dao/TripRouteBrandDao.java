package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteBrand;

public interface TripRouteBrandDao extends BaseMapper<TripRouteBrand> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteBrand record);

    int updateByPrimaryKeyWithBLOBs(TripRouteBrand record);

    int updateByPrimaryKey(TripRouteBrand record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteBrand> list);

    int batchInsertSelective(java.util.List<TripRouteBrand> list, TripRouteBrand.Column ... selective);
}
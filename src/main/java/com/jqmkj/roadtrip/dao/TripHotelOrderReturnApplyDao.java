package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripHotelOrderReturnApply;

public interface TripHotelOrderReturnApplyDao extends BaseMapper<TripHotelOrderReturnApply> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripHotelOrderReturnApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripHotelOrderReturnApply record);

    int updateByPrimaryKey(TripHotelOrderReturnApply record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripHotelOrderReturnApply> list);

    int batchInsertSelective(java.util.List<TripHotelOrderReturnApply> list, TripHotelOrderReturnApply.Column ... selective);
}
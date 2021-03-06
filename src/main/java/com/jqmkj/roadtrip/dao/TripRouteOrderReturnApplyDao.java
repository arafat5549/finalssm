package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteOrderReturnApply;

public interface TripRouteOrderReturnApplyDao extends BaseMapper<TripRouteOrderReturnApply> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteOrderReturnApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteOrderReturnApply record);

    int updateByPrimaryKey(TripRouteOrderReturnApply record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteOrderReturnApply> list);

    int batchInsertSelective(java.util.List<TripRouteOrderReturnApply> list, TripRouteOrderReturnApply.Column ... selective);
}
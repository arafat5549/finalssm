package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteLine;

public interface TripRouteLineDao extends BaseMapper<TripRouteLine> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteLine selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteLine record);

    int updateByPrimaryKey(TripRouteLine record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteLine> list);

    int batchInsertSelective(java.util.List<TripRouteLine> list, TripRouteLine.Column ... selective);
}
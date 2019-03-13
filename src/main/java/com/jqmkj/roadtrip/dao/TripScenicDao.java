package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenic;

public interface TripScenicDao extends BaseMapper<TripScenic> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenic record);

    int updateByPrimaryKey(TripScenic record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenic> list);

    int batchInsertSelective(java.util.List<TripScenic> list, TripScenic.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicBlacklist;

public interface TripScenicBlacklistDao extends BaseMapper<TripScenicBlacklist> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicBlacklist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicBlacklist record);

    int updateByPrimaryKey(TripScenicBlacklist record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicBlacklist> list);

    int batchInsertSelective(java.util.List<TripScenicBlacklist> list, TripScenicBlacklist.Column ... selective);
}
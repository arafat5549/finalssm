package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicDetail;

public interface TripScenicDetailDao extends BaseMapper<TripScenicDetail> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicDetail record);

    int updateByPrimaryKey(TripScenicDetail record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicDetail> list);

    int batchInsertSelective(java.util.List<TripScenicDetail> list, TripScenicDetail.Column ... selective);
}
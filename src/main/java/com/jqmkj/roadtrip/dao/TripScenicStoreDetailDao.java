package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicStoreDetail;

public interface TripScenicStoreDetailDao extends BaseMapper<TripScenicStoreDetail> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicStoreDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicStoreDetail record);

    int updateByPrimaryKey(TripScenicStoreDetail record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicStoreDetail> list);

    int batchInsertSelective(java.util.List<TripScenicStoreDetail> list, TripScenicStoreDetail.Column ... selective);
}
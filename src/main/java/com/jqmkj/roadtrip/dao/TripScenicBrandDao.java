package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicBrand;

public interface TripScenicBrandDao extends BaseMapper<TripScenicBrand> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicBrand record);

    int updateByPrimaryKeyWithBLOBs(TripScenicBrand record);

    int updateByPrimaryKey(TripScenicBrand record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicBrand> list);

    int batchInsertSelective(java.util.List<TripScenicBrand> list, TripScenicBrand.Column ... selective);
}
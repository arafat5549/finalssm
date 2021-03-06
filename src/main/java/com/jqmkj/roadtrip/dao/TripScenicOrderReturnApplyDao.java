package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicOrderReturnApply;

public interface TripScenicOrderReturnApplyDao extends BaseMapper<TripScenicOrderReturnApply> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicOrderReturnApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicOrderReturnApply record);

    int updateByPrimaryKey(TripScenicOrderReturnApply record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicOrderReturnApply> list);

    int batchInsertSelective(java.util.List<TripScenicOrderReturnApply> list, TripScenicOrderReturnApply.Column ... selective);
}
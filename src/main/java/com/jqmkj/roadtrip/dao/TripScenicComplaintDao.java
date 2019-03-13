package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripScenicComplaint;

public interface TripScenicComplaintDao extends BaseMapper<TripScenicComplaint> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripScenicComplaint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripScenicComplaint record);

    int updateByPrimaryKey(TripScenicComplaint record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripScenicComplaint> list);

    int batchInsertSelective(java.util.List<TripScenicComplaint> list, TripScenicComplaint.Column ... selective);
}
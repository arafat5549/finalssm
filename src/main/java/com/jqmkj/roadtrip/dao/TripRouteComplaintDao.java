package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.TripRouteComplaint;

public interface TripRouteComplaintDao extends BaseMapper<TripRouteComplaint> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    TripRouteComplaint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TripRouteComplaint record);

    int updateByPrimaryKey(TripRouteComplaint record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<TripRouteComplaint> list);

    int batchInsertSelective(java.util.List<TripRouteComplaint> list, TripRouteComplaint.Column ... selective);
}
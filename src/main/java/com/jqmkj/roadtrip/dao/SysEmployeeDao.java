package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysEmployee;

public interface SysEmployeeDao extends BaseMapper<SysEmployee> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysEmployee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysEmployee record);

    int updateByPrimaryKey(SysEmployee record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysEmployee> list);

    int batchInsertSelective(java.util.List<SysEmployee> list, SysEmployee.Column ... selective);
}
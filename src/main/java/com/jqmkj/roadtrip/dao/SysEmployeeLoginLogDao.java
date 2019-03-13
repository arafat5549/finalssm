package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysEmployeeLoginLog;

public interface SysEmployeeLoginLogDao extends BaseMapper<SysEmployeeLoginLog> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysEmployeeLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysEmployeeLoginLog record);

    int updateByPrimaryKey(SysEmployeeLoginLog record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysEmployeeLoginLog> list);

    int batchInsertSelective(java.util.List<SysEmployeeLoginLog> list, SysEmployeeLoginLog.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysEmployeeOperatorLog;

public interface SysEmployeeOperatorLogDao extends BaseMapper<SysEmployeeOperatorLog> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysEmployeeOperatorLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysEmployeeOperatorLog record);

    int updateByPrimaryKeyWithBLOBs(SysEmployeeOperatorLog record);

    int updateByPrimaryKey(SysEmployeeOperatorLog record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysEmployeeOperatorLog> list);

    int batchInsertSelective(java.util.List<SysEmployeeOperatorLog> list, SysEmployeeOperatorLog.Column ... selective);
}
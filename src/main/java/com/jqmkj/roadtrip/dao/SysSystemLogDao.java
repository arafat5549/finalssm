package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysSystemLog;

public interface SysSystemLogDao extends BaseMapper<SysSystemLog> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysSystemLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysSystemLog record);

    int updateByPrimaryKeyWithBLOBs(SysSystemLog record);

    int updateByPrimaryKey(SysSystemLog record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysSystemLog> list);

    int batchInsertSelective(java.util.List<SysSystemLog> list, SysSystemLog.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysUserLoginLog;

public interface SysUserLoginLogDao extends BaseMapper<SysUserLoginLog> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysUserLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserLoginLog record);

    int updateByPrimaryKey(SysUserLoginLog record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysUserLoginLog> list);

    int batchInsertSelective(java.util.List<SysUserLoginLog> list, SysUserLoginLog.Column ... selective);
}
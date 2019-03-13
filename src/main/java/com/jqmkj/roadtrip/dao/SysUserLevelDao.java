package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysUserLevel;

public interface SysUserLevelDao extends BaseMapper<SysUserLevel> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysUserLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserLevel record);

    int updateByPrimaryKey(SysUserLevel record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysUserLevel> list);

    int batchInsertSelective(java.util.List<SysUserLevel> list, SysUserLevel.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysUserRuleSetting;

public interface SysUserRuleSettingDao extends BaseMapper<SysUserRuleSetting> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysUserRuleSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRuleSetting record);

    int updateByPrimaryKey(SysUserRuleSetting record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysUserRuleSetting> list);

    int batchInsertSelective(java.util.List<SysUserRuleSetting> list, SysUserRuleSetting.Column ... selective);
}
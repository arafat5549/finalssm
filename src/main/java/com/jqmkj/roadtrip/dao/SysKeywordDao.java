package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysKeyword;

public interface SysKeywordDao extends BaseMapper<SysKeyword> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysKeyword selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysKeyword record);

    int updateByPrimaryKey(SysKeyword record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysKeyword> list);

    int batchInsertSelective(java.util.List<SysKeyword> list, SysKeyword.Column ... selective);
}
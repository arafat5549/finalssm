package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysSms;

public interface SysSmsDao extends BaseMapper<SysSms> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysSms selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysSms record);

    int updateByPrimaryKey(SysSms record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysSms> list);

    int batchInsertSelective(java.util.List<SysSms> list, SysSms.Column ... selective);
}
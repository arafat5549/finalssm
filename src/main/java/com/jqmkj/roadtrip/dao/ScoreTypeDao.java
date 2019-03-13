package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.ScoreType;

public interface ScoreTypeDao extends BaseMapper<ScoreType> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    ScoreType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScoreType record);

    int updateByPrimaryKey(ScoreType record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<ScoreType> list);

    int batchInsertSelective(java.util.List<ScoreType> list, ScoreType.Column ... selective);
}
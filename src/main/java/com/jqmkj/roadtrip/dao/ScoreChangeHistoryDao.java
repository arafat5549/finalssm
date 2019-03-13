package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.ScoreChangeHistory;

public interface ScoreChangeHistoryDao extends BaseMapper<ScoreChangeHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    ScoreChangeHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScoreChangeHistory record);

    int updateByPrimaryKey(ScoreChangeHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<ScoreChangeHistory> list);

    int batchInsertSelective(java.util.List<ScoreChangeHistory> list, ScoreChangeHistory.Column ... selective);
}
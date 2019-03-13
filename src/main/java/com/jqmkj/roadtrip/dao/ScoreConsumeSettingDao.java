package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.ScoreConsumeSetting;

public interface ScoreConsumeSettingDao extends BaseMapper<ScoreConsumeSetting> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    ScoreConsumeSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScoreConsumeSetting record);

    int updateByPrimaryKey(ScoreConsumeSetting record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<ScoreConsumeSetting> list);

    int batchInsertSelective(java.util.List<ScoreConsumeSetting> list, ScoreConsumeSetting.Column ... selective);
}
package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysNoticeHistory;

public interface SysNoticeHistoryDao extends BaseMapper<SysNoticeHistory> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysNoticeHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysNoticeHistory record);

    int updateByPrimaryKey(SysNoticeHistory record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysNoticeHistory> list);

    int batchInsertSelective(java.util.List<SysNoticeHistory> list, SysNoticeHistory.Column ... selective);
}
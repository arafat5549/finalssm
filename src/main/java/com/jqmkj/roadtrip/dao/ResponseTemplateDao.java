package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.ResponseTemplate;

public interface ResponseTemplateDao extends BaseMapper<ResponseTemplate> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    ResponseTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResponseTemplate record);

    int updateByPrimaryKey(ResponseTemplate record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<ResponseTemplate> list);

    int batchInsertSelective(java.util.List<ResponseTemplate> list, ResponseTemplate.Column ... selective);
}
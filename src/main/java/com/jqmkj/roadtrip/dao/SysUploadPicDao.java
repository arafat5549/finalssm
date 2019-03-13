package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysUploadPic;

public interface SysUploadPicDao extends BaseMapper<SysUploadPic> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysUploadPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUploadPic record);

    int updateByPrimaryKey(SysUploadPic record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysUploadPic> list);

    int batchInsertSelective(java.util.List<SysUploadPic> list, SysUploadPic.Column ... selective);
}
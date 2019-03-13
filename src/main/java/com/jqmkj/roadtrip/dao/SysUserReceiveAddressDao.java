package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.SysUserReceiveAddress;

public interface SysUserReceiveAddressDao extends BaseMapper<SysUserReceiveAddress> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    SysUserReceiveAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserReceiveAddress record);

    int updateByPrimaryKey(SysUserReceiveAddress record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<SysUserReceiveAddress> list);

    int batchInsertSelective(java.util.List<SysUserReceiveAddress> list, SysUserReceiveAddress.Column ... selective);
}
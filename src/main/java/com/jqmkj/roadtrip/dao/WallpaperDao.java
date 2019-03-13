package com.jqmkj.roadtrip.dao;

import com.jqmkj.roadtrip.base.BaseMapper;
import com.jqmkj.roadtrip.entity.Wallpaper;

public interface WallpaperDao extends BaseMapper<Wallpaper> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Long id);

    Wallpaper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Wallpaper record);

    int updateByPrimaryKey(Wallpaper record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<Wallpaper> list);

    int batchInsertSelective(java.util.List<Wallpaper> list, Wallpaper.Column ... selective);
}
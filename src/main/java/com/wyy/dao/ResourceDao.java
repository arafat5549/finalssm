package com.wyy.dao;

import com.wyy.base.BaseMapper;
import com.wyy.entity.Resource;

public interface ResourceDao extends BaseMapper<Resource> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
        
    	/**
    	 * 获取所有resource
    	 * @return
    	 */
    	List<Resource> getResourceList();
    	
    	/**
    	 * 根据所属模块获取资源
    	 * @return
    	 */
    	List<Resource> getResourceListByModuleFlag(@Param("moduleFlags") List<String> moduleFlags, @Param("userId") Integer userId);
    	
    	/**
    	 * 根据资源id判断是否被角色使用
    	 * @param resourceId
    	 * @return
    	 */
    	Boolean isUsedByRole(@Param("resourceId") Integer resourceId);
    	
    	/**
    	 * 给定角色具有权限的资源列表
    	 * @param roleId
    	 * @return
    	 */
    	List<Resource> getResourceListByRoleId(Integer roleId);
    	
    	/**
    	 * 根据parentId获取资源
    	 * @param parentId
    	 * @return
    	 */
    	List<Resource> getResourceListByParentId(@Param("parentId") Integer parentId);
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Integer id);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<Resource> list);

    int batchInsertSelective(java.util.List<Resource> list, Resource.Column ... selective);
}
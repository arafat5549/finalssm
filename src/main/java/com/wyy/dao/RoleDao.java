package com.wyy.dao;

import com.wyy.base.BaseMapper;
import com.wyy.entity.Role;

public interface RoleDao extends BaseMapper<Role> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
        
    	/**
    	 * 根据id删除角色
    	 * @param id
    	 * @return
    	 */
    	Integer deleteRoleById(Integer id);
    	
    	/**
    	 * 根据id删除角色模块关联关系
    	 * @param roleId
    	 * @return
    	 */
    	Integer deleteRoleModuleById(Integer roleId);
    	
    	/**
    	 * 根据id删除角色资源关联关系
    	 * @param roleId
    	 * @return
    	 */
    	Integer deleteRoleResourceById(Integer roleId);
        
    	/**
    	 * 根据条件查询角色列表总数
    	 * @param searchModel
    	 * @return
    	 */
    	Integer getRoleTotalBySearch(RoleSearchModel searchModel);
    	
    	/**
    	 * 根据条件查询用户List
    	 * @param searchModel
    	 * @return
    	 */
    	List<Role> getRoleListBySearch(RoleSearchModel searchModel, RowBounds rowBounds);
    	
    	/**
    	 * 角色是否被用户使用
    	 * @param roleId
    	 * @return
    	 */
    	Boolean isUsedByUser(Integer roleId);
    	
    	/**
    	 * 分配角色关联模块
    	 * @param moduleIds
    	 * @param roleId
    	 */
    	void assignModules(@Param("moduleIds") List<Integer> moduleIds, @Param("roleId") Integer roleId);
    
    	/**
    	 * 分配角色关联资源
    	 * @param resourceIds
    	 * @param roleId
    	 */
    	void assignResources(@Param("resourceIds") List<Integer> resourceIds, @Param("roleId") Integer roleId);
    	
    	/**
    	 * 根据userId获取关联的权限列表
    	 * @param userId
    	 * @return
    	 */
    	List<Role> getRoleListByUserId(@Param("userId") Integer userId);
    	
    	/**
    	 * 所有角色列表
    	 * @return
    	 */
    	List<Role> getRoleList();
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Integer id);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<Role> list);

    int batchInsertSelective(java.util.List<Role> list, Role.Column ... selective);
}
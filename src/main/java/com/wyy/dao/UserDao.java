package com.wyy.dao;

import com.wyy.base.BaseMapper;
import com.wyy.entity.User;

public interface UserDao extends BaseMapper<User> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
        
    	/**
    	 * 根据用户名查询用户
    	 * @param username
    	 * @return
    	 */
    	User getUserByUsername(@Param("username") String username);
        
    	/**
    	 * 根据条件查询用户总数
    	 * @param searchModel
    	 * @return
    	 */
    	Integer getUserTotalBySearch(UserSearchModel searchModel);
    	
    	/**
    	 * 根据条件查询用户List
    	 * @param searchModel
    	 * @return
    	 */
    	List<User> getUserListBySearch(UserSearchModel searchModel, RowBounds rowBounds);
    	
    	/**
    	 * 根据id删除用户关联的角色
    	 * @param id
    	 * @return
    	 */
    	Integer deleteUserRoleById(Integer id);	
    	
    	/**
    	 * 对用户赋予角色
    	 * @param roleIds
    	 * @param userId
    	 */
    	void assignRoles(@Param("roleIds") List<Integer> roleIds, @Param("userId") Integer userId);
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<User> list);

    int batchInsertSelective(java.util.List<User> list, User.Column ... selective);
}
package com.wyy.dao;

import com.wyy.base.BaseMapper;
import com.wyy.entity.Department;

public interface DepartmentDao extends BaseMapper<Department> {
    
    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    
        
    	/**
    	 * 查询所有Department对象
    	 * @return
    	 */
    	List<Department> getDepartmentList();
    	/**
    	 * 查询所有Department对象
    	 * @return
    	 */
    	List<Department> getDepartmentListByParentId(@Param("parentId") Integer parentId);
    	/**
    	 * 部门是否被用户使用
    	 * @param departmentId
    	 */
    	Boolean isUsedByUser(Integer departmentId);
    
    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/
    int deleteByPrimaryKey(Integer id);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    int deleteLogicByIds(int deleteFlag, Integer[] ids);

    int batchInsert(java.util.List<Department> list);

    int batchInsertSelective(java.util.List<Department> list, Department.Column ... selective);
}
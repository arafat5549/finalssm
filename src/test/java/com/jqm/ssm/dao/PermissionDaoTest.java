package com.jqm.ssm.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

import com.jqm.ssm.dao.PermissionDao;
import com.jqm.ssm.entity.Permission;

/**
 * 
 * PermissionTest DAO测试类
 *
 * @author wang
 */
public class PermissionDaoTest {

	private PermissionDao mapper;

	@Before
    public void prepare() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        mapper = (PermissionDao) ctx.getBean("permissionDao");
    }

	@Test
	public void selectListByMapTest() {
		List<Permission> ret = mapper.selectListByMap(null);
		System.out.println("测试selectListByMap："+ret);
	}

	@Test
	public void selectByPrimaryKeyTest( Integer id  ) {

		
		Permission ret = mapper.selectByPrimaryKey(id);
		System.out.println("测试selectByPrimaryKey："+ret);
	}
	
	//
	@Test
	public void deleteByPrimaryKeyTest( Integer id  ) {

		int ret = mapper.deleteByPrimaryKey(id);
		System.out.println("测试deleteByPrimaryKeyTest："+ret);
	}
	
	//@Test
	//public void deleteLogicByIdsTest() {
		//Integer deleteFlag, Integer[] ids
		//return mapper.deleteLogicByIds(deleteFlag, ids);
	//}

	//@Test
	//public void insertTest() {
		//Permission record =new Permission();
		//return mapper.insert(record);
	//}

	//@Test
	//public void insertSelectiveTest() {
	    //Permission record
		//return mapper.insertSelective(record);
	//}

	//@Test
	//public void updateByPrimaryKeySelectiveTest() {
		//Permission record
		//return mapper.updateByPrimaryKeySelective(record);
	//}

	//@Test
	//public void updateByPrimaryKey() {
		//Permission record
		//return mapper.updateByPrimaryKey(record);
	//}
}

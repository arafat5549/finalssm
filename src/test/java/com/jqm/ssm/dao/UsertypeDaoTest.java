package com.jqm.ssm.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

import com.jqm.ssm.dao.UsertypeDao;
import com.jqm.ssm.entity.Usertype;

/**
 * 
 * UsertypeTest DAO测试类
 *
 * @author wang
 */
public class UsertypeDaoTest {

	private UsertypeDao mapper;

	@Before
    public void prepare() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        mapper = (UsertypeDao) ctx.getBean("usertypeDao");
    }

	@Test
	public void selectListByMapTest() {
		List<Usertype> ret = mapper.selectListByMap(null);
		System.out.println("测试selectListByMap："+ret);
	}

	@Test
	public void selectByPrimaryKeyTest( Integer id  ) {

		
		Usertype ret = mapper.selectByPrimaryKey(id);
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
		//Usertype record =new Usertype();
		//return mapper.insert(record);
	//}

	//@Test
	//public void insertSelectiveTest() {
	    //Usertype record
		//return mapper.insertSelective(record);
	//}

	//@Test
	//public void updateByPrimaryKeySelectiveTest() {
		//Usertype record
		//return mapper.updateByPrimaryKeySelective(record);
	//}

	//@Test
	//public void updateByPrimaryKey() {
		//Usertype record
		//return mapper.updateByPrimaryKey(record);
	//}
}

package com.jqm.ssm.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

import com.jqm.ssm.dao.Devicedata1Dao;
import com.jqm.ssm.entity.Devicedata1;

/**
 * 
 * Devicedata1Test DAO测试类
 *
 * @author wang
 */
public class Devicedata1DaoTest {

	private Devicedata1Dao mapper;

	@Before
    public void prepare() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        mapper = (Devicedata1Dao) ctx.getBean("devicedata1Dao");
    }

	@Test
	public void selectListByMapTest() {
		List<Devicedata1> ret = mapper.selectListByMap(null);
		System.out.println("测试selectListByMap："+ret);
	}

	@Test
	public void selectByPrimaryKeyTest( Integer id  ) {

		
		Devicedata1 ret = mapper.selectByPrimaryKey(id);
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
		//Devicedata1 record =new Devicedata1();
		//return mapper.insert(record);
	//}

	//@Test
	//public void insertSelectiveTest() {
	    //Devicedata1 record
		//return mapper.insertSelective(record);
	//}

	//@Test
	//public void updateByPrimaryKeySelectiveTest() {
		//Devicedata1 record
		//return mapper.updateByPrimaryKeySelective(record);
	//}

	//@Test
	//public void updateByPrimaryKey() {
		//Devicedata1 record
		//return mapper.updateByPrimaryKey(record);
	//}
}

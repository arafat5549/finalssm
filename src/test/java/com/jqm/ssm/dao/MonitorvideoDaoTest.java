package com.jqm.ssm.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

import com.jqm.ssm.dao.MonitorvideoDao;
import com.jqm.ssm.entity.Monitorvideo;

/**
 * 
 * MonitorvideoTest DAO测试类
 *
 * @author wang
 */
public class MonitorvideoDaoTest {

	private MonitorvideoDao mapper;

	@Before
    public void prepare() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        mapper = (MonitorvideoDao) ctx.getBean("monitorvideoDao");
    }

	@Test
	public void selectListByMapTest() {
		List<Monitorvideo> ret = mapper.selectListByMap(null);
		System.out.println("测试selectListByMap："+ret);
	}

	@Test
	public void selectByPrimaryKeyTest( Integer id  ) {

		
		Monitorvideo ret = mapper.selectByPrimaryKey(id);
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
		//Monitorvideo record =new Monitorvideo();
		//return mapper.insert(record);
	//}

	//@Test
	//public void insertSelectiveTest() {
	    //Monitorvideo record
		//return mapper.insertSelective(record);
	//}

	//@Test
	//public void updateByPrimaryKeySelectiveTest() {
		//Monitorvideo record
		//return mapper.updateByPrimaryKeySelective(record);
	//}

	//@Test
	//public void updateByPrimaryKey() {
		//Monitorvideo record
		//return mapper.updateByPrimaryKey(record);
	//}
}

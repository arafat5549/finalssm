package com.ssf.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssf.common.twitter.IDGenerator.instance.IdWorkerInstance;
import com.ssf.common.vo.enums.DeleteFlagEnum;
import com.ssf.common.vo.mybatis.pagination.Page;
import com.ssf.dao.demo.DemoAttachment;
import com.ssf.dao.demo.DemoAttachmentMapper;

/**
 * 对MybatisGenerator生成的代码进行测试
 * @author wyy
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-demo-dao.xml")
public class MybatisGeneratorTest {

	@Autowired
	private DemoAttachmentMapper mapper;

	//@Before
    public void prepare() throws Exception {
    	
        ApplicationContext ctx = new ClassPathXmlApplicationContext( "spring-demo-dao.xml" );
        mapper = (DemoAttachmentMapper) ctx.getBean(DemoAttachmentMapper.class);
    }
	@Test
	public void selectCourseWithStudentByExampleTest() {
		Map<Object , Object> map = new HashMap<Object, Object>();
		//map.put("id", 22L);
		Page page = new Page(0, 10);
		map.put("page", page);
		
		int count = mapper.selectCountByMap(map);
		List<DemoAttachment> list = mapper.selectListByMap(map);
		System.out.println("count = " + count);
		System.out.println("list.size() = " + list.size());
	}
	
	 @Test
	public void selectByPrimaryKey() {
		 DemoAttachment obj = mapper.selectByPrimaryKey(13505135567381504L);
		 System.out.println(obj);
		//mapper.selectByPrimaryKeyAndTableName("1", "demo_attachment");
	}
	
	 @Test
	public void deleteByPrimaryKey() {
		mapper.deleteByPrimaryKey(1L);
		mapper.deleteByPrimaryKeyAndTableName("1", "demo_attachment");
	}
	
	 @Test
	public void insertUpdateEntity() {
		for (int i = 0; i < 100; i++) {
//			DemoAttachment attach = new DemoAttachment();
//			attach.setId(IdWorkerInstance.getId());
//			attach.setName(IdWorkerInstance.getIdStr());
//			attach.setCreateTime(IdWorkerInstance.getIdStr());
//			attach.setDeleteFlag(DeleteFlagEnum.NORMAL);
//			// attach.setDynamicTableName("demo_attachment"); //  可选
//			mapper.insert(attach);
			
			//attach.setId(IdWorkerInstance.getId());
			//mapper.insertSelective(attach);
			//mapper.updateByPrimaryKey(attach);
			//mapper.updateByPrimaryKeySelective(attach);
		}
		
	}
//	
//	// @Test
//	public void selectByMap() {
//		Map<Object , Object> map = new HashMap<Object, Object>();
//		// map.put("dynamicTableName", "demo_attachment1"); // 可选
//		int count = mapper.selectCountByMap(map);
//		System.out.println(count);
//		List<DemoAttachment> list = mapper.selectListByMap(map);
//		if(list != null && list.size() > 0) {
//			for (DemoAttachment demoAttachment : list) {
//				System.out.println(demoAttachment.getId());
//			}
//		}
//	}	
}

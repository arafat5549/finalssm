package com.ssf.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssf.common.vo.mybatis.pagination.Page;
import com.ssf.model.Category;

/**
 * Created by Administrator on 2017/5/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;
	
    @Test
    public void testQueryAll() {
		Map<Object , Object> map = new HashMap<Object, Object>();
		Page page = new Page(0, 10);
		map.put("page", page);
		map.put("databaseId","mysql");
		
		List<Category> list= categoryDao.selectListByMap(map);
        System.out.println(list.size()+"--------------------------");
    	
    	int count = categoryDao.selectCountByMap(null);
		System.out.println("count = " + count);
//    	String time ="2017-05-16 13:51:26.0";
//    	//String time ="20170516135126";
//    	String gmt = DateUtils.GMTTimeZoneTransToSysTimeZoneStr(time);
//    	System.out.println(gmt);
    }

//    @Test
//    public void findFirstCategorysTest(){
//        List<Category> lists = categoryService.findFirstCategorys();
//        String json = JsonMapper.toJsonString(lists);
//        System.out.println(json);
//    }
//    
//    @Test
//    public void findParentCategorysByPidTest(){
//    	List<Category> lists = categoryService.findParentCategorysByPid(87L);
//        String json = JsonMapper.toJsonString(lists);
//        System.out.println(json);
//    }
}




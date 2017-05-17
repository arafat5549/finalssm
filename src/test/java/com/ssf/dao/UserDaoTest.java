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
import com.ssf.model.User;



/**
 * 
 * @author yingjun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    
    
	
	@Test
	public void testQueryById() {
		User user= (User)userDao.selectByPrimaryKey(1L);
		System.out.println("User:"+user);
		System.out.println(user.getDeleteFlag());
		System.out.println("--1------------------------");
	}

	@Test
	public void testListPage() {
		Map<Object , Object> map = new HashMap<Object, Object>();
		//Page page = new Page(0, 10);
		//map.put("page", page);
		//map.put("databaseId","mysql");
		map.put("name", "wang");
		map.put("password", "123456");
		List<User> list=userDao.selectListByMap(map);
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("--2------------------------");
	}
//	
//	//@Test
//	public void testAddScore() {
//		userDao.addScore(10);
//		List<User> list=userDao.queryAll(0, 100);
//		for (User user : list) {
//			System.out.println(user);
//		}
//	}

}

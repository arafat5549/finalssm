package com.ssf.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    
//    @BeforeClass
//    public static void pre(){
//    	System.out.println("----------------------");
//    }
    
    
	
	@Test
	public void testQueryById() {
		User user= (User)userDao.selectByPrimaryKey(1L);
		System.out.println("User:"+user);
		System.out.println("--1------------------------");
	}

//	@Test
//	public void testListPage() {
//		List<User> list=userDao.listPage(0, 100);
//		for (User user : list) {
//			System.out.println(user);
//		}
//		System.out.println("--2------------------------");
//	}
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

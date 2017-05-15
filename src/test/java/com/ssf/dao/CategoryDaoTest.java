package com.ssf.dao;

import com.ssf.model.Category;
import com.ssf.model.Product;
import com.ssf.service.CategoryService;
import com.ssf.util.common.JsonMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class CategoryDaoTest {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testQueryAll() {
        List<Category> list=categoryDao.listPage(0, 10);
        for (Category goods : list) {
            System.out.println(goods);
        }
        System.out.println(list.size()+"--------------------------");
    }

    @Test
    public void findFirstCategorysTest(){
        List<Category> lists = categoryService.findFirstCategorys();
        String json = JsonMapper.toJsonString(lists);
        System.out.println(json);
    }
    
    @Test
    public void findParentCategorysByPidTest(){
    	List<Category> lists = categoryService.findParentCategorysByPid(87L);
        String json = JsonMapper.toJsonString(lists);
        System.out.println(json);
    }
}




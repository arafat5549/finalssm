package com.ssf.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssf.cache.RedisCache;
import com.ssf.model.Product;
import com.ssf.model.ProductImage;
import com.ssf.service.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ProductDaoTest {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private RedisCache cache;
	@Autowired
	private ProductImageDao productImageDao;

	@Test
	public void testQueryAll() {
		List<Product> list=productDao.listPage(0, 10);
		for (Product goods : list) {
			System.out.println(goods);
		}
		System.out.println(list.size()+"--------------------------");
	}

	@Test
	public void testListRelatedProducts() {
		String sql = "SELECT * FROM sys_product a WHERE a.category_id=83 AND a.id!=87;";
		List<Product> list = productDao.selectList(sql);
		System.out.println(list.size());
		System.out.println(list);
	}
	@Test
	public void testNewArrivals(){
		List<Product> list = productService.listNewArrivals();
		System.out.println(list.size());
		System.out.println(list);
	}
	
	@Test
	public void test(){
		String cache_key = RedisCache.CAHCENAME + "test";
		String sql = "SELECT * FROM sys_product_image a WHERE a.product_id=87";
		List<ProductImage> list = cache.reflectList(cache_key, ProductImage.class, sql, productImageDao,LOG);
		System.out.println(list.size());
		//System.out.println(list);
		for (ProductImage productImage : list) {
			System.out.println(productImage);
		}
	}
	
//
//	//@Test
//	public void testBugWithProcedure() {
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("userId", 1000L);
//		map.put("goodsId", 1000L);
//		map.put("title", "抢购iPhone7");
//		map.put("result", null);
//		goodsDao.bugWithProcedure(map);
//		//获取result
//		System.out.println("testBugWithProcedure result:"+map.get("result"));
//	}

}

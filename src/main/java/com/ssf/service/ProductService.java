package com.ssf.service;

import java.util.List;

import junit.framework.TestListener;

import com.ssf.model.Product;


public interface ProductService {

	/**
	 * 根据偏移量查询可用商品列表
	 *
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Product> listPage(int offset, int limit);
	/**
	 * 根据主键id查找商品
	 * @param id
	 * @return
	 */
	Product findById(Long id);
	/**
	 * 获取相关联商品
	 * @param p
	 * @return
	 */
	List<Product> listRelatedProducts(Product p);
	
	/**
	 * 根据分类id 获取该分页底下的所有商品
	 * @param cid
	 * @return
	 */
	List<Product> listPageByCategoryId(Long cid);
	/**
	 * 获取新到的商品
	 * @return
	 */
	List<Product> listNewArrivals();
	
	/**
	 * 商品购买
	 * 
	 * @param userPhone
	 * @param goodsId
	 * @param useProcedure
	 *            是否用存储过程提高并发能力
	 */
	
	//void buyGoods(long userPhone, long goodsId, boolean useProcedure);

	
	/**
	 * 测试获取List集合
	 */
	
}

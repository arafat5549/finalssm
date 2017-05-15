package com.ssf.service;

import com.ssf.model.Category;
import com.ssf.model.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10.
 */
public interface CategoryService {
	 /**
	  * 获取一级分类包括它的子分类
	  * @return
	  */
     List<Category> findFirstCategorys();
     
     /**
      * 根据商品id获取它的所有父分类(从大到小排序#爷爷分类>父亲分类>分类)
      * @param pid
      * @return
      */
     List<Category> findParentCategorysByPid(Long pid);
     /**
 	 * 根据主键id查找商品
 	 * @param id
 	 * @return
 	 */
     Category findById(Long id);
}

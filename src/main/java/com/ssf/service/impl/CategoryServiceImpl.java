package com.ssf.service.impl;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.ssf.cache.RedisCache;
import com.ssf.dao.CategoryDao;
import com.ssf.model.Category;
import com.ssf.model.Product;
import com.ssf.service.CategoryService;
import com.ssf.service.ProductService;

/**
 * Created by Administrator on 2017/5/10.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private static final String PREFIX_CAHCE = RedisCache.CAHCENAME + "|Category|";
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductService productService;
    
    @Autowired
	private RedisCache cache;
    
    /**
     * 跟父类id获取所有父分类
     * @param pid
     * @return
     */
    private List<Category> findByParentId(Long pid){
    	String cache_key = PREFIX_CAHCE + "findByParentId|" + pid;
    	
    	List<Category> result_cache = cache.getListCache(cache_key, Category.class);
		if (result_cache != null) {
			LOG.info("get cache with key:" + cache_key);
		} else {
			String sql = "SELECT * FROM sys_category a WHERE a.parent_id="+pid;
			result_cache = categoryDao.selectList(sql);
			
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:" + cache_key);
			return result_cache;
		}
		return result_cache;
		
        //String sql = "SELECT * FROM sys_category a WHERE a.parent_id="+pid;
        //return categoryDao.selectList(sql);
    }
    /**
     * 获取商品的分类
     */
    private Category findByProductId(Long pid){
    	
    	Product  product = productService.findById(pid);
    	Assert.state(product!=null);
    	
    	
    	String cache_key = PREFIX_CAHCE + "findByProductId|" + pid;
    	
    	Category result_cache = cache.getCache(cache_key, Category.class);
		if (result_cache != null) {
			LOG.info("get cache with key:" + cache_key);
		} else {
			String sql = "SELECT * FROM sys_category a WHERE a.id="+product.getCategoryId();
			result_cache = (Category) categoryDao.selectObject(sql);
			
			cache.putCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:" + cache_key);
			return result_cache;
		}
		return result_cache;
    }
    /*
     * -----------------------------Override区域--------------------------------
     */
    @Override
    public List<Category> findFirstCategorys(){;
        List<Category> lists = findByParentId(0L);
        for (Category category : lists) {
            List<Category> childs = findByParentId(category.getId());
            category.setLists(childs);
            for (Category grand : childs) {
                List<Category> grands = findByParentId(grand.getId());
                grand.setLists(grands);
            }
        }
        return lists;
    }


	@Override
	public List<Category> findParentCategorysByPid(Long pid) {
		List<Category> lists = Lists.newArrayList();
		
		//1.判断有没有这个分类
		Category cate = findByProductId(pid);
		if(cate == null){
		   return lists;  //一般集合不返回null	
		}
		String str = cate.getParentIds();
		
		List<String> parents = Splitter.on(",")
				.omitEmptyStrings()
				.trimResults(CharMatcher.is('0'))
				.splitToList(str);
		
		Function<String,Long> function = new Function<String, Long>() {		
			@Override
			public Long apply(String arg0) {
				return NumberUtils.toLong(arg0);
			}
		};
		List<Long> ints = Lists.transform(parents, function);
		for (Long id : ints) {
			lists.add(findById(id));
		}
		return lists;
		
		
//		//2.获取无限级别分类
//		String sql = "SELECT * FROM sys_category a WHERE a.parent_ids LIKE '"+cate.getParentIds()+"%'";
//		return categoryDao.selectList(sql);
	}
	@Override
	public Category findById(Long id) {
		Assert.state(id!=null && id > 0,"商品id不能为空");
		
		String cache_key = PREFIX_CAHCE + "findById|" + id;
		Category result_cache = cache.getCache(cache_key, Category.class);
		if (result_cache != null) {
			LOG.info("get cache with key:" + cache_key);
		} else {
			// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache = categoryDao.selectByPrimaryKey(id);
			cache.putCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:" + cache_key);
			return result_cache;
		}
		return result_cache;
	}
}

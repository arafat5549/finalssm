package com.ssf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ssf.cache.RedisCache;
import com.ssf.dao.ProductDao;
import com.ssf.dao.ProductImageDao;
import com.ssf.model.Product;
import com.ssf.model.ProductImage;
import com.ssf.service.ProductService;
import com.ssf.util.PageUtil;

@Service
public class ProductServiceImpl implements ProductService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private static final String PREFIX_CAHCE = RedisCache.CAHCENAME + "|Product|";
	private static final Class<Product> SELF_CLASS = Product.class;
	@Autowired
	private RedisCache cache;
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductImageDao productImageDao;
	
	/*
     * -----------------------------Override区域--------------------------------
     */
	@Override
	public List<Product> listPage(int offset, int limit) {
		String cache_key = PREFIX_CAHCE + "listPage|" + offset + "|" + limit;
		
		List<Product> result_cache = cache.getListCache(cache_key, Product.class);
		if (result_cache != null) {
			LOG.info("get cache with key:" + cache_key);
		} else {
			// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			//result_cache = productDao.listPage(offset, limit);
			Map<Object , Object>  paramMap = PageUtil.getPageParamMap(offset, limit);
			result_cache = productDao.selectListByMap(paramMap);
			
			_initProduct(result_cache);
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:" + cache_key);
			return result_cache;
		}
		return result_cache;	
	}

	@Override
	public Product findById(Long id) {
		Assert.state(id!=null && id > 0,"商品id不能为空");
		
		String cache_key = PREFIX_CAHCE + "findById|" + id;
		Product result_cache = cache.getCache(cache_key, Product.class);
		if (result_cache != null) {
			LOG.info("get cache with key:" + cache_key);
		} else {
			// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache = productDao.selectByPrimaryKey(id);
			_initProduct(result_cache);
			cache.putCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:" + cache_key);
			return result_cache;
		}
		return result_cache;
	}

	@Override
	public List<Product> listRelatedProducts(Product p) {
		Assert.state(p!=null && p.getCategoryId() > 0);
		
		String cache_key = PREFIX_CAHCE + "listRelatedProducts|" + p.getId();
		//String sql = "SELECT * FROM sys_product a WHERE a.category_id="+p.getCategoryId()+" AND a.id!="+p.getId();
		Map<Object , Object>  paramMap = PageUtil.getPageParamMap();
		paramMap.put("categoryId", p.getCategoryId());
		paramMap.put("id", p.getId());
		List<Product> list = cache.cacheList(cache_key, SELF_CLASS, paramMap, productDao,LOG);
		_initProduct(list);
		return list;
	}

	@Override
	public List<Product> listPageByCategoryId(Long cid) {
		String cache_key = PREFIX_CAHCE + "listPageByCategoryId|" + cid;
		
//		String sql = "SELECT * FROM sys_product a WHERE a.category_id="+cid;
//		sql += " LIMIT 0,20";
		Map<Object , Object>  paramMap = PageUtil.getPageParamMap(0, 20);
		paramMap.put("categoryId", cid);
		List<Product> list = cache.cacheList(cache_key, SELF_CLASS, paramMap, productDao,LOG);
		_initProduct(list);
		return list;
	}

	@Override
	public List<Product> listNewArrivals() {
		String cache_key = PREFIX_CAHCE + "listNewArrivals";
		//String sql = "SELECT * FROM sys_product LIMIT 0,20";
		Map<Object , Object>  paramMap = PageUtil.getPageParamMap(0, 20);
		List<Product> list = cache.cacheList(cache_key, SELF_CLASS, paramMap, productDao,LOG);
		_initProduct(list);
		return list;
	}
	
    
	private void _initProduct(List<Product> list){
		for (Product product : list) {
			_initProduct(product);
		}
	}  
	private void _initProduct(Product product){
//		if(Strings.isNullOrEmpty(product.getImage())){
//			List<ProductImage> imageList =listProuctImagesByPId(product.getId());
//			product.initImages(imageList);
//		}
	}
	//根据id初始化关联的图片
	private List<ProductImage> listProuctImagesByPId(Integer pid){
		String cache_key = PREFIX_CAHCE + "listProuctImagesByPId|"+pid;
		//String sql = "SELECT * FROM sys_product_image a WHERE a.product_id="+pid;
		Map<Object , Object> paramMap = PageUtil.getPageParamMap();
		paramMap.put("productId",pid);
		List<ProductImage> list = cache.cacheList(cache_key, ProductImage.class, paramMap, productImageDao,LOG);
		return list;
	}
	
	
//
//	@Transactional
//	@Override
//	public void buyGoods(long userPhone, long goodsId, boolean useProcedure) {
//		// 用户校验
//		User user = userDao.queryByPhone(userPhone);
//		if (user == null) {
//			throw new BizException(ResultEnum.INVALID_USER.getMsg());
//		}
//		if (useProcedure) {
//			// 通过存储方式的方法进行操作
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("userId", user.getUserId());
//			map.put("goodsId", goodsId);
//			map.put("title", "抢购");
//			map.put("result", null);
//			goodsDao.bugWithProcedure(map);
//			int result = MapUtils.getInteger(map, "result", -1);
//			if (result <= 0) {
//				// 买卖失败
//				throw new BizException(ResultEnum.INNER_ERROR.getMsg());
//			} else {
//				// 买卖成功
//				// 此时缓存中的数据不是最新的，需要对缓存进行清理（具体的缓存策略还是要根据具体需求制定）
//				cache.deleteCacheWithPattern("getGoodsList*");
//				LOG.info("delete cache with key: getGoodsList*");
//				return;
//			}
//		} else {
//
//			int inserCount = orderDao.insertOrder(user.getUserId(), goodsId, "普通买卖");
//			if (inserCount <= 0) {
//				// 买卖失败
//				throw new BizException(ResultEnum.DB_UPDATE_RESULT_ERROR.getMsg());
//			} else {
//				// 减库存
//				int updateCount = goodsDao.reduceNumber(goodsId);
//				if (updateCount <= 0) {
//					// 减库存失败
//					throw new BizException(ResultEnum.DB_UPDATE_RESULT_ERROR.getMsg());
//				} else {
//					// 买卖成功
//					// 此时缓存中的数据不再是最新的，需要对缓存进行清理（具体的缓存策略还是要根据具体需求制定）
//					cache.deleteCacheWithPattern("getGoodsList*");
//					LOG.info("delete cache with key: getGoodsList*");
//					return;
//				}
//			}
//		}
//	}

}

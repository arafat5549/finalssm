package com.ssf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.ssf.cache.RedisCache;
import com.ssf.dao.UserDao;
import com.ssf.model.User;
import com.ssf.service.UserService;
import com.ssf.util.PageUtil;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisCache cache;
	
	public User findByName(String name){
		if(Strings.isNullOrEmpty(name)){
			return null;
		}
		Map<Object , Object> paraMap = PageUtil.getPageParamMap();
		paraMap.put("name",name);
		List<User> list =  userDao.selectListByMap(paraMap);
		return list!=null&&list.size()>0 ?list.get(0):null;
	}
	
	
	@Override
	public List<User> listPage(int offset, int limit) {
		String cache_key=RedisCache.CAHCENAME+"|User|listPage|"+offset+"|"+limit;
		//先去缓存中取
		List<User> result_cache=cache.getListCache(cache_key, User.class);
		if(result_cache==null){
			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			Map<Object , Object> paraMap = PageUtil.getPageParamMap(offset, limit);
			result_cache = userDao.selectListByMap(paraMap);
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
			LOG.info("put cache with key:"+cache_key);
		}else{
			LOG.info("get cache with key:"+cache_key);
		}
		return result_cache;
	}


	@Override
	public User login(User user) {
		
		User exist = findByName(user.getName());
		
		return null;
	}
	
	

}

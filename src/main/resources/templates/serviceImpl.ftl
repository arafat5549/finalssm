package ${packageName}.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ${packageName}.I${className}Service;
import ${daoPackageName}.${className}Dao;
import ${modelPackageName}.${className};

import ${myBasePackage}.util.SpringContextHolder;
import ${myBasePackage}.cache.RedisCache;
import ${myBasePackage}.util.PageUtil;

import com.google.common.base.Strings;
import com.jqm.ssm.util.page.Page;
import com.jqm.ssm.misc.Constants;
import com.google.common.collect.Maps;
/**
 * 
 * I${className}Service 接口实现类
 *
 * @author wang
 */
@Service(value = "${smallClassName}Service")
public class ${className}ServiceImpl implements I${className}Service {

	private static final Logger LOG = LoggerFactory.getLogger(${className}ServiceImpl.class);
	private static final String PREFIX_CAHCE = RedisCache.CAHCENAME + "|${className}|";
	private static final Class<${className}> SELF_CLASS = ${className}.class;

	@Autowired    //@Resource(name = "${smallClassName}Dao")
	private ${className}Dao mapper;

	@Autowired  //@Resource(name= "redisCache")
	private RedisCache redisCache;

	@Autowired   //@Resource(name="springContextHolder")
	private SpringContextHolder springContextHolder;
	
	@Override
	public int selectCountByMap(Map<Object, Object> map) {
		return mapper.selectCountByMap(map);
	}
	@Override
	public ${className} selectObjByMap(Map<Object, Object> map){
		List<${className}> list = mapper.selectListByMap(map);
		return list.size()>=1 ? list.get(0) : null;
    }
	@Override
	public List<${className}> selectListByMap(Map<Object, Object> map,String cacheKey) {
		String cache_key = PREFIX_CAHCE + "selectListByMap";
		if(springContextHolder.getRedisAcaliable() && !Strings.isNullOrEmpty(cacheKey))
		{
			cache_key = cache_key + "|" + cacheKey;
			return redisCache.cacheList(cache_key, SELF_CLASS, map, mapper, LOG);
		}
		return mapper.selectListByMap(map);
	}
	@Override
	public List<${className}> selectListByMap( Map<Object, Object> map) {
    	return selectListByMap(map,"");
    }

	@Override
	public List<${className}> listPage(int offset,int limit,Map<Object, Object> map,String cacheKey)
	{
		String cache_key = PREFIX_CAHCE + "listPage|" + offset +"|"+ limit;
		if(map == null) map = Maps.newHashMap();
		if(offset>=0 && limit>=0) {
			Page page = new Page(offset, limit);
			map.put("page",page);
		}
		if(springContextHolder.getRedisAcaliable()&& !Strings.isNullOrEmpty(cacheKey))
		{
    		cache_key = cache_key + "|" + cacheKey;
			return redisCache.cacheList(cache_key, SELF_CLASS, PageUtil.getPageParamMap(offset, limit,map), mapper, LOG);
		}
		return mapper.selectListByMap(map);
	}
    @Override
    public List<${className}> listPage(int offset,int limit,Map<Object, Object> map)
    {
    	return listPage(offset,limit,map,"");
    }

	@Override
	public ${className} selectByPrimaryKey(${idField} id) {
		String cache_key = PREFIX_CAHCE + "selectByPrimaryKey|" + id;
		if(springContextHolder.getRedisAcaliable())
		{
			${className} result_cache = redisCache.getCache(cache_key, SELF_CLASS);
			if (result_cache != null) {
				LOG.info("get cache with key:" + cache_key);
			} else {
				result_cache = mapper.selectByPrimaryKey(id);
				if(result_cache!=null){
					redisCache.putCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
					LOG.info("put cache with key:" + cache_key);
				}
				else{
					LOG.error(cache_key+":获取的是空的对象");
				}
				return result_cache;
			}
			return result_cache;
		}
		return mapper.selectByPrimaryKey(id);
	}
	
	//
	@Override
	public int deleteByPrimaryKey(${idField} id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	<#--@Override-->
	<#--public int deleteLogicByIds(Integer deleteFlag, Integer[] ids) {-->
		<#--return mapper.deleteLogicByIds(deleteFlag, ids);-->
	<#--}-->

	@Override
	public int insert(${className} record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(${className} record) {
		return mapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(${className} record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(${className} record) {
		return mapper.updateByPrimaryKey(record);
	}
    /*
	@Override
	public MyPageView<${className}> generateMyPageViewVO(Map<Object, Object> map) {
		
		int _totalCount = mapper.selectCountByMap(map);
		
		List<${className}> _list = mapper.selectListByMap(map);
		
		int recordPerPage = 10;
		int currentPage = 1;
		if(map.get("page") != null) {
			Object _pageObj = map.get("page");
			if(_pageObj instanceof Page) {
				Page _page = (Page)_pageObj;
				currentPage = _page.getPageNo();
				recordPerPage = _page.getLength();
			}
		}
		MyPageView<${className}> pageView = MyPageView.generaterMyPageView(recordPerPage, currentPage, _totalCount, _list);
		
		return pageView;
		
	}
    */
	/**
	  * 底下是一些自定义的方法
	**/
}

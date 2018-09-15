package com.ssf.utils;

import com.ssf.common.vo.mybatis.pagination.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 * 
 * @author wyy
 *
 */
public class PageUtil {

	public static Map<Object , Object> getPageParamMap()
	{
		return new HashMap<Object, Object>();
	}
	
	public static Map<Object , Object> getPageParamMap(int offset,int limit){
		Map<Object , Object> map = new HashMap<Object, Object>();
		Page page = new Page(offset, limit);
		map.put("page", page);
		map.put("databaseId","mysql");
		return map;
	}

	public static Map<Object , Object> getPageParamMap(int offset,int limit,Map<Object, Object> paramMap){
		if(paramMap==null){
			paramMap = new HashMap<Object, Object>();
		}
		Page page = new Page(offset, limit);
		paramMap.put("page", page);
		paramMap.put("databaseId","mysql");
		return paramMap;
	}
	
}

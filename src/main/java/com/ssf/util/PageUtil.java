package com.ssf.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.bcel.generic.RETURN;

import com.ssf.common.vo.mybatis.pagination.Page;

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
	
	
}

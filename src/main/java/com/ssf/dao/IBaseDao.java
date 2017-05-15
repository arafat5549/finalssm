package com.ssf.dao;

import java.util.List;


public interface IBaseDao<T> {

	List<T> selectList(String sql);
}

package com.ssf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssf.model.User;


public interface IBaseDao<T> {

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectList(String sql);

    T selectObject(String sql);

    List<T> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}

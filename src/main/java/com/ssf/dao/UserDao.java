package com.ssf.dao;

import com.ssf.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectList(String sql);

    Object selectUser(String sql);

    List<User> listPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
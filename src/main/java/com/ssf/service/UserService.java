package com.ssf.service;

import java.util.List;

import com.ssf.model.User;


public interface UserService {

	List<User> listPage(int offset, int limit);
	 
}

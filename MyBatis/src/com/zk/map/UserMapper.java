package com.zk.map;

import java.util.List;

import com.zk.model.User;

public interface UserMapper {
	
	User selectUserById(Long id);
	List<User> selectUserByParms(User user);
}
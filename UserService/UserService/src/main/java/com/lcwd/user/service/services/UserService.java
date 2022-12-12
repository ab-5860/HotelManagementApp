package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entites.User;

public interface UserService {

	// save user
	User saveUser(User user);
	

	
	// get all users
	List<User> getAllUser();
	
	// get single user
	User getUser(String userId);
	
	// Delete and update
}

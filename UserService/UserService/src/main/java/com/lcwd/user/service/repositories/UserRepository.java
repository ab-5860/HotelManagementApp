package com.lcwd.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.entites.User;

public interface UserRepository extends JpaRepository<User,String>{
	
	
		// implement custom method
}

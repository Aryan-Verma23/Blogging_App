package com.aryan.blog.services;

import java.util.List;

import com.aryan.blog.entities.User;
import com.aryan.blog.payloads.UserDto;

public interface UserService {
	
	
	UserDto create(UserDto user);
	UserDto updateUser(UserDto user,int userId);
	UserDto getUserById(int userId);
	List <UserDto> getALLUsers();
	
	void deleteUser(int userId);

}

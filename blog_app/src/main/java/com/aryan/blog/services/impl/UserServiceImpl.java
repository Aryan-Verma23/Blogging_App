package com.aryan.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aryan.blog.entities.User;
import com.aryan.blog.payloads.UserDto;
import com.aryan.blog.repositories.UserRepo;
import com.aryan.blog.services.UserService;

public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto create(UserDto userDto) {
		User user = this.dtotoUser(userDto);
		
		User savedUser = this.userRepo.save(user);
		
		return this.usertoDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, int userId) {
		
		
		
		return null;
	}

	@Override
	public UserDto getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getALLUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}
	
	public User dtotoUser(UserDto userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}
	public UserDto usertoDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		
		return userDto;
		
		
	}
	
	

}

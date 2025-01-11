package com.aryan.blog.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryan.blog.entities.User;
import com.aryan.blog.payloads.UserDto;
import com.aryan.blog.repositories.UserRepo;
import com.aryan.blog.services.UserService;
import com.aryan.blog.exceptions.*;
@Service
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
	public UserDto updateUser(UserDto userDto, int userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.usertoDto(updateUser);
		return userDto1 ;
	}

	@Override
	public UserDto getUserById(int userId) {
		User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		return this.usertoDto(user);
	}

	@Override
	public List<UserDto> getALLUsers() {
		List<User> users= this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.usertoDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(int userId) {
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	
	public User dtotoUser(UserDto userDto) {
		
		//we can use model mapper too using bean and model mapper library
		//for converting one object to another
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

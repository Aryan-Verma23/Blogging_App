package com.aryan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
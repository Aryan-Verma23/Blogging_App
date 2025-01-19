package com.aryan.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.blog.entities.Category;
import com.aryan.blog.entities.Post;
import com.aryan.blog.entities.User;

public interface PostRepo extends JpaRepository <Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}

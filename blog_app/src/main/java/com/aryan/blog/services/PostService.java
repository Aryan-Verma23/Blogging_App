package com.aryan.blog.services;

import java.util.List;

import com.aryan.blog.entities.Post;
import com.aryan.blog.payloads.PostDto;

public interface PostService {
	
	//create
	
	Post createPost(PostDto postDto);
	
	//update
	Post updatePost(PostDto postDto,int postId);
	
	//delete
	void  deletePost(int postId);
	
	//getall
	List<Post> getAllpost();

	//getbyid
	Post getPostById(int postId);
	
	//getbycatid
	List<Post> getPostsByCategory(int categoryId);
	
	//getbyuserid
	List<Post> getPostsByUser(int userId);
	
	
	
	

}

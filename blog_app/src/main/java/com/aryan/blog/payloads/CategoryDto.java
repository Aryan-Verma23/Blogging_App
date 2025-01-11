package com.aryan.blog.payloads;

import com.aryan.blog.entities.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter 
public class CategoryDto {
	
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}

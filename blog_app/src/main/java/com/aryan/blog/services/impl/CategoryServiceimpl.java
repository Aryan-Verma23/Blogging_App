package com.aryan.blog.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.aryan.blog.entities.Category;
import com.aryan.blog.payloads.CategoryDto;
import com.aryan.blog.services.CategoryService;

public class CategoryServiceimpl implements CategoryService {
	
	@Autowired

	private CategoryDto  categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	    // Map CategoryDto to Category entity
	    Category category = this.modelMapper.map(categoryDto, Category.class);

	    // Save the Category entity
	    Category savedCategory = this.categoryRepo.save(category);

	    // Map the saved Category entity back to CategoryDto
	    return this.modelMapper.map(savedCategory, CategoryDto.class);
	}


	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public CategoryDto getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}

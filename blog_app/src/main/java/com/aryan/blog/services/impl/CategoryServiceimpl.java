package com.aryan.blog.services.impl;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.aryan.blog.entities.Category;
import com.aryan.blog.payloads.CategoryDto;
import com.aryan.blog.repositories.CategoryRepo;
import com.aryan.blog.services.CategoryService;
import com.aryan.blog.exceptions.ResourceNotFoundException;

public class CategoryServiceimpl implements CategoryService {
	
	@Autowired

	private CategoryRepo  categoryRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	    // Map CategoryDto to Category entity
	    Category cat = this.modelMapper.map(categoryDto, Category.class);

	    // Save the Category entity
	    Category addedCat = this.categoryRepo.save(cat);

	    // Map the saved Category entity back to CategoryDto
	    return this.modelMapper.map(addedCat, CategoryDto.class);
	}
 

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
	   Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId",categoryId));
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

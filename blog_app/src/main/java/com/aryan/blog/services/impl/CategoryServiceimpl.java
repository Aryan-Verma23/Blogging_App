package com.aryan.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryan.blog.entities.Category;
import com.aryan.blog.payloads.CategoryDto;
import com.aryan.blog.repositories.CategoryRepo;
import com.aryan.blog.services.CategoryService;
import com.aryan.blog.exceptions.ResourceNotFoundException;
@Service 
public class CategoryServiceimpl implements CategoryService {
	
	@Autowired

	private CategoryRepo  categoryRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	    // Map CategoryDto to Category 
	    Category cat = this.modelMapper.map(categoryDto, Category.class);

	    // Save the Category 
	    Category addedCat = this.categoryRepo.save(cat);

	    // Map the saved Category entity back to CategoryDto
	    return this.modelMapper.map(addedCat, CategoryDto.class);
	}
 

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
	   Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId",categoryId));
	   
	   cat.setCategoryTitle(categoryDto.getCategoryTitle());
	   cat.setCategoryDescription(categoryDto.getCategoryDescription());
	   Category updatedcat= this.categoryRepo.save(cat);
	   return this.modelMapper.map(updatedcat, CategoryDto.class);
	}


	@Override
	public void deleteCategory(int categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getCategory(int categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories =this.categoryRepo.findAll();
		List<CategoryDto> catDtos  = categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
	
		return catDtos;
	}

}

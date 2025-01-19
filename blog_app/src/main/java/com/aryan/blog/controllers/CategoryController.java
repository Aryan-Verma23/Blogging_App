package com.aryan.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryan.blog.payloads.APIresponse;
import com.aryan.blog.payloads.CategoryDto;
import com.aryan.blog.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired 
	private CategoryService categoryService;
	
	//Create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Validated @RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
	}
	
	//Update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Validated  @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
		
	}
	
	//delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<APIresponse> deleteCategory(@PathVariable Integer catId){
	 this.categoryService.deleteCategory(catId);
		return new ResponseEntity<APIresponse>(new APIresponse("category is deleted succesfully !!",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int catId) {
		CategoryDto categoryDto = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories() {
	List<CategoryDto> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}
	

}

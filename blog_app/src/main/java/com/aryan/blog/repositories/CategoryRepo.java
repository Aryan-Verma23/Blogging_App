package com.aryan.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryan.blog.entities.Category;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}

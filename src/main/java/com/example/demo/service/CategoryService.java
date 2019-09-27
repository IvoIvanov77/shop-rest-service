package com.example.demo.service;

import com.example.demo.domain.model.category.request.CreateCategoryRequest;
import com.example.demo.domain.model.category.request.EditCategoryRequest;
import com.example.demo.domain.model.category.response.CategoryResponse;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.List;

public interface CategoryService
{
    Resource<CategoryResponse> get(Long id);

    Resources<Resource<CategoryResponse>> getAll();

    CategoryResponse createCategory(CreateCategoryRequest request);

    CategoryResponse edit(EditCategoryRequest request);

    CategoryResponse delete(Long id);    
    
    List<CategoryResponse> searchByName(String name);
}

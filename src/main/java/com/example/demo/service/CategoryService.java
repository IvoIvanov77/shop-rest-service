package com.example.demo.service;

import com.example.demo.domain.model.category.request.CreateCategoryRequest;
import com.example.demo.domain.model.category.request.DeleteCategoryRequest;
import com.example.demo.domain.model.category.request.EditCategoryRequest;
import com.example.demo.domain.model.category.request.SearchCategoryByNameRequest;
import com.example.demo.domain.model.category.response.CategoryResponse;

import java.util.List;

public interface CategoryService
{
    CategoryResponse get(Long id);

    List<CategoryResponse> getAll();

    CategoryResponse createCategory(CreateCategoryRequest request);

    CategoryResponse edit(EditCategoryRequest request);

    CategoryResponse delete(DeleteCategoryRequest request);    
    
    List<CategoryResponse> searchByName(SearchCategoryByNameRequest request);
}

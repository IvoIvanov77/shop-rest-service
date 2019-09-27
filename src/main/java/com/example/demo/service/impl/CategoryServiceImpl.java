/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.service.impl;


import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.category.request.CreateCategoryRequest;
import com.example.demo.domain.model.category.request.EditCategoryRequest;
import com.example.demo.domain.model.category.response.CategoryResponse;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService
{

    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Resource<CategoryResponse> get(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Resources<Resource<CategoryResponse>> getAll()
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public CategoryResponse edit(EditCategoryRequest request)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public CategoryResponse delete(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<CategoryResponse> searchByName(String name)
    {
        // TODO Auto-generated method stub
        return null;
    }

}

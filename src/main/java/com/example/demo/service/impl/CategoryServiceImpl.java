/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.constants.ErrorMessages;
import com.example.demo.domain.entities.Category;
import com.example.demo.domain.model.category.request.CreateCategoryRequest;
import com.example.demo.domain.model.category.request.DeleteCategoryRequest;
import com.example.demo.domain.model.category.request.EditCategoryRequest;
import com.example.demo.domain.model.category.request.SearchCategoryByNameRequest;
import com.example.demo.domain.model.category.response.CategoryResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.DtoMapper;


@Service
public class CategoryServiceImpl implements CategoryService
{

    private final CategoryRepository categoryRepository;

    private final DtoMapper mapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, DtoMapper mapper)
    {

        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }


    @Override
    public CategoryResponse get(Long id)
    {
        Category category = getById(id);
        CategoryResponse responseModel = mapper.map(category, CategoryResponse.class);
        System.out.println(responseModel);
        return responseModel;

    }


    @Override
    public List<CategoryResponse> getAll()
    {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryResponse> responceModels = mapper.map(allCategories, CategoryResponse.class)
                .collect(Collectors.toList());
        return responceModels;
    }


    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request)
    {
        Category category = mapper.map(request, Category.class);
        return saveCategory(category);
    }


    @Override
    public CategoryResponse edit(EditCategoryRequest request)
    {
        Category categoryToEdit = getById(request.getId());

        categoryToEdit.setName(request.getName());
        categoryToEdit.setImageUrl(request.getImageUrl());
        return saveCategory(categoryToEdit);
    }


    @Override
    public CategoryResponse delete(DeleteCategoryRequest request)
    {
        Category categoryToDelete = getById(request.getId());
        categoryRepository.delete(categoryToDelete);
        return mapper.map(categoryToDelete, CategoryResponse.class);
    }


    @Override
    public List<CategoryResponse> searchByName(SearchCategoryByNameRequest request)
    {
        List<Category> resultList = categoryRepository.searchByName(request.getName());
        return mapper
                .map(resultList, CategoryResponse.class)
                .collect(Collectors.toList());
    }


    private Category getById(Long id)
    {
        return categoryRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.CATEGORY_NOT_FOUND));
    }


    private CategoryResponse saveCategory(Category category)
    {
        Category createdCategory = categoryRepository.save(category);
        return mapper.map(createdCategory, CategoryResponse.class);
    }

}

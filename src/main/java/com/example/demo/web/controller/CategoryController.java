/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.web.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.category.request.CreateCategoryRequest;
import com.example.demo.domain.model.category.request.DeleteCategoryRequest;
import com.example.demo.domain.model.category.request.EditCategoryRequest;
import com.example.demo.domain.model.category.request.SearchCategoryByNameRequest;
import com.example.demo.domain.model.category.response.CategoryListItemResponse;
import com.example.demo.domain.model.category.response.CategoryResponse;
import com.example.demo.service.CategoryService;


@RestController
@RequestMapping("/categories")
public class CategoryController
{
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }


    @GetMapping(produces = "application/json")
    public Resources<Resource<CategoryResponse>> all()
    {
        List<CategoryResponse> allCategories = categoryService.getAll();
        List<Resource<CategoryResponse>> resourcesList = allCategories.stream()
                .map(this::getCategoryResource)
                .collect(Collectors.toList());
        return new Resources<>(resourcesList,
                linkTo(methodOn(this.getClass()).all()).withSelfRel());
    }


    @GetMapping(path = "/{id}", produces = "application/json")
    public Resource<CategoryResponse> one(@PathVariable String id)
    {
        CategoryResponse responseModel = categoryService.getOneById(id);
        return getCategoryResource(responseModel);
    }
    
    @GetMapping("/list")
    public List<CategoryListItemResponse> categoryList()
    {
        return categoryService.getCaregotyList();
    }


    //TODO - Resources
    @PostMapping("/search")
    public List<CategoryResponse> searchList(@RequestBody SearchCategoryByNameRequest request)
    {
        return categoryService.searchByName(request);
    }


    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> create(@RequestBody CreateCategoryRequest request)
    {
        CategoryResponse response = categoryService.createCategory(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/edit")
    public ResponseEntity<CategoryResponse> edit(@RequestBody EditCategoryRequest request)
    {
        CategoryResponse response = categoryService.edit(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/delete")
    public ResponseEntity<CategoryResponse> delete(@RequestBody DeleteCategoryRequest request)
    {
        CategoryResponse response = categoryService.delete(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    private Resource<CategoryResponse> getCategoryResource(CategoryResponse responseModel){
        return new Resource<>(responseModel,
                linkTo(methodOn(this.getClass()).one(responseModel.getId())).withSelfRel(),
                linkTo(methodOn(this.getClass()).all()).withRel("categories"));
    }

}

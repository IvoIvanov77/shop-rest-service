/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController
{
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService)
    {        
        this.categoryService = categoryService;
    }
    
    

}

/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.service.ProductService;

@Controller
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService)
    {        
        this.productService = productService;
    }
    
    

}

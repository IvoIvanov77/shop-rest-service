package com.example.demo.web.controller;

import com.example.demo.domain.model.product.request.*;
import com.example.demo.domain.model.product.response.ProductDetailsResponse;
import com.example.demo.domain.model.product.response.ProductListItemResponse;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService)
    {        
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    public Resources<Resource<ProductListItemResponse>> all()
    {
        List<ProductListItemResponse> allCategories = productService.getAll();
        List<Resource<ProductListItemResponse>> resourcesList = allCategories.stream()
                .map(this::getProductResource)
                .collect(Collectors.toList());
        return new Resources<>(resourcesList,
                linkTo(methodOn(this.getClass()).all()).withSelfRel());
    }


    @GetMapping(path = "/{id}", produces = "application/json")
    public Resource<ProductDetailsResponse> one(@PathVariable String id)
    {
        ProductDetailsResponse responseModel = productService.get(id);
        return new Resource<>(responseModel,
                linkTo(methodOn(this.getClass()).one(responseModel.getId())).withSelfRel(),
                linkTo(methodOn(this.getClass()).all()).withRel("products"));
    }


    //TODO - Resources
    @GetMapping("/search")
    public List<ProductListItemResponse> searchByName(@RequestBody SearchProductByNameRequest request)
    {
        return productService.searchByName(request);
    }

    @GetMapping("/advanced-search")
    public List<ProductListItemResponse> advancedSearch(@RequestBody AdvancedSearchRequest request)
    {
        return productService.advancedSearch(request);
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDetailsResponse> addProduct(@RequestBody AddProductRequest request)
    {
        ProductDetailsResponse response = productService.addProduct(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<ProductDetailsResponse> edit(@RequestBody EditProductRequest request)
    {
        ProductDetailsResponse response = productService.edit(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<ProductDetailsResponse> delete(@RequestBody DeleteProducRequest request)
    {
        ProductDetailsResponse response = productService.delete(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private Resource<ProductListItemResponse> getProductResource(ProductListItemResponse responseModel){
        return new Resource<>(responseModel,
                linkTo(methodOn(this.getClass()).one(responseModel.getId())).withSelfRel(),
                linkTo(methodOn(this.getClass()).all()).withRel("categories"));
    }

}

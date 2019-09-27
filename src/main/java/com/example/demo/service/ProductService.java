package com.example.demo.service;

import com.example.demo.domain.model.product.request.AddProductRequest;
import com.example.demo.domain.model.product.request.AdvancedSearchRequest;
import com.example.demo.domain.model.product.request.EditProductRequest;
import com.example.demo.domain.model.product.response.ProductDetailsResponse;
import com.example.demo.domain.model.product.response.ProductListItemResponse;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.List;

public interface ProductService
{
    Resource<ProductDetailsResponse> get(Long id);

    Resources<Resource<ProductListItemResponse>> getAll();

    ProductDetailsResponse addProduct(AddProductRequest request);

    ProductDetailsResponse edit(EditProductRequest request);

    ProductDetailsResponse delete(Long id);

    List<ProductListItemResponse> advancedSearch(AdvancedSearchRequest request);
    
    List<ProductListItemResponse> searchByName(String name);
}

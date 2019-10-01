package com.example.demo.service;

import com.example.demo.domain.model.product.request.CreateProductRequest;
import com.example.demo.domain.model.product.request.AdvancedSearchRequest;
import com.example.demo.domain.model.product.request.DeleteProducRequest;
import com.example.demo.domain.model.product.request.EditProductRequest;
import com.example.demo.domain.model.product.request.SearchProductByNameRequest;
import com.example.demo.domain.model.product.response.ProductDetailsResponse;
import com.example.demo.domain.model.product.response.ProductListItemResponse;

import java.util.List;

public interface ProductService
{
    ProductDetailsResponse get(String id);

    List<ProductListItemResponse> getAll();
    
    List<ProductListItemResponse> getProductsListByCategory(String categoryId);

    ProductDetailsResponse addProduct(CreateProductRequest request);

    ProductDetailsResponse edit(EditProductRequest request);

    ProductDetailsResponse delete(DeleteProducRequest request);

    List<ProductListItemResponse> advancedSearch(AdvancedSearchRequest request);
    
    List<ProductListItemResponse> searchByName(SearchProductByNameRequest request);
}

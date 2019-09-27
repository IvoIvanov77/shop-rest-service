/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.product.request.AddProductRequest;
import com.example.demo.domain.model.product.request.AdvancedSearchRequest;
import com.example.demo.domain.model.product.request.EditProductRequest;
import com.example.demo.domain.model.product.response.ProductDetailsResponse;
import com.example.demo.domain.model.product.response.ProductListItemResponse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
    
    private final ProductRepository productRepository;
    
    

    public ProductServiceImpl(ProductRepository productRepository)
    {        
        this.productRepository = productRepository;
    }

    @Override
    public Resource<ProductDetailsResponse> get(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resources<Resource<ProductListItemResponse>> getAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductDetailsResponse addProduct(AddProductRequest request)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductDetailsResponse edit(EditProductRequest request)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductDetailsResponse delete(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductListItemResponse> advancedSearch(AdvancedSearchRequest request)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductListItemResponse> searchByName(String name)
    {
        // TODO Auto-generated method stub
        return null;
    }

}

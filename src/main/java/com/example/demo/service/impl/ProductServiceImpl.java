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
import com.example.demo.domain.entities.Product;
import com.example.demo.domain.model.product.request.AddProductRequest;
import com.example.demo.domain.model.product.request.AdvancedSearchRequest;
import com.example.demo.domain.model.product.request.DeleteProducRequest;
import com.example.demo.domain.model.product.request.EditProductRequest;
import com.example.demo.domain.model.product.request.SearchProductByNameRequest;
import com.example.demo.domain.model.product.response.ProductDetailsResponse;
import com.example.demo.domain.model.product.response.ProductListItemResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.utils.DtoMapper;


@Service
public class ProductServiceImpl implements ProductService
{

    private final ProductRepository productRepository;
    
    private final CategoryRepository categoryRepository;

    private final DtoMapper mapper;    


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
            DtoMapper mapper)
    {        
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }


    @Override
    public ProductDetailsResponse get(String id)
    {
        Product product = getById(id);
        ProductDetailsResponse responseModel = mapper.map(product, ProductDetailsResponse.class);        
        return responseModel;
    }


    @Override
    public List<ProductListItemResponse> getAll()
    {
        List<Product> allProducts = productRepository.findAll();
        List<ProductListItemResponse> responceModels = mapper.map(allProducts, ProductListItemResponse.class)
                .collect(Collectors.toList());
        return responceModels;
    }
    
    @Override
    public List<ProductListItemResponse> getProductsListByCategory(String categoryId)
    {
        List<Product> resultList = productRepository.getByCategory(categoryId);
        List<ProductListItemResponse> responceModels = mapper.map(resultList, ProductListItemResponse.class)
                .collect(Collectors.toList());
        return responceModels;
    }


    @Override
    public ProductDetailsResponse addProduct(AddProductRequest request)
    {
        Product product = mapper.map(request, Product.class);
        Category category = categoryRepository.getOne(request.getCategoryId());
        return saveProduct(product, category);
    }


    @Override
    public ProductDetailsResponse edit(EditProductRequest request)
    {
        Product productToEdit = getById(request.getId());

        productToEdit.setName(request.getName());
        productToEdit.setImageUrl(request.getImageUrl());
        productToEdit.setDescription(request.getDescription());
        productToEdit.setPrice(request.getPrice());        
        Category category = categoryRepository.getOne(request.getCategoryId());
        
        return saveProduct(productToEdit, category);
    }

    @Override
    public ProductDetailsResponse delete(DeleteProducRequest request)
    {
        Product productToDelete = getById(request.getId());
        productRepository.delete(productToDelete);
        return mapper.map(productToDelete, ProductDetailsResponse.class);
    }


    @Override
    public List<ProductListItemResponse> advancedSearch(AdvancedSearchRequest request)
    {
        List<Product> resultList = productRepository.search(
                request.getName(),
                request.getCategory(),
                request.getMinPrice(),
                request.getMaxPrice()
        );
        return mapper.map(resultList, ProductListItemResponse.class)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductListItemResponse> searchByName(SearchProductByNameRequest request)
    {
        List<Product> resultList = productRepository.searchByName(request.getName());
        return mapper.map(resultList, ProductListItemResponse.class)
                .collect(Collectors.toList());
    }
    
    private Product getById(String id)
    {
        return productRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
    }


    private ProductDetailsResponse saveProduct(Product product, Category category)
    {
        product.setCategory(category);
        Product createdProduct = productRepository.save(product);       
        return mapper.map(createdProduct, ProductDetailsResponse.class);
    }    

}

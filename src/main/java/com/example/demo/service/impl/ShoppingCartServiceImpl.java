/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Oct 1, 2019
 */
package com.example.demo.service.impl;


import org.springframework.stereotype.Service;

import com.example.demo.constants.ErrorMessages;
import com.example.demo.domain.entities.Product;
import com.example.demo.domain.entities.ShopItem;
import com.example.demo.domain.entities.ShoppingCart;
import com.example.demo.domain.enums.ShopItemStatus;
import com.example.demo.domain.model.shopping_cart.request.CreateShopItemRequest;
import com.example.demo.domain.model.shopping_cart.response.ShopItemResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShoppItemRepository;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.utils.DtoMapper;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService
{

    private final ShoppingCartRepository cartrepository;

    private final ShoppItemRepository shopItemRepository;
    
    private final ProductRepository productRepository;

    private final DtoMapper mapper;


    public ShoppingCartServiceImpl(ShoppingCartRepository cartrepository, ShoppItemRepository shopItemRepository,
            DtoMapper mapper, ProductRepository productRepository)
    {
        this.cartrepository = cartrepository;
        this.shopItemRepository = shopItemRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;        
    }


    @Override
    public ShopItemResponse addItemToShoppingCart(CreateShopItemRequest request)
    {
        Product product = productRepository
                .findById(request.getProductId()).orElseThrow(() 
                        -> new ResourceNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
        ShoppingCart shoppingCart = cartrepository.findById(request.getShoppingCartId()).orElseThrow(() 
                -> new ResourceNotFoundException(ErrorMessages.NOT_EXISTING_SHOPPING_CART));
        ShopItem shopItem = new ShopItem();
        shopItem.setProduct(product);
        shopItem.setShoppingCart(shoppingCart);
        shopItem.setQuantity(request.getQuantity());
        shopItem.setStatus(ShopItemStatus.IN_USER_CART);
        return saveShopItem(shopItem);
    }
    
    
    private ShopItemResponse saveShopItem(ShopItem shopItem)
    {
        ShopItem createdItem = shopItemRepository.save(shopItem);  
        return mapper.map(createdItem, ShopItemResponse.class);
    }  

}

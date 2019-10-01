package com.example.demo.service;

import com.example.demo.domain.model.shopping_cart.request.CreateShopItemRequest;
import com.example.demo.domain.model.shopping_cart.response.ShopItemResponse;

public interface ShoppingCartService
{
    
    ShopItemResponse addItemToShoppingCart(CreateShopItemRequest request);
    
    
}

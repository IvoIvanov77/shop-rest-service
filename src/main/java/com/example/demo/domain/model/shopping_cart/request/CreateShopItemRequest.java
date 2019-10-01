/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.domain.model.shopping_cart.request;


public class CreateShopItemRequest
{

    private String productId;

    private String shoppingCartId;

    private Integer quantity;


    public String getProductId()
    {
        return productId;
    }


    public void setProductId(String productId)
    {
        this.productId = productId;
    }


    public String getShoppingCartId()
    {
        return shoppingCartId;
    }


    public void setShoppingCartId(String shoppingCartId)
    {
        this.shoppingCartId = shoppingCartId;
    }


    public Integer getQuantity()
    {
        return quantity;
    }


    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

}

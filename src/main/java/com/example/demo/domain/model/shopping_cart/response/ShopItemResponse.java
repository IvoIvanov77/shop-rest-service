/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Oct 1, 2019
 */
package com.example.demo.domain.model.shopping_cart.response;


import com.example.demo.domain.entities.Product;


public class ShopItemResponse
{

    private String id;

    private Product productName;

    private Integer quantity;


    public String getId()
    {
        return id;
    }


    public void setId(String id)
    {
        this.id = id;
    }


    public Product getProductName()
    {
        return productName;
    }


    public void setProductName(Product productName)
    {
        this.productName = productName;
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

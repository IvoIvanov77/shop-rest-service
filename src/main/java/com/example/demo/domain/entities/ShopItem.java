package com.example.demo.domain.entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.domain.enums.ShopItemStatus;


@Entity
@Table(name = "order_items")
public class ShopItem extends BaseEntity
{

    private Product product;  
    
    private ShoppingCart shoppingCart;
    
    private Order order;

    private Integer quantity;
    
    private ShopItemStatus status;  
   
  
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) 
    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }    

    @ManyToOne
    @JoinColumn(name = "cart_id") 
    public ShoppingCart getShoppingCart()
    {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
    
    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public ShopItemStatus getStatus()
    {
        return status;
    }

    public void setStatus(ShopItemStatus status)
    {
        this.status = status;
    }      

}

package com.example.demo.domain.entities;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "shopping_carts")
public class ShoppingCart extends BaseEntity
{    
    
    private User user;

    private List<ShopItem> shopItems;
    
    private BigDecimal totalPrice;

    @OneToOne(mappedBy = "shoppingCart")
    @JoinColumn(name = "user_id", unique = true)
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @OneToMany(mappedBy = "shoppingCart")   
    public List<ShopItem> getOrderItems()
    {
        return shopItems;
    }

    public void setOrderItems(List<ShopItem> orderItems)
    {
        this.shopItems = orderItems;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }
  
   

}

package com.example.demo.domain.entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order extends BaseEntity
{
    private User user;

    private UserAddress userAddress;

    private List<ShopItem> shopItems;

    private BigDecimal totalPrice;

    private OrderStatus status;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser()
    {
        return user;
    }


    public void setUser(User user)
    {
        this.user = user;
    }


    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    public UserAddress getUserAddress()
    {
        return userAddress;
    }


    public void setUserAddress(UserAddress userAddress)
    {
        this.userAddress = userAddress;
    }


    @OneToMany(mappedBy = "order")
    public List<ShopItem> getShopItems()
    {
        return shopItems;
    }


    public void setShopItems(List<ShopItem> shopItems)
    {
        this.shopItems = shopItems;
    }


    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }


    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }


    public OrderStatus getStatus()
    {
        return status;
    }


    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

}

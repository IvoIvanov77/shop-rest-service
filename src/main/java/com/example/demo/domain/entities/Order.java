package com.example.demo.domain.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order extends BaseEntity
{
    private Set<Product> products;

    private User user;

    private BigDecimal totalPrice;

    private String status;

    @ManyToMany    
    public Set<Product> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }

    @ManyToOne
    public User getUser()
    {
        return user;
    }


    public void setUser(User user)
    {
        this.user = user;
    }


    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }


    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }


    public String getStatus()
    {
        return status;
    }


    public void setStatus(String status)
    {
        this.status = status;
    }

}

package com.example.demo.domain.entities;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "products")
public class Product extends BaseEntity
{

    private String name;

    private String imageUrl;

    private Category category;

    private String description;

    private BigDecimal price;


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getImageUrl()
    {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)   
    public Category getCategory()
    {
        return category;
    }


    public void setCategory(Category category)
    {
        this.category = category;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public BigDecimal getPrice()
    {
        return price;
    }


    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }   

}

/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.domain.model.product.request;


import java.math.BigDecimal;


public class AddProductRequest
{
    private String name;

    private String imageUrl;

    private String categoryId;

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


    public String getCategoryId()
    {
        return categoryId;
    }


    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
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

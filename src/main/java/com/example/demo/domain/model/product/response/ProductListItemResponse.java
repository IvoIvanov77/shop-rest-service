/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.domain.model.product.response;


import java.math.BigDecimal;


public class ProductListItemResponse
{

    private String name;

    private String imageUrl;

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


    public BigDecimal getPrice()
    {
        return price;
    }


    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

}

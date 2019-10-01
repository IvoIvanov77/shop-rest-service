/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.domain.model.product.request;

import java.math.BigDecimal;

import com.example.demo.domain.entities.Category;


public class AdvancedSearchRequest
{
    private String name;

    private String category;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getMinPrice()
    {
        return minPrice;
    }


    public void setMinPrice(BigDecimal minPrice)
    {
        this.minPrice = minPrice;
    }


    public BigDecimal getMaxPrice()
    {
        return maxPrice;
    }


    public void setMaxPrice(BigDecimal maxPrice)
    {
        this.maxPrice = maxPrice;
    }

}

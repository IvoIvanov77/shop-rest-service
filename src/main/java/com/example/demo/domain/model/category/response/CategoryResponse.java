/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.domain.model.category.response;


public class CategoryResponse
{
    private Long id;

    private String name;

    private String imageUrl;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


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

}

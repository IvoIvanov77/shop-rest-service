/**
 * @author Ivaylo R Ivanov <ivanov.ir@isoft.bg>
 * Since Sep 27, 2019
 */
package com.example.demo.domain.model.category.response;


public class CategoryListItemResponse
{
    private String id;

    private String name;    


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    
}

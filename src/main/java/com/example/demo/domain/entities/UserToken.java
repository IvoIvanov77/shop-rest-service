package com.example.demo.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "invalid_tokens")
public class UserToken extends BaseEntity
{
    
    private String token;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
    
    

}

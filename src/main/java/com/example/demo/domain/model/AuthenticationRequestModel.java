package com.example.demo.domain.model;


import java.io.Serializable;


public class AuthenticationRequestModel implements Serializable
{

    private static final long serialVersionUID = 1989182221355372713L;

    private String email;

    private String password;


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }
}

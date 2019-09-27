package com.example.demo.domain.entities;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity implements GrantedAuthority
{

    private static final long serialVersionUID = 3624696123557377660L;

    private String authority;


    public UserRole()
    {
    }


    public UserRole(String authority)
    {
        this.authority = authority;
    }


    @Override
    public String getAuthority()
    {
        return authority;
    }


    public void setAuthority(String authority)
    {
        this.authority = authority;
    }
}

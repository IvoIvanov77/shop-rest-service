package com.example.demo.domain.entities;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails
{

    private static final long serialVersionUID = -4136138174848064025L;

    private String username;

    private String email;

    private String password;

    private Set<UserRole> authorities;

    private ShoppingCart shoppingCart;

    private List<Order> userOrders;

    private List<UserAddress> userAddresses;


    @Override
    @Column(nullable = false, unique = true)
    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    @Override
    @Column(nullable = false)
    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    @Column(nullable = false, unique = true)
    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    @Override
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    public Set<UserRole> getAuthorities()
    {
        return this.authorities;
    }


    public void setAuthorities(Set<UserRole> authorities)
    {
        this.authorities = authorities;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id", unique = true)
    public ShoppingCart getShoppingCart()
    {
        return shoppingCart;
    }


    public void setShoppingCart(ShoppingCart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }


    @OneToMany(mappedBy = "user")
    public List<Order> getUserOrders()
    {
        return userOrders;
    }


    public void setUserOrders(List<Order> userOrders)
    {
        this.userOrders = userOrders;
    }


    @OneToMany(mappedBy = "user")
    public List<UserAddress> getUserAddresses()
    {
        return userAddresses;
    }


    public void setUserAddresses(List<UserAddress> userAddresses)
    {
        this.userAddresses = userAddresses;
    }


    @Override
    @Transient
    public boolean isAccountNonExpired()
    {
        return true;
    }


    @Override
    @Transient
    public boolean isAccountNonLocked()
    {
        return true;
    }


    @Override
    @Transient
    public boolean isCredentialsNonExpired()
    {
        return true;
    }


    @Override
    @Transient
    public boolean isEnabled()
    {
        return true;
    }

}

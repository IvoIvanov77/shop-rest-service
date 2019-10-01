package com.example.demo.repository;

import com.example.demo.domain.entities.UserAddress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, String>
{   

}

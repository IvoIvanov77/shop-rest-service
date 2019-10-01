package com.example.demo.repository;

import com.example.demo.domain.entities.ShopItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppItemRepository extends JpaRepository<ShopItem, String>
{
   

}

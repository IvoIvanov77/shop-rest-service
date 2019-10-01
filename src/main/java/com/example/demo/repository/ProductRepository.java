package com.example.demo.repository;

import com.example.demo.domain.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
{
    @Query("" +
            "select p from Product p where p.name like concat('%',:name,'%') " +
            "and p.category.name like concat('%',:category,'%') " +
            "and p.price >= :minPrice " +
            "and p.price <= :maxPrice order by p.price")
    List<Product> search(@Param("name") String name, @Param("category") String category,
                         @Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

    @Query("" +
            "select p from Product p where p.name like concat('%',:name,'%') " +
            "order by p.name")
    List<Product> searchByName(@Param("name") String name);

}

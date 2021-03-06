package com.example.demo.repository;

import com.example.demo.domain.entities.Category;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{  
    @Query("" +
            "select c from Category c where c.name like concat('%',:name,'%') " +
            "order by c.name")
    List<Category> searchByName(@Param("name") String name);

}

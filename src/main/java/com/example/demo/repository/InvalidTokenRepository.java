package com.example.demo.repository;


import com.example.demo.domain.entities.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InvalidTokenRepository extends JpaRepository<UserToken, String>
{
    @Query("select count(it) > 0 from UserToken it where it.token = :token")
    boolean exist(@Param("token")String token);
}

package com.example.demo.configuration;

import com.example.demo.domain.entities.UserRole;
import com.example.demo.domain.enums.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SeedDatabase
{
    @Bean
    CommandLineRunner initDatabase( RoleRepository roleRepository)
    {

        return args ->
        {
            if (roleRepository.count() == 0)
            {
                for (Role role : Role.values())
                {

                roleRepository.save(new UserRole(role.name()));

                }
            }

        };
    }
}

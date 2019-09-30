package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
public class ApplicationBeanConfiguration
{

    @Bean
    public SimpleUrlAuthenticationFailureHandler failureHandler()
    {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

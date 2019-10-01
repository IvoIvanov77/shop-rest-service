package com.example.demo.configuration;

import com.example.demo.configuration.component.jwt.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{

    private final BCryptPasswordEncoder passwordEncoder;
   
//    private final JwtTokenProvider jwtTokenProvider;
    
    private final UserService userService;

    public WebSecurityConfiguration(BCryptPasswordEncoder passwordEncoder, UserService userService, 
            JwtTokenProvider jwtTokenProvider)
    {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
//        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers("/").permitAll();
//                .antMatchers("/users/login", "/users/register").anonymous()
//                .antMatchers(HttpMethod.GET, "/employees/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/employees/**").hasRole("ADMIN")
//                .anyRequest().authenticated().and()
//                .formLogin()
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                .apply(new JwtConfigurer(jwtTokenProvider));


    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }


}

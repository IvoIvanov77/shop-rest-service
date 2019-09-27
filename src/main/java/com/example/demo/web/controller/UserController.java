package com.example.demo.web.controller;

import com.example.demo.configuration.component.jwt.JwtTokenProvider;
import com.example.demo.domain.model.AuthenticationRequestModel;
import com.example.demo.domain.model.UserRegisterRequestModel;
import com.example.demo.domain.model.UserViewModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;



@RestController
@RequestMapping("/users")
public class UserController
{


    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;


    @Autowired
    public UserController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService)
    {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;

    }

   
    @PostMapping("/register")
    public UserViewModel registerUser(@RequestBody UserRegisterRequestModel bindingModel)
    {
        if (bindingModel == null || !this.userService.register(bindingModel))
        {
            throw new IllegalArgumentException("Something went wrong.....");
        }

        return new UserViewModel(bindingModel.getUsername(), bindingModel.getEmail());
    }

   
    @PostMapping("/login")
    public ResponseEntity< Map<String, String>> login(@RequestBody AuthenticationRequestModel requestModel)
    {
        try
        {
            String email = requestModel.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, requestModel.getPassword()));
            String token = jwtTokenProvider.createToken(email,
                    this.userService.loadUserByUsername(email).getAuthorities());
            Map<String, String> model = new HashMap<>();
            model.put("email", email);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e)
        {
            e.printStackTrace();
            System.out.println("error");
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest req)
    {
        String token = this.jwtTokenProvider.resolveToken(req);
        if(this.userService.invalidateUserToken(token)) {
            return ok("Success");
        }
        return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
    }

}




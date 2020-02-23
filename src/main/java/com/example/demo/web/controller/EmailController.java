package com.example.demo.web.controller;

import com.example.demo.domain.entities.UserEmail;
import com.example.demo.repository.EmailRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailRepository emailRepository;

    public EmailController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @CrossOrigin
    @PostMapping("/subscribe")
    public String subscribe(@RequestBody  String email){
        UserEmail userEmail = new UserEmail();
        userEmail.setEmail(email);
        emailRepository.save(userEmail);
        return "success";
    }
}

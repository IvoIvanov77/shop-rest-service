package com.example.demo.web.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
public class CommunicationController
{

   

    @GetMapping("/{id}")   
    public String  test(@PathVariable("id") String id)
    {        
        return "Working" + id;
    }

    

//    @PostMapping("/create")
//    public ResponseEntity<Employee> create(@RequestBody Employee employee)
//    {
//        return new ResponseEntity<>(this.employeeService.createEmployee(employee), HttpStatus.CREATED);
//    }

    

    
    
}

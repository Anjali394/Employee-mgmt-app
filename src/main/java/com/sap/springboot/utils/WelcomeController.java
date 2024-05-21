package com.sap.springboot.utils;

import com.sap.springboot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }
}

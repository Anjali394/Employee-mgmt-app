package com.sap.springboot.controller;

import com.sap.springboot.service.EmployeeService;
import com.sap.springboot.utils.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/getEmployee")
    public String getEmployee() {
        return employeeService.viewAllEmps();
    }

    @PostMapping("/addEmployee")
    public void addEmployee() {
        employeeService.addEmp();
    }
}

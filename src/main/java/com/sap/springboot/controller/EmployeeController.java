package com.sap.springboot.controller;

import com.sap.springboot.service.EmployeeService;
import com.sap.springboot.utils.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/getAllEmployee")
    public String getAllEmployee() {
        return employeeService.viewAllEmps();
    }

    @GetMapping("/getEmployee")
    public String getEmployee(@RequestParam(value = "id") int empId) {
        return employeeService.viewEmp(empId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody(required = true) Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@RequestParam(value = "id") int empId) {
        employeeService.deleteEmp(empId);
    }

    @ResponseStatus(HttpStatus.RESET_CONTENT)
    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody(required = true) Employee employee, @RequestParam(value = "id") int id) {
        employeeService.updateEmployee(employee, id);
    }

}

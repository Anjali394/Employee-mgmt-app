package com.sap.springboot.service;

import com.sap.springboot.utils.Employee;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EmployeeService {

    HashSet<Employee> empSet = new HashSet<>();

    Employee emp1=new Employee(101, "Ram", 24, "Developer", "IT", 25000);
    Employee emp2=new Employee(102, "Lakhan", 26, "Tester","CO", 57000);
    Employee emp3=new Employee(103, "Bharat", 20, "DevOps Eng","Admin", 5000);
    Employee emp4=new Employee(104, "Shatrughna", 27, "System Eng","CO",  70000);


    public EmployeeService() {
        empSet.add(emp1);
        empSet.add(emp2);
        empSet.add(emp3);
        empSet.add(emp4);
    }

    //view all employees
    public String viewAllEmps() {
        for(Employee emp:empSet) {
            System.out.println(emp);
        }
        return empSet.toString();
    }
    //view emp based on there id
    public String viewEmp(int id){
        boolean found=false;
        Set<Employee> newSet = new HashSet<>();
        for(Employee emp:empSet) {
            if(emp.getId()==id) {
                newSet.add(emp);
                System.out.println("Found Employee: " + emp);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Employee with this id is not present");
        } else {
            return newSet.toString();
        }
        return "Employee with this id not found";
    }
    //update the employee
    public void updateEmployee(Employee reqEmp, int id) {
//
        boolean flag=false;
        for(Employee emp:empSet) {
            if(emp.getId()==id) {
                emp.setName(reqEmp.getName());
                emp.setSalary(reqEmp.getSalary());
                emp.setAge(reqEmp.getAge());
                emp.setDepartment(reqEmp.getDepartment());
                emp.setDesignation(reqEmp.getDesignation());
                System.out.println("Updated Details of employee are: ");
                System.out.println(emp);
                flag=true;
            }
        }
        if(!flag) {
            System.out.println("Employee is not present");
        }
        else {
            System.out.println("Employee details updated successfully !!");
            System.out.println(empSet);
        }
    }
    //delete emp
    public void deleteEmp(int id) {
        boolean found=false;
        Employee empdelete=null;
        for(Employee emp:empSet) {
            if(emp.getId()==id) {
                empdelete=emp;
                found=true;
            }
        }
        if(!found) {
            System.out.println("Employee is not present");
        }
        else {
            empSet.remove(empdelete);
            System.out.println("Employee deleted successfully!!");
        }
    }
    //add emp
    public void addEmployee(Employee employee){
        empSet.add(employee);
        System.out.println("Employee added successfully");
        System.out.println(empSet);
    };

}


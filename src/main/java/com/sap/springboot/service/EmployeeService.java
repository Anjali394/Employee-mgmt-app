package com.sap.springboot.service;

import com.sap.springboot.utils.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Scanner;
@Service

public class EmployeeService {

    HashSet<Employee> empSet = new HashSet<>();

    Employee emp1=new Employee(101, "Ram", 24, "Developer", "IT", 25000);
    Employee emp2=new Employee(102, "Lakhan", 26, "Tester","CO", 57000);
    Employee emp3=new Employee(103, "Bharat", 20, "DevOps Eng","Admin", 5000);
    Employee emp4=new Employee(104, "Shatrughna", 27, "System Eng","CO",  70000);

    Scanner sc=new Scanner(System.in);
    boolean found=false;
    int id;
    String name;
    int age;
    String department;
    String designation;
    double sal;

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
    public void viewEmp(){

        System.out.println("Enter id: ");
        id=sc.nextInt();
        for(Employee emp:empSet) {
            if(emp.getId()==id) {
                System.out.println(emp);
                found=true;
            }

        }
        if(!found) {
            System.out.println("Employee with this id is not present");
        }
    }
    //update the employee
    public void updateEmployee() {
        System.out.println("Enter id: ");
        id=sc.nextInt();
        boolean found=false;
        for(Employee emp:empSet) {
            if(emp.getId()==id) {
                System.out.println("Enter name: ");
                name=sc.next();
                System.out.println("Enter age: ");
                age=sc.nextInt();
                System.out.println("Enter designation: ");
                designation=sc.next();
                System.out.println("Enter department: ");
                department=sc.next();
                System.out.println("Enter new Salary");
                sal=sc.nextDouble();
                emp.setName(name);
                emp.setSalary(sal);
                emp.setAge(age);
                emp.setDepartment(department);
                emp.setDesignation(designation);
                System.out.println("Updated Details of employee are: ");
                System.out.println(emp);
                found=true;
            }
        }
        if(!found) {
            System.out.println("Employee is not present");
        }
        else {
            System.out.println("Employee details updated successfully !!");
        }
    }
    //delete emp
    public void deleteEmp() {
        System.out.println("Enter id");
        id=sc.nextInt();
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
    public void addEmp() {
        System.out.println("Enter id:");
        id=sc.nextInt();
        System.out.println("Enter name");
        name=sc.next();
        System.out.println("Enter age");
        age=sc.nextInt();
        System.out.println("enter Designation");
        designation=sc.next();
        System.out.println("Enter Department");
        department=sc.next();
        System.out.println("Enter sal");
        sal=sc.nextDouble();

        Employee emp = new Employee(id, name, age, designation, department, sal);

        empSet.add(emp);
        System.out.println(emp);
        System.out.println("Employee added successfully");
    }

}


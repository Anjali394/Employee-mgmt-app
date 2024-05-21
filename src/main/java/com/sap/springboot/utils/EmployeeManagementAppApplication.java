package com.sap.springboot.utils;

import com.sap.springboot.controller.EmployeeController;
import com.sap.springboot.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
public class EmployeeManagementAppApplication {

	static boolean ordering = true;
	public static void menu() {
		System.out.println("----------------Welcome To Employee Management System ---------------"
				+ "\n1. Add Employee"
				+ "\n2.View Employee"
				+ "\n3.Update Employee"
				+ "\n4. Delete Employee"
				+ "\n5.View All Employee"
				+ "\n6. Exist ");
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementAppApplication.class, args);
		Scanner sc = new Scanner(System.in);
		EmployeeService service=new EmployeeService();

		do {
			menu();
			System.out.println("Enter your Choice");
			int choice=sc.nextInt();
			switch(choice) {

				case 1:
					System.out.println("Add Employee");
					service.addEmp();
					break;
				case 2:
					System.out.println("View Employee");
					service.viewEmp();
					break;
				case 3:
					System.out.println("Update Employee");
					service.updateEmployee();
					break;
				case 4:
					System.out.println("Delete Employee");
					service.deleteEmp();
					break;
				case 5:
					System.out.println("view All Employee");
					service.viewAllEmps();
					break;
				case 6:
					System.out.println("Thank you for using application!!");
					System.exit(0);
				default:
					System.out.println("Please enter valid choice");
					break;
			}
		}while(ordering);
	}
}

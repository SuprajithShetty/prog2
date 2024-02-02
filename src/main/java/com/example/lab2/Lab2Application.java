package com.example.lab2;

import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
		
		Scanner scan=new Scanner(System.in);
		
		ApplicationContext ac =new ClassPathXmlApplicationContext("TestBean.xml");
		
		Department d=(Department) ac.getBean("department");
		
		while(true) {
			System.out.println("1. Insert\n2. Display\n. Exit");
			System.out.print("Enter the choice: ");
			int choice = scan.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("\n Insert Department details");
				System.out.print(" - Name: ");
				d.setDept_name(scan.next());
				System.out.print(" - ID");
				d.setDept_id(scan.nextInt());
				System.out.print(" - Description: ");
				d.setDept_description(scan.next());
			    break;
			    
			case 2:
				System.out.println("\nDepartment Details");
				System.out.print(" - Name: "+d.getDept_name());
				System.out.print(" - ID: "+d.getDept_id());
				System.out.print(" - Description: "+d.getDept_description());
				
				College c=d.getCollege_instance();
				
				
				System.out.println("\nCollege Details");
				System.out.print(" - Name: "+c.getCollege_name());
				System.out.print(" - Address: "+c.getCollege_address());
				break;
				
			case 3:
				System.out.println("\nExiting");
				System.exit(0);
				
			default:
				System.out.println("\n Invalid choice");
				
			}
		}
	}

}

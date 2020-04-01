package com.java.controller;

import java.util.Scanner;

import com.java.pojo.User;
import com.java.service.CaseStudyService;
import com.java.service.CaseStudyServiceImpl;

public class BankApplicationController {
	
	// reference of interface
	private CaseStudyService refCaseStudyService = new CaseStudyServiceImpl();
	// reference of POJO class
	private User refUser = new User();											
	
	Scanner sc = new Scanner(System.in);
	
	public void bankControllerLogic() {
		
		// display User Home Page
		System.out.println("User Home Page : ");
		System.out.println("\n1. Register");
		System.out.println("2. Login");
		System.out.println("3. Forget Password");
		System.out.println("4. Logout (exit)");
			
		System.out.println("\nEnter your choice : ");
		
		// read user input
		String choice = sc.next();
		switch (choice) {
		case "1":
			refCaseStudyService.userRegister(refUser);
			break;
		case "2":
			refCaseStudyService.userLogin(refUser);
			refCaseStudyService.useBankApplication(refUser);
			break;
		case "3":
			refCaseStudyService.userForgetPassword(refUser);
			break;
		case "4":
			System.out.println("Logout Successfully!!");
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
		// Ask user to input
		// Assumption ==> user already register
		/* refUser = new User();
		refCaseStudyService = new CaseStudyServiceImpl();	// down casting
		refCaseStudyService.useBankApplication(refUser);	// pass the reference of User (POJO class) */
	
		/* public void userInput() {
		// Assumption ==> user already registered and logged in
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Amount : ");
		int amount = sc.nextInt();
		refUser.setAmount(amount);
	} // end of userInput */
		
	}
	
}

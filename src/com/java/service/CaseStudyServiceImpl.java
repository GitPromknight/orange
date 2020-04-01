package com.java.service;

import java.util.Scanner;

import com.java.dao.BankDAOImpl;
import com.java.dao.BankDAOInterface;
import com.java.pojo.User;

public class CaseStudyServiceImpl implements CaseStudyService{ //implement here
	
	BankDAOInterface refBankDAOInterface = null;	//reference of BankDAOInterface interface

	 Scanner sc = new Scanner(System.in);
	 
	public CaseStudyServiceImpl(){
		refBankDAOInterface = new BankDAOImpl();
	}
	
	void checkPassword(String password) {
		
		System.out.println("Re-Enter Password : ");
		String rePassword = sc.next();
		
		if (!password.equals(rePassword)) {
			System.out.println("Password does not match!!");
			checkPassword(password);
			return;
		}
	}
	
	@Override
	public void userRegister(User ref) {
		
			System.out.println("Enter Email Address : ");
			String email = sc.next();

			if (email.equals(ref.getUserID())){
				System.out.println("Email already exists!!");
				userRegister(ref);

			} else {
				System.out.println("Enter Password : ");
				String password = sc.next();
				checkPassword(password);
				System.out.println("What is your favourite colour?");
				String securityKey = sc.next();
				System.out.println(securityKey + " is your security key, if you forget your password." );
				System.out.println("Registration Successful!!");
				ref.setUserID(email);
				ref.setPassword(password);
				ref.setSecurityKey(securityKey);
				ref.setAmount(0);
			}
	
	}
	
	@Override
	public void userLogin(User ref) {
		
		 System.out.println("Enter User ID : ");
		 String email = sc.next();
		 
		 System.out.println("Password : ");
		 String password = sc.next();
		 
		 if (email.equals(ref.getUserID()) && password.equals(ref.getPassword())) {
			 System.out.println("Login Successful!!");
		 } else {
			 System.out.println("Invalid User ID or Password!!");
			 userLogin(ref);
		 }
	}

	@Override
	public void userForgetPassword(User ref) {
		
			System.out.println("Enter your ID : ");
			String email = sc.next();
			
			System.out.println("Enter Security Key : ");
			String securityKey = sc.next();
			
			if (email.equals(ref.getUserID()) && securityKey.equals(ref.getSecurityKey())){
				System.out.println("Enter New Password : ");
				String password = sc.next();
				checkPassword(password);
				
				System.out.println("What is your favourite colour?");
				securityKey = sc.next();
				System.out.println(securityKey + " is your security key, if you forget your password." );
				
				System.out.println("Your password has been reset successfully.");
				
				ref.setPassword(password);
				ref.setSecurityKey(securityKey);
				
			} else {
				System.out.println("Invalid userID");
			}
	}

	@Override
	public void useBankApplication(User ref) {
		
		System.out.println("Type 1 : Check Available Bank Balance");
		System.out.println("Type 2 : Deposit Amount");
		System.out.println("Type 3 : Withdraw Amount");

		System.out.println("Enter your choice : ");
		 int userChoice = sc.nextInt();	// get choice from user
		 
		 switch(userChoice) {
		 case 1:
			 refBankDAOInterface.checkBalance(ref);
			 break;
			 
		 case 2:
			 refBankDAOInterface.deposit(ref);
			 break;
			 
		 case 3:
			 refBankDAOInterface.withdraw(ref);
			 break;
			 
		default:
			System.out.println("Invalid choice");
			break;
		 }
		 }
	
}

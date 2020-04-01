package com.java.application;

import java.util.Scanner;
import com.java.controller.BankApplicationController;

public class CaseStudyApplication {
	
	public static void main(String[] args) {
		BankApplicationController ref = new BankApplicationController();
		
		String choice;
		do {
			ref.bankControllerLogic();
			System.out.println("Wish to continue? (y/n) : ");
			Scanner sc = new Scanner(System.in);
			choice = sc.next();
		} while (!choice.contentEquals("n"));
		System.out.println("Thank you for Banking with Us!!");
	}
}

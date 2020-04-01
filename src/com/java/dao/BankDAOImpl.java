package com.java.dao;

import java.util.Scanner;
import com.java.pojo.User;

public class BankDAOImpl implements BankDAOInterface {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void checkBalance(User refUser) {
		System.out.println("Available Balance : " + refUser.getAmount());
	}

	@Override
	public void deposit(User refUser) {
		System.out.println("Enter Amount :  ");
		int amount = sc.nextInt();
		
		if (amount < 1){
			System.out.println("Amount can't be negative!!");
			deposit(refUser);
		} else {
			refUser.setAmount(amount+refUser.getAmount());
			System.out.println(amount+" dollars deposited successfully!!");
		}

	}

	@Override
	public void withdraw(User refUser) {
		System.out.println("Enter Amount :  ");
		int amount = sc.nextInt();
		
		if (refUser.getAmount() < amount) {
			System.out.println("Sorry!! Insufficient Balance.");
		} else {
			refUser.setAmount(refUser.getAmount()-amount);
			System.out.println("Available Balance : " + refUser.getAmount());
			System.out.println("Transaction Successful!!");
		}

	}
		
}



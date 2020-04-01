package com.java.dao;

import com.java.pojo.User;

public interface BankDAOInterface {

	void checkBalance(User data);
	void deposit(User data);
	void withdraw(User data);
}

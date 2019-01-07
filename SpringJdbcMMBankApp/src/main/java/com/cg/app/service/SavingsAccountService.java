package com.cg.app.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.app.pojo.account.SavingsAccount;
import com.cg.app.pojo.exception.AccountNotFoundException;

public interface SavingsAccountService {

	SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary)
			throws ClassNotFoundException, SQLException;

	double checkCurrentBalance(int accountNumber) throws ClassNotFoundException, AccountNotFoundException, SQLException;

	SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException;

	SavingsAccount searchAccountByAccountHoldername(String accountHolderName)
			throws ClassNotFoundException, AccountNotFoundException, SQLException;

	SavingsAccount deleteAccount(int accountNumber)
			throws ClassNotFoundException, AccountNotFoundException, SQLException;

	List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException;

	void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount)
			throws ClassNotFoundException, SQLException;

	void deposit(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException;

	void withdraw(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException;

	List<SavingsAccount> searchAccountByAccountBalance(double minimumBalance, double maximumBalance)
			throws ClassNotFoundException, SQLException;

	SavingsAccount updateAccount(SavingsAccount account)
			throws ClassNotFoundException, SQLException, AccountNotFoundException;

	List<SavingsAccount> sort(int choice, int sortBy) throws ClassNotFoundException, SQLException;
}

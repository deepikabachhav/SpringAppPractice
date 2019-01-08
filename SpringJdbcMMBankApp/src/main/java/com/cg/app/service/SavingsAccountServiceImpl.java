package com.cg.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.app.dao.SavingsAccountDAO;
import com.cg.app.factory.AccountFactory;
import com.cg.app.pojo.account.SavingsAccount;
import com.cg.app.pojo.exception.AccountNotFoundException;
import com.cg.app.pojo.exception.InsufficientFundsException;
import com.cg.app.pojo.exception.InvalidInputException;
import com.cg.app.util.DBUtil;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	private AccountFactory factory;
	@Autowired
	private SavingsAccountDAO savingsAccountDAO;
	
	
	public SavingsAccountServiceImpl( SavingsAccountDAO savingsAccountDAO) {
		factory = AccountFactory.getInstance();
		//savingsAccountDAO = new SavingsAccountDAOImpl();
	}

	@Override
	public SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary){
		SavingsAccount account = factory.createNewSavingsAccount(accountHolderName, accountBalance, salary);
		return savingsAccountDAO.createNewAccount(account);
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() {
		return savingsAccountDAO.getAllSavingsAccount();
	}

	@Override
	public void deposit(SavingsAccount account, double amount) {
		if (amount > 0) {
			double currentBalance = account.getBankAccount().getAccountBalance();
			currentBalance += amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}

	@Override
	public void withdraw(SavingsAccount account, double amount)  {
		double currentBalance = account.getBankAccount().getAccountBalance();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InsufficientFundsException("Invalid Input or Insufficient Funds!");
		}
	}

	@Override
	@Transactional
	public void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount) {
			withdraw(sender, amount);
			deposit(receiver, amount);	
	}

	@Override
	public SavingsAccount getAccountById(int accountNumber)throws AccountNotFoundException {
		return savingsAccountDAO.getAccountById(accountNumber);
	}

	@Override
	public SavingsAccount deleteAccount(int accountNumber)throws AccountNotFoundException{
		return savingsAccountDAO.deleteAccount(accountNumber);
	}

	@Override
	public double checkCurrentBalance(int accountNumber)throws AccountNotFoundException {
		return savingsAccountDAO.checkCurrentBalance(accountNumber);
	}

	@Override
	public SavingsAccount searchAccountByAccountHoldername(String accountHolderName)throws AccountNotFoundException {
		return savingsAccountDAO.searchAccountByAccountHoldername(accountHolderName);
	}

	@Override
	public List<SavingsAccount> searchAccountByAccountBalance(double minimumBalance, double maximumBalance) {
		return savingsAccountDAO.searchAccountByAccountBalance(minimumBalance, maximumBalance);
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount account)throws AccountNotFoundException {
		return savingsAccountDAO.updateAccount(account);
	}

	@Override
	public List<SavingsAccount> sort(int choice, int sortBy) {
		return savingsAccountDAO.sort(choice, sortBy);
	}

}

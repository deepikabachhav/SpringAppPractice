package com.cg.app.pojo.account;

public class CurrentAccount {
	private double odLimit;
	private BankAccount bankAccount;
	
	public CurrentAccount(String accountHolderName, double accountBalance,double odLimit) {
		bankAccount = new BankAccount(accountHolderName, accountBalance);
		this.odLimit = odLimit;
	}
	
	public CurrentAccount(String accountHolderName, double odLimit) {
		bankAccount = new BankAccount(accountHolderName);
		this.odLimit = odLimit;
	}

	public CurrentAccount(int accountNumber, String accountHolderName, double accountBalance,double odLimit) {
		bankAccount = new BankAccount(accountNumber, accountHolderName, accountBalance);
		this.odLimit = odLimit;
	}
	
	
	
	
}

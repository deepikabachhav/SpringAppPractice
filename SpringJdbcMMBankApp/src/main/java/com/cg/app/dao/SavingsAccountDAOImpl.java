package com.cg.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.app.pojo.account.SavingsAccount;
import com.cg.app.pojo.exception.AccountNotFoundException;
import com.cg.app.util.DBUtil;
@Repository
public class SavingsAccountDAOImpl implements SavingsAccountDAO {

	public SavingsAccount createNewAccount(SavingsAccount account) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, account.getBankAccount().getAccountNumber());
		preparedStatement.setString(2, account.getBankAccount().getAccountHolderName());
		preparedStatement.setDouble(3, account.getBankAccount().getAccountBalance());
		preparedStatement.setBoolean(4, account.isSalary());
		preparedStatement.setObject(5, null);
		preparedStatement.setString(6, "SA");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		DBUtil.commit();
		return account;
	}

	public List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException {
		List<SavingsAccount> savingsAccounts = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNT");
		while (resultSet.next()) {// Check if row(s) is present in table
			int accountNumber = resultSet.getInt(1);
			String accountHolderName = resultSet.getString("account_hn");
			double accountBalance = resultSet.getDouble(3);
			boolean salary = resultSet.getBoolean("salary");
			SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolderName, accountBalance,
					salary);
			savingsAccounts.add(savingsAccount);
		}
		DBUtil.commit();
		return savingsAccounts;
	}

	@Override
	public List<SavingsAccount> searchAccountByAccountBalance(double minimumBalance, double maximumBalance)
			throws ClassNotFoundException, SQLException {
		List<SavingsAccount> savingsAccounts = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM account WHERE account_bal BETWEEN ? AND ?");
		preparedStatement.setDouble(1, minimumBalance);
		preparedStatement.setDouble(2, maximumBalance);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {// Check if row(s) is present in table
			int accountNumber = resultSet.getInt(1);
			String accountHolderName = resultSet.getString("account_hn");
			double accountBalance = resultSet.getDouble(3);
			boolean salary = resultSet.getBoolean("salary");
			SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolderName, accountBalance,
					salary);
			savingsAccounts.add(savingsAccount);
		}
		return savingsAccounts;
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection();
		connection.setAutoCommit(false);
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE ACCOUNT SET account_bal=? where account_id=?");
		preparedStatement.setDouble(1, currentBalance);
		preparedStatement.setInt(2, accountNumber);
		preparedStatement.executeUpdate();
	}

	@Override
	public SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account where account_id=?");
		preparedStatement.setInt(1, accountNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		SavingsAccount savingsAccount = null;
		if (resultSet.next()) {
			String accountHolderName = resultSet.getString("account_hn");
			double accountBalance = resultSet.getDouble(3);
			boolean salary = resultSet.getBoolean("salary");
			savingsAccount = new SavingsAccount(accountNumber, accountHolderName, accountBalance, salary);
			return savingsAccount;
		}
		throw new AccountNotFoundException("Account with account number " + accountNumber + " does not exist.");
	}

	@Override
	public SavingsAccount searchAccountByAccountHoldername(String accountHolderName)
			throws AccountNotFoundException, ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account where account_hn=?");
		preparedStatement.setString(1, accountHolderName);
		ResultSet resultSet = preparedStatement.executeQuery();
		SavingsAccount savingsAccount = null;
		if (resultSet.next()) {
			int accountNumber = resultSet.getInt("account_id");
			double accountBalance = resultSet.getDouble(3);
			boolean salary = resultSet.getBoolean("salary");
			savingsAccount = new SavingsAccount(accountNumber, accountHolderName, accountBalance, salary);
			return savingsAccount;
		}
		throw new AccountNotFoundException(
				"Account with account Holder Name " + accountHolderName + " does not exist.");
	}

	@Override
	public double checkCurrentBalance(int accountNumber)
			throws AccountNotFoundException, ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account where account_id=?");
		preparedStatement.setInt(1, accountNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		// SavingsAccount savingsAccount = null;
		if (resultSet.next()) {
			double accountBalance = resultSet.getDouble(3);
			return accountBalance;
		}
		throw new AccountNotFoundException("Account with account number " + accountNumber + " does not exist.");
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount account)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		Connection connection = DBUtil.getConnection();
		// if(getAccountById(accountNumber).getBankAccount().getAccountNumber()==accountNumber){
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE account SET salary=?,account_hn=?  WHERE account_id=?");
		preparedStatement.setBoolean(1, account.isSalary());
		preparedStatement.setString(2, account.getBankAccount().getAccountHolderName());
		preparedStatement.setInt(3, account.getBankAccount().getAccountNumber());
		preparedStatement.executeUpdate();
		DBUtil.commit();
		return getAccountById(account.getBankAccount().getAccountNumber());
		// }
		// throw new AccountNotFoundException("Account with account number
		// "+accountNumber+" does not exist.");
	}

	@Override
	public SavingsAccount deleteAccount(int accountNumber) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM account where account_id=?");
		preparedStatement.setInt(1, accountNumber);
		preparedStatement.executeUpdate();
		SavingsAccount savingsAccount = null;
		return savingsAccount;
	}
	// throw new AccountNotFoundException("Account with account number
	// "+accountNumber+" does not exist.");

	@Override
	public List<SavingsAccount> sort(int choice, int sortBy) throws ClassNotFoundException, SQLException {
		Connection connection = DBUtil.getConnection();
		SavingsAccount savingsAccount = null;
		String query = "";
		switch (choice) {
		case 1:
			if (sortBy == 1)
				query = "SELECT * FROM account ORDER BY account_id";
			else
				query = "SELECT * FROM account ORDER BY account_id DESC";
			break;
		case 2:
			if (sortBy == 1)
				query = "SELECT * FROM account ORDER BY account_hn";
			else
				query = "SELECT * FROM account ORDER BY account_hn DESC";
			break;
		case 3:
			if (sortBy == 1)
				query = "SELECT * FROM account ORDER BY account_bal";
			else
				query = "SELECT * FROM account ORDER BY account_bal DESC";
			break;
		}
		List<SavingsAccount> savingsAccounts = new ArrayList<>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {// Check if row(s) is present in table
			int accountNumber = resultSet.getInt(1);
			String accountHolderName = resultSet.getString("account_hn");
			double accountBalance = resultSet.getDouble(3);
			boolean salary = resultSet.getBoolean("salary");
			savingsAccount = new SavingsAccount(accountNumber, accountHolderName, accountBalance, salary);
			savingsAccounts.add(savingsAccount);
		}
		statement.close();
		return savingsAccounts;
	}

}

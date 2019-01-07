package com.cg.app.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.app.ui.AccountCUI;

public class App {
	/*
	 * static { try { Class.forName("com.mysql.jdbc.Driver"); Connection connection
	 * = DriverManager.getConnection ("jdbc:mysql://localhost:3306/bankapp_db",
	 * "root", "root"); PreparedStatement preparedStatement =
	 * connection.prepareStatement("DELETE FROM ACCOUNT");
	 * preparedStatement.execute(); } catch (ClassNotFoundException e) {
	 * e.printStackTrace(); } catch (SQLException e) { e.printStackTrace(); } }
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		AccountCUI accountCUI = context.getBean(AccountCUI.class,"context.xml");
		accountCUI.start();
	}
}

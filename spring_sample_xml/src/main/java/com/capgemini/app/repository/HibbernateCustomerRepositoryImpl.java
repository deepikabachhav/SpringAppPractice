package com.capgemini.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.capgemini.app.model.Customer;

public class HibbernateCustomerRepositoryImpl implements CustomerRepository {
	@Value("${dbUsername}")
	private String dbUsername;
	
	/* (non-Javadoc)
	 * @see com.capgemini.app.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		System.out.println(dbUsername);
		 List<Customer> customers= new ArrayList<>();
		 Customer customer= new Customer();
		 customer.setFirstName("Deepika");
		 customer.setLastName("Bachhav");
		 customers.add(customer);
		 return customers;
	}
	
}

package com.capgemini.app.repository;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.app.model.Customer;

@Repository("customerRepository")
public class HibbernateCustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.capgemini.app.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		 List<Customer> customers= new ArrayList<>();
		 Customer customer= new Customer();
		 customer.setFirstName("Deepika");
		 customer.setLastName("Bachhav");
		 customers.add(customer);
		 return customers;
	}
	
}

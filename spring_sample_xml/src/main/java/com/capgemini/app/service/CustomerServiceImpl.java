package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.model.Customer;
import com.capgemini.app.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	public CustomerServiceImpl () {
		
	}
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	/* (non-Javadoc)
	 * @see com.capgemini.app.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
}

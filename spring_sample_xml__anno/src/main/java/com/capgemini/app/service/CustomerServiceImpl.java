package com.capgemini.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.model.Customer;
import com.capgemini.app.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	//@Autowired
	private CustomerRepository customerRepository;
	public CustomerServiceImpl () {
		
	}
	@Autowired()
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We used autowire here using constructor injection");
		this.customerRepository=customerRepository;
	}
	//@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We used autowire here");
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

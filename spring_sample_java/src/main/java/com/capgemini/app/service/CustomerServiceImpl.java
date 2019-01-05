package com.capgemini.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.app.model.Customer;
import com.capgemini.app.repository.CustomerRepository;

@Service("customerService")
@Scope("prototype")
public class CustomerServiceImpl implements CustomerService {
	//@Autowired
	private CustomerRepository customerRepository;
	
	
	
	/* (non-Javadoc)
	 * @see com.capgemini.app.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("we are using setter injection");
		this.customerRepository = customerRepository;
	}

	public CustomerServiceImpl (CustomerRepository customerRepository) {
		//System.out.println("We are using constructor injection");
		this.customerRepository = customerRepository;
	}
	
	public CustomerServiceImpl ( ) {
		//System.out.println("We are using constructor injection");
	}
}

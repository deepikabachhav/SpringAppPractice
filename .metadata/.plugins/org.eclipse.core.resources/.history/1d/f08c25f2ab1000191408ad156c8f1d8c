package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.model.Customer;
import com.capgemini.app.repository.CustomerRepository;
import com.capgemini.app.repository.HibbernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository = new HibbernateCustomerRepositoryImpl();
	/* (non-Javadoc)
	 * @see com.capgemini.app.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
}

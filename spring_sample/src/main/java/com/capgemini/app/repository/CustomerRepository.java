package com.capgemini.app.repository;

import java.util.List;

import com.capgemini.app.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}
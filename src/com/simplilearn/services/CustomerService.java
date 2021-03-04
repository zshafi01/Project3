package com.simplilearn.services;

import java.util.List;

import com.simplilearn.entities.Customer;

public interface CustomerService {
	public boolean saveCustomer(Customer customer);

	public boolean delete(String id);

	public Customer getCustomerByid(String id);

	public List<Customer> getAllCustomer();

	public Customer getCustomerByUserId(String id);

	public Customer getCustomerStatus();

	public boolean updateState(String id, String state);

}

package com.simplilearn.repo;

import java.util.List;

import com.simplilearn.entities.Customer;

public interface CustomerRepository {
	public void saveOrUpdate(Customer customer);

	public void delete(String id);

	public List<Customer> getCustomerByid(String id);

	public List<Customer> getAllCustomer();

	public List<Customer> getCustomerByUserId(String id);

	public List<Customer> getCustomerByStatus();

	public void updateState(String id, String state);
}

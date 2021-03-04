package com.simplilearn.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.entities.Customer;
import com.simplilearn.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean delete(String id) {
		try {
			customerRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Customer getCustomerByid(String id) {
		List<Customer> listofcustomer = customerRepository.getCustomerByid(id);
		if (listofcustomer != null && !listofcustomer.isEmpty()) {
			return listofcustomer.get(0);
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.getAllCustomer();
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		try {
			customerRepository.saveOrUpdate(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Customer getCustomerByUserId(String id) {
		List<Customer> customerByUserIdList = customerRepository.getCustomerByUserId(id);
		if (customerByUserIdList != null && !customerByUserIdList.isEmpty()) {
			return customerByUserIdList.get(0);
		}
		return null;
	}

	@Override
	public Customer getCustomerStatus() {
		List<Customer> customerByStatus = customerRepository.getCustomerByStatus();

		return (Customer) customerByStatus;
	}

	@Override
	public boolean updateState(String id, String state) {
		try {
			customerRepository.updateState(id, state);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
		return true;
	}

}
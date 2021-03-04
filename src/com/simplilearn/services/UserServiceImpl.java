package com.simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.entities.Customer;
import com.simplilearn.entities.User;
import com.simplilearn.repo.CustomerRepository;
import com.simplilearn.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public long retreveUserCount() {
		return 0;
	}

	@Override
	public List<User> retreveAllUserInfo() {
		return userRepository.getAllUsers();
	}

	@Override
	public User retreveUserById(String id) {
		return (User) userRepository.getById(id);
	}

	@Override
	public boolean saveUser(User user) {
		try {
			userRepository.saveOrUpdate(user);
			User usersaved = getUserByEmail(user.getEmail(), user.getPassword());
			if (user.getType().equalsIgnoreCase("customer")) {
				Customer customer = new Customer();
				customer.setCustName(user.getName());
				customer.setEmail(user.getEmail());
				customer.setUserId(usersaved.getId());

				customerRepository.saveOrUpdate(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			userRepository.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void deleteUser(String id) {

	}

	@Override
	public User getUserByEmail(String email, String password) {
		List<User> userByEmailList = userRepository.findbyemail(email);
		if (userByEmailList == null || userByEmailList.isEmpty()) {
			return null;
		} else {
			User user = userByEmailList.get(0);
			if (password.equalsIgnoreCase(user.getPassword())) {
				return user;
			} else {
				return null;
			}
		}
	}

}

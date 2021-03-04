package com.simplilearn.repo;

import java.util.List;

import com.simplilearn.entities.User;

public interface UserRepository {
	public void saveOrUpdate(User user);

	public void delete(String userid);

	public List<User> findbyemail(String email);

	public List<User> getById(String userId);

	public List<User> getAllUsers();

}

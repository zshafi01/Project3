package com.simplilearn.services;

import java.util.List;
import com.simplilearn.entities.User;

public interface UserService {

	public long retreveUserCount();

	public List<User> retreveAllUserInfo();

	public User retreveUserById(String id);

	public boolean saveUser(User user);

	public boolean updateUser(User user);

	public void deleteUser(String id);

	public User getUserByEmail(String email, String password);

}

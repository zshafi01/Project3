package com.simplilearn.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.simplilearn.entities.User;

public interface UserService {

	public long retreveUserCount();

	public List<User> retreveAllUserInfo();

	public User retreveUserById(String id);

	public User saveUser(User user);

	public void updateUser(User user);

	public void deleteUser(String id);

}

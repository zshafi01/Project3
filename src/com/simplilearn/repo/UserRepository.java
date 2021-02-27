package com.simplilearn.repo;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.simplilearn.entities.User;

public interface UserRepository {
	public void saveOrUpdate(User user);
    
    public void delete(int userid);
     
    public User get(int userId);
     
    public List<User> getUsers();

}

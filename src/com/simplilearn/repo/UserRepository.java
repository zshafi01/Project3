package com.simplilearn.repo;



import java.util.List;


import com.simplilearn.entities.User;

public interface UserRepository {
	public void saveOrUpdate(User user);
    
    public void delete(int userid);
    public List<User> findbyemail(String email);

     
    public User get(int userId);
     
    public List<User> getUsers();

}

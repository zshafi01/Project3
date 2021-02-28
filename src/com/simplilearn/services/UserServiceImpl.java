package com.simplilearn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entities.User;
import com.simplilearn.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
//
//	@Override
//	public long retreveUserCount() {
//		return userRepository.count();
//	}
//
//	@Override
//	public List<User> retreveAllUserInfo() {
//		return userRepository.findAll();
//	}
//
//	@Override
//	public User retreveUserById(String id) {
//		User user = userRepository.findById(id).orElse(null);
//
//		return user;
//	}
//
//	@Override
//	public User saveUser(User user) {
//		return userRepository.save(user);
//	}
//
//	@Override
//	public void updateUser(User user) {
//		Optional<User> _user = userRepository.findById(user.getId());
//		if (_user.isPresent()) {
//			User update_user = _user.get();
//			update_user.setName(user.getName());
//			update_user.setAddress(user.getAddress());
//			update_user.setEmail(user.getEmail());
//			update_user.setPassword(user.getPassword());
//			userRepository.save(update_user);
//		}
//	}
//
//	@Override
//	public void deleteUser(String id) {
//		userRepository.deleteById(id);
//
//	}

	@Override
	public long retreveUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> retreveAllUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retreveUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		userRepository.saveOrUpdate(user);
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByEmail(String email, String password) {
		List<User> userByEmailList = userRepository.findbyemail(email);
		//if there is no user by the eamil
		if(userByEmailList==null || userByEmailList.isEmpty()) {
			return null;
		} else {
			//take the first user
			User user=userByEmailList.get(0);
			if(password.equalsIgnoreCase(user.getPassword())) {
				return user;
			} else {
				return null;
			}
		}
	}

}

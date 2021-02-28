package com.simplilearn.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.entities.User;

public class UserRepositoryImpl implements UserRepository{
	
	private JdbcTemplate jdbcTemplate;
	 
    public UserRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public void saveOrUpdate(User user) {
		if (user==null || user.getId()==null || user.getId().equals("")) {
			   // insert

			String id = UUID.randomUUID().toString();
	        String sql = "INSERT INTO user (id,name, address, email, password, type)"
	                    + " VALUES (?,?, ?, ?, ?,?)";
	        jdbcTemplate.update(sql, id, user.getName(),user.getAddress(), user.getEmail(), user.getPassword(),user.getType());
	    } else {
	        // update
	        String sql = "UPDATE user SET name=?, address=?, email=?, password=?, type=? where id=?";
	        jdbcTemplate.update(sql, user.getName(),user.getAddress(), user.getEmail(), user.getPassword(),user.getType(),user.getId());
	    }
		
	}

	@Override
	public void delete(int userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public List<User> findbyemail(String email) {
		String sql = "SELECT * FROM sportshoesdb.user where email=?";
		return jdbcTemplate.query(sql, new UserMapper(),email);
	}
	
	private static final class UserMapper implements RowMapper<User> {
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	      User user = new User();
	      user.setId(rs.getString("id"));
	      user.setAddress(rs.getString("address"));
	      user.setEmail(rs.getString("email"));
	      user.setName(rs.getString("name"));
	      user.setPassword(rs.getString("password"));
	      user.setType(rs.getString("type"));
	      return user;
	    }
	  }  

}

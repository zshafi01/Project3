package com.simplilearn.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.simplilearn.entities.User;

public class UserRepositoryImpl implements UserRepository {

	private JdbcTemplate jdbcTemplate;

	public UserRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(User user) {
		if (user == null || user.getId() == null || user.getId().equals("")) {
			String id = UUID.randomUUID().toString().substring(0, 8);
			String sql = "INSERT INTO user (id,name, email, password, type)" + " VALUES (?,?, ?, ?, ?)";
			jdbcTemplate.update(sql, id, user.getName(), user.getEmail(), user.getPassword(), user.getType());
		} else {
			// update
			String sql = "UPDATE user SET name=?, email=?, password=?, type=? where id=?";
			jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getType(), user.getId());
		}

	}

	@Override
	public void delete(String userid) {
		String sql = "DELETE FROM user where id=?";
		jdbcTemplate.update(sql, userid);
	}

	@Override
	public List<User> getById(String userId) {
		String sql = "SELECT * FROM user where id=?";
		return jdbcTemplate.query(sql, new UserMapper(), userId);
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select * FROM user";

		return jdbcTemplate.query(sql, new UserMapper());
	}

	@Override
	public List<User> findbyemail(String email) {
		String sql = "SELECT * FROM sportshoesdb.user where email=?";
		return jdbcTemplate.query(sql, new UserMapper(), email);
	}

	private static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setType(rs.getString("type"));
			return user;
		}
	}

}

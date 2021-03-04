package com.simplilearn.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.simplilearn.entities.Customer;

public class CustomerRepositoryImp implements CustomerRepository {

	private JdbcTemplate jdbcTemplate;

	public CustomerRepositoryImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		if (customer == null || customer.getId() == null || customer.getId().equals("")) {
			// insert

			String id = UUID.randomUUID().toString().substring(0, 8);
			String sql = "INSERT INTO customer(id, name, email, street,city,zipcode,country,userId) "
					+ "VALUES (?,?, ?, ?, ?,?,?,?)";
			jdbcTemplate.update(sql, id, customer.getCustName(), customer.getEmail(), customer.getStreet(),
					customer.getCity(), customer.getZipcode(), customer.getCountry(), customer.getUserId());
		} else {
			// update
			String sql = "UPDATE customer SET name=?, email=?, street=?, city=?, zipcode=?, country=?, userId=? "
					+ "where id=?";
			jdbcTemplate.update(sql, customer.getCustName(), customer.getEmail(), customer.getStreet(),
					customer.getCity(), customer.getZipcode(), customer.getCountry(), customer.getUserId(),
					customer.getId());
		}
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM customer where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public List<Customer> getCustomerByid(String id) {
		String sql = "select *  from customer " + "where id=?";
		return jdbcTemplate.query(sql, new CustomerMapper(), id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		String sql = "select * FROM customer";

		return jdbcTemplate.query(sql, new CustomerMapper());
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setId(rs.getString("id"));
			customer.setCustName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setStreet(rs.getString("street"));
			customer.setCity(rs.getString("city"));
			customer.setZipcode(rs.getString("zipcode"));
			customer.setCountry(rs.getString("country"));
			customer.setUserId(rs.getString("userId"));
			customer.setApproved(rs.getString("approved"));
			return customer;
		}
	}

	@Override
	public List<Customer> getCustomerByUserId(String userId) {
		String sql = "select * from customer " + "where userId=?";
		return jdbcTemplate.query(sql, new CustomerMapper(), userId);
	}

	@Override
	public List<Customer> getCustomerByStatus() {
		String sql = "select * from customer " + "where approved=?";
		return jdbcTemplate.query(sql, new CustomerMapper());
	}

	@Override
	public void updateState(String id, String state) {
		// TODO Auto-generated method stub
		String sql = "update customer set approved=? where id=?";
		jdbcTemplate.update(sql, state, id);

	}

}

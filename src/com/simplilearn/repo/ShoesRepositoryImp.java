package com.simplilearn.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.entities.Shoes;

public class ShoesRepositoryImp implements ShoesRepository {

	private JdbcTemplate jdbcTemplate;

	public ShoesRepositoryImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Shoes shoes) {
		if (shoes == null || shoes.getId() == null || shoes.getId().equals("")) {
			// insert

			String id = UUID.randomUUID().toString().substring(0, 8);
			String sql = "INSERT INTO shoes (id, brandName, color, size, image, price)" + " VALUES (?,?, ?, ?, ?,?)";
			jdbcTemplate.update(sql, id, shoes.getBrandName(), shoes.getColor(), shoes.getSize(), shoes.getImage(),
					shoes.getPrice());
		} else {
			// update
			String sql = "UPDATE shoes SET brandName=?, color=?, size=?, image=?, price=? where id=?";
			jdbcTemplate.update(sql, shoes.getBrandName(), shoes.getColor(), shoes.getSize(), shoes.getImage(),
					shoes.getPrice(), shoes.getId());
		}
	}

	@Override
	public void delete(String shoesId) {
		String sql = "DELETE FROM shoes where id=?";
		jdbcTemplate.update(sql, shoesId);
	}

	@Override
	public List<Shoes> getById(String shoesId) {
		String sql = "SELECT * FROM shoes where id=?";
		return jdbcTemplate.query(sql, new ShoesMapper(), shoesId);
	}

	@Override
	public List<Shoes> getAllShoes() {
		String sql = "select * FROM shoes";

		return jdbcTemplate.query(sql, new ShoesMapper());
	}

	private static final class ShoesMapper implements RowMapper<Shoes> {
		public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException {
			Shoes shoes = new Shoes();
			shoes.setId(rs.getString("id"));
			shoes.setBrandName(rs.getString("brandName"));
			shoes.setColor(rs.getString("color"));
			shoes.setSize(rs.getInt("size"));
			shoes.setImage(rs.getString("image"));
			shoes.setPrice(rs.getDouble("price"));
			return shoes;
		}
	}

}

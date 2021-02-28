package com.simplilearn.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.entities.Shoes;
import com.simplilearn.entities.User;


public class ShoesRepositoryImp implements ShoesRepository{
	
	private JdbcTemplate jdbcTemplate;
	 
    public ShoesRepositoryImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



	@Override
	public void saveOrUpdate(Shoes shoes) {
		if (shoes==null || shoes.getId()==null || shoes.getId().equals("")) {
			   // insert

			String id = UUID.randomUUID().toString();
	        String sql = "INSERT INTO shoes (id, brand_Name, color, size, image, price)"
	                    + " VALUES (?,?, ?, ?, ?,?)";
	        jdbcTemplate.update(sql, id, shoes.getBrand_Name(),shoes.getColor(), shoes.getSize(), shoes.getImage(),shoes.getPrice());
	    } else {
	        // update
	        String sql = "UPDATE shoes SET brand_Name=?, color=?, size=?, image=?, price=? where id=?";
	        jdbcTemplate.update(sql,shoes.getBrand_Name(),shoes.getColor(), shoes.getSize(), shoes.getImage(),shoes.getPrice());
	    }		
	}

	@Override
	public void delete(int shoesId) {
		
	}

	@Override
	public Shoes get(int shoesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shoes> getShoes() {
	String sql= "select * FROM shoes";
	
	return jdbcTemplate.query(sql, new ShoesMapper());	
	}
	
	private static final class ShoesMapper implements RowMapper<Shoes> {
	    public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Shoes shoes = new Shoes();
	    	shoes.setId(rs.getString("id"));
	    	shoes.setBrand_Name(rs.getString("brand_Name"));
	    	shoes.setColor(rs.getString("color"));
	    	shoes.setSize(rs.getInt("size"));
	    	shoes.setImage(rs.getString("image"));
	    	shoes.setPrice(rs.getDouble("price"));
	      return shoes;
	    }
	  }  


}

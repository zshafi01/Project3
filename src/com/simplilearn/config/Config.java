package com.simplilearn.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.simplilearn.repo.UserRepository;
import com.simplilearn.repo.UserRepositoryImpl;

@Configuration
@ComponentScan(basePackages={"com.simplilearn","com.simplilearn.config","com.simplilearn.domain","com.simplilearn.repository","com.simplilearn.service"})
public class Config {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sportshoesdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("rootroot");
		return dataSource;
	}
	
	@Bean
    public UserRepository getUserRepository() {
        return new UserRepositoryImpl(dataSource());
    }
	

}

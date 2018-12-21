package com.spring.library.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.library.dao.BookDaoImpl;
import com.spring.library.dao.UserDaoImpl;

@Configuration
public class AppConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/library?useSSL=false");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("raihan");
		return dataSource;
	}
	@Bean(name="daoBean")
	public UserDaoImpl userDao() {
		return new UserDaoImpl(getDataSource());
	}
	
	@Bean(name="bookDao")
	public BookDaoImpl bookDao() {
		return new BookDaoImpl(getDataSource());
	}
	
}

package com.spring.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.spring.library.model.User;
import com.spring.library.passwordEncoder.PasswordEnCoder;
@Repository
public class UserDaoImpl implements UserDao {
	private DataSource dataSource;
	
	
	public UserDaoImpl(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	@Override
	public void addUser(User user) {
		String queryForUser = "insert into users(username,firstname,lastname,email,password,enabled) values(?,?,?,?,?,?)";
		String queryForAuthorities = "insert into authorities(username,authority) values(?,?)";
		Connection conn ;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(queryForUser);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getFirstname());
			pst.setString(3, user.getLastname());
			pst.setString(4, user.getEmail());
			pst.setString(5, new PasswordEnCoder().encoder(user.getPassword()));
			pst.setInt(6, 1);
			pst.execute();
			PreparedStatement pst2 = conn.prepareStatement(queryForAuthorities);
			pst2.setString(1, user.getUsername());
			pst2.setString(2, "ROLE_USER");
			pst2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

}

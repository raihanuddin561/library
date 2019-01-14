package com.spring.library.dao;

import java.util.List;

import com.spring.library.model.Authorities;
import com.spring.library.model.Users;

public interface UserDao {
	public void addUser(Users user);
	public List<Users> userList();
	public void addAuthority(Authorities authority);
}

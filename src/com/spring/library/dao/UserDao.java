package com.spring.library.dao;

import java.util.List;

import com.spring.library.model.User;

public interface UserDao {
	public void addUser(User user);
	public List<User> userList();
}

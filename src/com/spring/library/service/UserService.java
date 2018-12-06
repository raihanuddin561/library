package com.spring.library.service;

import java.util.List;

import com.spring.library.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> userList();
}

package com.spring.library.service;

import java.util.List;

import com.spring.library.dao.UserDaoImpl;
import com.spring.library.model.User;

public class UserServiceImpl implements UserService {
	private UserDaoImpl userDao;
	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return userDao.userList();
	}

}

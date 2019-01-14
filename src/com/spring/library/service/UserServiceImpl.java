package com.spring.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.library.dao.UserDao;
import com.spring.library.model.Authorities;
import com.spring.library.model.Users;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	@Transactional
	public void addUser(Users user) {
		userDao.addUser(user);

	}

	@Override
@Transactional
	public List<Users> userList() {
		// TODO Auto-generated method stub
		return userDao.userList();
	}

	@Override
	@Transactional
	public void addAuthority(Authorities authority) {
		userDao.addAuthority(authority);
		
	}

}
